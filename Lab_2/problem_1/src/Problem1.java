import java.util.Scanner;

public class Problem1{
    private static Scanner dis;
    public static void main(String args[]){
        dis =  new Scanner(System.in);
        int n;
        System.out.println("Enter a integer: ");
        n = dis.nextInt();
        int p=1;
        for(int i=1; i<=n; i++){
            p*=i;
        }
        System.out.println("Your integer's factorial is: " + p);
    }
}
