package org.example;


import org.checkerframework.checker.nullness.qual.NonNull;

public class Artemis {

    private UserManager userManager;
    private CourseManager courseManager;

    public void setUserManager(@NonNull UserManager userManager) {
        this.userManager = userManager;
    }

    public void setCourseManager(@NonNull CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public @NonNull UserManager getUserManager() {
        return userManager;
    }

    public @NonNull CourseManager getCourseManager() {
        return courseManager;
    }

    public static void main(String[] args) {
        // You can test your code here
    }

}
