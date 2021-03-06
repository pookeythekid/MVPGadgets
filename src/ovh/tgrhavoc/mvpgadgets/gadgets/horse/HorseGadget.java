package ovh.tgrhavoc.mvpgadgets.gadgets.horse;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ovh.tgrhavoc.mvpgadgets.MVPGadgets;
import ovh.tgrhavoc.mvpgadgets.gadgets.Gadget;

public class HorseGadget extends Gadget{
	
	public HorseGadget(MVPGadgets plugin){
		super(plugin, "horseGadget", new ItemStack(Material.MONSTER_EGG, 1, (byte)100));
	}
	
	@Override
	public void execute(Player player) {
		for (Entity e: player.getWorld().getEntities()){
			if (e instanceof Horse){
				Horse h = (Horse)e;
				if (h.isCustomNameVisible() && (h.getCustomName().equals(player.getName() + "'s horse") )){
					e.remove();
				}
			}
		}
		Horse horse = (Horse)player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
		horse.setTamed(true);
		horse.setVariant(Horse.Variant.values()[new Random().nextInt(Horse.Variant.values().length)]); //Spawn random horse type
		horse.setOwner((AnimalTamer)player);
		horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		horse.setCustomName(player.getName() +"'s horse");
		horse.setCustomNameVisible(true);
		horse.setBreed(false);
		horse.setJumpStrength(1.0D);
		horse.setAdult();
		horse.setPassenger(player);
	}
}
