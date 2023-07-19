import major.Avenger;
import worker.workerList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static List<Avenger> avengers;
    public static void main(String[] args) {
        workerList obj=new workerList();
        initializeAvengers();
        System.out.println("=======------S.H.I.E.L.D ------=========");
        System.out.println("Welcome to Captain Fury. (Note: Below interface is for Captain Fury)");

        int option=0;
        while (option != 8) {
            obj.PrintMenu();
            option = in.nextInt();
            switch (option) {
                case 1:
                    obj.assignMission();
                    break;
                case 2:
                    obj.displayMissions();
                    break;

            }
        }
    }
    private static void initializeAvengers() {
        avengers = new ArrayList<>();

        avengers.add(new Avenger("Captain America"));
        avengers.add(new Avenger("Iron Man"));
        avengers.add(new Avenger("Hulk"));
        avengers.add(new Avenger("Thor"));
        avengers.add(new Avenger("Black Widow"));
        avengers.add(new Avenger("Hawkeye"));
    }
}
