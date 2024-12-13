public class City {
    public static void main(String[] args){
        CountryMap data = new CountryMap();
        WayFinder calculate = new WayFinder();
        data.fileread();
        System.out.println(data.citynamearr[0] +data.routecity1[0] );
        System.out.println(calculate.checkcityandroutes());
    }
}
