public class City {
    public static void main(String[] args){
        CountryMap data = new CountryMap();
        data.fileread();

        WayFinder calculate = new WayFinder(data);
        System.out.println(calculate.checkfirstcolumncities());
        System.out.println(calculate.checksecondcolumncities());
        System.out.println(calculate.allcheck());
        if(calculate.allcheck()){
            System.out.println("Cities and routes checked");
        }
        else{
            System.out.println("There is/are a city that doesn't fit with route");
        }
    }
}
