package redrob.onepiece.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import redrob.onepiece.OnePiece;

public class PlayerSneak implements Listener {
    final OnePiece plugin;
    public PlayerSneak(OnePiece plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent e){
        e.getPlayer().sendMessage("player sneak");
        if(this.plugin.getFruitManager().isAOwner(e.getPlayer()) && this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).getFruitItem().equals(e.getPlayer().getItemInUse()) && e.isSneaking()){
            this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).SneakInteraction();
            e.getPlayer().sendMessage("owner sneak");
            e.getPlayer().sendMessage("test");
        }
    }
}
