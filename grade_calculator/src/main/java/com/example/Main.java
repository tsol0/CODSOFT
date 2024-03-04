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

            System.out.print("Enter subject and mark e.g. Maths-55 (or 'continue' to exit): ");
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
            String [] data =  subjectMarkList.get(i).split("-");
            try {
                subjectMarkMap.put(data[0].toLowerCase(), Integer.parseInt(data[1]));
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
        }

        for (String i : subjectMarkMap.keySet()) {
            System.out.println(i + " - " + subjectMarkMap.get(i));
          }


        sc.close();


    }
}