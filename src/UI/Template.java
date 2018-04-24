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

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class Template {

    String template;
    final static String tFileName = "./src/webapp/master-template.html";

    private static final Template t = new Template(tFileName);

    public static Template getInstance() {
        return t;
    }

    private Template(String tFile) {

        List<String> list = new ArrayList<>();

        Path path = Paths.get(tFile).toAbsolutePath();
        try (BufferedReader br = Files.newBufferedReader(path)) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(line -> sb.append(line));

        template = sb.toString();

        // Replace $$year tag
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        template = template.replace("$$year", "" + year);
    }

    public String get() {
        return template;
    }

}
