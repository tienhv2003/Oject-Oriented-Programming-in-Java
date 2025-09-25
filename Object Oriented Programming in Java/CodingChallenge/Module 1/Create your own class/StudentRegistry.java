// StudentRegistry class to test the Student class
public class StudentRegistry {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Student class
        Student student1 = new Student();
        Student student2 = new Student();
           
        // Step 2: Use setter methods to set values for all attributes of first student
        // Example values: ID "S001", name "John Doe", grade 85.5, active true
        student1.setStudentId("S001");
        student1.setName("Tien");
        student1.setGrade(83.11);
        student1.setIsActive(true);
               
        // Step 3: Set values for second student
        // Example values: ID "S002", name "Jane Smith", grade 92.0, active true
        student2.setStudentId("S002");
        student2.setName("Hoang");
        student2.setGrade(92);
        student2.setIsActive(true);
        
        // Step 4: Display details of both students
        student1.displayStudent();
        student2.displayStudent();
        
        // Step 5: Compare the grades of the two students and print who has the higher grade
        // Hint: Create a separate method for this comparison
        System.out.println("Step5:  compare the grades ");
        System.out.println(compareGrade(student1, student2));
        
        // Step 6: Test the letter grade method for both students
        System.out.println("Step6: test the letter grade");
        System.out.println("ID: " + student1.getStudentId() + " - " + "Rank: " + student1.scoreClassification(student1));
        System.out.println("ID: " + student2.getStudentId() + " - " + "Rank: " + student2.scoreClassification(student2));
        
        // Step 7: Test the passing status method for both students
        System.out.println("\nStep7: Test the passing status");
        if(student1.passCheck()){
            System.out.println(student1.getStudentId()+ " pass");
        }else{
            System.out.println(student1.getStudentId()+ " fail");
        };
        if(student2.passCheck()){
            System.out.println(student2.getStudentId()+ " pass");
        }else{
            System.out.println(student2.getStudentId()+ " fail");
        };

        // Step 8: Change one student to inactive and display the updated information
        System.out.println("\nStep8: Change status");
        student1.setIsActive(false);
        student1.displayStudent();
    }
    
    // Step 9: Create a static method to compare two students' grades and return the student with the higher grade
    // Hint: Take two Student objects as parameters
    public static String compareGrade(Student std1, Student std2) {
        double grade1 = std1.getGrade();
        double grade2 = std2.getGrade();

        if(grade1 > grade2){
            return  std1.getName() + " is higer Grade";
        }
        else{
            return  std2.getName() + " is higer Grade";
        }
    }
}
