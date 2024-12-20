import java.util.Scanner;
import java.util.Formatter;
import java.io.IOException;
import java.io.FileWriter;

public class City {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: give defined file name");
            System.exit(1);
        }

        String filename = args[0];

        CountryMap data = new CountryMap();
        Art textart = new Art();

        data.fileRead(filename + ".txt");

        WayFinder calculate = new WayFinder(data);
        if (calculate.allCheck()) {
            System.out.println("Cities and routes checked");
            calculate.shortestWay();

            PathResult lastresult = calculate.result;

            Formatter f = null;
            try {
                f = new Formatter("output.txt");
                f.format("Fastest Way: %s\n", lastresult.getPath());
                f.format("Total Time: %d min\n", lastresult.getTotalTime());
                f.format("%s", textart.textart);
            } catch (IOException e) {
                System.out.println("Something went wrong");
                System.exit(32);
            } finally {
                if (f != null) {
                    f.close();
                }
            }
        } else {
            System.out.println("There exist a problem while checking cities and routes. Please check your file and fix it");
            System.exit(42);
        }
    }
}