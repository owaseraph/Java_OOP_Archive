import java.util.Scanner;

class Fraction {
    protected int a; // numerator
    protected int b; // denominator

    // Default constructor
    public Fraction() {
        this.a = 0;
        this.b = 1;
    }

    // Parameterized constructor with denominator check
    public Fraction(int a, int b) {
        if (b != 0) {
            this.a = a;
            this.b = b;
        } else {
            System.out.println("Error: Denominator cannot be zero. Defaulting to 1.");
            this.a = a;
            this.b = 1;
        }
    }

    // Setters
    public void setA(int a) { this.a = a; }
    public void setB(int b) {
        if (b != 0) {
            this.b = b;
        } else {
            System.out.println("Error: Denominator cannot be zero. Not changed.");
        }
    }
    // Getters
    public int getA() { return a; }
    public int getB() { return b; }

    // GCD (by division)
    public static int greatestCommonDivider(int x, int y) {
        if (y==0) return x;
        return greatestCommonDivider(y, x%y);
    }

    // Simplify
    public Fraction simplify() {
        int gcd = greatestCommonDivider(Math.abs(a), Math.abs(b));
        return new Fraction(a / gcd, b / gcd);
    }

    // Add two fractions, return simplified result
    public Fraction add(Fraction other) {
        int num = this.a * other.b + other.a * this.b;
        int denom = this.b * other.b;
        Fraction sum = new Fraction(num, denom);
        return sum.simplify();
    }

    // Display method
    public void display(String prefix) {
        System.out.println(prefix + a + "/" + b);
    }
}

class ExtendedFraction extends Fraction {
    // Constructor calls base
    public ExtendedFraction(int a, int b) {
        super(a, b);
    }

    // GCD by subtraction
    public static int greatestCommonDivider(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (x == 0) return y;
        if (y == 0) return x;
        while (x != y) {
            if (x > y) x -= y;
            else y -= x;
        }
        return x;
    }

    // Override simplify using subtraction GCD
    @Override
    public Fraction simplify() {
        int gcd = greatestCommonDivider(a, b);
        return new ExtendedFraction(a/gcd, b/gcd);
    }

    // Subtract method
    public ExtendedFraction subtract(ExtendedFraction other) {
        int num = this.a * other.b - other.a * this.b;
        int denom = this.b * other.b;
        ExtendedFraction result = new ExtendedFraction(num, denom);
        return (ExtendedFraction) result.simplify();
    }
}

public class FractionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Fraction objects with default constructor, set attributes from input
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        int num, denom;

        System.out.print("Enter numerator for first Fraction: ");
        num = sc.nextInt();
        f1.setA(num);

        System.out.print("Enter denominator for first Fraction: ");
        denom = sc.nextInt();
        f1.setB(denom);

        System.out.print("Enter numerator for second Fraction: ");
        num = sc.nextInt();
        f2.setA(num);

        System.out.print("Enter denominator for second Fraction: ");
        denom = sc.nextInt();
        f2.setB(denom);

        // Display original attributes
        System.out.println("\nOriginal Fractions:");
        f1.display("f1 = ");
        f2.display("f2 = ");

        // Simplify and display
        Fraction simp1 = f1.simplify();
        Fraction simp2 = f2.simplify();
        System.out.println("\nSimplified Fractions:");
        simp1.display("f1 (simplified) = ");
        simp2.display("f2 (simplified) = ");

        // Add and display
        Fraction sum = f1.add(f2);
        sum.display("\nf1 + f2 (simplified) = ");

        // ExtendedFraction objects from input
        System.out.print("\nEnter numerator for first ExtendedFraction: ");
        num = sc.nextInt();
        System.out.print("Enter denominator for first ExtendedFraction: ");
        denom = sc.nextInt();
        ExtendedFraction ef1 = new ExtendedFraction(num, denom);

        System.out.print("Enter numerator for second ExtendedFraction: ");
        num = sc.nextInt();
        System.out.print("Enter denominator for second ExtendedFraction: ");
        denom = sc.nextInt();
        ExtendedFraction ef2 = new ExtendedFraction(num, denom);

        // Display
        System.out.println("\nOriginal ExtendedFractions:");
        ef1.display("ef1 = ");
        ef2.display("ef2 = ");

        // Simplify and display
        ExtendedFraction sef1 = (ExtendedFraction) ef1.simplify();
        ExtendedFraction sef2 = (ExtendedFraction) ef2.simplify();

        System.out.println("\nSimplified ExtendedFractions:");
        sef1.display("ef1 (simplified) = ");
        sef2.display("ef2 (simplified) = ");

        // Add and display
        Fraction esum = ef1.add(ef2);
        esum.display("\nef1 + ef2 (simplified) = ");

        // Subtract and display
        ExtendedFraction ediff = ef1.subtract(ef2);
        ediff.display("ef1 - ef2 (simplified) = ");

        // Upcast to Fraction and attempt subtraction (which won't work)
        Fraction pf = ef1;
        // There is no subtract method in base class: the following would not compile:
        // pf.subtract(ef2);
        System.out.println("\nUpcast to Fraction: cannot call subtract() method (it's not in Fraction).");

        sc.close();
    }
}
