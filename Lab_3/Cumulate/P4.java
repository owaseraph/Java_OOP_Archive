import java.util.Scanner;
public class P4 {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        System.out.println("0b"+Integer.toBinaryString(n));
        System.out.println("0o"+Integer.toOctalString(n));
        System.out.println("0x"+Integer.toHexString(n));
    }
}