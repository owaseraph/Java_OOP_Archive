import java.util.Scanner;
public class P1 {
    public static boolean isNumber(String input){
        try{
            Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    private static Scanner dis;
    private static String[] Months = {"January", "February", "March", "April","May","June", "July",
                        "August", "September", "October", "November", "December"};

    public static void main(String[] args){
        dis = new Scanner(System.in);

        String n = dis.next();
        if(isNumber(n)){
            System.out.println(Months[Integer.parseInt(n)-1]);
        }
        else{
            for(int i=0;i< Months.length;i++){
                if(n.equals(Months[i])){
                    System.out.println(i+1);
                }
            }
        }

    }
}
