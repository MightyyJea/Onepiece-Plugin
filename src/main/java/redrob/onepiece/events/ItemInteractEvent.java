package redrob.onepiece.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import redrob.onepiece.OnePiece;

public class ItemInteractEvent implements Listener {
    private OnePiece plugin;
    public ItemInteractEvent(OnePiece plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void itemInteract(PlayerSwapHandItemsEvent e){
        if(plugin.getFruitManager().isAOwner(e.getPlayer()) && e.getOffHandItem().equals(this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).getFruitItem()) ){
            e.getPlayer().sendMessage("Owner swap");
            e.setCancelled(true);
        }
    }
}
