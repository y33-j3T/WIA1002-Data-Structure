package readmyletter_wid180503;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadMyLetter_WID180503 {

    public static void main(String[] args) {
        System.out.println("Input second part of letter: ");
        Scanner in = new Scanner(System.in);
        String part2 = in.nextLine();
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("tanyeejet_wid180503.txt"), true));
            pw.println();
            pw.println("29 May 2019");
            pw.println();
            pw.println(part2);
            pw.close();

            Scanner s = new Scanner(new FileInputStream(new File("tanyeejet_wid180503.txt")));
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("File output error.");
        }
    }
}
