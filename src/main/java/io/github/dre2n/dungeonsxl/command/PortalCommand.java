/*
 * Copyright (C) 2012-2016 Frank Baumann
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.dre2n.dungeonsxl.command;

import io.github.dre2n.commons.command.BRCommand;
import io.github.dre2n.commons.util.messageutil.MessageUtil;
import io.github.dre2n.dungeonsxl.DungeonsXL;
import io.github.dre2n.dungeonsxl.config.MessageConfig;
import io.github.dre2n.dungeonsxl.config.MessageConfig.Messages;
import io.github.dre2n.dungeonsxl.global.DPortal;
import io.github.dre2n.dungeonsxl.player.DPlayer;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * @author Frank Baumann, Daniel Saukel
 */
public class PortalCommand extends BRCommand {

    protected static DungeonsXL plugin = DungeonsXL.getInstance();
    protected static MessageConfig messageConfig = plugin.getMessageConfig();

    public PortalCommand() {
        setCommand("portal");
        setMinArgs(0);
        setMaxArgs(0);
        setHelp(messageConfig.getMessage(Messages.HELP_CMD_PORTAL));
        setPermission("dxl.portal");
        setPlayerCommand(true);
    }

    @Override
    public void onExecute(String[] args, CommandSender sender) {
        Player player = (Player) sender;
        DPlayer dPlayer = DPlayer.getByPlayer(player);

        if (dPlayer != null) {
            MessageUtil.sendMessage(player, messageConfig.getMessage(Messages.ERROR_LEAVE_DUNGEON));
        }

        DPortal dPortal = DPortal.getByPlayer(player);

        if (dPortal == null) {
            dPortal = new DPortal(false);
            dPortal.setPlayer(player);
            dPortal.setWorld(player.getWorld());
            player.getInventory().setItemInHand(new ItemStack(Material.WOOD_SWORD));
            MessageUtil.sendMessage(player, messageConfig.getMessage(Messages.PLAYER_PORTAL_INTRODUCTION));

        } else {
            plugin.getDPortals().remove(dPortal);
            MessageUtil.sendMessage(player, messageConfig.getMessage(Messages.PLAYER_PORTAL_ABORT));
        }
    }

}