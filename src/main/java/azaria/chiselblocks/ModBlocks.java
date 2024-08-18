package azaria.chiselblocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
        BLOCKS.register(eventBus);
    }

    public static class Stone {
        public static void init () {}

        public static final RegistryObject<Block> BRAID = registerStone("stone/braid");
        public static final RegistryObject<Block> CHAOTIC_BRICKS = registerStone("stone/chaotic_bricks");
        public static final RegistryObject<Block> CRACKED = registerStone("stone/cracked");
        public static final RegistryObject<Block> DENT = registerStone("stone/dent");
        public static final RegistryObject<Block> JELLYBEAN = registerStone("stone/jellybean");
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
}
