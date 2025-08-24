// 🎨 Ferrari Formula — StudentDashboard.java
// Author: Ale Ferrari
// Description: Simulates a student-facing dashboard for DriverPass.
// Highlights: Modular design, clean output formatting, and user-centric logic.

import java.time.LocalDateTime;
import java.util.List;

public class StudentDashboard {
    private String studentName;
    private int completedLessons;
    private List<LocalDateTime> upcomingLessons;
    private boolean paymentStatus;

    public StudentDashboard(String studentName, int completedLessons, List<LocalDateTime> upcomingLessons, boolean paymentStatus) {
        this.studentName = studentName;
        this.completedLessons = completedLessons;
        this.upcomingLessons = upcomingLessons;
        this.paymentStatus = paymentStatus;
    }

    public void displayDashboard() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.printf("║ 🚗 Welcome, %s%n", studentName);
        System.out.println("╠════════════════════════════════════╣");
        System.out.printf("║ ✅ Lessons Completed: %d%n", completedLessons);
        System.out.printf("║ 📅 Upcoming Lessons: %d%n", upcomingLessons.size());
        System.out.printf("║ 💳 Payment Status: %s%n", paymentStatus ? "Active" : "Pending");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 🔍 Next Lesson Preview:");
        if (!upcomingLessons.isEmpty()) {
            System.out.printf("║    → %s%n", upcomingLessons.get(0));
        } else {
            System.out.println("║    → No lessons scheduled.");
        }
        System.out.println("╚════════════════════════════════════╝");
    }
}