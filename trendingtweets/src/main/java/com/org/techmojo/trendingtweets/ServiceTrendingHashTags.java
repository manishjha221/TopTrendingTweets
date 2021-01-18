package com.org.techmojo.trendingtweets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * This is a service class which will take the input process the input and print
 * it
 */
public class ServiceTrendingHashTags {
	// Used to maintain the top k trending tweets based on its frequency
	private PriorityQueue<Map.Entry<String, Integer>> minHeap;
	// Used to maintain original string based on its '#" tags
	private HashMap<String, String> mapToGetString;
	// Used to keep track of frequencies based on '#' tags
	private HashMap<String, Integer> mapToStoreFrequencies;
	// For taking input
	private Scanner in;
	// Maintains top k trending tweets initially 10;
	private int k;
	// To print top trends
	private StringBuilder topKTrends;

//ServiceTrendingHashTags is a constructor which will instantiate object 
	public ServiceTrendingHashTags() {
		minHeap = new PriorityQueue<Map.Entry<String, Integer>>((n1, n2) -> n1.getValue() - n2.getValue());
		mapToGetString = new HashMap<String, String>();
		mapToStoreFrequencies = new HashMap<String, Integer>();
		in = new Scanner(System.in);
		//we had taken default value
		k = 10;
		topKTrends=new StringBuilder("");
	}

//getInput takes the input and maintain in seprate data structure
	public void getInput() {

		int numberOfTweets = Integer.parseInt(in.next());

		in.nextLine();
		String[] allTweets = new String[numberOfTweets];
		for (int i = 0; i < numberOfTweets; i++) {
			allTweets[i] = in.nextLine();
			String[] splitString = allTweets[i].split("#");
			mapToStoreFrequencies.put(splitString[1], mapToStoreFrequencies.getOrDefault(splitString[1], 0) + 1);
			mapToGetString.put(splitString[1], allTweets[i]);
		}
	}

//processInput will process the taken input
	public void processInput() {
		for (Map.Entry<String, Integer> eachStringFrequencies : mapToStoreFrequencies.entrySet()) {
			minHeap.add(eachStringFrequencies);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		List<String>listToTakeMaintaintopTrend=new ArrayList<>();
		while (!minHeap.isEmpty()) {
			listToTakeMaintaintopTrend.add(minHeap.poll().getKey());
		}
		for(int i=listToTakeMaintaintopTrend.size()-1;i>=0;i--) {
			topKTrends.append(listToTakeMaintaintopTrend.get(i)).append("\n");
		}

	}

//printTopTrends print the top trending tweets
	public void printTopTrends() {
		System.out.println("*****Top k:"+k+" trends are******");
		System.out.println(topKTrends);
	}
}
