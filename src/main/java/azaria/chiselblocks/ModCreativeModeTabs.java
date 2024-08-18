package azaria.chiselblocks;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTabs {
    public static final CreativeModeTab CHISEL_BLOCKS_TAB = new CreativeModeTab("chiselblocks") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModBlocks.Stone.DENT.get());
        }
    };
}
