package redrob.onepiece.fruit;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import redrob.onepiece.OnePiece;
import redrob.onepiece.allFruit.DEFAULTFRUIT;

import java.util.HashMap;

import java.util.Map;

public class DevilFruitManager {
    private Map<Player, DevilFruit> Owners;
    private Map<Location, DevilFruit> DevilMap;
    private OnePiece plugin;
    public DevilFruitManager(OnePiece plugin){
        this.Owners = new HashMap<>();
        this.DevilMap = new HashMap<>();
        this.plugin = plugin;
    }
    public void addOwner(Player plr , DevilFruit fruit){
        this.Owners.put(plr, fruit);
        //SkullMeta skull = (SkullMeta) FruitItem.getItemMeta();
        //GameProfile profile = ((CraftPlayer)plr).getProfile();
        //profile.getProperties().put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY4ODg1NTQyMjgzNywKICAicHJvZmlsZUlkIiA6ICI1ZGU2OTI3MjhjZGM0Nzg3YmEyMDVhMjUwNzMzODA1YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJYemVyb2xheSIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8xMGEwMTkzNGU4M2U3ZTQ0NGUzNmVhZmQ4MDM3Y2UyYjMxYmE4OWU3OGUwN2Q0NTAyY2EzMmIxNDc5YTgyMTBhIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=", "Z0NXAFWLrip+Niwyht7n7A++NSK1ZvrponJHQdEtOIG6NiP+mR7dtglAPQ+NPdDvEOClVVauh+0qfd5vZOTKNujwiroG+wc8OhDoTu6VN8v6SYfcD9rl8522eGlItoNZRBiUSAE667VW4+yDoJZiY6f/QLx2QfaS2nkRV0JBpNq2aXNMshQD9pvgYlXml2P8IMcC3x/2XbUgaOyToeP14j9CBnTB6P6DO7tId9lb/9ZBDUzMofSOvlF3ivzdo2Rt0HoQwjSFlqOYdCAZCIaipMhefERV/12UyBLhDLtYgS4/5lroltHhDpp+pPrlugYpblEAHt7EanhxxCMZZysNwsnkwYKrdak5gJi06U8izP2dV64HwDgmC3a3+mJPyW34JZaUkNxfVEZiLnqJTMs5mBQOnnkE5bAuzL4rFIzGajHHk2Qox+mIV73ys3dOyzFwRpkHIM8jwrJ+/1DGPIH7LMUET0jzQ/x1D22EEXeDE/juK0CQiq0sPWTK4JmeDJLcPRfz9gnpKfjIC+Q+slX4QSVXNua2BqCGyHsb4ueS9C60bS358CxysQr46gJn1AniMjTL84OgmmaOgewHPuV0zxNbOYQDwocnYsskWRY1eui+7rdtcxDUQ0oJu/iDjAA9QCpYqDAOG15Z4bcUekMjEJ2Re4MqJ6n2zqd/Hqle+gs="));
        //skull.setOwnerProfile((PlayerProfile) profile);
        //FruitItem.setItemMeta(skull);
        plr.getInventory().setItem(0, fruit.getFruitItem());
    }
    public Map<Player, DevilFruit> getOwners(){
        return this.Owners;
    }
    public void addDevilBlockFruit(Location location, DevilFruit devilFruit){
        this.DevilMap.put(location, devilFruit);
    }

    public DevilFruit getDevilBlockFruitWithType(String deviltype){
        for (Map.Entry<Location, DevilFruit> entry : DevilMap.entrySet()) {
            if (entry.getValue().getDevilType().toString().equals(deviltype)){
                return entry.getValue();
            }
        }
        return null;
    }

    public DevilFruit getDevilBlockFruitWithLocation(Location location){
        for(Map.Entry<Location, DevilFruit> entry :  this.DevilMap.entrySet()){
            this.plugin.getServer().broadcastMessage(entry.getValue().toString());
            this.plugin.getServer().broadcastMessage(entry.getKey().toString());
        }

        return this.DevilMap.getOrDefault(location, new DEFAULTFRUIT());
    }

    public DevilFruit getDevilFruitWithPlayer(Player plr){
        return this.Owners.getOrDefault(plr, new DEFAULTFRUIT());
    }

    public void deleteBlockFruit(Location location){
        this.DevilMap.remove(location);
        Bukkit.getWorld("world").getBlockAt(location).setType(Material.AIR);
    }

    public Boolean isAOwner(Player plr){
        if (this.getOwners().containsKey(plr)){
            return true;
        }
        else return false;
    }

    public void spawnBlockFruit(){

    }
    public Location getFloorLocation(Location location){
        return new Location(location.getWorld(), Math.floor(location.getX()), Math.floor(location.getY()), Math.floor(location.getZ()), 0.0f, 0.0f);
    }

}
