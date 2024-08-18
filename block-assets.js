/* note:
  renames:
  - tiles_large -> panel,
  - panel -> tile,
  - layers -> layered_bricks,
  - mosaic -> bordered_panel,
  - road -> windmill_bricks,
  - triple_bricks - medium_bricks
*/

const STANDARD_BRICKS = [
    "braid",
    "cracked",
    "layered_bricks",
    "tile",
    "prism",
    "windmill_bricks",
    "small_bricks",
    "medium_bricks",
    "tiles_medium",
    "tiles_small",
];

const fs = require("fs");

let material = process.argv[2];
let type = process.argv[3];

console.log(`Creating assets for block with id '${material}/${type}'.`);

fs.mkdirSync(getBsPath(material), { recursive: true });
fs.mkdirSync(getBlockModelPath(material), { recursive: true });
fs.mkdirSync(getItemModelPath(material), { recursive: true });
fs.mkdirSync(getLootTablePath(material), { recursive: true });

if (type === 'chaotic_bricks') {
    const AMOUNT = 9;
    createBlockstate_random(material, type, AMOUNT);

    for (let i = 0; i < AMOUNT; i++) {
        createBlockModel_randomPart(material, type, i);
    }

    createItemModel_standard(material, type);
}
else if (type === 'dent' || type === "panel" || type === "bordered_panel" || type === "weaver") {
    createBlockstate_square(material, type);
    createBlockModel_standard(material, type);
    createItemModel_standard(material, type);
}
else if (type === 'jellybean' || type === "slanted" || type === "zag") {
    createBlockstate_giant2x2(material, type);
    createBlockModel_standard(material, type);
    createItemModel_standard(material, type);
}
else if (type === 'pillar') {
    createBlockstate_pillar(material, type);
    createBlockModel_pillar(material, type);
    createItemModel_standard(material, type);
}
// standard 1x1 blocks.
else if (STANDARD_BRICKS.includes(type)) {
    createBlockstate_standard(material, type);
    createBlockModel_standard(material, type);
    createItemModel_standard(material, type);
}
else {
    console.error(`ERROR: Undefined type: ${type}.`);
}

createLootTable(material, type);

// FUNCTIONS

function getBsPath (material) {
    return `./src/main/resources/assets/chiselblocks/blockstates/${material}`;
}
function getBlockModelPath (material) {
    return `./src/main/resources/assets/chiselblocks/models/block/${material}`;
}
function getItemModelPath (material) {
    return `./src/main/resources/assets/chiselblocks/models/item/${material}`;
}
function getLootTablePath (material) {
    return `./src/main/resources/data/chiselblocks/loot_tables/blocks/${material}`;
}

function createBlockstate_standard (material, type) {
    const path = getBsPath(material) + "/" + type + ".json";

    const data = {
        "variants": {
            "": {
                "model": `chiselblocks:block/${material}/${type}`
            }
        }
    };

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}

function createBlockstate_square (material, type) {
    const path = getBsPath(material) + "/" + type + ".json";

    const data = {
        "variants": {
            "": {
                "model": `chiselblocks:block/${material}/${type}`
            }
        },
        "athena:loader": "athena:ctm",
        "ctm_textures": {
            "center": `chiselblocks:block/ctm/${material}/${type}/4`,
            "empty": `chiselblocks:block/ctm/${material}/${type}/1`,
            "horizontal": `chiselblocks:block/ctm/${material}/${type}/3`,
            "particle": `chiselblocks:block/ctm/${material}/${type}/0`,
            "vertical": `chiselblocks:block/ctm/${material}/${type}/2`,
        }
    };

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}

function createBlockstate_giant2x2 (material, type) {
    const path = getBsPath(material) + "/" + type + ".json";

    const data = {
        "variants": {
            "": {
                "model": `chiselbricks:block/${material}/${type}`
            }
        },
        "athena:loader": "athena:giant",
        "ctm_textures": {
            "1": `chiselbricks:block/ctm/${material}/${type}/0`,
            "2": `chiselbricks:block/ctm/${material}/${type}/1`,
            "3": `chiselbricks:block/ctm/${material}/${type}/2`,
            "4": `chiselbricks:block/ctm/${material}/${type}/3`,
            "particle": `chiselbricks:block/${material}/${type}`
        },
        "height": 2,
        "width": 2
    };

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}

function createBlockstate_random (material, type, amount) {
    const path = getBsPath(material) + "/" + type + ".json";

    const data = {
        "variants": {
            "": []
        }
    }

    for (let i = 0; i < amount; i++) {
        data["variants"][""].push({
            "model": `chiselblocks:block/${material}/${type}_${i}`,
            "weight": 1
        });
    }

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}

function createBlockstate_pillar (material, type, amount) {
    const path = getBsPath(material) + "/" + type + ".json";

    const data = {
        "variants": {
            "axis=x": {
                "model": `chiselbricks:block/${material}/${type}_horizontal`,
                "x": 90,
                "y": 90
            },
            "axis=y": {
                "model": `chiselbricks:block/${material}/${type}`
            },
            "axis=z": {
                "model": `chiselbricks:block/${material}/${type}_horizontal`,
                "x": 90
            }
        }
    };

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}

function createBlockModel_standard (material, type) {
    const path = getBlockModelPath(material) + "/" + type + ".json";

    const data = {
        "parent": "block/cube_all",
        "textures": {
            "all": `chiselblocks:block/${material}/${type}`
        }
    }

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}

function createBlockModel_randomPart (material, type, index) {
    const path = getBlockModelPath(material) + "/" + type + "_" + index + ".json";

    const data = {
        "parent": "block/cube_all",
        "textures": {
            "all": `chiselblocks:block/${material}/${type}/${index}`,
            "particle": `chiselbricks:block/${material}/${type}`
        }
    };

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}

function createBlockModel_pillar (material, type, index) {
    const path = getBlockModelPath(material) + "/" + type + ".json";
    const pathHoriz = getBlockModelPath(material) + "/" + type + "_horizontal.json";

    const data = {
        "parent": "minecraft:block/cube_column",
        "textures": {
            "end": `chiselbricks:block/${material}/${type}_top`,
            "side": `chiselbricks:block/${material}/${type}`
        }
    };
    const dataHoriz = {
        "parent": "minecraft:block/cube_column_horizontal",
        "textures": {
            "end": `chiselbricks:block/${material}/${type}_top`,
            "side": `chiselbricks:block/${material}/${type}`
        }
    };

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
    fs.writeFileSync(pathHoriz, JSON.stringify(dataHoriz, null, 4));
}

function createItemModel_standard (material, type) {
    const path = getItemModelPath(material) + "/" + type + ".json";

    const data = {
        "parent": `chiselblocks:block/${material}/${type}`
    }

    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}

function createLootTable (material, type) {
    const path = getLootTablePath(material, type);
    
    const data = {
        "type": "minecraft:block",
        "pools": [
            {
                "rolls": 1.0,
                "bonus_rolls": 0.0,
                "entries": [
                    {
                        "type": "minecraft:item",
                        "name": `chiselblocks:${material}/${type}`
                    }
                ],
                "conditions": [
                    {
                        "condition": "minecraft:survives_explosion"
                    }
                ]
            }
        ]
    };
    
    fs.writeFileSync(path + `/${type}.json`, JSON.stringify(data, null, 4));
}
