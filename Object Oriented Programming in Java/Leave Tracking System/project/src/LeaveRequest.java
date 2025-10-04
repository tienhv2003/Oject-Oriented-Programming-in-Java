import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LeaveRequest {
    private int requestId;
    public Employee employee;
    private String startDate;
    private String endDate;
    private String status; // "Pending", "Approved", "Denied"
    private String reason;

    // Constructor chính
    public LeaveRequest(int requestId, Employee employee, String startDate,
                        String endDate, String reason) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending"; // mặc định
        this.reason = reason;
    }

    // Overloaded constructor (không có reason)
    public LeaveRequest(int requestId, Employee employee, String startDate, String endDate) {
        this(requestId, employee, startDate, endDate, "No reason provided");
    }

    // Getters and setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        this.status = "Approved";
    }

    public void deny() {
        this.status = "Denied";
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public long  getDuration() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return ChronoUnit.DAYS.between(start, end) + 1;
    }
    // In the parent LeaveRequest class
    public boolean processRequest() {
        //Basic request processing logic
        System.out.println("Processing generic leave request...");
        return true;
    }
}

