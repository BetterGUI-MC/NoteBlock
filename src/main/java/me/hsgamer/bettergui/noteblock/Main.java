package me.hsgamer.bettergui.noteblock;

import me.hsgamer.bettergui.builder.CommandBuilder;
import me.hsgamer.bettergui.object.addon.Addon;

public final class Main extends Addon {

  @Override
  public void onEnable() {
    CommandBuilder.register("sound:", PlaySound.class);
  }
}
