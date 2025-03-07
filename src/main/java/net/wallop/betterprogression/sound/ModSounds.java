package net.wallop.betterprogression.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;

public class ModSounds {
    public static final SoundEvent ARID_ECHOES = registerSoundEvent("arid_echoes");
    public static final RegistryKey<JukeboxSong> ARID_ECHOES_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(BetterProgression.MOD_ID, "arid_echoes"));


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(BetterProgression.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        BetterProgression.LOGGER.info("Registering Mod Sounds for {}", BetterProgression.MOD_ID);
    }
}
