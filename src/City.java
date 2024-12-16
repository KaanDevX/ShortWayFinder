public class City {
    public static void main(String[] args){
        CountryMap abc = new CountryMap();
        abc.fileread();

        WayFinder calculate = new WayFinder(abc);
       if(calculate.allcheck()){
           System.out.println("Cities and routes checked");
           calculate.ShortestWay();
       }
       else{
           System.out.println("There exist a problem while checking cities and routes. Please check your file and fix it");
       }
    }
}
