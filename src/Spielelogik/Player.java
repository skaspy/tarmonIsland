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

import java.util.Date;

public class Player {

    /**
     * @return the lastActiv
     */
    public Date getLastActiv() {
        return lastActiv;
    }

    /**
     * @param lastActiv the lastActiv to set
     */
    public void setLastActiv(Date lastActiv) {
        this.lastActiv = lastActiv;
    }
    private String SessionId;
    private String Nickname;
    private Lehen.Lehen lehen;
    private boolean rundeFertig;
    private Date lastActiv;

    public Player(String sessionId, String nickname, Lehen.Lehen lehen, Date lastActiv) {
        setSessionId(sessionId);
        setNickname(nickname);
        setLehen(lehen);
        rundeFertig = false;
        setLastActiv(lastActiv);
    }

    /**
     * @return the SessionId
     */
    public String getSessionId() {
        return SessionId;
    }

    /**
     * @param SessionId the SessionId to set
     */
    public void setSessionId(String SessionId) {
        this.SessionId = SessionId;
    }

    /**
     * @return the Nickname
     */
    public String getNickname() {
        return Nickname;
    }

    /**
     * @param Nickname the Nickname to set
     */
    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    /**
     * @return the lehen
     */
    public Lehen.Lehen getLehen() {
        return lehen;
    }

    /**
     * @param lehen the lehen to set
     */
    public void setLehen(Lehen.Lehen lehen) {
        this.lehen = lehen;
    }

    /**
     * @return the rundeFertig
     */
    public boolean isRundeFertig() {
        return rundeFertig;
    }

    /**
     * @param rundeFertig the rundeFertig to set
     */
    public void setRundeFertig(boolean rundeFertig) {
        this.rundeFertig = rundeFertig;
    }

}
