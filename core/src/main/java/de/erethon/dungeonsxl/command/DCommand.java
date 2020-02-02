/*
 * Copyright (C) 2012-2020 Frank Baumann
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
package de.erethon.dungeonsxl.command;

import de.erethon.commons.command.DRECommand;
import de.erethon.dungeonsxl.DungeonsXL;
import de.erethon.dungeonsxl.config.MainConfig;
import de.erethon.dungeonsxl.player.DPlayerCache;
import de.erethon.dungeonsxl.world.DWorldCache;

/**
 * @author Daniel Saukel
 */
public abstract class DCommand extends DRECommand {

    protected DungeonsXL plugin;
    protected MainConfig config;
    protected DPlayerCache dPlayers;
    protected DWorldCache instances;

    protected DCommand(DungeonsXL plugin) {
        this.plugin = plugin;
        config = plugin.getMainConfig();
        dPlayers = plugin.getDPlayerCache();
        instances = plugin.getDWorldCache();
    }

}
