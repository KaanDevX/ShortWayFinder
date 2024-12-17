import java.util.Scanner;

public class City {
    public static void main(String[] args){
        CountryMap data = new CountryMap();
        Scanner sc = new Scanner(System.in);
        String filename;
        System.out.println("Enter file name");
        filename = sc.nextLine();

        data.fileread(filename+".txt");

        WayFinder calculate = new WayFinder(data);
       if(calculate.allcheck()){
           System.out.println("Cities and routes checked");
           System.out.println(calculate.findTheTime(0,1));
       }
       else{
           System.out.println("cities and routes don't fit, fix your file.");
           System.exit(7);
       }
    }
}
