package com.example;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> subjectMarks = new HashMap<>();

        Scanner  sc = new Scanner(System.in);
        // get user name
        // System.out.println("Enter your name:");
        String  name = sc.nextLine();
        System.out.println("Hello  " + name + "");

        System.out.println("Enter number of subjects you take");
        int numSubjects = sc.nextInt();
        int count = 0;
        while (count != numSubjects){
            System.out.println("Enter subject name and mark");
            String subject = sc.nextLine();
                subjectMarks.put(subject,0);
            // String[] splitNameAndGrade = data.split(" ");
            count++;
        }

        // for (int num = 0; num <= numSubjects - 1 ; num++) {
        //     // System.out.print("\n Enter subject "+ num+": ");
        //     System.out.println("Enter subject name");
        //     String subject = sc.next();
        //     System.out.println("Enter subject mark");

        //     int mark  = sc.nextInt();
        //     String[] splitNameAndGrade = data.split(" ");
        //     String subject = splitNameAndGrade[0];
        //     int mark = Integer.parseInt(splitNameAndGrade[1]); 
        // }

        for (String l : subjectMarks.keySet()){
            System.out.println(l+" "+ subjectMarks.get(l));
        }
        
        sc.close();


    }
}