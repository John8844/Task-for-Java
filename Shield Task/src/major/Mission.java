package major;

import java.util.*;

public class Mission {
    private String MissionName;
    private String MissionStatus;
    private String Avenger;
    Scanner in=new Scanner(System.in);
    public Mission(){
        System.out.println("Enter Mission Name :");
        MissionName=in.nextLine();
        System.out.println("Enter mission Status :");
        MissionStatus=in.nextLine();
        System.out.println("Enter Avenger :");
        Avenger=in.nextLine();
    }
    public boolean isAvailable(List<Mission> missions, List<Avenger> avengers){
        int capacity=0;
        for(Avenger a:avengers){
            if(a.getAvengerName()== Avenger){
                capacity = a.getCapacity();
            }
        }
        int miss=0;
        for (Mission m:missions){
            if(MissionStatus == "Assigned"){
                miss++;
            }
        }
        return miss<capacity?true:false;
    }
    public static void addMission(){
        Mission mission=new Mission();
        List<Mission> missions=new ArrayList<>();
        List<Avenger> avengers=new ArrayList<>();
        if(mission.isAvailable(missions,avengers)){
            missions.add(mission);
            System.out.println("Mission added success");
        }

    }


}
