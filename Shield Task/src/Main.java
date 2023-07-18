import java.util.ArrayList;
import java.util.Scanner;

class Avengers {
    private String aveName;
    private String status;
    private ArrayList<String> missList = new ArrayList<>();

    public Avengers(String aveName) {
        this.aveName = aveName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addMissList(String missList) {
        this.missList.add(missList);
    }

    public String getAveName() {
        return aveName;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getMissList() {
        return missList;
    }
}

class Missions {
    private String missName;
    private String status;
    private ArrayList<String> aveList = new ArrayList<>();

    public void setMissName(String missName) {
        this.missName = missName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addAveList(String ave) {
        this.aveList.add(ave);
    }

    public String getMissName() {
        return missName;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getAveList() {
        return aveList;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("=======------S.H.I.E.L.D------=========");
        System.out.println();
        System.out.println("Welcome to Captain Fury. (Note: Below interface is for Captain Fury)");
        System.out.println();
        System.out.println("1. Assign mission to Avengers");
        System.out.println("2. Check the missions");
        System.out.println("3. Check Avenger’s details");
        System.out.println("4. Update Mission’s status");
        System.out.println("5. List Avengers");
        System.out.println("6. Assign avenger to mission.");
        System.out.println();

        ArrayList<Missions> missionList = new ArrayList<>();
        ArrayList<Avengers> avengersList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            System.out.println("Enter the option: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    Missions mission = new Missions();

                    System.out.println("Enter Avengers: ");
                    String avengers = in.nextLine();
                    System.out.println("Enter Mission Name: ");
                    String missName = in.next();
                    System.out.println("Enter Mission Status: ");
                    String missStatus = in.next();

                    Avengers ave = new Avengers(avengers);
                    ave.setStatus(missStatus);
                    ave.addMissList(missName);
                    avengersList.add(ave);

                    mission.addAveList(avengers);
                    mission.setMissName(missName);
                    mission.setStatus(missStatus);
                    missionList.add(mission);
                    break;

                case 2:
                    for (Missions m : missionList) {
                        System.out.println("Mission Name: " + m.getMissName());
                        System.out.println("Status: " + m.getStatus());
                        System.out.println("Avengers List: " + m.getAveList());
                    }
                    break;
                case 3:
                    for (Avengers a : avengersList) {
                        System.out.println("Avenger Name: " + a.getAveName());
                        System.out.println("Status: " + a.getStatus());
                        System.out.println("Mission List: " + a.getMissList());
                    }
                    break;
                case 4:
                    System.out.println("Enter the mission name to update status: ");
                    String missionName = in.next();
                    System.out.println("Enter the new status: ");
                    String newStatus = in.next();
                    for (Missions m : missionList) {
                        if (m.getMissName().equals(missionName)) {
                            m.setStatus(newStatus);
                            break;
                        }
                    }
                    break;
                case 5:
                    for (Avengers a : avengersList) {
                        System.out.println("Avenger Name: " + a.getAveName());
                    }
                    break;
                case 6:
                    System.out.println("Enter the mission name to assign an avenger: ");
                    String missionToAssign = in.next();
                    System.out.println("Enter the avenger name: ");
                    String avengerToAssign = in.next();
                    for (Missions m : missionList) {
                        if (m.getMissName().equals(missionToAssign)) {
                            if (m.getAveList().size() < 2) {
                                m.addAveList(avengerToAssign);
                                System.out.println("Avenger assigned to the mission successfully.");
                            } else {
                                System.out.println("Maximum avengers already assigned to this mission.");
                            }
                            break;
                        }
                    }
                    break;
            }
        }
    }
}