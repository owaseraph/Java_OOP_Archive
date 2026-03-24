import java.util.Scanner;

public class Problem2{
    private static Scanner dis;
    static int gcd(int a, int b){
        return (b==0) ? a : gcd(b, a%b);
    }
    public static void main(String args[]){
        dis = new Scanner(System.in);
        int a = dis.nextInt();
        int b = dis.nextInt();

        System.out.println(gcd(a,b));
    }
}