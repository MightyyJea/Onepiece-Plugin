package redrob.onepiece.fruit;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import redrob.onepiece.OnePiece;

import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

public abstract class DevilFruit {
    private DevilType devilType;
    private OnePiece plugin;
    private ItemStack fruitItem;
     public DevilFruit(DevilType devilType, String name){
        this.fruitItem = new ItemStack(Material.NETHER_STAR,1);
        //this.fruitItem.getItemMeta().setDisplayName(name);
        this.devilType = devilType;
        this.plugin = (OnePiece) Bukkit.getPluginManager().getPlugin("OnePiece");
    }

    public DevilType getDevilType() {
        return devilType;
    }

    public abstract void DropInteraction();
    public abstract void SneakInteraction();
    public abstract void LeftClickInteraction();
    public abstract void RightClickInteraction();



    public void setDevilType(DevilType devilType) {
        this.devilType = devilType;
    }

    public ItemStack getFruitItem(){
        return this.fruitItem;
    }

    public Player getOwner(){
         for(Map.Entry<Player, DevilFruit> entry : this.plugin.getFruitManager().getOwners().entrySet()){
             if (entry.getValue().getDevilType() == this.devilType){
                 return entry.getKey();
             }
         }
         return null;
    }

    public OnePiece getPlugin(){
         return this.plugin;
    }

    public Boolean IsFruitItem(ItemStack item){
        if(this.getFruitItem().equals(item)){
            return true;
        }
        else return false;
    }

}
