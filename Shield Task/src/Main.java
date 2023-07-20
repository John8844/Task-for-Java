import major.Avenger;
import major.Mission;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Avenger> avengers;
    private List<Mission> missions;

    public Main() { //SHIELDApp
        avengers = new ArrayList<>();
        missions = new ArrayList<>();
    }

    public void addAvenger(Avenger avenger) {
        avengers.add(avenger);
    }

    public void addMission(Mission mission) {
        missions.add(mission);
    }
    public void assignMissionToAvenger(Avenger avenger, Mission mission) {
        if (avenger.getAssignedMissions() < 2 && mission.getMissionStatus().equals("Assigned")) {
            avenger.assignMission();
            avenger.setAvailable(false);
            mission.setMissionStatus("In Progress");
            mission.getAssignedAvengers().add(avenger.getName());
            notifyAvenger(avenger, mission);
            System.out.println("Mission has been assigned.");
        } else {
            System.out.println("Sorry, " + avenger.getName() + " has already been working on two missions.");
        }
    }
    private void notifyAvenger(Avenger avenger, Mission mission) {
        // Simulate notification (You can add real notification logic here in the future)
        System.out.println("Email notification sent and/or SMS notification sent.");
    }
    private Avenger findAvenger(String avengerName) {
        for (Avenger avenger : avengers) {
            if (avenger.getName().equalsIgnoreCase(avengerName)) {
                return avenger;
            }
        }
        return null;
    }
    public void listMissions() {
        System.out.println("Missions:");
        for (Mission mission : missions) {
            System.out.println("- " + mission.getMissionName() + " | Status: " + mission.getMissionStatus() +
                    " | Avengers: " + String.join(", ", mission.getAssignedAvengers()));
        }
    }
    //Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main shieldTask = new Main();

        // Create Avengers
        Avenger ironMan = new Avenger("Iron Man");
        Avenger captainAmerica = new Avenger("Captain America");
        Avenger hulk = new Avenger("Hulk");
        Avenger thor = new Avenger("Thor");
        Avenger blackWidow = new Avenger("Black Widow");
        Avenger hawkeye = new Avenger("Hawkeye");

        // Add Avengers to the list
        shieldTask.addAvenger(ironMan);
        shieldTask.addAvenger(captainAmerica);
        shieldTask.addAvenger(hulk);
        shieldTask.addAvenger(thor);
        shieldTask.addAvenger(blackWidow);
        shieldTask.addAvenger(hawkeye);

        while (true) {
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
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Check the missions
                    shieldTask.listMissions();
                    break;
                case 2:
                    // Assign mission to Avengers
                    scanner.nextLine();
                    System.out.println("Enter Avengers : ");
                    String[] avengersInput = scanner.nextLine().split(", ");
                    System.out.println("Enter Mission Name: ");
                    String missionName = scanner.nextLine();
                    System.out.println("Enter Mission Details: ");
                    String missionDetails = scanner.nextLine();
                    Mission newMission = new Mission(missionName, missionDetails);
                    shieldTask.addMission(newMission);
                    for (String avengerName : avengersInput) {
                        Avenger avenger = shieldTask.findAvenger(avengerName);
                        if (avenger != null) {
                            shieldTask.assignMissionToAvenger(avenger, newMission);
                        } else {
                            System.out.println("Avenger not found: " + avengerName);
                        }
                    }
                    break;
            }
        }
    }
}

    