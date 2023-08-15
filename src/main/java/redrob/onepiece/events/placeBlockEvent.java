package redrob.onepiece.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import redrob.onepiece.OnePiece;

public class placeBlockEvent implements Listener {
    private OnePiece plugin;
    public placeBlockEvent(OnePiece plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void OnPlaceBlock(BlockPlaceEvent e ){
        if(plugin.getFruitManager().isAOwner(e.getPlayer()) && this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).getFruitItem().equals(e.getItemInHand())){
            e.setCancelled(true);
        }
    }
}
