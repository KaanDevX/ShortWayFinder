import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

public class CountryMap {
    public String numberofcity;
    public int numofcity;
    public String citynames;
    public String[] citynamearr;
    public String routes;
    public int numofroutes;
    public String[] routeandtime;
    public String[] routecity1;
    public String[] routecity2;
    public String target;

    public void fileread(){
        try{
            Scanner reader = new Scanner(Paths.get("map1.txt"));
            while(reader.hasNextLine()){

                //şehir sayımızı string olarak okuyup integera dönüştürüyoruz.//
                numberofcity =reader.nextLine();
                try {
                    numofcity = Integer.parseInt(numberofcity);
                }
                catch (NumberFormatException e){
                    System.out.println("Number error while getting city number");
                    System.out.println("Fix your text file and put number for city");
                }

                //şehirlerin isimlerini alıyoruz//
                citynames = reader.nextLine();

                citynamearr = new String[numofcity];
                for (int i = 0;i<numofcity;i++){
                    citynamearr = citynames.split(" ");
                    //System.out.println("Route " + (i + 1) + ": " + routeandtime[i]);//
                }


                routes = reader.nextLine();
                try {
                    numofroutes = Integer.parseInt(routes);
                }
                catch (NumberFormatException e){
                    System.out.println("Number error while getting city number");
                    System.out.println("Fix your text file and put number for route number");
                }

                routeandtime = new String[numofroutes];

                for (int i = 0;i<numofroutes;i++){
                    routeandtime[i] = reader.nextLine();
                    //System.out.println("Route " + (i + 1) + ": " + routeandtime[i]);//
                }

                routecity1 = new String[numofroutes];

                for(int i = 0;i<numofroutes;i++){
                    routecity1[i] = routeandtime[i].trim().substring(0,1);
                    //System.out.println("1. city route " + routecity1[i]);//
                }

                routecity2 = new String[numofroutes];

                for(int i = 0;i<numofroutes;i++){
                    routecity2[i] = routeandtime[i].trim().substring(2,3);
                    //System.out.println("2. city route " + routecity2[i]);//
                }


                // Target hedeflediğimiz bölgenin adıdır. Örnek olarak A dan E ye gitmek istiyorsak, E targettır. Bunu yol bulmada check() fonksiyonu için kullanıcaz//
                target = reader.nextLine();
                System.out.println("File read is successful");
            }
        }
        catch (IOException e){
            System.out.println("File couldn't read");
        }
    }
}
