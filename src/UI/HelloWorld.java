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
import java.io.*;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloWorld extends HttpServlet {

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

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        //out.println("<h1>" + name + " says " + message + "</h1>");
        String output = replaceTemplate();
        out.println(output);
    }

    private String replaceTemplate() {
        String template;
        template = Template.getInstance().get();

        template = template.replace("$$div0", "");

        template = template.replace("$$div1", "<h1>Los geht - get connected...</h1>");

        String logo = "<a href=\"/island.png\">\n"
                + "            <img style=\"width: 120%; height: 120%\" alt=\"Island\" src=\"/res/island.png\" class=\"img-responsive\">\n"
                + "        </a>\n";

        template = template.replace("$$div2", logo);

        template = template.replace("$$div3", "");
        return template;
    }

    public void destroy() {
        // do nothing.
    }
}
