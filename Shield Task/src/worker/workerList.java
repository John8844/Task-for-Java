package worker;

import major.Avenger;
import major.Mission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class workerList {
    Scanner in=new Scanner(System.in);
    ArrayList<String> missionList = new ArrayList<>();
    ArrayList<String> AvengerList = new ArrayList<>();
    public void PrintMenu(){
        System.out.println("1. Assign mission to Avengers");
        System.out.println("2. Check the missions");
        System.out.println("3. Check Avenger’s details");
        System.out.println("4. Update Mission’s status");
        System.out.println("5. List Avengers");
        System.out.println("6. Assign avenger to mission.");
        System.out.println();
    }
    public void assignMission(){
        System.out.println("Enter Mission Name :");
        String missName=in.nextLine();
        System.out.println("Enter Status :");
        String missionStatus=in.nextLine();
        System.out.println("Enter Avenger :");
        String assignedAvenger=in.nextLine();
        if(Avenger.getAvengerName().equals(assignedAvenger)){
            if (Avenger.getAvengerStatus()=="Available"){
                Avenger.setAssignedMission(Collections.singletonList(missName));
                missionList.add(String.valueOf(new Mission(missName)));
                System.out.println(missName+" assigned for "+assignedAvenger);
            }else{
                System.out.println("Avenger Not Available..");
            }
        }
    }
    public void displayMissions(){
        for (String m: missionList){
            System.out.println(missionList);
        }
    }
}
