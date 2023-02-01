package org.example;


import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public class CourseManager {

    private @NonNull List<Course> courses;
    private @NonNull Artemis artemis;
    private  @NonNull UserManager userManager;
    public CourseManager(@NonNull Artemis artemis) {
        this.artemis = artemis;
        this.courses = new ArrayList<>();
        this.userManager = new UserManager();
    }

    /**
     * Loads courses from the passed Json data
     * @param Json The Json data to parse
     */
    public void loadCourses(@NonNull String jsonData) {
        // TODO: Task 3.3: implement loadCourses()
        JSONArray jsonArray = new JSONArray(jsonData);
        courses.clear();
        if (jsonArray.length() > 0) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Course course = Course.fromJson(jsonObject, userManager);
                courses.add(course);
            }
        }

    }

    /**
     * Serializes the courses to Json
     * @return The course list represented in Json format
     */
    public @NonNull String serializeCourses() {
        // TODO: Task 3.3: implement serializeCourses()
        JSONArray jsonArray = new JSONArray();
        for (Course course : courses) {
            jsonArray.put(course.toJson());
        }
        return jsonArray.toString();
    }

    public @NonNull Artemis getArtemis() {
        return artemis;
    }
    public @NonNull List<Course> getCourses() {
        return courses;
    }

    public void setCourses(@NonNull List<Course> courses) {
        this.courses = courses;
    }
}
