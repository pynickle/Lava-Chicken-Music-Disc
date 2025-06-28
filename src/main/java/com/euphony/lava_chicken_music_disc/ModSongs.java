package com.euphony.lava_chicken_music_disc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.JukeboxSong;

public interface ModSongs {
    ResourceKey<JukeboxSong> LAVA_CHICKEN = of("lava_chicken");

    private static ResourceKey<JukeboxSong> of(String id) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(LavaChickenMusicDisc.MOD_ID, id));
    }
}
