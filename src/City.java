public class City {
    public static void main(String[] args){
        CountryMap data = new CountryMap();
        data.fileread();

        WayFinder calculate = new WayFinder(data);
        System.out.println(data.citynamearr[0] +data.routecity1[0] );
        calculate.yazdir();
        System.out.println(calculate.checkroutes());
    }
}
