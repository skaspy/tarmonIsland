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
import Spielelogik.Befehl;
import Lehen.Lehenmanager;
import Spielelogik.Player;
import Spielelogik.Players;
import java.util.Iterator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class Game extends HttpServlet {

    private String message;

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

        // handle Request
        String sCommand = "";
        Player p = null;
        Map<String, String[]> params = request.getParameterMap();
        if (!params.isEmpty()) {
            // Playerstatus
            HttpSession session = request.getSession(true);
            String sessionId = session.getId();
            p = Players.getInstance().getPlayer(sessionId);

            // Befehl weiterleiten TODO mehrere Befehle
            String sBefehlId = "";
            String sBefehlParam = "";
            for (Map.Entry<String, String[]> entry : params.entrySet()) {
                System.out.println(entry.getKey() + "/" + (entry.getValue())[0]);
                if (entry.getKey().equals("action")) {
                    sBefehlId = (entry.getValue())[0];
                }
                if (entry.getKey().equals("param")) {
                    sBefehlParam = (entry.getValue())[0];
                }
                if (entry.getKey().startsWith("command")) {
                    sCommand = entry.getKey();
                }
            }

            // process command
            switch (sCommand) {
                case "command_send":
                    p.getLehen().setCommand(new Befehl(Integer.parseInt(sBefehlId), Double.parseDouble(sBefehlParam)));
                    break;
                case "command_cutRound":
                    p.getLehen().cutShortCommands();
                    break;
            // do nothing
                default:
                    break;
            }

            // Runde beenden, abschließen
            if (p.getLehen().getLeftCommands() == 0) {
                p.setRundeFertig(true);

                boolean rundeAktiv = true;
                rundeAktiv = Players.getInstance().getPlayers().stream().map((player) -> player.isRundeFertig()).reduce(rundeAktiv, (accumulator, _item) -> accumulator & _item);
                if (rundeAktiv) {
                    Lehenmanager.getInstance().endOfRound();
                    Players.getInstance().getPlayers().forEach((player) -> {
                        player.setRundeFertig(false);
                    });

                }
            }

        }

        //response content type
        response.setContentType(
                "text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        //out.println("<h1>" + name + " says " + message + "</h1>");
        String output = replaceTemplate(p);

        out.println(output);
    }

    private String replaceTemplate(Player p) {
        String template;
        template = Template.getInstance().get();

        template = template.replace("$$div0", "");

        template = template.replace("$$div1", "<div><h2>Players</h2></div> <div id=\"status\"></div>");

        String whoIsThePlayer = "";
        if (p != null) {
            whoIsThePlayer = "&player=" + p.getSessionId();
        }

        template = template.replace("$$div2", "<div><h2>Actions</h2></div>" + actionForm());

        template = template.replace("$$div3", "<div id=\"report\"><h2>Bericht der letzten Runde </h2></div> <div id=\"report\"></div>");

        String script = "<script>"
                + "var myTimer = setInterval(loadDoc, 1000);"
                + "function loadDoc() {"
                + "  var xhttp = new XMLHttpRequest();"
                + "  xhttp.onreadystatechange = function() {"
                + "    if (this.readyState == 4 && this.status == 200) {"
                + "     document.getElementById(\"status\").innerHTML = this.responseText;"
                + "    }"
                + "  };"
                + "  xhttp.open(\"GET\", \"api?action=status\", true);"
                + "  xhttp.send();"
                + "}"
                + " "
                + "var myTimer2 = setInterval(loadDoc2, 1000);"
                + "function loadDoc2() {"
                + "  var xhttp = new XMLHttpRequest();"
                + "  xhttp.onreadystatechange = function() {"
                + "    if (this.readyState == 4 && this.status == 200) {"
                + "     document.getElementById(\"report\").innerHTML = this.responseText;"
                + "    }"
                + "  };"
                + "  xhttp.open(\"GET\", \"api?action=report" + whoIsThePlayer + "\", true);"
                + "  xhttp.send();"
                + "}"
                + "</script>";
        template = template.replace("<script></script>", script);

        return template;
    }

    private String actionForm() {
        HashMap<Integer, String> actions = Befehl.BEFEHLSTEXTE;
        StringBuilder actionOptions = new StringBuilder();

        actions.entrySet().forEach((pair) -> {
            actionOptions.append("              <option value = \"" + pair.getKey() + "\">" + pair.getValue() + "</option>\n");
        });
        String body = "<form  method=\"post\" action=\"/game\">\n"
                + " $$liste "
                + "  <input class=\"btn btn-secondary\" type=\"submit\" name=\"command_send\" value=\"Send command\">\n"
                + "  <input class=\"btn btn-secondary\" type=\"submit\" name=\"command_cutRound\" value=\"Cut round\">\n"
                + "</form> \n";

        String listitem = " <div class=\"row\">\n"
                + "   <div class=\"col form-group\">\n"
                + "    <select name=\"action\" class=\"form-control\" id=\"exampleFormControlSelect1\">\n"
                + actionOptions.toString()
                + "    </select>\n"
                + "  </div>"
                + "    <div class=\"col\">\n"
                + "<input type=\"number\" class=\" form-control\" name=\"param\" id=\"param\" value=\"0\" placeholder=\"0\">"
                + "    </div>\n"
                + "  </div>";
        return body.replace("$$liste", listitem);
    }

    @Override
    public void destroy() {
        // do nothing.
    }
}
