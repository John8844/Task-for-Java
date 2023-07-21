package worker;

import major.Avenger;
import major.Mission;

import java.util.Scanner;

public class MissionManagerService {
    Scanner scanner=new Scanner(System.in);
    HelperService helperService=new HelperService();

    public void assignMission() {
        scanner.nextLine();
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

    public void listMissions(){
        System.out.println("Missions:");
        for (Mission mission : GlobalService.masterMissionList) {
            System.out.println("- " + mission.getMissionName() + " | Status: " + mission.getMissionStatus() +
                    " | Avengers: " + String.join(", ", mission.getAssignedAvengers()));
        }
    }
    public void listAvengers() {
        System.out.println("Avengers:");
        for (Avenger avenger : GlobalService.masterAvengerList) {
            System.out.println("- " + avenger.getName() + " | Available: " +
                    (avenger.isAvailable() ? "Yes" : "No") + " | Assigned Missions: " +
                    avenger.getAssignedMissions());
        }
    }
    public void missionDetails(){
        scanner.nextLine();
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
    public void avengerDetails(){
        scanner.nextLine();
        System.out.println("Enter Avenger Name: ");
        String avengerToView = scanner.nextLine();
        Avenger avenger = helperService.findAvenger(avengerToView);
        if (avenger != null) {
            helperService.getAvengerDetails(avenger);
        } else {
            System.out.println("Avenger not found: " + avengerToView);
        }
    }
}
