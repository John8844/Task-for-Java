package worker;

import major.Avenger;
import major.Mission;

import java.util.Scanner;

public class MissionManagerService {
    Scanner scanner=new Scanner(System.in);
    HelperService helperService=new HelperService();


    /**
     * Assign mission to the avenger
     */
    public void assignMission() {
        System.out.println("Enter Avengers : ");
        String[] avengersInput = scanner.nextLine().split(", ");
        System.out.println("Enter Mission Name: ");
        String missionName = scanner.nextLine();
        System.out.println("Enter Mission Details: ");
        String missionDetails = scanner.nextLine();
        Mission newMission = new Mission(missionName, missionDetails);
        newMission.addMission(newMission);
        for (String avengerName : avengersInput) {
            Avenger avenger = helperService.findAvenger(avengerName);
            if (avenger != null) {
                helperService.assignMissionToAvenger(avenger, newMission);
            } else {
                System.out.println("Avenger not found: " + avengerName);
            }
        }
    }


    /**
     * List of missions
     */
    public void listMissions(){
        System.out.println("Missions:");
        for (Mission mission : GlobalService.masterMissionList) {
            System.out.println("- " + mission.getMissionName() + " | Status: " + mission.getMissionStatus() +
                    " | Avengers: " + String.join(", ", mission.getAssignedAvengers()));
        }
    }


    /**
     * List of Avengers
     */
    public void listAvengers() {
        System.out.println("Avengers:");
        for (Avenger avenger : GlobalService.masterAvengerList) {
            System.out.println("- " + avenger.getName() + " | Available: " +
                    (avenger.isAvailable() ? "Yes" : "No") + " | Assigned Missions: " +
                    avenger.getAssignedMissions());
        }
    }


    /**
     * Mission Details
     */
    public void missionDetails(){
        System.out.println("Enter Mission Name: ");
        String missionToView = scanner.nextLine();
        Mission mission = null;
        for (Mission m : GlobalService.masterMissionList) {
            if (m.getMissionName().equalsIgnoreCase(missionToView)) {
                mission = m;
                break;
            }
        }
        if (mission != null) {
            helperService.getMissionDetails(mission);
        } else {
            System.out.println("Mission not found: " + missionToView);
        }
    }


    /**
     * Avenger Details
     */
    public void avengerDetails(){
        System.out.println("Enter Avenger Name: ");
        String avengerToView = scanner.nextLine();
        Avenger avenger = helperService.findAvenger(avengerToView);
        if (avenger != null) {
            helperService.getAvengerDetails(avenger);
        } else {
            System.out.println("Avenger not found: " + avengerToView);
        }
    }


    /**
     * Update Mission Status
     */
    public void updateMissionStatus(){
        System.out.println("Enter Mission Name: ");
        String missionToUpdate = scanner.nextLine();
        Mission missionToUpdateStatus = null;
        for (Mission m : GlobalService.masterMissionList) {
            if (m.getMissionName().equalsIgnoreCase(missionToUpdate)) {
                missionToUpdateStatus = m;
                break;
            }
        }
        if (missionToUpdateStatus != null) {
            System.out.println("Enter new status: ");
            String newStatus = scanner.nextLine();
            helperService.updateMissionStatus(missionToUpdateStatus, newStatus);
        } else {
            System.out.println("Mission not found: " + missionToUpdate);
        }
    }

    /**
     * Assign avenger to mission
     */
    public void assignAvenger(){
        System.out.println("Enter Avenger Name: ");
        String avengerName = scanner.nextLine();
        System.out.println("Enter Mission Name: ");
        String missionNameToAssign = scanner.nextLine();
        Avenger avengerToAssign = helperService.findAvenger(avengerName);
        Mission missionToAssign = null;
        for (Mission m : GlobalService.masterMissionList) {
            if (m.getMissionName().equalsIgnoreCase(missionNameToAssign)) {
                missionToAssign = m;
                break;
            }
        }
        if (avengerToAssign != null && missionToAssign != null) {
            helperService.assignAvengerToMission(avengerToAssign, missionToAssign);
        } else {
            System.out.println("Error: Avenger or Mission not found.");
        }
    }
}
