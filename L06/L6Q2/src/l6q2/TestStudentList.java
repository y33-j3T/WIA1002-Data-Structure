package l6q2;

import java.util.Scanner;

public class TestStudentList {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StudentList<String> list = new StudentList<>();

        System.out.println("Enter your student name list. Enter 'n' to end.....");
        while (true) {
            String input = s.nextLine();
            if (input.equalsIgnoreCase("n") == false) {
                list.add(input);
            } else {
                System.out.println();
                break;
            }
        }

        System.out.println("You have entered the following students' name :");
        list.printList();

        System.out.println("The number of students entered is : " + list.getSize() + "\n");

        System.out.println("All the names entered are correct? "
                + "Enter 'r' to rename the student name, "
                + "'n' to proceed. ");

        String rn;
        do {
            rn = s.nextLine();
            System.out.println();

            if (rn.equalsIgnoreCase("r") == true) {
                System.out.println("Enter the existing student name that you want to rename : ");
                String oriName = s.nextLine();
                System.out.println();

                System.out.println("Enter the new name : ");
                String newName = s.nextLine();
                System.out.println();

                list.replace(oriName, newName);

                System.out.println("The new student list is :");
                list.printList();
            } else if (rn.equalsIgnoreCase("r") == false && rn.equalsIgnoreCase("n") == false) {
                System.out.println("Invalid input! ");
            }
        } while (rn.equalsIgnoreCase("r") == false && rn.equalsIgnoreCase("n") == false);

        System.out.println("Do you want to remove any of your student name? "
                + "Enter 'y' for yes, 'n' to proceed.");

        String yn;
        do {
            yn = s.nextLine();
            System.out.println();

            if (yn.equalsIgnoreCase("y") == true) {
                System.out.println("Enter a student name to remove : ");
                String name = s.nextLine();
                System.out.println();

                list.removeElement(name);

                System.out.println("The number of updated student is : " + list.getSize());
                System.out.println("The new student list is :");
                list.printList();
            } else if (yn.equalsIgnoreCase("y") == false && yn.equalsIgnoreCase("n") == false) {
                System.out.println("Invalid input! ");
            }
        } while (yn.equalsIgnoreCase("y") == false && yn.equalsIgnoreCase("n") == false);

        System.out.println("All student data captured complete. Thank you!");
    }
}
