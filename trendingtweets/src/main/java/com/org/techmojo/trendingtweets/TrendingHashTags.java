package com.org.techmojo.trendingtweets;

/**
 * @Input String contains '#' tags //assuming each line contains only one '#'
 *        tags
 * @Output Top k trending '#' tags
 * @Used data structure Map.Entry<String,String> to store hash tags MaxHeap to
 *       maintains top k hash tags
 */
public class TrendingHashTags {
	public static void main(String[] args) {
		ServiceTrendingHashTags serviceTrendingHashTags = new ServiceTrendingHashTags();
		serviceTrendingHashTags.getInput();
		serviceTrendingHashTags.processInput();
		serviceTrendingHashTags.printTopTrends();
	}
}
