package task2.example;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        ArrayList<String> subjectMarkList = new ArrayList<>();
        HashMap<String, Integer> subjectMarkMap = new HashMap<>();

        boolean graded = false;
        while (graded != true){
            String subjectAndMark = "";
            while (subjectAndMark != "continue") {
    
                
                System.out.println("Enter subject and mark e.g. Maths-55 (or 'continue' to exit): ");
                subjectAndMark = sc.nextLine();
                
                if (subjectAndMark.equalsIgnoreCase("continue")) {
                    System.out.println();
                    break; // Exit the loop if user enters 'continue'
                }

                if  (!subjectAndMark.contains("-")){
                    System.out.println("Invalid input! Please follow the format: SubjectName-mark");
                    continue;
                }
    
                String [] checkIntEnd = subjectAndMark.split("-");
                try {
                    Integer.parseInt(checkIntEnd[1]);
                } catch (Exception e) {
                    System.out.println("Please enter a valid integer!");
                    continue;   // If it is not a valid integer
                }
    
                subjectMarkList.add(subjectAndMark);
    
            }
    
            if  (subjectMarkList.isEmpty()) {
                System.out.println("No data entered.");
                continue;
            }
    
            
            for (int i = 0; i < subjectMarkList.size(); i++){
                String [] info =  subjectMarkList.get(i).split("-");
                try {
                    subjectMarkMap.put(info[0].toUpperCase(), Integer.parseInt(info[1]));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            
            
            for (String i : subjectMarkMap.keySet()) {
                System.out.println(i + " : " + subjectMarkMap.get(i));
            }
            
            int numSubjects = subjectMarkList.size();
    
            //sum the values inside the map
            int sum = 0; 
            for (int currentValue : subjectMarkMap.values()){
                sum+= currentValue;
            }
            System.out.printf("\nTotal Marks : %d", sum);
            double percentage = (double)sum / numSubjects;
                    // give a grade based on the percentage
                    String grade;
                    switch((int) percentage/ 10) {
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
            graded = true;
        }
        sc.close();
        
    }
}