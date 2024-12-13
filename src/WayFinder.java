public class WayFinder {
    public boolean checkcityandroutes(){
        CountryMap data = new CountryMap();
        for(int i = 0; i<data.numofcity;i++){
            int existcities = 0;
            for (int a = 0; a< data.numofroutes;a++){
                if(data.citynamearr[i].equals(data.routecity1[a])){
                    existcities += 1;
                    i += 1 ;
                    if(existcities == (data.numofroutes-1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
