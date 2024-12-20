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
    public String[] time;
    public String startandtarget;
    public String start;
    public String target;
    public int[] intTime;

    public void fileRead(String textname){
        Scanner reader = null;
        try{
            reader = new Scanner(Paths.get(textname));
            while(reader.hasNextLine()){

                //şehir sayımızı string olarak okuyup integera dönüştürüyoruz.//
                numberofcity = reader.nextLine();
                try {
                    numofcity = Integer.parseInt(numberofcity);
                }
                catch (NumberFormatException e){
                    System.out.println("----------------------------------------------");
                    System.out.println("Line 29|Error: Number error while getting city number!");
                    System.out.println("|Fix your text file and put number for city");
                    System.out.println("----------------------------------------------");
                    System.exit(32);
                }

                //şehirlerin isimlerini alıyoruz//
                citynames = reader.nextLine().trim().toUpperCase();

                citynamearr = new String[numofcity];
                citynamearr = citynames.split(" ");


                routes = reader.nextLine();
                try {
                    numofroutes = Integer.parseInt(routes);
                }
                catch (NumberFormatException a){
                    System.out.println("---------------------------------------------------");
                    System.out.println("Line 48|Error: Number error while getting city number!");
                    System.out.println("|Fix your text file and put number for route number");
                    System.out.println("---------------------------------------------------");
                    System.exit(56);
                }

                routeandtime = new String[numofroutes];

                for (int i = 0;i<numofroutes;i++){
                    routeandtime[i] = reader.nextLine().trim().toUpperCase();
                    //System.out.println("Route " + (i + 1) + ": " + routeandtime[i]);//
                }


                routecity1 = new String[numofroutes];
                routecity2 = new String[numofroutes];
                time = new String[numofroutes];
                intTime = new int[time.length];

                for(int i = 0;i<numofroutes;i++){
                    routecity1[i] = routeandtime[i].trim().substring(0,1);
                    routecity2[i] = routeandtime[i].trim().substring(2,3);
                    //System.out.println("1. city route " + routecity1[i]);//
                }

                for(int d = 0; d<numofroutes;d++){
                    time[d] = routeandtime[d].trim().substring(4);
                    intTime[d] = Integer.parseInt(time[d]);
                }



                // Target hedeflediğimiz bölgenin adıdır. Örnek olarak A dan E ye gitmek istiyorsak, E targettır. Bunu yol bulmada check() fonksiyonu için kullanıcaz//
                startandtarget= reader.nextLine().trim();


                try {
                    start = startandtarget.substring(0,1);
                }
                catch (Exception b){
                    System.out.println("Line 90 Error|Start point not entered properly");
                    System.exit(94);
                }

                try{
                    target = startandtarget.substring(2,3);
                }
                catch (Exception c){
                    System.out.println("Line 98 Error|End point not entered properly");
                    System.exit(102);
                }
            }
        }
        catch (IOException e){
            System.out.println("File couldn't read");
            System.exit(3);
        }
        finally{
            if(reader != null){
            reader.close();
            System.out.println("\nThe file has been read.\n");
        }

        }
    }
}
