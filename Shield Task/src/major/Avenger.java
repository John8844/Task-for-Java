package major;

import worker.GlobalService;

public class Avenger {
    private String name;
    private boolean available;
    private int assignedMissions;

    public Avenger(String name) {
        this.name = name;
        this.available = true;
        this.assignedMissions = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getAssignedMissions() {
        return assignedMissions;
    }

    public void assignMission() {
        this.assignedMissions++;
    }

}
