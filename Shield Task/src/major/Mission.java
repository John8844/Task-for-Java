package major;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private String MissionName;
    private String MissionStatus;
    private List<Avenger> AssignedAvenger;

    public Mission(String missionName) {
        this.MissionName = missionName;
        this.MissionStatus = "Assigned";
        this.AssignedAvenger = new ArrayList<>();
    }

    public String getMissionName() {
        return MissionName;
    }

    public String getMissionStatus() {
        return MissionStatus;
    }

    public List<Avenger> getAssignedAvenger() {
        return AssignedAvenger;
    }
}
