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

import java.util.ArrayList;
import java.util.Stack;

public class Ressourcenmanager {

    private int bauern = 0;
    private int ritter = 0;
    private double gold = 0;
    private int vieh = 0;
    private double le = 0;
    private double steuer = 0.20;
    private int bergwerke = 0;

    public Ressourcenmanager(int anzBauern, int anzRitter, int anzVieh, double anzGold, double anzLebensmitteleinheiten) {
        bauern = anzBauern;
        ritter = anzRitter;
        gold = anzGold;
        vieh = anzVieh;
        le = anzLebensmitteleinheiten;
    }

    public String ressourcenstatus() {
        return "<table style=\"width:100%\">"
                + "<tr>"
                + "<td>Bauern</td><td>" + bauern + "</td></tr>"
                + "<tr>"
                + "<td>Ritter</td><td>" + ritter + "</td></tr>"
                + "<tr>"
                + "<td>Gold</td><td>" + gold + "</td></tr>"
                + "<tr>"
                + "<td>Vieh</td><td>" + vieh + "</td></tr>"
                + "<tr>"
                + "<td>Lebensmitteleinheiten</td><td>" + le + "</td></tr>"
                + "<tr>"
                + "<td>Steuer</td><td>" + steuer + "</td></tr>"
                + "<tr>"
                + "<td>Bergwerke</td><td>" + bergwerke + "</td></tr>"
                + "</table>";
    }

    public void aktionenAusfuehren(Stack<Befehl> befehlsstack) {
        Befehl aktuellerBefehl = null;
        while (!befehlsstack.isEmpty()) {
            aktuellerBefehl = befehlsstack.pop();
            switch (aktuellerBefehl.getID()) {
                case Befehl.DEFAULT_BEFEHL:
                    defaultBefehl();
                    break;
                case Befehl.STEUER_AENDERN:
                    steuerAendern(aktuellerBefehl);
                    break;
                case Befehl.VIEH_SCHLACHTEN:
                    viehSchlachten(aktuellerBefehl);
                    break;
                case 3:
                    aktion3Ausfuehren();
                    break;
                case 4:
                    aktion4Ausfuehren();
                    break;
                case 5:
                    aktion5Ausfuehren();
                    break;
                case 6:
                    aktion6Ausfuehren();
                    break;
                case Befehl.RITTER_AUSBILDEN:
                    ritterAusbilden(aktuellerBefehl);
                    break;
                case 8:
                    aktion8Ausfuehren();
                    break;
                case 9:
                    aktion9Ausfuehren();
                    break;
                case 10:
                    aktion10Ausfuehren();
                    break;
                case 11:
                    aktion11Ausfuehren();
                    break;
                case 12:
                    aktion12Ausfuehren();
                    break;
                case 13:
                    aktion13Ausfuehren();
                    break;
                case 14:
                    aktion14Ausfuehren();
                    break;
                case 15:
                    aktion15Ausfuehren();
                    break;
                case 16:
                    aktion16Ausfuehren();
                    break;

                case Befehl.VIEHKAUF:
                    viehkauf(aktuellerBefehl);
                    break;

                case Befehl.FORSCHUNG_NACH_ROHSTOFFEN:
                    forschungNachRohstoffen();
                    break;
            }
        }
    }

    private void aktion0Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion1Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion2Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion3Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion4Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion5Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion6Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion7Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion8Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion9Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion10Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion11Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion12Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion13Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion14Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion15Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void aktion16Ausfuehren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void steuerAendern(Befehl aktuellerBefehl) {
        steuer = aktuellerBefehl.getWert() / 100;
    }

    private void defaultBefehl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viehSchlachten(Befehl aktuellerBefehl) {
        vieh = vieh - (int) aktuellerBefehl.getWert();
        le = le + (int) aktuellerBefehl.getWert();
    }

    private void viehkauf(Befehl aktuellerBefehl) {
        //maximal 100 vieh kaufbar
        vieh = vieh + (int) aktuellerBefehl.getWert();
        le = le - aktuellerBefehl.getWert();
        gold = gold - aktuellerBefehl.getWert() * 5;
    }

    private void ritterAusbilden(Befehl aktuellerBefehl) {
        ritter = ritter + (int) aktuellerBefehl.getWert();
        bauern = bauern - (int) aktuellerBefehl.getWert();
        le = le - aktuellerBefehl.getWert();
        gold = gold - aktuellerBefehl.getWert() * 20;
    }

    private void forschungNachRohstoffen() {
        bergwerke = bergwerke + 1;
        gold = gold - 200;
    }

}
