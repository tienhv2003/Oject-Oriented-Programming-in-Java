// TestEncapsulation class to test the Employee class
public class TestEncapsulation {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Employee class
        // One using the parameterized constructor and one using default constructor with setters
        Employee emp1 = new Employee();
        emp1.setName("HOANG");
        emp1.setAge(23);
        emp1.setSalary(23.00);

        Employee emp2 = new Employee("NGA", 22, 12.00);
        // Step 2: Print details of both employees
        System.out.println(emp1);
        System.out.println(emp2);
        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        // and see if your validation works
        System.out.println("Testing validation with invalid values:");
        emp1.setName("");  // Invalid: empty name
        emp1.setAge(70);   // Invalid: age outside range
        emp1.setSalary(-100); // Invalid: negative salary
        
        System.out.println("\nEmployee Details After Invalid Values:");
        System.out.println(emp1);
        System.out.println(emp2);
        // Step 4: Give both employees a 10% raise and display their details again
        System.out.println("Giving both employees a 10% raise:");
        emp1.giveRaise(10);
        emp2.giveRaise(10);
        // Step 5: Clone the first employee and display the cloned employee details
        // Hint: Use try-catch block to handle CloneNotSupportedException
        // Employee clonedEmployee = (Employee) employee1.clone();
        System.out.println("Clone emp1");
        try{
            Employee clonedEmployee = (Employee) emp1.clone();
            System.out.println(clonedEmployee);
        } catch(CloneNotSupportedException e){
            System.out.println("error can not clone: "+ e.getMessage());
        }
        // Step 6: Modify the original employee and verify that the clone remains unchanged
        // This demonstrates that cloning creates a separate object
        // System.out.println("Step6:cloning creates a separate object ");
        // emp1.setName("newTIEN");
        // System.out.println(emp1);
        // System.out.println(clonedEmployee);

        //Step 7: compare salary
        String result = compareSalaries(emp1, emp2);
        System.out.println(result);
    }
    // Step 7: Create a method that compares the salaries of two employees
    // and returns the name of the employee with the higher salary
    // If salaries are equal, return "Equal salaries"
    public static String compareSalaries (Employee employee1, Employee employee2) { 
        if (employee1.getSalary() > employee2.getSalary()) {
            return employee1.getName() + " has a higher salary";
        } else if (employee2.getSalary() > employee1.getSalary()) {
            return employee2.getName() + " has a higher salary";
        } else {
            return "Equal salaries";
        }
    }
}
