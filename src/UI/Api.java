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
package UI;

// Import required java libraries
import Spielelogik.Player;
import Spielelogik.Players;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class Api extends HttpServlet {

    public void init() throws ServletException {
        // Do required initialization
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        handleRequest(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        handleRequest(req, res);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Get Parameter
        String action = request.getParameter("action");

        // Set response content type
        response.setContentType("text");

        // Actual logic goes here.
        // Create api Answer
        // action: status
        StringBuilder answer = new StringBuilder();

        if (action.equals("status")) {
            answer.append(getStatusTable());
        } else if (action.equals("report")) {
            String player = request.getParameter("player");
            answer.append(getReport(player));
        }

        PrintWriter out = response.getWriter();
        out.println(answer.toString());
    }

    public String getStatusTable() {
        StringBuilder status = new StringBuilder();

        status.append("<table class=\"table\">\n"
                + "  <thead>\n"
                + "    <tr>\n"
                + "      <th scope=\"col\">Nick</th>\n"
                + "      <th scope=\"col\">Lehen</th>\n"
                + "      <th scope=\"col\">Last Action</th>\n"
                + "      <th scope=\"col\">Action left</th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
                + "  <tbody>");

        for (Player p : Players.getInstance().getPlayers()) {
            
            // Format last active date
            SimpleDateFormat dLastActive = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date dt = p.getLastActiv();
            String sLastActive = dLastActive.format(dt);
            
            status.append("<tr>");
            status.append("<td>" + p.getNickname() + "</td>");
            status.append("<td>" + p.getLehen().getName() + "</td>");
            status.append("<td>" + sLastActive + "</td>");
            status.append("<td>" + (p.getLehen().getLeftCommands()) + "</td>");
            status.append("</tr>");
        }
        status.append("</tbody>\n"
                + "</table>");

        return status.toString();
    }

    public String getReport(String sessionId) {
        Player p = Players.getInstance().getPlayer(sessionId);

        StringBuilder report = new StringBuilder();
        if (sessionId == null) {
            report.append("<h2>No Report available!</h2>");
        } else {
            report.append(p.getLehen().getR().ressourcenstatus());
        }
        return report.toString();
    }

    public void destroy() {
        // do nothing.
    }
}
