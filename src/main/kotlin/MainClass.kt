import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryType
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin
import java.awt.Container

class MainClass : JavaPlugin(), Listener {
    override fun onEnable() {
        logger.info("Hello World")
        server.pluginManager.registerEvents(this, this)
    }

    override fun onDisable() {
        super.onDisable()
    }

    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        val player = e.player
        if(player.inventory.itemInMainHand.type == Material.CRAFTING_TABLE) {
            val craftingTable = Bukkit.createInventory(null, InventoryType.CRAFTING, "Mobile Crafting")
            player.openInventory(craftingTable)
        }
    }
}