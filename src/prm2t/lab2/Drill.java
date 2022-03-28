package prm2t.lab2;
/*
    wiertatka na baterie
    wierc - musi miec baterie
    model
    numer seryjny
    poziom baterii
    sprawdz poziom baterii

 */

public class Drill {

    /**Model wiertarki*/
    private String model;
    /** Numer seryjny wiertarki*/
    private int serialNumber;
    /** Aktualny poziom baterii wiertarki */
    private int batteryLevel = 100;

    Drill(String model, int serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.batteryLevel = 100;
    }

        /** @returns Model wiertarki */
    public String getModel(){
        return this.model;
    }

    /** @returns Numer seryjny wiertarki */
    public int getSerialNumber(){
        return this.serialNumber;
    }

    /** @returns Aktualny poziom baterii wiertarki */
    public int getBatteryLevel(){
        return this.batteryLevel;
    }


    /** Symuluje wiercenie wiertarki. Za kazda jednostke czasu wiertarka traci jeden poziom baterii
     * @param time Dlugosc wiercenia
     * @returns zwraca {@code true} jesli wiercenie odbylo sie bez problemow,
     * {@code false} jesli nie wystarczylo baterii na ustawiona dlugosc wiercenia*/

    public boolean drilling(int time) {
        while (time > 0) {
            if (this.batteryLevel > 0) {
                this.batteryLevel -= 1;
                time -= 1;
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    /** Ładuje wiertarke do 100% */
    public void charge(){
        this.batteryLevel = 100;
    }

    @Override
    public String toString(){
        return model + " " + serialNumber + " " + batteryLevel + '%';
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (obj instanceof Drill){
            Drill equalDrill = (Drill) obj;
            return model.equals(equalDrill.model) &&
                    serialNumber == equalDrill.serialNumber &&
                    batteryLevel == equalDrill.batteryLevel;
        }
        return false;
    }

    @Override public int hashCode(){
        return 23 * model.hashCode() + 7 * serialNumber + 13 * batteryLevel;
    }

    public static void main(String[] args){
    Drill testDrill = new Drill("Model 1", 1111);
    System.out.println(testDrill);
    //System.out.println("Model: " + testDrill.getModel());
    //System.out.println("Serial Number: " + testDrill.getSerialNumber());
    System.out.println("Battery Level: " + testDrill.getBatteryLevel() + "%");
    testDrill.drilling(40);
    System.out.println("Battery Level: " + testDrill.getBatteryLevel() + "%");
    testDrill.charge();
    System.out.println("Battery Level: " + testDrill.getBatteryLevel() + "%");

    Drill testDrill2 = new Drill("Model 1", 2222);
    Drill testDrill3 = new Drill("Model 1", 1111);
    System.out.println(testDrill.equals(testDrill3));
    System.out.println(testDrill.equals(testDrill2));
    System.out.println(testDrill.hashCode() + " " + testDrill3.hashCode());
    System.out.println(testDrill.hashCode() + " " + testDrill2.hashCode());



    }
}
