package org.example;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.json.JSONArray;

import java.util.List;

public class Utils {

//    /**
//     * Parses the passed user list into a JSONArray using Streams
//     * @param userList The user list to parse
//     * @return The JSONArray containing the parsed users
//     */
//    public @NonNull JSONArray jsonArrayFromUserList(@NonNull List<User> userList) {
//        TODO: Bonus Task: implement jsonArrayFromUserList()
//        return null;
//    }
public @NonNull JSONArray jsonArrayFromUserList(@NonNull List<User> userList) {
    return userList.stream()
            .map(User::toJson)
            .collect(JSONArray::new, JSONArray::put, JSONArray::put);
}
//    /**
//     * Parses the passed course list into a JSONArray using Streams
//     * @param courseList The course list to parse
//     * @return The JSONArray containing the parsed courses
//     */
//    public @NonNull JSONArray jsonArrayFromCourseList(@NonNull List<Course> courseList) {
//        TODO: Bonus Task: implement jsonArrayFromCourseList()
//        return null;
//    }
public @NonNull JSONArray jsonArrayFromCourseList(@NonNull List<Course> courses) {
    return courses.stream()
            .map(Course::toJson)
            .collect(JSONArray::new, JSONArray::put, JSONArray::put);
}

}
