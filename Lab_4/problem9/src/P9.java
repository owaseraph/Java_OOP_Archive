import java.util.Scanner;
public class P9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of circles: ");
        int n = sc.nextInt();
        Circle[] circles = new Circle[n];
        final int mask = 0xFF;

        for(int i=0;i<n;i++){
            System.out.println("Enter the X pos: ");
            int x = sc.nextInt();
            System.out.println("Enter the Y pos: ");
            int y =sc.nextInt();
            System.out.println("Enter the radius: ");
            float r = sc.nextFloat();
            System.out.println("Enter the alpha range: ");
            int a = sc.nextInt();
            System.out.println("Enter the red range: ");
            int red = sc.nextInt();
            System.out.println("Enter the green range: ");
            int green = sc.nextInt();
            System.out.println("Enter the blue range: ");
            int blue = sc.nextInt();

            int color = ((a&mask)<<24) | ((red&mask)<<16) | ((green&mask)<<8) | (blue&mask);

            circles[i] = new Circle(color,  r, new int[]{x,y});
        }

        for(Circle c: circles){
            System.out.println(c);
        }
        sc.close();
    }
}
