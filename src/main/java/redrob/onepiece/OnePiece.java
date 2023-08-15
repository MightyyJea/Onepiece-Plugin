package redrob.onepiece;

import org.bukkit.plugin.java.JavaPlugin;
import redrob.onepiece.command.spawnFruit;
import redrob.onepiece.events.*;
import redrob.onepiece.fruit.DevilFruitManager;

public final class OnePiece extends JavaPlugin {

    private DevilFruitManager FruitManager;

    @Override
    public void onEnable() {
        this.FruitManager = new DevilFruitManager(this);

        //event
        getServer().getPluginManager().registerEvents(new PlayerInteract(this), this);
        getServer().getPluginManager().registerEvents(new ItemInteractEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDropEvent(this), this);
        getServer().getPluginManager().registerEvents(new placeBlockEvent(this), this);

        //command
        this.getCommand("spawnFruit").setExecutor(new spawnFruit(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public DevilFruitManager getFruitManager(){
        return this.FruitManager;
    }
}
