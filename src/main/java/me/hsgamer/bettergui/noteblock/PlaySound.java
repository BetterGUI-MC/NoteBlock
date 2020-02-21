package me.hsgamer.bettergui.noteblock;

import com.cryptomorin.xseries.XSound;
import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import me.hsgamer.bettergui.object.Command;
import org.bukkit.entity.Player;

public class PlaySound extends Command {

  public PlaySound(String string) {
    super(string);
  }

  @Override
  public void addToTaskChain(Player player, TaskChain<?> taskChain) {
    String parsed = getParsedCommand(player);
    taskChain.sync(() -> XSound.playSoundFromString(player, parsed).join());
  }
}
