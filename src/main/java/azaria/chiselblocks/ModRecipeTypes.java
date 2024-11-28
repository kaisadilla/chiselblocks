package azaria.chiselblocks;

import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
        ForgeRegistries.RECIPE_TYPES, ChiselBlocks.MOD_ID
    );

    public static void addToRegistry (IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }

    public static final RegistryObject<RecipeType<ChiselingTableRecipe>> CHISELING_TABLE
        = registerType(
            ChiselingTableRecipe.RECIPE_NAME,
            () -> RecipeType.simple(ChiselingTableRecipe.ID)
        );

    private static <T extends Recipe<Container>> RegistryObject<RecipeType<T>> registerType(
        String name, Supplier<RecipeType<T>> type
    ) {
        return RECIPE_TYPES.register(name, type);
    }
}
