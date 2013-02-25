package me.blha303;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ArmorColorSetter extends JavaPlugin {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p;
		if (sender instanceof Player) {
			p = (Player) sender;
			if (p.getItemInHand().getType() == Material.LEATHER_BOOTS 
					|| p.getItemInHand().getType() == Material.LEATHER_CHESTPLATE 
					|| p.getItemInHand().getType() == Material.LEATHER_LEGGINGS 
					|| p.getItemInHand().getType() == Material.LEATHER_HELMET) {
				if (args.length == 3) {
					String red = args[0];
					String green = args[1];
					String blue = args[2];
					Color color;
					LeatherArmorMeta am = (LeatherArmorMeta) p.getItemInHand().getItemMeta();
					try { 
						color = Color.fromRGB(Integer.parseInt(red), 
								Integer.parseInt(green), 
								Integer.parseInt(blue)); 
					} catch (NumberFormatException e) { 
						sender.sendMessage("Please use numbers.");
						return false; 
					}
					am.setColor(color);
					p.getItemInHand().setItemMeta(am);
					return true;
				} else {
					return false;
				}
			} else {
				sender.sendMessage("You can only use leather armor with this command");
				return true;
			}
		} else {
			sender.sendMessage("Only players can use this command");
			return true;
		}
	}
}
