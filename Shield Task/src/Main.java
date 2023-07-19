import major.Avenger;
import major.Mission;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("=======------S.H.I.E.L.D ------=========");
        System.out.println("Welcome to Captain Fury. (Note: Below interface is for Captain Fury)");

        int option = 0;
        Scanner in = new Scanner(System.in);

        while (option == 0) {
            choices();
            System.out.println("Enter your choice :");
            int choice=in.nextInt();
            switch (choice){
                case 1:
                    Mission.addMission();
                    break;
                case 2:
                    Avenger.addAvengers();
                    break;
            }
        }
    }
    private static void choices() {
        System.out.println("1. Assign mission to Avengers");
        System.out.println("2. Check the missions");
        System.out.println("3. Check Avenger’s details");
        System.out.println("4. Update Mission’s status");
        System.out.println("5. List Avengers");
        System.out.println("6. Assign avenger to mission.");
        System.out.println();
    }

}

