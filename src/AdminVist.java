import java.util.Scanner;

public class AdminVist {
    public AdminVist(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("|-   1. Sort by the name                   --|");
        System.out.println("|-   2. Sort by the Available Number       --|");
        System.out.println("|-   3. Search a vehicle Name              --|");
        System.out.println("|-   4. Search a vehicle by Numberplate    --|");
        System.out.println("|-   5. Change the Security deposit amount --|");
        System.out.println("----------------------------------------------");
        int n=sc.nextInt();
        switch (n){
            case 1:
                new SortbyName();
                break;
            case 2:
                new SortByAvailableNumber();
                break;
            case 3:
                new SearchVehicleByName();
                break;
            case 4:
                new SearchByVehicleplate();
                break;
            case 5:
                new DepositAmount();
                break;
        }
    }
}