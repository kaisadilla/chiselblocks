package azaria.chiselblocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
        Sandstone.init();
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

    public static class Sandstone {
        public static void init () {}

        public static final RegistryObject<Block> HIEROGLYPH = registerStone("sandstone/hieroglyph");
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
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE))
        );
    }
    private static RegistryObject<RotatedPillarBlock> registerStonePillar (String id) {
        return ModBlocks.register(
            id,
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE))
        );
    }
}
