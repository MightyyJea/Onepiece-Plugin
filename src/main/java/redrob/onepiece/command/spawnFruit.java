package redrob.onepiece.command;

import com.mojang.datafixers.TypeRewriteRule;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import redrob.onepiece.OnePiece;
import redrob.onepiece.allFruit.OPNOMI;
import redrob.onepiece.fruit.DevilType;
import redrob.onepiece.fruit.ParameciaFruit;

public class spawnFruit implements CommandExecutor {
    private OnePiece plugin;
    public spawnFruit(OnePiece plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player plr = (Player) commandSender;

        BlockData playerHeadData = Bukkit.createBlockData(Material.PLAYER_HEAD);
        Location location = this.plugin.getFruitManager().getFloorLocation(plr.getLocation());

        Block playerheadBlock = plr.getWorld().getBlockAt(location);

        playerheadBlock.setType(Material.PLAYER_HEAD);
        playerheadBlock.setBlockData(playerHeadData);

        this.plugin.getFruitManager().addDevilBlockFruit(location, new OPNOMI());

        return true;
    }
}
