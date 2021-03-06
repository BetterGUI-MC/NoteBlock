package me.hsgamer.bettergui.noteblock;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import me.hsgamer.bettergui.builder.CommandBuilder;
import me.hsgamer.bettergui.object.addon.Addon;

public final class Main extends Addon {

  private static final Map<String, Path> musicFiles = new HashMap<>();

  public static Path getMusicPath(String name) {
    return musicFiles.get(name);
  }

  public static boolean containsMusicFile(String name) {
    return musicFiles.containsKey(name);
  }

  @Override
  public boolean onLoad() {
    inputMusicFile(getDataFolder());
    return true;
  }

  private void inputMusicFile(File file) {
    if (file.isDirectory()) {
      for (File subFile : Objects.requireNonNull(file.listFiles())) {
        inputMusicFile(subFile);
      }
    } else {
      musicFiles.put(file.getName(), file.toPath());
    }
  }

  @Override
  public void onEnable() {
    CommandBuilder.register("sound:", PlaySound.class);
    CommandBuilder.register("raw-sound:", PlayRawSound.class);
    CommandBuilder.register("music:", PlayMusic.class);
  }

  @Override
  public void onReload() {
    musicFiles.clear();
    inputMusicFile(getDataFolder());
  }
}
