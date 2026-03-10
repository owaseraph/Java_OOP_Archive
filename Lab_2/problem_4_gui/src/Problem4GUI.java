import java.awt.*;
import javax.swing.*;

class PrimePanel extends JPanel{
    private String []numbers = {};
    private Boolean []isPrime = {};
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int d = 2; d <= Math.sqrt(n); d++) {
            if (n % d == 0) return false;
        }
        return true;
    }
    public void checkNumbers(String input){
        String []parts=input.split(" ");
        numbers = new String[parts.length];
        isPrime = new Boolean[parts.length];


        for(int i=0; i< parts.length;i++){
            numbers[i] = parts[i];
            int n = Integer.parseInt(numbers[i]);
            isPrime[i] = isPrime(n);
        }

        repaint();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int y = 30;
        for (int i = 0; i < numbers.length; i++) {
            if (isPrime[i]) {
                g.setColor(Color.GREEN);
                g.drawString(numbers[i] + " is prime", 20, y);
            } else {
                g.setColor(Color.RED);
                g.drawString(numbers[i] + " is not prime", 20, y);
            }
            y += 25;
        }
    }
}
public class Problem4GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prime Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new BorderLayout());
        JTextField inputField = new JTextField();
        JButton checkButton = new JButton("Check");
        inputPanel.add(new JLabel(" Numbers: "), BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(checkButton, BorderLayout.EAST);

        PrimePanel primePanel = new PrimePanel();

        checkButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                primePanel.checkNumbers(text);
            }
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(primePanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
