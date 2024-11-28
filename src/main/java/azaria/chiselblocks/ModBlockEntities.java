package azaria.chiselblocks;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
        ForgeRegistries.BLOCK_ENTITY_TYPES, ChiselBlocks.MOD_ID
    );


    public static void addToRegistry (IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<ChiselingTableBlockEntity>> CHISELING_TABLE =
        BLOCK_ENTITIES.register(
            "chiseling_table",
            () -> BlockEntityType.Builder.of(
                ChiselingTableBlockEntity::new,
                ModBlocks.CHISELING_TABLE.get()
            ).build(null)
        );
}
