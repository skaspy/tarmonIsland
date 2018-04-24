/*
 *
 * (c) 2018 by SabineKa
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
package Lehen;

import java.util.ArrayList;

public class Lehenmanager {

    private static final String[] NAMEN = {"Dillingfurt", "Wurzbourgh", "Augsboria", "Passuraurus", "NyVein"};
    //private static boolean[] vergeben = {false, false, false, false, false};
    private static final int ANZAHL_LEHEN = 5;

    private ArrayList<Lehen> island = new ArrayList<Lehen>();

    //TODO  Graph via ArrayList der Knoten und jeder Knoten enthält eine ArrayList mit den Nachbarn
    private static final Lehenmanager t = new Lehenmanager();

    public static Lehenmanager getInstance() {
        return t;
    }

    private Lehenmanager() {

        island.add(new Lehen(1, NAMEN[0]));
        island.add(new Lehen(2, NAMEN[1]));
        island.add(new Lehen(3, NAMEN[2]));
        island.add(new Lehen(4, NAMEN[3]));
        island.add(new Lehen(5, NAMEN[4]));
    }

    public Lehen allocateLehen() {
        int ID = -1;
        Lehen lehen = null;
        boolean oneFree = false;
        for (int i = 0; i < island.size(); i++) {
            if (island.get(i).isVergeben() == false) {
                oneFree = true;
            } else {
                System.out.println("Maximale Spieleranzahl erreicht. Du kannst dem Spiel leider nicht mehr beitreten.");
            }
        }

        if (oneFree) {
            boolean allocated = false;
            while (allocated == false) {
                int i = (int) (Math.random() * island.size());
                if (island.get(i).isVergeben() == false) {
                    island.get(i).setVergeben(true);
                    allocated = true;
                    ID = i;
                }
            }
        }
        return island.get(ID);
    }

    public void endOfRound() {

        for (Lehen l : island) {
            l.processCommands();
        }

        // TODO müssen vom Lehen 
    }
}
