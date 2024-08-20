/* note:
  renames:
  - panel -> tile,
  - tiles_large -> panel,
  - layers -> layered_bricks,
  - mosaic -> bordered_panel,
  - road -> windmill_bricks,
  - triple_bricks -> bricks_medium
  - small_bricks -> bricks_small
  - pillar-side -> pillar
  - pillar-top -> pillar_top
  PLANKS:
  create: - tile from smooth
*/

// regex for tags: public [^\n]* = registerStone\("

const STANDARD_STONE_BLOCKS = [
    "braid",
    "cracked",
    "layered_bricks",
    "tile",
    "prism",
    "windmill_bricks",
    "bricks_small",
    "bricks_medium",
    "tiles_medium",
    "tiles_small",
];
const STANDARD_PLANKS_BLOCKS = [
    "crude_paneling",
    "large",
    "stacked",
    "tile",
];

const fs = require("fs");

let type = process.argv[2];
let material = process.argv[3];
let pattern = process.argv[4];

console.log(`Creating assets for block with id '${material}/${pattern}'.`);

fs.mkdirSync(getBsPath(material), { recursive: true });
fs.mkdirSync(getBlockModelPath(material), { recursive: true });
fs.mkdirSync(getItemModelPath(material), { recursive: true });
fs.mkdirSync(getLootTablePath(material), { recursive: true });

if (type === 'stone') {
    if (pattern === 'chaotic_bricks') {
        const AMOUNT = 9;
        createBlockstate_random(material, pattern, AMOUNT);
    
        for (let i = 0; i < AMOUNT; i++) {
            createBlockModel_randomPart(material, pattern, i);
        }
    
        createItemModel_random(material, pattern);
    }
    else if (pattern === 'dent' || pattern === "panel" || pattern === "bordered_panel" || pattern === "weaver") {
        createBlockstate_square(material, pattern);
        createBlockModel_standard(material, pattern);
        createItemModel_standard(material, pattern);
    }
    else if (pattern === 'jellybean' || pattern === "slanted" || pattern === "zag") {
        createBlockstate_giant2x2(material, pattern);
        createBlockModel_standard(material, pattern);
        createItemModel_standard(material, pattern);
    }
    else if (pattern === 'pillar') {
        createBlockstate_pillar(material, pattern);
        createBlockModel_pillar(material, pattern);
        createItemModel_standard(material, pattern);
    }
    else if (pattern === 'hieroglyph') {
        const AMOUNT = 16;
        createBlockstate_random(material, pattern, AMOUNT);
    
        for (let i = 0; i < AMOUNT; i++) {
            createBlockModel_randomPart(material, pattern, i);
        }
    
        createItemModel_random(material, pattern);
    }
    // standard 1x1 blocks.
    else if (STANDARD_STONE_BLOCKS.includes(pattern)) {
        createBlockstate_standard(material, pattern);
        createBlockModel_standard(material, pattern);
        createItemModel_standard(material, pattern);
    }
    else {
        console.error(`ERROR: Undefined type: ${pattern}.`);
    }
}
else if (type === 'planks') {
    if (pattern === 'braced') {
        // side
    }
    else if (pattern === 'braid' || pattern === 'encased_large' || pattern === 'encased' || pattern === 'encased_smooth' || pattern === 'paneling' || pattern === 'shipping_crate' || pattern === 'smooth') {
        createBlockstate_square(material, pattern);
        createBlockModel_standard(material, pattern);
        createItemModel_standard(material, pattern);
    }
    else if (pattern === 'crude_horizontal' || pattern === 'crude_vertical') {
        createBlockstate_giant2x2(material, pattern);
        createBlockModel_standard(material, pattern);
        createItemModel_standard(material, pattern);
    }
    // standard 1x1 blocks.
    else if (STANDARD_PLANKS_BLOCKS.includes(pattern)) {
        createBlockstate_standard(material, pattern);
        createBlockModel_standard(material, pattern);
        createItemModel_standard(material, pattern);
    }
    else {
        console.error(`ERROR: Undefined type: ${pattern}.`);
    }
}

createLootTable(material, pattern);

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
                "model": `chiselblocks:block/${material}/${type}`
            }
        },
        "athena:loader": "athena:giant",
        "ctm_textures": {
            "1": `chiselblocks:block/ctm/${material}/${type}/0`,
            "2": `chiselblocks:block/ctm/${material}/${type}/1`,
            "3": `chiselblocks:block/ctm/${material}/${type}/2`,
            "4": `chiselblocks:block/ctm/${material}/${type}/3`,
            "particle": `chiselblocks:block/${material}/${type}`
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
                "model": `chiselblocks:block/${material}/${type}_horizontal`,
                "x": 90,
                "y": 90
            },
            "axis=y": {
                "model": `chiselblocks:block/${material}/${type}`
            },
            "axis=z": {
                "model": `chiselblocks:block/${material}/${type}_horizontal`,
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
            "all": `chiselblocks:block/${material}/${type}_${index}`,
            "particle": `chiselblocks:block/${material}/${type}`
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
            "end": `chiselblocks:block/${material}/${type}_top`,
            "side": `chiselblocks:block/${material}/${type}`
        }
    };
    const dataHoriz = {
        "parent": "minecraft:block/cube_column_horizontal",
        "textures": {
            "end": `chiselblocks:block/${material}/${type}_top`,
            "side": `chiselblocks:block/${material}/${type}`
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

function createItemModel_random (material, type, index = 0) {
    const path = getItemModelPath(material) + "/" + type + ".json";

    const data = {
        "parent": `chiselblocks:block/${material}/${type}_${index}`
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
