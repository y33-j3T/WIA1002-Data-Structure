package l1q2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L1Q2 {

    public static void main(String[] args) {
        read_txt_with_char_sep_by_commas("text1.txt");
        read_txt_with_char_sep_by_commas_and_space("text2.txt");
        read_txt_with_char_sep_by_semicolons_and_spaces("text3.txt");
        read_txt_with_char_sep_by_numbers("text4.txt");
    }
    
    // reads txt with characters seperated by commas
    public static void read_txt_with_char_sep_by_commas(String filename){
        try{
            Scanner s = new Scanner(new FileInputStream(new File(filename)));
            String line = "";
            int numOfChar = 0;
            
            while(s.hasNextLine()){
                line = String.join("", s.nextLine().split(","));
                numOfChar += line.length();
                System.out.println(line);
            }
            System.out.println("Number of characters: " + numOfChar + "\n");
            
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }

    // reads txt with integers seperated by commas and spaces
    public static void read_txt_with_char_sep_by_commas_and_space(String filename){
        try{
            Scanner s = new Scanner(new FileInputStream(new File(filename)));
            String line = "";
            int numOfChar = 0;
            
            while(s.hasNextLine()){
                line = String.join("", s.nextLine().split(", "));
                numOfChar += line.length();
                System.out.println(line);
            }
            System.out.println("Number of characters: " + numOfChar + "\n");
            
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
    
    // reads txt with real numbers seperated by semicolons and spaces
    public static void read_txt_with_char_sep_by_semicolons_and_spaces(String filename){
        try{
            Scanner s = new Scanner(new FileInputStream(new File(filename)));
            String line = "";
            int numOfChar = 0;
            
            while(s.hasNextLine()){
                line = String.join("", s.nextLine().split("; "));
                numOfChar += line.length();
                System.out.println(line);
            }
            System.out.println("Number of characters: " + numOfChar + "\n");
            
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
    
    // reads txt with alphabets seperated by numbers
    public static void read_txt_with_char_sep_by_numbers(String filename){
        try{
            Scanner s = new Scanner(new FileInputStream(new File(filename)));
            String line = "";
            int numOfChar = 0;
            
            while(s.hasNextLine()){
                String originalText = s.nextLine();
                
                for (int i=0 ; i<originalText.length() ; i++){
                    if(Character.isDigit(originalText.charAt(i))==false){
                        line += originalText.charAt(i);
                    }
                }
                numOfChar += line.length();
                System.out.println(line);
            }
            System.out.println("Number of characters: " + numOfChar + "\n");
            
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
    }
}
