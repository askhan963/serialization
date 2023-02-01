package org.example;


import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public class Course {

    private @NonNull String name;
    private @NonNull CourseAccess courseAccess;
    private @NonNull List<User> participants;
    private @NonNull String description;

    public Course(@NonNull String name, @NonNull CourseAccess courseAccess, @NonNull List<User> participants, @NonNull String description) {
        this.name = name;
        this.courseAccess = courseAccess;
        this.participants = participants;
        this.description = description;
    }

//    /**
//     * Serializes the Course object into a JSONObject
//     * @return The serialized course as JSONObject
//     */
//    public @NonNull JSONObject toJson(){
//        TODO: Task 3.1: implement toJson()
//        return null;
//    }
public @NonNull JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("name", name);
    json.put("access", courseAccess.toString());
    JSONArray participantNames = new JSONArray();
    for (User participant : participants) {
        participantNames.put(participant.getName());
    }
    json.put("participantNames", participantNames);
    json.put("description", description);
    return json;

}
//    /**
//     * Deserializes the JSONObject to a Course object.
//     * @param json The JSONObject to deserialize
//     * @param userManager The UserManager to retrieve the User objects from
//     * @return The deserialized Course
//     */
//    public static @NonNull Course fromJson(@NonNull JSONObject json, @NonNull UserManager userManager){
//        TODO: Task 3.2: implement fromJson()
//        return null;
//    }
public static @NonNull Course fromJson(@NonNull JSONObject json, @NonNull UserManager userManager) {
    String name = json.getString("name");
    CourseAccess access = CourseAccess.valueOf(json.getString("access"));
    JSONArray participantNames = json.getJSONArray("participantNames");
    List<User> participants = new ArrayList<>();
    for (int i = 0; i < participantNames.length(); i++) {
        User participant =  userManager.getUsers().get(i);
        participants.add(participant);
    }
    String description = json.getString("description");
    return new Course(name, access, participants, description);
}

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(@NonNull List<User> participants) {
        this.participants = participants;
    }

    public @NonNull CourseAccess getCourseAccess() {
        return courseAccess;
    }

    public void setCourseAccess(@NonNull CourseAccess courseAccess) {
        this.courseAccess = courseAccess;
    }

    public @NonNull String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{"
                + "name='" + name + '\''
                + ", courseAccess=" + courseAccess
                + ", participants=" + participants
                + ", description='" + description + '\''
                + '}';
    }

}
