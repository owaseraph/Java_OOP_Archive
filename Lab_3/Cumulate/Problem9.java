import java.util.*;

public class Problem9 {
    public static void main(String[] args) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        List<String> deck = new ArrayList<>();

        // Build the deck
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }

        Random rand = new Random();
        int extractedCount = 0;

        while (!deck.isEmpty()) {
            int idx = rand.nextInt(deck.size());
            String card = deck.remove(idx);
            extractedCount++;

            System.out.println("Card #" + extractedCount + ": " + card);

            // Check if the card is Clubs and value > 8 (i.e., 9, 10, J, Q, K, A)
            if (card.endsWith("Clubs")) {
                String rank = card.split(" ")[0];
                // Values greater than 8: 9, 10, J, Q, K, A
                if (rank.equals("9") || rank.equals("10") || rank.equals("J") ||
                        rank.equals("Q") || rank.equals("K") || rank.equals("A")) {
                    System.out.println("A Clubs card with value > 8 was picked. Stopping!");
                    break;
                }
            }
        }

        if (deck.isEmpty()) {
            System.out.println("All cards have been extracted without meeting the condition.");
        }
    }
}