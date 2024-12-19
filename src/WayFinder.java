public class WayFinder {
    private CountryMap data; // CountryMap'i bağlamak için
    PathResult result = new PathResult();
    public WayFinder(CountryMap data) {
        this.data = data;
    }

    public boolean checkstart(){
        boolean[] result = new boolean[data.numofroutes];
        boolean netresult = true;

        for (int i = 0; i < 1; i++) {
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

        for (int i = 0; i < 1; i++) {
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
        int startIndex = findCity(data.start);
        int targetIndex = findCity(data.target);

        boolean[] visited = new boolean[data.numofcity];
        String currentWay = data.start;
        int currentTime = 0;

        findWays(startIndex, targetIndex, visited, currentWay, currentTime);

        if (result.getTotalTime() == Integer.MAX_VALUE) {
            System.out.println("No route exists from " + data.start + " to " + data.target);
        } else {
            System.out.println("Fastest Way: " + result.getPath());
            System.out.println("Total Time: " + result.getTotalTime() + " min");
        }
    }

    //tüm yolları denemek için
    private void findWays(int current, int target, boolean[] visited, String currentway, int currentTime) {
        if (current == target) {
            if (currentTime < result.getTotalTime()) {
                result.setPath(currentway);
                result.setTotalTime(currentTime);
            }
        }

        visited[current] = true;

        for (int i = 0; i < data.numofcity; i++) {
            int zaman = findTime(current, i);
            if (!visited[i] && zaman != Integer.MAX_VALUE) {
                //findways sürekli tekrar döndürmem lazım
            }
        }
    }

    //iki yol arasnda zamanı bulmak için
    private int findTime(int city1, int city2) {
        for (int i = 0; i < data.numofroutes; i++) {
            if ((data.routecity1[i].equals(data.citynamearr[city1]) && data.routecity2[i].equals(data.citynamearr[city2]))){
                return data.intTime[i];
            }
        }
        return Integer.MAX_VALUE;//eğer sonsuz değerse komşu değildir.
    }

    //başlangıç noktası ve son noktaya integer değer vermek için
    private int findCity(String city) {
        for (int i = 0; i < data.citynamearr.length; i++) {
            if (data.citynamearr[i].equals(city)) {
                return i;
            }
        }
        return -1;
    }
}