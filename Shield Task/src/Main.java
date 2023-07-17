import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;
class avengers{

}
class missions{
    String missName;
    public String status;
    public String aveList;
    public String details;
    missions(){

    }
    missions(String aveList, String missName,String details, String status) {
        this.missName = missName;
        this.aveList = aveList;
        this.details = details;
        this.status = status;
    }
    public void display(){

        ArrayList<String> cars = new ArrayList<String>();
        System.out.println("Mission Name :"+missName);
        System.out.println("Status :"+status);
        System.out.println("Avengers List :"+aveList);
        System.out.println("Mission Details :"+details);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        for (int i=0;i<15;i++){
            System.out.println("=======------S.H.I.E.L.D ------=========");
            System.out.println("");
            System.out.println("Welcome to Captain Fury. (Note: Below interface is for Captain Fury)");
            System.out.println("");
            System.out.println("1. Assign mission to Avengers");
            System.out.println("2. Check the missions");
            System.out.println("3. Check mission’s details");
            System.out.println("4. Check Avenger’s details");
            System.out.println("5. Update Mission’s status");
            System.out.println("6. List Avengers");
            System.out.println("7. Assign avenger to mission.");
            System.out.println("");
            System.out.println("Enter the option :");
            int choice=in.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Avengers: ");
                    String avengers=in.next();
                    System.out.println("Enter Mission Name: ");
                    String missName=in.next();
                    System.out.println("Enter Mission Details: ");
                    String missDetails=in.next();
                    missions arr=new missions(avengers,missName,missDetails,"assigned");
                    break;
                case 2:
                    missions arr1=new missions();
                    arr1.display();
            }
        }
    }
}