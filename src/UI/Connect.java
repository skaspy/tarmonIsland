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
import Spielelogik.Players;
import java.io.*;
import java.util.Date;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class Connect extends HttpServlet {

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

        Map<String, String[]> params = request.getParameterMap();
        if (params.size() != 0) {
            doSessionHandling(request, response);
            response.sendRedirect("/game");
        } else {
            // Set response content type
            response.setContentType("text/html");
            // Actual logic goes here.
            PrintWriter out = response.getWriter();
            String output = replaceTemplate();
            out.println(output);
        }
    }

    private void doSessionHandling(HttpServletRequest request, HttpServletResponse response) {

        // nickname 
        String nickname = request.getParameter("nickname");

        // Create a session object if it is already not  created.
        HttpSession session = request.getSession(true);

        // Get session creation time.
        Date createTime = new Date(session.getCreationTime());

        // Get last access time of this web page.
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        Integer visitCount = new Integer(0);
        String visitCountKey = new String("visitCount");

        // Check if this is new comer on your web page.
        if (session.isNew()) {
            //session.setAttribute(userIDKey, userID);
            // Insert new Player

            Players.getInstance().connectPlayer(nickname, session.getId(), lastAccessTime);

        } else {
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount = visitCount + 1;
            //userID = (String) session.getAttribute(nickname);
        }
        session.setAttribute(visitCountKey, visitCount);
    }

    private String replaceTemplate() {
        String template;
        template = Template.getInstance().get();

        template = template.replace("$$div0", "");

        String connectForm
                = "<form class=\"form-signin\" method=\"post\">\n"
                + "        <h2 class=\"form-signin-heading\">Connect ... </h2>\n"
                + "        <label for=\"nickname\" class=\"sr-only\">Nickname</label>\n"
                + "        <input name=\"nickname\" id=\"nickname\" class=\"form-control\" placeholder=\"nickname\" required=\"\" autofocus=\"\" type=\"\"> <div> <br> </div>\n"
                + "        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Connect</button>\n"
                + "</form>";

        template = template.replace("$$div1", connectForm);

        String logo = "<a href=\"/island.png\">\n"
                + "            <img style=\"width: 120%; height: 120%\" alt=\"Island\" src=\"/res/island.png\" class=\"img-responsive\">\n"
                + "        </a>\n";

        template = template.replace("$$div2", logo);
        return template;
    }

    public void destroy() {
        // do nothing.
    }
}
