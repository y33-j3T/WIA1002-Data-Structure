package l9q3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class L9Q3 {

    public static void main(String[] args) {
        MyQueue<Integer> shareQueue = new MyQueue<>();
        MyQueue<Integer> priceQueue = new MyQueue<>();
        int gainLoss = 0;
        Scanner s = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");

            // get input 
            if (s.hasNextLine()) {
                input = s.nextLine();
            }

            // manipulate queue
            if (!input.equals("\n") && !input.isEmpty()) {
                boolean validFlag = false;
                if (Pattern.matches("Buy \\d+ shares at \\$\\d+ each$", input)) {
                    validFlag = true;
                    System.out.println("Buying now...");
                    shareQueue.enqueue(Integer.parseInt(input.substring(3, input.indexOf("shares")).trim()));
                    priceQueue.enqueue(Integer.parseInt(input.substring(input.indexOf("$") + 1, input.indexOf("each")).trim()));
                } else if (Pattern.matches("^Sell \\d+ shares at \\$\\d+ each$", input)) {
                    validFlag = true;
                    int sellNum = Integer.parseInt(input.substring(4, input.indexOf("shares")).trim());
                    int sellPrice = Integer.parseInt(input.substring(input.indexOf("$") + 1, input.indexOf("each")).trim());
                    if (!shareQueue.isEmpty()) {
                        System.out.println("Selling the shares now...");
                    }

                    while (sellNum != 0 && !shareQueue.isEmpty()) {

                        if (shareQueue.getElement(0) <= sellNum) {
                            gainLoss += (sellPrice - priceQueue.getElement(0)) * shareQueue.getElement(0);
                            sellNum -= shareQueue.getElement(0);
                            shareQueue.dequeue();
                            priceQueue.dequeue();
                        } else {
                            gainLoss += (sellPrice - priceQueue.getElement(0)) * sellNum;
                            shareQueue.enqueue(shareQueue.getElement(0) - sellNum);
                            sellNum = 0;
                            shareQueue.dequeue();
                            for (int i = 0; i < shareQueue.getSize() - 1; i++) {
                                shareQueue.enqueue(shareQueue.dequeue());
                            }
                            System.out.println(shareQueue);
                        }
                        System.out.println("Total Capital Gain / Loss: " + gainLoss);
                    }
                }

                if (validFlag) {
                    if (shareQueue.isEmpty()) {
                        System.out.println("No share to sell!");
                    }

                    System.out.println("Queue for Share: " + shareQueue);
                    System.out.println("Queue for Price: " + priceQueue);

                    if (shareQueue.isEmpty()) {
                        System.out.println("Final Capital Gain / Loss: " + gainLoss);
                        break;
                    }
                }
            }
        }
    }
}
