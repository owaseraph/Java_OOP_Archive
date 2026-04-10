import java.util.Scanner;
public class P3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[]a=s.toCharArray();
        char[]b=new char[3];
        System.arraycopy(a,0,b,0,3);
        System.out.println(b);
    }
}
