public class WayFinder {
    private CountryMap data; // CountryMap'i bağlamak için

    public WayFinder(CountryMap data) {
        this.data = data;
    }

    public void yazdir() {
        System.out.println(data.citynamearr[1]);
    }

    public boolean checkfirstcolumncities() {
        boolean[] result = new boolean[data.numofroutes];
        boolean netresult = true;

        for (int i = 0; i < (data.numofroutes); i++) {
            result[i] = false;
            for (int a = 0; a < (data.numofcity); a++) {
                if (data.routecity1[i].equals(data.citynamearr[a])) {
                    result[i] = true;
                }
            }

            if (result[i] == false) {
                netresult = false;
            }
        }
        return netresult;
    }

    public boolean checksecondcolumncities() {
        boolean[] result = new boolean[data.numofroutes];
        boolean netresult = true;

        for (int i = 0; i < (data.numofroutes); i++) {
            result[i] = false;
            for (int a = 0; a < (data.numofcity); a++) {
                if (data.routecity2[i].equals(data.citynamearr[a])) {
                    result[i] = true;
                }
            }

            if (result[i] == false) {
                netresult = false;
            }
        }
        return netresult;
    }

    public boolean allcheck(){
        if(checkfirstcolumncities() && checksecondcolumncities()){
            return true;
        }
        else {
            return false;
        }
    }

    public void ShortestWay(){
        int sumtime = 0;
        int[] sum;
        int mintime = 0;
        int currenttime = 0;
        String currentway;
        for(int i = 0;i<data.numofroutes;i++){
            if(data.target.equals(data.routecity2[i])){
                int countways = 0;
                countways +=1;
                currentway = data.routecity1[i];
                System.out.print(currentway);
                System.out.print(" --> ");
                System.out.print(data.target);
                sumtime += data.intTime[i];
                System.out.print(" ");
                System.out.println(sumtime);
                sum =new int[countways];
                for (int a= 0;a< data.numofroutes;a++){
                    if(data.routecity1[i].equals(data.routecity2[a])){
                        currentway = data.routecity1[a];

                    }
                }
            }
        }

    }

}