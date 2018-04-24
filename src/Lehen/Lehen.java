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

import Spielelogik.Befehl;
import Spielelogik.Ressourcenmanager;
import java.lang.Math;
import java.util.Stack;

public class Lehen {

    private int ID;
    private String name;
    private boolean vergeben;

    private static final int MAX_BERGWERK = 3;
    private int max_command = 2;

    private Ressourcenmanager r;
    private Stack<Befehl> befehle = new Stack<>();
    private int leftCommands = max_command;

    public Lehen(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.r = new Ressourcenmanager(5, 5, 5, 100, 100);
        this.vergeben = false;
    }

    /**
     * @return the ID of the feudal tenure
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the name of the feudal tenure
     */
    public String getName() {
        return name;
    }

    /**
     * @return the maxBergwerk
     */
    public static int getMaxBergwerk() {
        return MAX_BERGWERK;
    }

    public void setCommand(Befehl com) {
        befehle.push(com);
        leftCommands--;
    }

    public void processCommands() {
        r.aktionenAusfuehren(befehle);
        befehle = new Stack<>();
        leftCommands = max_command;
    }

    public int getLeftCommands() {
        return leftCommands;
    }

    public void cutShortCommands() {
        leftCommands = 0;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return den ressourcenmanager des Lehens
     */
    public Ressourcenmanager getR() {
        return r;
    }

    /**
     * @return true falls das Lehen aktuell an einen realen Spieler vergeben ist
     */
    public boolean isVergeben() {
        return vergeben;
    }

    public void setVergeben(boolean vergeben) {
        this.vergeben = vergeben;
    }

}
