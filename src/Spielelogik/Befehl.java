/*
 *
 * (c) 2018 by SebastianKa
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

import java.util.HashMap;

public class Befehl {

    //alle Befehle
    public static final int DEFAULT_BEFEHL = 0;
    public static final int STEUER_AENDERN = 1;
    public static final int VIEH_SCHLACHTEN = 2;
    public static final int VIEHKAUF = 20;
    public static final int RITTER_AUSBILDEN = 7;
    public static final int FORSCHUNG_NACH_ROHSTOFFEN = 24;
    //Erklaerungen zu den Befehlen
    public static final HashMap<Integer, String> BEFEHLSTEXTE = new HashMap<Integer, String>() {
        {
            put(STEUER_AENDERN, "Steuersatz ändern");
            put(VIEH_SCHLACHTEN, "Vieh schlachten");
            put(VIEHKAUF, "Viehkauf");
            put(RITTER_AUSBILDEN, "Ritter ausbilden");
            put(FORSCHUNG_NACH_ROHSTOFFEN, "Forschung nach Rohstoffen");
        }
    };

    private double wert;
    private int ID;

    public Befehl(int ID, double wert) {
        this.ID = ID;
        this.wert = wert;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }

    public double getWert() {
        return wert;
    }

    public int getID() {
        return ID;
    }
}
