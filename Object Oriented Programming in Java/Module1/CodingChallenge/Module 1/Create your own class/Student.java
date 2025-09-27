// Student class to store and manage student information
public class Student {
    // Step 1: Declare private variables for studentId, name, grade, and isActive
    // Hint: Use appropriate data types (String, String, double, boolean)
    private String studentId;
    private String name;
    private double grade;
    private boolean isActive;

    // Step 2: Create getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getStudentId(){
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public boolean getIsActive() {
        return isActive;
    }

    // Step 3: Create setter methods for each variable
    // Hint: Use the format: public void setVariableName(parameter)
    // Add simple validation:
    // - For grade: Ensure it is between 0 and 100
    // - For studentId: No special validation needed
    // - For name: No special validation needed
    // - For isActive: No special validation needed
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade){
        if(grade <= 100 && grade >= 0){
            this.grade = grade;
        }
    }

    public void setIsActive (boolean isActive){
        this.isActive = isActive;
    }
    // Step 4: Create a method to display student details
    // Hint: Use System.out.println() to print all student information
    // Format should include ID, name, grade, and status (Active/Inactive)
    public void displayStudent(){
        System.out.println("ID: "+ this.getStudentId());
        System.out.println("name: "+ this.getName());
        System.out.println("grade: "+ this.getGrade());
        System.out.println("status "+ this.getIsActive());
        System.out.println(" ");
    }

    // Step 5: Create a method that returns a letter grade based on the numeric grade
    // Hint: A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60
    public String scoreClassification(Student student) {
        double grade = student.getGrade();
        if(grade >= 90 && grade <= 100 ){
            return "A";
        }
        else if(grade >= 80 && grade <= 89 ){
            return "B";
        }
        else if(grade >= 70 && grade <= 79 ){
            return "C";
        }
        else if(grade >= 60 && grade <= 69 ){
            return "D";
        }
        else if(grade < 60 ){
            return "F";
        }
        else {
            return "Error";
        }
    }
   
    // Step 6: Create a method to check if the student is passing (grade >= 60)
    // Hint: Return a boolean value
    public boolean passCheck(){
        double grade = this.getGrade();
        if (grade >= 60){
            return true;
        }else {
            return false;
        }
    }
}
