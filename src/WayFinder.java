public class WayFinder {
    private CountryMap data; // CountryMap'i bağlamak için
    PathResult result = new PathResult();

    public WayFinder(CountryMap data) {
        this.data = data;
    }

    public boolean checkstart(){
        boolean[] result = new boolean[data.numofroutes];
        boolean netresult = true;

        for (int i = 0; i < (data.numofroutes); i++) {
            result[i] = false;
            for (int a = 0; a < (data.numofcity); a++) {
                if (data.start.equals(data.citynamearr[a])) {
                    result[i] = true;
                }
            }

            if (result[i] == false) {
                netresult = false;
            }
        }
        return netresult;
    }

    public boolean checktarget(){
        boolean[] result = new boolean[data.numofroutes];
        boolean netresult = true;

        for (int i = 0; i < (data.numofroutes); i++) {
            result[i] = false;
            for (int a = 0; a < (data.numofcity); a++) {
                if (data.target.equals(data.citynamearr[a])) {
                    result[i] = true;
                }
            }

            if (result[i] == false) {
                netresult = false;
            }
        }
        return netresult;
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

    public boolean allcheck() {
        if (checkfirstcolumncities() && checksecondcolumncities() && checkstart() && checktarget()) {
            return true;
        } else {
            return false;
        }
    }

    public void ShortestWay() {

        // Yoları tutmak için
        boolean[] visited = new boolean[data.numofcity];
        String currentway = data.start;
        int currenttime = 0;


        // Sonuçlar
        if (result.getTotalTime() == Integer.MAX_VALUE) {
            System.out.println("No route exists from " + data.start + " to " + data.target);
        } else {
            System.out.println("Fastest Way: " + result.getPath());
            System.out.println("Total Time: " + result.getTotalTime() + " min");
        }
    }

    //dijkstra algoritması ile yol bulmak için
    public void findWays(String current, String target,String currentway,int currenttime,boolean[] visited){
        //eğer rotasyonun sonuna geldiyse ve önceki veriden zamanı azsa kaydedicek
        if (current.equals(target)) {
            if(currenttime<result.getTotalTime()){
                result.setTotalTime(currenttime);
                result.setPath(currentway);
            }
        }
        //recoursive ile tüm yolları denettirmem lazım findTheTimthodunu bir şekilde kullanmam lazım

    }

    //Yollar arasındaki bağlantıyı bulmak için böylece süreyi eşleştirebiliriz.
    public int findTheTime(int city1, int city2){
        for (int i = 0; i < data.numofroutes; i++) {
            if ((data.routecity1[i].equals(data.citynamearr[city1]) && data.routecity2[i].equals(data.citynamearr[city2]))) {
                return data.intTime[i];
            }
        }
        return 5;
    }





}