import java.io.Console;
import java.lang.String;
import java.lang.Math;

public class Problem4 {
    /**
     Method for verifying if a number is prime
     @param n is the provided number
     @return returns true or false
    */
    static boolean is_Prime(int n){
        if(n<=1){
            return false;
        }
        for(int d = 2; d<=Math.sqrt(n);d++){
            if(n%d==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Console dis = System.console();
        String s = dis.readLine();
        System.out.println(s);
        String[] parts = s.split(" ");
        int[] n;
        n = new int[parts.length];
        for(int i=0;i< parts.length;i++){
            n[i]=Integer.parseInt(parts[i]);
        }

        for(int element : n){
            System.out.println(element + " is " + (is_Prime(element) ? "":"not ") + "prime");
        }
    }
}
