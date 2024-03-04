package com.example;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        ArrayList<String> subjectMarkList = new ArrayList<>();
        HashMap<String, Integer> subjectMarkMap = new HashMap<>();


        // enter the  marks of each subject
        // System.out.print("Enter subject and mark e.g. Maths-55 (or 'continue' to exit): ");
        String subjectAndMArk = "";
        while (subjectAndMArk != "continue") {
            if (subjectAndMArk.equalsIgnoreCase("continue")) {
                // subjectMarkList.remove(-1);
                break; // Exit the loop if user enters 'quit'
            }

            System.out.print("Enter subject and mark e.g. Maths-55 (or 'continue' to exit): \n");
            subjectAndMArk = sc.nextLine();
            subjectMarkList.add(subjectAndMArk);

        }
        if  (!subjectMarkList.isEmpty()) {
            subjectMarkList.remove(subjectMarkList.size() - 1);
        } else {
            System.out.println("No data entered.");
        }

        
        for (int i = 0; i < subjectMarkList.size(); i++){
            // display the subject and mark list
            // System.out.println(subjectMarkList.get(i));
            String [] info =  subjectMarkList.get(i).split("-");
            try {
                subjectMarkMap.put(info[0].toUpperCase(), Integer.parseInt(info[1]));
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
        }
        
        
        for (String i : subjectMarkMap.keySet()) {
            System.out.println(i + " : " + subjectMarkMap.get(i));
        }
        
        int numSubjects = subjectMarkList.size();

        //sum the values of map
        int sum = 0; 
        for (int currentValue : subjectMarkMap.values()){
            sum+= currentValue;
        }
        System.out.printf("\nTotal Mark : %d", sum);
        double percentage = (double)sum / numSubjects;
                // give a grade based on the percentage
                String grade;
                switch( (int) percentage/ 10) {
                    case 10:
                    case 9:
                    case 8:
                        grade = "A+";
                        break;
                    case 7:
                        grade = "A";
                        break;
                    case 6:
                        grade = "B";
                        break;
                    case 5:
                        grade = "C";
                        break;
                    case 4:
                        grade = "D";
                        break;
                    case 3:
                        grade = "E";
                        break;
                    default:
                        grade = "F";
                        break;
                }
        System.out.printf("\nYour Average Percentage: %.2f \nYour Grade: %s",percentage, grade);


        sc.close();


    }
}