class Student extends User {
    private String studentId;
    private String major;

    public Student(String userId, String name, String email, String studentId, String major) {
        super(userId, name, email);
        this.studentId = studentId;
        this.major = major;
    }

    public int getMaxBorrowLimit() {
        return 5;
    }
}
