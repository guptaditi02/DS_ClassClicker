package com.example.project1task2;

import java.util.HashMap;
import java.util.Map;
/*
* Explanation:
* Author: Aditi Gupta - argupta
* Last Modified: September 22, 2023
ClickerModel is a Java class that represents the model component of a simple voting or polling application.
It maintains a static optionMap which is a map to store the vote counts for each voting option.
The recordVote method is used to record a user's vote for a given option.
It takes an option parameter, representing the option that the user voted for.
It uses getOrDefault to increment the vote count for the specified option. If the option doesn't exist in the map, it initializes it to 1.
The getResults method retrieves the voting results.
It returns a copy of the optionMap to prevent external modifications to the map.
The clearResults method clears the voting results.
It empties the optionMap to reset the vote counts, allowing a fresh round of voting.
This class serves as the data model for the voting application, responsible for storing, recording, retrieving, and clearing voting results.
* */
public class ClickerModel {
    // A static map to store vote counts for each option
    public static Map<String, Integer> optionMap = new HashMap<>();

    // Method to record a vote for a given option
    public void recordVote(String option) {
        // Increment the vote count for the specified option, or initialize to 1 if it doesn't exist
        optionMap.put(option, optionMap.getOrDefault(option, 0) + 1);
    }

    // Method to retrieve the voting results
    public Map<String, Integer> getResults() {
        // Return a copy of the optionMap to prevent direct modification
        return new HashMap<>(optionMap);
    }

    // Method to clear the voting results
    public void clearResults() {
        // Clear the optionMap to reset the vote counts
        optionMap.clear();
    }
}
