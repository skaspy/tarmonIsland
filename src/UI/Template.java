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

public class Template {

    String template;

    private static final Template t = new Template();

    public static Template getInstance() {
        return t;
    }

    private Template() {

        String bootstrap_css = "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\" integrity=\"sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4\" crossorigin=\"anonymous\">";
        String bootstrap_rest = "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\" integrity=\"sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ\" crossorigin=\"anonymous\"></script>\n"
                + "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\" integrity=\"sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm\" crossorigin=\"anonymous\"></script>";

        StringBuilder bs = new StringBuilder();
        bs.append("<!doctype html>\n"
                + "<script></script>"
                + "<html lang=\"en\">\n"
                + "  <head>\n"
                + "    <meta charset=\"utf-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                + "    <meta name=\"description\" content=\"\">\n"
                + "    <meta name=\"author\" content=\"\">\n"
                + "    <link rel=\"icon\" href=\"../../../../favicon.ico\">\n"
                + "\n"
                + "    <title>Sticky Footer Navbar Template for Bootstrap</title>\n"
                + "\n"
                /*+ "    <!-- Bootstrap core CSS -->\n"
                + "    <link href=\"../../../../dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                + "\n"
                + "    <!-- Custom styles for this template -->\n"
                + "    <link href=\"sticky-footer-navbar.css\" rel=\"stylesheet\">\n"*/
                + bootstrap_css
                + bootstrap_rest
                + "  </head>\n"
                + "\n"
                + "  <body>\n"
                + "\n"
                + "    <header>\n"
                + "      <!-- Fixed navbar -->\n"
                + "      <nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark\">\n"
                + "        <a class=\"navbar-brand\" href=\"#\">Alp Tarmon Island</a>\n"
                + "        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "          <span class=\"navbar-toggler-icon\"></span>\n"
                + "        </button>\n"
                + "        <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n"
                + "          <ul class=\"navbar-nav mr-auto\">\n"
                + "            <li class=\"nav-item active\">\n"
                + "              <a class=\"nav-link\" href=\"/connect\">Connect <span class=\"sr-only\">(current)</span></a>\n"
                + "            </li>\n"
                + "            <li class=\"nav-item\">\n"
                + "              <a class=\"nav-link\" href=\"/game\">Game</a>\n"
                + "            </li>\n"
                + "            <li class=\"nav-item\">\n"
                + "              <a class=\"nav-link disabled\" href=\"#\">Highscore</a>\n"
                + "            </li>\n"
                + "            <li class=\"nav-item\">\n"
                + "              <a class=\"nav-link disabled\" href=\"#\">Rules</a>\n"
                + "            </li>\n"
                + "          </ul>\n"
                + "        </div>\n"
                + "      </nav>\n"
                + "    </header>\n"
                + "\n"
                + "    <!-- Begin page content -->\n"
                + "    <main role=\"main\" class=\"container\">\n"
                + "      <h1 class=\"mt-5\"> <br> </h1>\n"
                + "        <div class=\"row\">"
                + "             <div class=\"col-md-12 col-sm-12 col-xs-12\"> $$div0 </div>"
                + "             <div class=\"col-md-5 col-sm-6 col-xs-12\"> $$div1 </div>"
                + "             <div class=\"col-md-5 col-sm-6 col-xs-12\"> $$div2 </div>"
                + "             <div class=\"col-md-12 col-sm-12 col-xs-12\"> $$div3 </div>"
                + "    </div>"
                + "    </main>\n"
                + "\n"
                + "    <footer class=\"footer\">\n"
                + "      <div class=\"container\">\n"
                + "        <span class=\"text-muted\">Place sticky footer content here.</span>\n"
                + "      </div>\n"
                + "    </footer>\n"
                + "\n"
                + "    <!-- Bootstrap core JavaScript\n"
                + "    ================================================== -->\n"
                + "    <!-- Placed at the end of the document so the pages load faster -->\n"
                + "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
                //+ "    <script>window.jQuery || document.write('<script src=\"../../../../assets/js/vendor/jquery-slim.min.js\"><\\/script>')</script>\n"
                //+ "    <script src=\"../../../../assets/js/vendor/popper.min.js\"></script>\n"
                //+ "    <script src=\"../../../../dist/js/bootstrap.min.js\"></script>\n"
                + "  </body>\n"
                + "</html>");

        template = bs.toString();
    }

    public String get() {
        return template;
    }

}
