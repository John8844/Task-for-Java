import major.Avenger;

import worker.GlobalService;
import worker.HelperService;
import worker.MissionManagerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MissionManagerService missionManagerService=new MissionManagerService();
        HelperService helperService=new HelperService();
        Main.initializeAvengers();

        while (true) {
            helperService.menu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    missionManagerService.listMissions();
                    break;
                case 2:
                    missionManagerService.assignMission();
                    break;
                case 3:
                    missionManagerService.missionDetails();
                    break;
                case 4:
                    missionManagerService.avengerDetails();
                    break;
                case 5:
                    missionManagerService.listAvengers();
                    break;
            }
        }
    }

    /**
     * add Avengers to the masterAvengerList
     */
    public static void initializeAvengers(){
        Avenger ironMan = new Avenger("Iron Man");
        GlobalService.masterAvengerList.add(ironMan);
        Avenger captainAmerica = new Avenger("Captain America");
        GlobalService.masterAvengerList.add(captainAmerica);
        Avenger hulk = new Avenger("Hulk");
        GlobalService.masterAvengerList.add(hulk);
        Avenger thor = new Avenger("Thor");
        GlobalService.masterAvengerList.add(thor);
        Avenger blackWidow = new Avenger("Black Widow");
        GlobalService.masterAvengerList.add(blackWidow);
        Avenger hawkeye = new Avenger("Hawkeye");
        GlobalService.masterAvengerList.add(hawkeye);
    }
}

    