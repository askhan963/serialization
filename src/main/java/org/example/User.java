package org.example;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
public class User {


    private @NonNull String name;
    private @NonNull String role;
    private @Nullable String profileDescription;

    public User(@NonNull String name, @NonNull String role) {
        this.name = name;
        this.role = role;
        this.profileDescription = null;
    }

    public User(@NonNull String name, @NonNull String role, @Nullable String profileDescription) {
        this.name = name;
        this.role = role;
        this.profileDescription = profileDescription;
    }

//    /**
//     * Serializes the User object into a JSONObject
//     * @return The serialized user as JSONObject
//     */
//    public @NonNull JSONObject toJson(){
//        TODO: Task 2.1: implement toJson()
//    }
public @NonNull JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("name", name);
    json.put("role", role);
    if (profileDescription != null) {
        json.put("profileDescription", profileDescription);
    }
    return json;
}

//    /**
//     * Deserializes the JSONObject to a User object.
//     * @param json The JSONObject to deserialize
//     * @return The deserialized User
//     */
//    public static @NonNull User fromJson(@NonNull JSONObject json) {
//        TODO: Task 2.3: implement fromJson(JSONObject)
//        return null;
//    }
public static @NonNull User fromJson(@NonNull JSONObject json) {
    String name = json.getString("name");
    String role = json.getString("role");
    String profileDescription = json.has("profileDescription") ? json.getString("profileDescription") : null;
    return new User(name, role, profileDescription);
}

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull String getRole() {
        return role;
    }

    public void setRole(@NonNull String role) {
        this.role = role;
    }

    public @Nullable String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(@Nullable String profileDescription) {
        this.profileDescription = profileDescription;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", role='" + role + '\''
                + ", profileDescription='" + profileDescription + '\''
                + '}';
    }
}
