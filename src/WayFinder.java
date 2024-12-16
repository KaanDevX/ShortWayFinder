public class WayFinder {
    private CountryMap data; // CountryMap'i bağlamak için

    public WayFinder(CountryMap data) {
        this.data = data;
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
        if (checkfirstcolumncities() && checksecondcolumncities()) {
            return true;
        } else {
            return false;
        }
    }


    public int kiyasla(String neariyom, String[] col1, String[] col2, int[] col3) {
        for (int i = 0; i < data.numofroutes; i++) {
            if (neariyom.equals(col2[i])) {
                return i;
            }
        }
        return -1;
    }

    public void ShortestWay() {
        boolean check = true;
        int counter = 0;
        String target = data.target;
        String[] aradiklarimiz = new String[data.numofroutes];
        for (int i = 0; i < data.numofroutes; i++) {
            aradiklarimiz[i] = "-1";
        }
        while (check) {
            if (counter == 10) {
                System.out.println("10 dan fazla çalıştı");
                break;
            }
            System.out.println(counter);
            int neariyom_index = kiyasla(target, data.routecity1, data.routecity2, data.intTime);
            if (neariyom_index == -1) {
                System.out.println("error");
                System.exit(0);
            } else {
                String aradigimiz = data.routecity1[neariyom_index];
                for (int i = 0; i < data.numofroutes; i++) {
                    if (aradiklarimiz[i].equals("-1")) {
                        aradiklarimiz[i] = aradigimiz;
                        target = aradigimiz;
                        if (data.start.equals(target)) {
                            System.out.println(data.start + " " + target);
                            check = false;
                            for (int a = 0; a < aradiklarimiz.length; a++) {
                                System.out.println(aradiklarimiz[a]);
                            }
                        }
                        break;
                    }
                }
            }
            counter += 1;
        }
    }
}