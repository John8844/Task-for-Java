package major;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private String missionName;
    private String missionDetails;
    private String missionStatus;
    private List<String> assignedAvengers;

    public Mission(String missionName, String missionDetails) {
        this.missionName = missionName;
        this.missionDetails = missionDetails;
        this.missionStatus = "Assigned";
        this.assignedAvengers = new ArrayList<>();
    }

    public String getMissionName() {
        return missionName;
    }

    public String getMissionDetails() {
        return missionDetails;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public List<String> getAssignedAvengers() {
        return assignedAvengers;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }
}
