package azaria.chiselblocks;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(
        ForgeRegistries.RECIPE_SERIALIZERS, ChiselBlocks.MOD_ID
    );

    public static void addToRegistry (IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

    public static final RegistryObject<RecipeSerializer<ChiselingTableRecipe>> CHISELING_TABLE_RECIPE
        = SERIALIZERS.register(
            ChiselingTableRecipe.RECIPE_NAME,
            () -> ChiselingTableRecipe.Serializer.INSTANCE
        );
}
