package worker;

import major.Avenger;
import major.Mission;

public class HelperService {
    /**
     *
     * @param avengerName for find the avenger
     * @return
     */
    public Avenger findAvenger(String avengerName) {
        for (Avenger avenger : GlobalService.masterAvengerList) {
            if (avenger.getName().equalsIgnoreCase(avengerName)) {
                return avenger;
            }
        }
        return null;
    }

    /**
     * send notification to the avenger
     * @param avenger
     * @param mission
     */
    public static void notifyAvenger(Avenger avenger, Mission mission) {
        // Simulate notification (You can add real notification logic here in the future)
        System.out.println("Email notification sent and/or SMS notification sent.");
    }

    /**
     * print the mission's details
     * @param mission
     */
    public void getMissionDetails(Mission mission) {
        System.out.println("Mission Details:");
        System.out.println("Mission Name : " + mission.getMissionName());
        System.out.println("Mission Details : " + mission.getMissionDetails());
        System.out.println("Status : " + mission.getMissionStatus());
        System.out.println("Assigned Avengers : " + mission.getAssignedAvengers());
    }

    /**
     * print the avenger's details
     * @param avenger
     */
    public void getAvengerDetails(Avenger avenger) {
        System.out.println("Avenger Name : " + avenger.getName());
        System.out.println("Available : " + avenger.isAvailable());
        System.out.println("Assigned Missions : " + avenger.getAssignedMissions());
        System.out.println("Completed Missions : " + avenger.getCompletedMissions());

    }

    /**
     * assign mission to the avenger
     * @param avenger
     * @param mission
     */
    public void assignMissionToAvenger(Avenger avenger, Mission mission) {
        if (avenger.getAssignedMissions() < 2 && mission.getMissionStatus().equals("Assigned")) {
            avenger.assignMission();
            avenger.setAvailable(false);
            mission.setMissionStatus("In Progress");
            mission.getAssignedAvengers().add(avenger.getName());
            HelperService.notifyAvenger(avenger, mission);
            System.out.println("Mission has been assigned.");

        } else {
            System.out.println("Sorry, " + avenger.getName() + " has already been working on two missions.");
        }
    }

    /**
     * update mission status
     * @param mission
     * @param newStatus
     */
    public void updateMissionStatus(Mission mission, String newStatus) {
        mission.setMissionStatus(newStatus);
        notifyAvengersForStatusUpdate(mission);
        System.out.println("Mission status updated.");
    }
    private void notifyAvengersForStatusUpdate(Mission mission) {
        for (String avengerName : mission.getAssignedAvengers()) {
            Avenger avenger = findAvenger(avengerName);
            if (avenger != null) {
                avenger.completeMission();
                if (mission.getMissionStatus().equals("Completed")) {
                    avenger.setAvailable(true);
                }
            }
        }
    }

    /**
     *  Assign Avenger to mission
     * @param avenger
     * @param mission
     */
    public void assignAvengerToMission(Avenger avenger, Mission mission) {
        if (mission.getAssignedAvengers().size() >= 2) {
            System.out.println("Error: Maximum two avengers can be assigned to a mission.");
        } else if (mission.getAssignedAvengers().contains(avenger.getName())) {
            System.out.println("Error: " + avenger.getName() + " is already assigned to this mission.");
        } else {
            avenger.assignMission();
            avenger.setAvailable(false);
            mission.getAssignedAvengers().add(avenger.getName());
            notifyAvenger(avenger, mission);
            System.out.println(avenger.getName() + " is assigned to the mission: " + mission.getMissionName());
        }
    }

    /**
     * this method is used for display the menu for Captain Fury
     */
    public void menu(){
        System.out.println("=============------S.H.I.E.L.D ------===============");
        System.out.println("Welcome to Captain Fury. (Note: Below interface is for Captain Fury)");
        System.out.println("1. Check the missions");
        System.out.println("2. Assign mission to Avengers");
        System.out.println("3. Check mission's details");
        System.out.println("4. Check Avenger's details");
        System.out.println("5. Update Mission's status");
        System.out.println("6. List Avengers");
        System.out.println("7. Assign avenger to mission.");
        System.out.println("Enter the option: ");
    }
}
