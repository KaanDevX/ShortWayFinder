public class WayFinder {
    private CountryMap data; // CountryMap'i bağlamak için

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
        int startIndex = 0;
        int targetIndex = 2;

        // Yoları tutmak için
        boolean[] visited = new boolean[data.numofcity];
        String currentPath = data.start;
        int currentTime = 0;
        PathResult result = new PathResult();


        // Sonuçlar
        if (result.getTotalTime() == Integer.MAX_VALUE) {
            System.out.println("No route exists from " + data.start + " to " + data.target);
        } else {
            System.out.println("Fastest Way: " + result.getPath());
            System.out.println("Total Time: " + result.getTotalTime() + " min");
        }
    }

    //recoursive ile tüm yolları denettirmem lazım
}