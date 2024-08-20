package azaria.chiselblocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        ForgeRegistries.BLOCKS, ChiselBlocks.MOD_ID
    );

    public static void addToRegistry (IEventBus eventBus) {
        Stone.init();
        Granite.init();
        Diorite.init();
        Andesite.init();
        Sandstone.init();

        Planks_Oak.init();
        BLOCKS.register(eventBus);
    }

    public static class Stone {
        public static void init () {}

        public static final RegistryObject<Block> BORDERED_PANEL = registerStone("stone/bordered_panel");
        public static final RegistryObject<Block> BRAID = registerStone("stone/braid");
        public static final RegistryObject<Block> BRICKS_MEDIUM = registerStone("stone/bricks_medium");
        public static final RegistryObject<Block> BRICKS_SMALL = registerStone("stone/bricks_small");
        public static final RegistryObject<Block> CHAOTIC_BRICKS = registerStone("stone/chaotic_bricks");
        public static final RegistryObject<Block> CRACKED = registerStone("stone/cracked");
        public static final RegistryObject<Block> DENT = registerStone("stone/dent");
        public static final RegistryObject<Block> JELLYBEAN = registerStone("stone/jellybean");
        public static final RegistryObject<Block> LAYERED_BRICKS = registerStone("stone/layered_bricks");
        public static final RegistryObject<Block> PANEL = registerStone("stone/panel");
        public static final RegistryObject<RotatedPillarBlock> PILLAR = registerStonePillar("stone/pillar");
        public static final RegistryObject<Block> PRISM = registerStone("stone/prism");
        public static final RegistryObject<Block> SLANTED = registerStone("stone/slanted");
        public static final RegistryObject<Block> TILE = registerStone("stone/tile");
        public static final RegistryObject<Block> TILES_MEDIUM = registerStone("stone/tiles_medium");
        public static final RegistryObject<Block> TILES_SMALL = registerStone("stone/tiles_small");
        public static final RegistryObject<Block> WEAVER = registerStone("stone/weaver");
        public static final RegistryObject<Block> WINDMILL_BRICKS = registerStone("stone/windmill_bricks");
        public static final RegistryObject<Block> ZAG = registerStone("stone/zag");
    }

    public static class Granite {
        public static void init () {}

        public static final RegistryObject<Block> BORDERED_PANEL = registerStone("granite/bordered_panel");
        public static final RegistryObject<Block> BRAID = registerStone("granite/braid");
        public static final RegistryObject<Block> BRICKS_MEDIUM = registerStone("granite/bricks_medium");
        public static final RegistryObject<Block> BRICKS_SMALL = registerStone("granite/bricks_small");
        public static final RegistryObject<Block> CHAOTIC_BRICKS = registerStone("granite/chaotic_bricks");
        public static final RegistryObject<Block> CRACKED = registerStone("granite/cracked");
        public static final RegistryObject<Block> DENT = registerStone("granite/dent");
        public static final RegistryObject<Block> JELLYBEAN = registerStone("granite/jellybean");
        public static final RegistryObject<Block> LAYERED_BRICKS = registerStone("granite/layered_bricks");
        public static final RegistryObject<Block> PANEL = registerStone("granite/panel");
        public static final RegistryObject<RotatedPillarBlock> PILLAR = registerStonePillar("granite/pillar");
        public static final RegistryObject<Block> PRISM = registerStone("granite/prism");
        public static final RegistryObject<Block> SLANTED = registerStone("granite/slanted");
        public static final RegistryObject<Block> TILE = registerStone("granite/tile");
        public static final RegistryObject<Block> TILES_MEDIUM = registerStone("granite/tiles_medium");
        public static final RegistryObject<Block> TILES_SMALL = registerStone("granite/tiles_small");
        public static final RegistryObject<Block> WEAVER = registerStone("granite/weaver");
        public static final RegistryObject<Block> WINDMILL_BRICKS = registerStone("granite/windmill_bricks");
        public static final RegistryObject<Block> ZAG = registerStone("granite/zag");
    }

    public static class Diorite {
        public static void init () {}

        public static final RegistryObject<Block> BORDERED_PANEL = registerStone("diorite/bordered_panel");
        public static final RegistryObject<Block> BRAID = registerStone("diorite/braid");
        public static final RegistryObject<Block> BRICKS_MEDIUM = registerStone("diorite/bricks_medium");
        public static final RegistryObject<Block> BRICKS_SMALL = registerStone("diorite/bricks_small");
        public static final RegistryObject<Block> CHAOTIC_BRICKS = registerStone("diorite/chaotic_bricks");
        public static final RegistryObject<Block> CRACKED = registerStone("diorite/cracked");
        public static final RegistryObject<Block> DENT = registerStone("diorite/dent");
        public static final RegistryObject<Block> JELLYBEAN = registerStone("diorite/jellybean");
        public static final RegistryObject<Block> LAYERED_BRICKS = registerStone("diorite/layered_bricks");
        public static final RegistryObject<Block> PANEL = registerStone("diorite/panel");
        public static final RegistryObject<RotatedPillarBlock> PILLAR = registerStonePillar("diorite/pillar");
        public static final RegistryObject<Block> PRISM = registerStone("diorite/prism");
        public static final RegistryObject<Block> SLANTED = registerStone("diorite/slanted");
        public static final RegistryObject<Block> TILE = registerStone("diorite/tile");
        public static final RegistryObject<Block> TILES_MEDIUM = registerStone("diorite/tiles_medium");
        public static final RegistryObject<Block> TILES_SMALL = registerStone("diorite/tiles_small");
        public static final RegistryObject<Block> WEAVER = registerStone("diorite/weaver");
        public static final RegistryObject<Block> WINDMILL_BRICKS = registerStone("diorite/windmill_bricks");
        public static final RegistryObject<Block> ZAG = registerStone("diorite/zag");
    }

    public static class Andesite {
        public static void init () {}

        public static final RegistryObject<Block> BORDERED_PANEL = registerStone("andesite/bordered_panel");
        public static final RegistryObject<Block> BRAID = registerStone("andesite/braid");
        public static final RegistryObject<Block> BRICKS_MEDIUM = registerStone("andesite/bricks_medium");
        public static final RegistryObject<Block> BRICKS_SMALL = registerStone("andesite/bricks_small");
        public static final RegistryObject<Block> CHAOTIC_BRICKS = registerStone("andesite/chaotic_bricks");
        public static final RegistryObject<Block> CRACKED = registerStone("andesite/cracked");
        public static final RegistryObject<Block> DENT = registerStone("andesite/dent");
        public static final RegistryObject<Block> JELLYBEAN = registerStone("andesite/jellybean");
        public static final RegistryObject<Block> LAYERED_BRICKS = registerStone("andesite/layered_bricks");
        public static final RegistryObject<Block> PANEL = registerStone("andesite/panel");
        public static final RegistryObject<RotatedPillarBlock> PILLAR = registerStonePillar("andesite/pillar");
        public static final RegistryObject<Block> PRISM = registerStone("andesite/prism");
        public static final RegistryObject<Block> SLANTED = registerStone("andesite/slanted");
        public static final RegistryObject<Block> TILE = registerStone("andesite/tile");
        public static final RegistryObject<Block> TILES_MEDIUM = registerStone("andesite/tiles_medium");
        public static final RegistryObject<Block> TILES_SMALL = registerStone("andesite/tiles_small");
        public static final RegistryObject<Block> WEAVER = registerStone("andesite/weaver");
        public static final RegistryObject<Block> WINDMILL_BRICKS = registerStone("andesite/windmill_bricks");
        public static final RegistryObject<Block> ZAG = registerStone("andesite/zag");
    }

    public static class Sandstone {
        public static void init () {}

        public static final RegistryObject<Block> HIEROGLYPH = registerStone("sandstone/hieroglyph");
    }

    public static class Planks_Oak {
        public static void init () {}

        public static final RegistryObject<Block> BRAID = registerPlanks("planks/oak/braid");
        public static final RegistryObject<Block> CRUDE_HORIZONTAL = registerPlanks("planks/oak/crude_horizontal");
        public static final RegistryObject<Block> CRUDE_PANELING = registerPlanks("planks/oak/crude_paneling");
        public static final RegistryObject<Block> CRUDE_VERTICAL = registerPlanks("planks/oak/crude_vertical");
        public static final RegistryObject<Block> ENCASED = registerPlanks("planks/oak/encased");
        public static final RegistryObject<Block> ENCASED_LARGE = registerPlanks("planks/oak/encased_large");
        public static final RegistryObject<Block> ENCASED_SMOOTH = registerPlanks("planks/oak/encased_smooth");
        public static final RegistryObject<Block> LARGE = registerPlanks("planks/oak/large");
        public static final RegistryObject<Block> PANELING = registerPlanks("planks/oak/paneling");
        public static final RegistryObject<Block> SHIPPING_CRATE = registerPlanks("planks/oak/shipping_crate");
        public static final RegistryObject<Block> SMOOTH = registerPlanks("planks/oak/smooth");
        public static final RegistryObject<Block> STACKED = registerPlanks("planks/oak/stacked");
        public static final RegistryObject<Block> TILE = registerPlanks("planks/oak/tile");
    }

    public static <T extends Block> RegistryObject<T> register (
        String name, Supplier<T> block
    ) {
        RegistryObject<T> blockObj = BLOCKS.register(name, block);
        registerBlockItem(name, blockObj, ModCreativeModeTabs.CHISEL_BLOCKS_TAB);
        return blockObj;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem (
        String name, RegistryObject<T> block, CreativeModeTab tab
    ) {
        return ModItems.register(
            name,
            () -> new BlockItem(block.get(), new Item.Properties().tab(tab))
        );
    }


    private static RegistryObject<Block> registerStone (String id) {
        return ModBlocks.register(
            id,
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE))
        );
    }
    private static RegistryObject<RotatedPillarBlock> registerStonePillar (String id) {
        return ModBlocks.register(
            id,
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE))
        );
    }
    private static RegistryObject<Block> registerPlanks (String id) {
        return ModBlocks.register(
            id,
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS))
        );
    }
}
