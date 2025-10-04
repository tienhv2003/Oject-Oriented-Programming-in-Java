import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo nhân viên
        Employee emp1 = new Employee(101, "Nga", "IT", "nga@example.com");
        Employee emp2 = new Employee(102, "Linh", "HR", "linh@example.com");
        Employee emp3 = new Employee(103, "An", "Finance", "an@example.com");

        // Tạo các đơn nghỉ phép khác nhau
        SickLeaveRequest sickLeave = new SickLeaveRequest(
                1, emp1, "2025-10-01", "2025-10-04", true);

        VacationLeaveRequest vacationLeave = new VacationLeaveRequest(
                2, emp2, "2025-11-01", "2025-11-05", "Da Nang");

        MaternityLeaveRequest maternityLeave = new MaternityLeaveRequest(
                3, emp3, "2025-12-01", "2026-03-01", 12);

        // Tạo danh sách polymorphic
        List<LeaveRequest> leaveRequests = new ArrayList<>();
        leaveRequests.add(sickLeave);
        leaveRequests.add(vacationLeave);
        leaveRequests.add(maternityLeave);

        // Xử lý tất cả yêu cầu nghỉ phép
        for (LeaveRequest request : leaveRequests) {
            System.out.println("Request for employee: " + request.employee.getName());
            request.processRequest(); // Java gọi đúng method override tương ứng
            System.out.println();
        }
    }
}
