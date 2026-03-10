import java.util.Scanner;

public class Problem3 {
    static void all_div(int n){
        System.out.print("The dividers of "+n+" are: ");
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
    }
    private static Scanner dis;
    public static void main(String args[]){
        dis = new Scanner(System.in);
        int n = dis.nextInt();
        all_div(n);
    }
}
