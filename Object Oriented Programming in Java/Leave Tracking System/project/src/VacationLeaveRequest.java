public class VacationLeaveRequest extends LeaveRequest {
    private String vacationLocation;

    public VacationLeaveRequest(int requestId, Employee employee,
                                String startDate, String endDate,
                                String vacationLocation) {
        super(requestId, employee, startDate, endDate, "Vacation Leave");
        this.vacationLocation = vacationLocation;
    }

    public String getVacationLocation() {
        return vacationLocation;
    }
    public void setVacationLocation(String vacationLocation) {
        this.vacationLocation = vacationLocation;
    }

    // Override phương thức processRequest
    // Override processRequest theo dạng bạn muốn
    @Override
    public boolean processRequest() {
        if (getDuration() > 10) { // ví dụ nghỉ quá 10 ngày cần xét duyệt đặc biệt
            System.out.println("Vacation leave longer than 10 days requires manager approval");
            return false;
        }
        System.out.println("Processing vacation leave request...");
        return true;
    }
}
