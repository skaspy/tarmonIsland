/*
 *
 * (c) 2018 by JoachimWe
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
package Spielelogik;

import Lehen.Lehenmanager;
import java.util.ArrayList;
import java.util.Date;

public class Players {

    private ArrayList<Player> players = new ArrayList<>();

    private static final Players t = new Players();

    public static Players getInstance() {
        return t;
    }

    private Players() {
    }

    public void connectPlayer(String nickname, String sessionId, Date lastActiv) {
        Lehen.Lehen lehen = Lehenmanager.getInstance().allocateLehen();
        getPlayers().add(new Player(sessionId, nickname, lehen, lastActiv));
    }

    public Player getPlayer(String sessionId) {
        Player result = null;
        for (Player p : getPlayers()) {
            if (p.getSessionId().equals(sessionId)) {
                result = p;
            }
        }

        return result;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
