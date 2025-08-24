// 📘 DriverPass System — LessonScheduler.java
// Author: Ale Ferrari
// Description: Core scheduling logic for DriverPass lesson management.
// Part of the CS255 System Design Portfolio

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LessonScheduler {
    private List<Lesson> scheduledLessons;

    public LessonScheduler() {
        this.scheduledLessons = new ArrayList<>();
    }

    public boolean scheduleLesson(String studentId, String instructorId, LocalDateTime dateTime) {
        Lesson newLesson = new Lesson(studentId, instructorId, dateTime);
        if (isConflict(newLesson)) {
            System.out.println("⚠️ Conflict detected: Lesson not scheduled.");
            return false;
        }
        scheduledLessons.add(newLesson);
        System.out.println("✅ Lesson scheduled successfully.");
        return true;
    }

    private boolean isConflict(Lesson newLesson) {
        for (Lesson lesson : scheduledLessons) {
            if (lesson.getInstructorId().equals(newLesson.getInstructorId()) &&
                lesson.getDateTime().equals(newLesson.getDateTime())) {
                return true;
            }
        }
        return false;
    }

    // Inner class representing a lesson
    private static class Lesson {
        private String studentId;
        private String instructorId;
        private LocalDateTime dateTime;

        public Lesson(String studentId, String instructorId, LocalDateTime dateTime) {
            this.studentId = studentId;
            this.instructorId = instructorId;
            this.dateTime = dateTime;
        }

        public String getStudentId() { return studentId; }
        public String getInstructorId() { return instructorId; }
        public LocalDateTime getDateTime() { return dateTime; }
    }
}