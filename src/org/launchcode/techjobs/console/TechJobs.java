package org.launchcode.techjobs.console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by LaunchCode
 */
public class TechJobs {

    private static Scanner in = new Scanner(System.in);

    public static void main (String[] args) {

        // Initialize our field map with key/name pairs
        HashMap<String, String> columnChoices = new HashMap<>();
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("all", "All");

        // Top-level menu options
        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        System.out.println("Welcome to LaunchCode's TechJobs App!");

        // Allow the user to search until they manually quit
        while (true) {

            String actionChoice = getUserSelection("View jobs by:", actionChoices);

            if (actionChoice.equals("list")) {

                String columnChoice = getUserSelection("List", columnChoices);

                if (columnChoice.equals("all")) {
                    printJobs(JobData.findAll());
                } else {

                    ArrayList<String> results = JobData.findAll(columnChoice);
                    Collections.sort(results);

                    System.out.println("\n*** All " + columnChoices.get(columnChoice) + " Values ***");

                    // Print list of skills, employers, etc
                    for (String item : results) {
                        System.out.println(item);
                    }
                }

            } else { // choice is "search"

                // How does the user want to search (e.g. by skill or employer)
                String searchField = getUserSelection("Search by:", columnChoices);

                // What is their search term?
                System.out.println("\nSearch term: ");
                String searchTerm = in.nextLine().toLowerCase();

                if (searchField.equals("all")) {
                    //System.out.println("Search all fields not yet implemented.");
                    printJobs(JobData.findByValue(searchTerm));
                } else {
                    printJobs(JobData.findByColumnAndValue(searchField, searchTerm));
                }
            }
        }
    }

    // ﻿Returns the key of the selected item from the choices Dictionary
    private static String getUserSelection(String menuHeader, HashMap<String, String> choices) {

        Integer choiceIdx;
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];

        // Put the choices in an ordered structure so we can
        // associate an integer with each one
        Integer i = 0;
        for (String choiceKey : choices.keySet()) {
            choiceKeys[i] = choiceKey;
            i++;
        }

        do {

            System.out.println("\n" + menuHeader);

            // Print available choices
            for (Integer j = 0; j < choiceKeys.length; j++) {
                System.out.println("" + j + " - " + choices.get(choiceKeys[j]));
            }

            choiceIdx = in.nextInt();
            in.nextLine();

            // Validate user's input
            if (choiceIdx < 0 || choiceIdx >= choiceKeys.length) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }

        } while(!validChoice);

        return choiceKeys[choiceIdx];
    }

    // Print a list of jobs
    private static void printJobs(ArrayList<HashMap<String, String>> someJobs) {

        //System.out.println("printJobs is not implemented yet");
        //print job if there is a search result
        //iterate over an arraylist of jobs(which each is a hashmap)
       // ArrayList<HashMap<String, String>> someJobs = jobs;
    if (someJobs.size() == 0) {
        System.out.println("No records found.");
    }else {
        for (int i = 0; i < someJobs.size(); i++) {
            HashMap<String, String> foundJobs = someJobs.get(i);
            System.out.println("*****");
            for (String key : foundJobs.keySet()) {
                System.out.println(key + ": " + foundJobs.get(key));
            }
            System.out.println("***** \n");

        }
    }
        //variables needed: jobs
//
        //for (Integer Key: someJobs[i].keyset()){
        //for (HashMap<String, String> row : someJobs.get(i)) {

        //make a nested loop to loop over each hashmap
        //make it so nexted loop will pring out any new field added  to the job records without any updates to printJobs
        /**
         * *****
         * position type: Data Scientist / Business Intelligence
         * name: Sr. IT Analyst (Data/BI)
         * employer: Bull Moose Industries
         * location: Saint Louis
         * core competency: Statistical Analysis
         * *****
         *
         * To do this, you’ll need to iterate over an ArrayList of jobs. Each job is itself a HashMap.
         * While you can get each of the items out of the HashMap using the known keys (employer, location, etc.),
         * think instead about creating a nested loop to loop over each HashMap.
         * If a new field is added to the job records,
         * this approach will print out the new field without any updates to printJobs.
         */


        //print something if there are no results
    }
}
