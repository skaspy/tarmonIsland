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

import java.util.EnumSet;
import javax.servlet.SessionTrackingMode;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create Server
        Server server = new Server(8080);

        //Init servlet context
        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        //Memory based session handling
        SessionHandler sessionHandler = new SessionHandler();
        sessionHandler.setSessionTrackingModes(EnumSet
                .of(SessionTrackingMode.COOKIE));
        context.setSessionHandler(sessionHandler);

        // if needed use this to set Attributes on servlet context
        // context.setAttribute(CONNECTION_POOL, connectionPool);
        // Jetty should also serve static files
        ServletHolder staticHolder = new ServletHolder(new DefaultServlet());
        staticHolder.setInitParameter("resourceBase", "./src/webapp"); // static content is in Directory "WebContent"
        staticHolder.setInitParameter("pathInfoOnly", "true");
        staticHolder.setInitParameter("dirAllowed", "false");
        // register staticHolder with 
        context.addServlet(staticHolder, "/res/*");

        // Examples for registering servlets.
        context.addServlet(HelloWorld.class, "/");
        context.addServlet(Api.class, "/api");
        context.addServlet(Connect.class, "/connect");
        context.addServlet(Game.class, "/game");

        // register servlets of modules and plugins
        server.setHandler(context);

        // Start the server
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
