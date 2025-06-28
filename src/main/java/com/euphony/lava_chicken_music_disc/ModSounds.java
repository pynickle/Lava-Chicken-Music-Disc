package com.euphony.lava_chicken_music_disc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, LavaChickenMusicDisc.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_LAVA_CHICKEN = SOUNDS.register(
            "music_disc.lava_chicken",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(LavaChickenMusicDisc.MOD_ID, "music_disc.lava_chicken"))
    );
}
