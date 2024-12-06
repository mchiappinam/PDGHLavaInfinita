package me.mchiappinam.pdghlavainfinita;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class Listeners implements Listener {

	private Main plugin;

	public Listeners(Main main) {
		plugin = main;
	}

	@EventHandler
	public void onFlow(BlockFromToEvent e) {
		BlockFace face = e.getFace();
		if ((face == BlockFace.SELF) || (face == BlockFace.DOWN) || (face == BlockFace.UP))
			return;
		final Block from = e.getBlock();
		final Block to = e.getToBlock();

		if (from.getType() == Material.STATIONARY_LAVA) {
			if (to.getType() == Material.STATIONARY_LAVA) {
				return;
			}
			if (from.getData() != 0) {
				return;
			}
			plugin.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
				public void run() {
					if (to.getType() == Material.LAVA) {
						BlockFace[] faces = { BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };

						for (BlockFace f : faces) {
							Block relative = to.getRelative(f);

							if ((!relative.getLocation().equals(from.getLocation()))
									&& (relative.getType() == Material.STATIONARY_LAVA)) {
		                        to.setTypeIdAndData(Material.LAVA.getId(), (byte) 0x0, true);
							}
						}
					}
				}
			}, 1L);
		}
	}
}
