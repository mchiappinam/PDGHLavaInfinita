package me.mchiappinam.pdghlavainfinita;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2iniciando...");
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2registrando eventos...");
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2eventos registrados");
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2ativado - Developed by mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2Acesse: http://pdgh.com.br/");
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2Acesse: https://hostload.com.br/");
	}
	    
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2desativado - Developed by mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2Acesse: http://pdgh.com.br/");
		getServer().getConsoleSender().sendMessage("§3[PDGHLavaInfinita] §2Acesse: https://hostload.com.br/");
	}
}
