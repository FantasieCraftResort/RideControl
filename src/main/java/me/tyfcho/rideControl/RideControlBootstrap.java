package me.tyfcho.rideControl;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.bootstrap.PluginProviderContext;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The bootstrap class for the RideControl plugin.
 * This class is responsible for initializing the plugin during the bootstrap phase
 * and providing an instance of the main plugin class.
 */
public class RideControlBootstrap implements PluginBootstrap {

    /**
     * Called during the bootstrap phase of the plugin lifecycle.
     * This method is used to perform any early initialization logic.
     *
     * @param context The bootstrap context provided by the Paper API.
     */
    @Override
    public void bootstrap(BootstrapContext context) {
        context.getLogger().info("RideControl bootstrapper loaded");
    }

    /**
     * Creates and returns an instance of the main plugin class.
     * This method is called by the Paper API to initialize the plugin.
     *
     * @param context The plugin provider context provided by the Paper API.
     * @return An instance of the RideControl plugin.
     */
    @Override
    public JavaPlugin createPlugin(PluginProviderContext context) {
        return new RideControl();
    }
}