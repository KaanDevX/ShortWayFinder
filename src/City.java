public class City {
    public static void main(String[] args){
        CountryMap data = new CountryMap();
        data.fileread();

        WayFinder calculate = new WayFinder(data);
       if(calculate.checkfirstcolumncities() && calculate.checksecondcolumncities()){
           System.out.println("Cities and routes checked");
           calculate.ShortestWay();
       }
       else{
           System.out.println("There exist a problem while checking cities and routes. Please check your file and fix it");
       }
    }
}
