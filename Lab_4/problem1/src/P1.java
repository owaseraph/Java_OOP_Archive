import java.util.Random;
import java.util.Scanner;
class Methods{
    double Mean(int ... a){
        if(a.length==0){
            return 0;
        }
        double s=0;
        for(int element:a){
            s+=element;
        }
        return s/a.length;
    }
    double[] randomArray(int n){
        double[] arr = new double[n];
        Random rand = new Random();
        for(int i=0;i<n;i++){
            arr[i]=rand.nextDouble()*100;
        }
        return arr;
    }

    static String charToString(char[] array){
        for(int i=0;i<array.length;i++){
            array[i]=Character.toUpperCase(array[i]);
        }
        return new String(array);
    }
}
public class P1 {

    public static void main(String[] args){
        Methods m = new Methods();
        Scanner sc = new Scanner(System.in);
        double mean = m.Mean(2,4,6,8);
        System.out.println("Mean: "+mean);

        System.out.println("Enter array length: ");
        int n = sc.nextInt();
        sc.nextLine();
        double[] random_array = m.randomArray(n);
        System.out.print("Random array: ");
        for (double d : random_array) System.out.printf("%.2f ", d);
        System.out.println();
        System.out.print("Enter your character array: ");
        String s = sc.nextLine();
        String upper = Methods.charToString(s.toCharArray());
        System.out.println("Uppercase string: " + upper);
    }
}
