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
            calculate.ShortestWay();
        }
        else{
            System.out.println("There exist a problem while checking cities and routes. Please check your file and fix it");
        }

        //wayfinder sonucunu text file yazdır
    }
}