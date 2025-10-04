public class Employee {
    // Properties
    private int employeeId;
    private String name;
    private String department;
    private String email;
    private int leaveBalance = 20; // mặc định 20 ngày phép/năm

    // Default constructor (constructor rỗng)
    public Employee() {
        this.employeeId = 0;
        this.name = "Unknown";
        this.department = "Unassigned";
        this.email = "No email";
    }

    // Constructor có tham số
    public Employee(int employeeId, String name, String department, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        if (leaveBalance >= 0) {
            this.leaveBalance = leaveBalance;
        } else {
            System.out.println("Leave balance cannot be negative.");
        }
    }

    // Method trừ số ngày phép sau khi nghỉ
    public void deductLeave(int days) {
        if (days > 0 && leaveBalance >= days) {
            leaveBalance -= days;
        } else {
            System.out.println("Not enough leave balance!");
        }
    }
}
