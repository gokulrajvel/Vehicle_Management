import java.sql.SQLException;
import java.util.Scanner;

public class UserVisit {
    public UserVisit(String user_id) throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("|-   1. Display all available vehicles     --|");
        System.out.println("|-   2. Rent a vehicle                     --|");
        System.out.println("|-   3. Add vehicle to cart                --|");
        System.out.println("|-   4. Pay fines                          --|");
        System.out.println("|-   5. View history                       --|");
        System.out.println("|-   6. Extend rent                        --|");
        System.out.println("|-   7. Payment                            --|");
        System.out.println("|-   8. Exit                               --|");
        System.out.println("----------------------------------------------");
        int n=sc.nextInt();
        switch (n){
            case 1:
                new UserDisplay();
                break;
            case 2:
                new RentVehicle(user_id);
                break;
            case 3:
                new AddCart(user_id);
                break;
//            case 4:
//                new PayFine();
//                break;
//            case 5:
//                new ViewHistory();
//                break;
//            case 6:
//                new ExtandRent();
//                break;
//            case 7:
//                new Payment();
//                break;
            case 8:
                System.out.println("--------------------------");
                System.out.println("Thank You For Using.......");
                System.out.println("--------------------------");
                new req();
        }
    }
}
