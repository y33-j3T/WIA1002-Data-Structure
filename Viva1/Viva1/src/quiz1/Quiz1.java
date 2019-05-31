package quiz1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Quiz1 {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new FileInputStream(new File("quiz1.txt")));
            int totalLine = 0;
            int totalWords = 0;
            String mostFreq = "haha";
            int freq = 0;
            int totalUniqueWords = 0;
            ArrayList<String> occWords = new ArrayList();
            ArrayList<Integer> occWordsCount = new ArrayList();

            while (s.hasNextLine()) {
                String nextLine = s.nextLine();

                if (nextLine.equals("") == false) {
                    totalLine += 1;

                    nextLine = nextLine.toLowerCase();
                    nextLine = nextLine.replace(",", "");
                    nextLine = nextLine.replace(".", "");
                    nextLine = nextLine.replace(":", "");
                    nextLine = nextLine.replace("!", "");
                    nextLine = nextLine.replace("'", "");
                    nextLine = nextLine.trim();

//                    System.out.println(nextLine);
                    String[] wordArr = nextLine.split(" ");
                    totalWords += nextLine.split(" ").length;
//                    System.out.println(totalWords);

                    for (int i = 0; i < wordArr.length; i++) {
                        if (occWords.contains(wordArr[i])) {
                            occWordsCount.set(occWords.indexOf(wordArr[i]), occWordsCount.get(occWords.indexOf(wordArr[i])) + 1);
                        } else {
                            if(!isNumeric(wordArr[i]))
                                totalUniqueWords++;
                            occWords.add(wordArr[i]);
                            occWordsCount.add(occWords.indexOf(wordArr[i]), 1);
                        }
                    }
                }
            }

            freq = occWordsCount.get(0);
            for (int i = 0; i < occWordsCount.size(); i++) {
                if (occWordsCount.get(i) > freq) {
                    freq = occWordsCount.get(i);
                    mostFreq = occWords.get(i);
                }
            }

            System.out.println("Total line: " + totalLine);
            System.out.println("The total words: " + totalWords);
            System.out.println("One of the most frequent occuring words is '" + mostFreq + "' which has appeared " + freq + " times");
            System.out.println("Total unique words: " + totalUniqueWords);
            s.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Quiz1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isNumeric(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
