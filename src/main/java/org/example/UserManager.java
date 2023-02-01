package org.example;


import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Optional;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserManager {

    private @NonNull ArrayList<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    /**
     * Creates a Json backup containing all users
     *
     * @return The user list represented in Json format
     */
    public @NonNull String serializeUsers() {
        // TODO: Task 2.2: implement serializeUsers()
        JSONArray jsonArray = new JSONArray();
        for (User user : users) {
            jsonArray.put(user.toJson());
        }
        return jsonArray.toString();
       // return "";
    }

    /**
     * Loads users from the passed Json data
     *
     * @param json The Json data to parse
     */
    public void loadUsers(@NonNull String json) {
        // TODO: Task 2.4: implement loadUsers()
        try {
            JSONArray jsonArray = new JSONArray(json);
            users.clear();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                users.add(User.fromJson(jsonObject));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user object to the respective name
     *
     * @param name The users name
     * @return The respective user
     */
    public @NonNull Optional<User> getUserByName(@NonNull String name) {
        return users.stream()
                .filter(user -> name.equals(user.getName()))
                .findFirst();
    }

    public @NonNull ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(@NonNull ArrayList<User> users) {
        this.users = users;
    }
}
