public class WayFinder {
    private CountryMap data; // CountryMap'i bağlamak için

    public WayFinder(CountryMap data) {
        this.data = data;
    }

    public void yazdir() {
        System.out.println(data.citynamearr[1]);
    }

    public boolean checkroutes() {
        boolean[] result = new boolean[data.numofroutes];
        boolean netresult = true;

        for (int i = 0; i < (data.numofroutes); i++) {
            result[i] = false;
            for (int a = 0; a < (data.numofcity-1); a++) {
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
}