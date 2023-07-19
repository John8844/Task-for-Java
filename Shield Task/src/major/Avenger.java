package major;

import java.util.ArrayList;
import java.util.List;

public class Avenger{
    private static String AvengerName;
    private static String AvengerStatus;
    private static List<String> AssignedMission;

    public Avenger(String avengerName) {
        this.AvengerName = avengerName;
        this.AvengerStatus = "Available";
        this.AssignedMission = new ArrayList<>();
    }

    public static String getAvengerName() {
        return AvengerName;
    }

    public static String getAvengerStatus() {
        return AvengerStatus;
    }

    public static List<String> getAssignedMission() {
        return AssignedMission;
    }

    public static void setAssignedMission(List<String> assignedMission) {
        AssignedMission = assignedMission;
    }

}
