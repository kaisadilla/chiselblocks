package azaria.chiselblocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
        DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ChiselBlocks.MOD_ID);

    public static final RegistryObject<SoundEvent> BREAK_METAL = registerSoundEvent("break_metal");
    public static final RegistryObject<SoundEvent> FALL_METAL = registerSoundEvent("fall_metal");
    public static final RegistryObject<SoundEvent> HIT_METAL = registerSoundEvent("hit_metal");
    public static final RegistryObject<SoundEvent> PLACE_METAL = registerSoundEvent("place_metal");
    public static final RegistryObject<SoundEvent> STEP_METAL = registerSoundEvent("step_metal");

    public static final ForgeSoundType METAL_BLOCK_SOUNDS = new ForgeSoundType(
        1f, 1f, BREAK_METAL, STEP_METAL, PLACE_METAL, HIT_METAL, FALL_METAL
    );

    private static RegistryObject<SoundEvent> registerSoundEvent (String name) {
        var id = new ResourceLocation(ChiselBlocks.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void addToRegistry (IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
