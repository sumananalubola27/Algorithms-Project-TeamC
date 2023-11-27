package pkg;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.io.BufferedWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
    	
    	List<String> firstColumnValues = new ArrayList<>();
    	
    	String formattedDateTime = null;
//    	String weatherCsvFilePath = "C:/Users/saini/eclipse-workspace/githublatest/pkg/weather.csv";
        String distanceCsvFilePath = "C:/Users/saini/eclipse-workspace/githublatest/pkg/DistanceMS2.csv";
        String seaLevelCsvFilePath = "C:/Users/saini/eclipse-workspace/githublatest/pkg/seaLevel.csv";
        
        System.out.print("Please provide the name of your starting city and state in the specified format: Ex: (MillCity-NV) ");
        Scanner sc = new Scanner(System.in);
        String startcity = sc.nextLine();
        System.out.println();
        System.out.print("Please provide your destination city in the same format: (City-State) ");
        String endcity = sc.nextLine();
        System.out.println();
        System.out.print("Specify the desired travel range (in miles) : ");
        int range = sc.nextInt();
        sc.nextLine();
        System.out.println();
        
        
        //System.out.print("Enter date and time of your commencement (yyyy-MM-dd HH:mm): ");
        //String userInput = sc.nextLine();
        
       // if (userInput.isEmpty()) {
       //     System.out.println("Error: Please provide a non-empty input.");
        //    return;
        //}

//        try {
//            // Parse user input into LocalDateTime
//            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            LocalDateTime localDateTime = LocalDateTime.parse(userInput, inputFormatter);
//
//            // Format the LocalDateTime into the desired output format
//            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//            formattedDateTime = localDateTime.format(outputFormatter);
//
//        } catch (Exception e) {
//            System.out.println("Error: Unable to parse the input. Please provide a valid date and time format.");
//        }
        
        try {
        	 CityWeatherManager cityWeatherManager = new CityWeatherManager();
             DistanceDataManager distanceDataManager = new DistanceDataManager();
             SeaLevel seaLevel = new SeaLevel();

             // Load weather data
//             Map<String, CityData> cityWeatherMap = cityWeatherManager.loadWeatherData(weatherCsvFilePath);

             // Loading distance data
             List<List<String>> distanceData = distanceDataManager.loadDistanceData(distanceCsvFilePath);
             
             
             for (List<String> row : distanceData) {
                 if (!row.isEmpty()) {
                     // Add the first element of the inner list (first column) to the new list
                     firstColumnValues.add(row.get(0));
                 }
             }
             

            // loading seaLevel data
             List<List<String>> seaLeveldata = seaLevel.loadSeaLevel(seaLevelCsvFilePath);
            
             // Combining data
//             cityWeatherManager.combineData(cityWeatherMap, distanceData,seaLeveldata);
            
//             display_temperatures temperature = new display_temperatures(cityWeatherMap, formattedDateTime);  
            
             possible_paths_1 paths = new possible_paths_1(distanceData, startcity, endcity, range);
            
             List<List<String>> allpaths = paths.findAllPaths();
            
//             if(allpaths.size() != 0) {
//            	 allpaths.remove(0);
//             }
            
//             List<List<String>> mst = prims.findMST(allpaths, new_distancedata, startcity, endcity, 100, cityWeatherMap, temperature);

//             System.out.println("Minimum Spanning Tree:");
//             int total = 0;
//             for (List<String> pathWithDistance : mst) {
//                 System.out.println("Path: " + pathWithDistance.subList(0, 2));
//                 System.out.println("Distance: " + pathWithDistance.get(2));
//                 int distance = Integer.parseInt(pathWithDistance.get(2));
//                 total = (total + distance);
//             }
//             System.out.println("Total distance travelled with Prims Algorithms: " + total);

             long endTime = System.currentTimeMillis();

            // Calculate and print the runtime
             long runtime = endTime - startTime;
//            System.out.println("Runtime: " + runtime + " milliseconds");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
