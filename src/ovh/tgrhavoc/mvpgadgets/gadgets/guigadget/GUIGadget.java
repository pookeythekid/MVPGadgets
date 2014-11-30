package ovh.tgrhavoc.mvpgadgets.gadgets.guigadget;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ovh.tgrhavoc.mvpgadgets.gadgets.Gadget;

public class GUIGadget extends Gadget {
	
	public GUIGadget(ItemStack myItem) {
		setItemStack(ChatColor.GOLD + "Open" + ChatColor.GREEN +" Gadget"+ChatColor.GOLD+" Selector"
				+ChatColor.BLUE, myItem);
		isGUI = true;
		
	}
	
	@Override
	public void execute(Player player) {
		player.openInventory(GUIGadgetListener.getInv());
	}

}
