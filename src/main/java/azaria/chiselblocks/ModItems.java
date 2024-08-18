package azaria.chiselblocks;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, ChiselBlocks.MOD_ID
    );

    public static <I extends Item> RegistryObject<I> register (
        final String name, final Supplier<? extends I> sup
    ) {
        return ITEMS.register(name, sup);
    }

    public static void addToRegistry (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
