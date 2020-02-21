package me.hsgamer.bettergui.noteblock;

import com.cryptomorin.xseries.NoteBlockMusic;
import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import me.hsgamer.bettergui.object.Command;
import org.bukkit.entity.Player;

public class PlayMusic extends Command {

  public PlayMusic(String string) {
    super(string);
  }

  @Override
  public void addToTaskChain(Player player, TaskChain<?> taskChain) {
    String parsed = getParsedCommand(player);
    taskChain
        .sync(() -> NoteBlockMusic.playMusic(player, player.getLocation(), parsed).cancel(true));
  }
}
