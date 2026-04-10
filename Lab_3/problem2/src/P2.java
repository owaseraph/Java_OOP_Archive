import java.util.Scanner;

public class P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt=0;
        char b = sc.next().charAt(0);
        char[] a= s.toCharArray();
        for(int i=0;i<a.length;i++){
            if(a[i]==b){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
