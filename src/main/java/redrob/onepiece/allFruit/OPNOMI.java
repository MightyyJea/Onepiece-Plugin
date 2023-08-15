package redrob.onepiece.allFruit;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import redrob.onepiece.fruit.DevilFruit;
import redrob.onepiece.fruit.DevilType;
import redrob.onepiece.fruit.ParameciaFruit;

import javax.annotation.Nullable;


public class OPNOMI extends DevilFruit implements ParameciaFruit {
    private int RoomCooldown;
    public OPNOMI(){
        super(DevilType.OP_OP_NOMI, "op op nomi");
        this.RoomCooldown =10;
    }

    public void SneakInteraction(){
        this.getOwner().sendMessage("shambles");
        this.getOwner().getNearbyEntities(getOwner().getEyeLocation().getX(),getOwner().getEyeLocation().getY(),getOwner().getEyeLocation().getZ());
    }

    public void RightClickInteraction(){}
    public void LeftClickInteraction(){}

    public void DropInteraction(){
        if(this.RoomCooldown != 0){return;}
        this.RoomCooldown = 10;
        Player plr = this.getOwner();
        plr.sendMessage("ROOM !!!!");
        Location roomlocation = plr.getLocation();
        new BukkitRunnable(){
            private int cooldown = 0;
            @Override
            public void run(){
                if(cooldown == RoomCooldown){this.cancel();}
                cooldown++;
                for(int i = 0; i<= 360; i++){
                    double radian = Math.toRadians(i);
                    double x = Math.cos(radian) *10;
                    double z = Math.sin(radian) *10;
                    plr.spawnParticle(Particle.PORTAL, roomlocation.clone().add(x,0,z),1);
                }
            }
        }.runTaskTimer(this.getPlugin(),0,20);
    }
}
