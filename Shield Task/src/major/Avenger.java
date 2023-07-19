package major;

import java.util.ArrayList;

public class Avenger{
    private String AvengerName;
    private boolean AvengerStatus;
    private int capacity;

    public Avenger(String aveName, boolean aveStatus, int cap) {
        this.AvengerName = aveName;
        this.AvengerStatus = aveStatus;
        this.capacity = cap ;
    }

    public void setAvengerName(String avengerName) {
        AvengerName = avengerName;
    }

    public void setAvengerStatus(boolean avengerStatus) {
        AvengerStatus = avengerStatus;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAvengerName() {
        return AvengerName;
    }

    public boolean isAvengerStatus() {
        return AvengerStatus;
    }

    public int getCapacity() {
        return capacity;
    }
    public void AvengersList(){
        System.out.println(" Avenger " + AvengerName + " is " +AvengerStatus+ " Mission Details : "+capacity);
    }

    public static void addAvengers(){
        ArrayList<Avenger> avengers = new ArrayList<>();

        avengers.add(new Avenger("Hulk", true, 0));
        avengers.add(new Avenger("Thor", true, 0));
        avengers.add(new Avenger("Iron", true, 0));
        for (Avenger avenger : avengers){
            avenger.AvengersList();
        }
    }
}
