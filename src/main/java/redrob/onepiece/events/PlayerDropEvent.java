package redrob.onepiece.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import redrob.onepiece.OnePiece;

public class PlayerDropEvent implements Listener {
    final OnePiece plugin;

    public PlayerDropEvent(OnePiece plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void DropEvent(PlayerDropItemEvent e ){
        if(this.plugin.getFruitManager().isAOwner(e.getPlayer()) && e.getItemDrop().getItemStack().equals(this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).getFruitItem())){
            //e.getPlayer().getInventory().setItem(0,e.getItemDrop().getItemStack());
            //e.getItemDrop().getItemStack().setType(Material.AIR);

            this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).DropInteraction();

            e.getPlayer().sendMessage(this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).getDevilType().toString());
            e.getPlayer().sendMessage("Owner dropped");

            e.setCancelled(true);
        }
    }
}
