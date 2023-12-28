import java.util.Scanner;
public class req {
    public req(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1.Sign In \n2.Sign Up\n3.Admin\n");
        System.out.println("\t-----------------");
        System.out.println("\tSelect the option");
        System.out.println("\t-----------------");
        int n = sc.nextInt();
        System.out.println("--------------------------------");
        sc.nextLine();
        Sign_in in=new Sign_in(n);
        signup up=new signup(n);
        Admin ad=new Admin(n);
    }
    public static void main(String[] args) {
        System.out.println("*****welcome*****");
        req k=new req();
    }
}
