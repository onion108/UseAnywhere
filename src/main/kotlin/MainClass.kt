import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryType
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin

class MainClass : JavaPlugin(), Listener {
    override fun onEnable() {
        logger.info("Hello World")
        getCommand("use")?.setExecutor(this)
    }

    override fun onDisable() {
        super.onDisable()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender is ConsoleCommandSender) {
            val s: ConsoleCommandSender = sender
            s.sendMessage("Oh fuck. Since you send the command from console, do you think you will use anything?")
        } else {
            val player = sender as Player
            when(command.name) {
                "use" -> {
                    when(player.inventory.itemInMainHand.type) {
                        Material.CRAFTING_TABLE -> {
                            val i = Bukkit.createInventory(null, InventoryType.CRAFTING, "Mobile Crafting >>>CMCC")
                            player.openInventory(i)
                        }
                        Material.ANVIL, Material.CHIPPED_ANVIL, Material.DAMAGED_ANVIL -> {
                            val i = Bukkit.createInventory(null, InventoryType.ANVIL, "Mobile Anvil >>>CMCC")
                            player.openInventory(i)
                        }
                        else -> {
                            player.sendRawMessage("${ChatColor.RED}DO YOU THINK YOU CAN USE A ${player.inventory.itemInMainHand.type.name.uppercase()} !!?")
                        }
                    }
                }
            }
        }
        return true
    }
}