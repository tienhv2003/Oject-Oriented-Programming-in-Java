public class MaternityLeaveRequest extends LeaveRequest {
    private int numberOfWeeks;

    public MaternityLeaveRequest(int requestId, Employee employee,
                                 String startDate, String endDate,
                                 int numberOfWeeks) {
        super(requestId, employee, startDate, endDate, "Maternity Leave");
        this.numberOfWeeks = numberOfWeeks;
    }

    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void setNumberOfWeeks(int numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    // Override processRequest
    @Override
    public boolean processRequest() {
        if (numberOfWeeks > 12) { // ví dụ: nghỉ thai sản > 12 tuần cần xét duyệt đặc biệt
            System.out.println("Maternity leave longer than 12 weeks requires HR approval");
            return false;
        }
        System.out.println("Processing maternity leave request...");
        return true;
    }
}
