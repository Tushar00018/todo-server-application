package com.myTodoApplication.TodoApplication.utility;

public class CommonUtilities {
    public static final String DATA_FETCHED = "Data fetched successfully";
    public static final String NO_DATA = "No data found";

    public static String created(String entity) {
        return entity + " created successfully";
    }

    public static String failure(String entity, String errorMessage) {
        return "Failed to create " + entity + ": " + errorMessage;
    }
}
