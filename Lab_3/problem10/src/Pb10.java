import java.util.Scanner;

public class Pb10 {
    private static Scanner dis;
    public static void main(String[] args) {
        dis = new Scanner(System.in);

        System.out.print("Enter String A: ");
        String A = dis.next();
        System.out.print("Enter String B: ");
        String B = dis.next();
        //System.out.println(A + " " + B);
        dis.nextLine();
        System.out.print("Enter the associated numerical values for String B: ");
        String C = dis.nextLine();
        String[] parts = C.split(" ");
        int[] n = new int [parts.length];
        for(int i=0;i<parts.length;i++) {
            n[i] = Integer.parseInt(parts[i]);
        }
        int s=0;
        for (int i = 0; i<B.length(); i++) {
            char ch = B.charAt(i);
            int found = A.indexOf(ch,0);
            while(found!=-1){
                s+=n[i]+found+1;
                found = A.indexOf(ch, found+1);
            }

        }
        System.out.println((s<100)?"INVALID ENCRYPTION": "VALID ENCRYPTION");
    }
}
