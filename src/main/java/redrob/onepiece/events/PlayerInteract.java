package redrob.onepiece.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import redrob.onepiece.OnePiece;

public class PlayerInteract implements Listener {
    final OnePiece plugin;
    public PlayerInteract(OnePiece plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (e.getClickedBlock().getType().equals(Material.PLAYER_HEAD) ){
                Location FinalLocation = plugin.getFruitManager().getFloorLocation(e.getClickedBlock().getLocation());
                e.getPlayer().sendMessage(FinalLocation.toString());
                plugin.getFruitManager().addOwner(e.getPlayer(), plugin.getFruitManager().getDevilBlockFruitWithLocation(FinalLocation));

                plugin.getFruitManager().deleteBlockFruit(FinalLocation);

                e.getPlayer().sendMessage(this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).getDevilType().toString());
            }
        }
        if(this.plugin.getFruitManager().isAOwner(e.getPlayer()) && this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).getFruitItem().equals(e.getPlayer().getItemInUse())){

            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).RightClickInteraction();
            }
            if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
                this.plugin.getFruitManager().getDevilFruitWithPlayer(e.getPlayer()).LeftClickInteraction();
            }
            e.setCancelled(true);
        }
    }
}
