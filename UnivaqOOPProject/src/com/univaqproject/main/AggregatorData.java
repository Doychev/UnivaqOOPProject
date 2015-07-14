package com.univaqproject.main;

import java.util.HashMap;
import java.util.Map;

public class AggregatorData {
	
	private String rawWebData;
	private String analysedWebData;	
	private String mostUsedWord;
	private Map<String, Integer> tagsCounts = new HashMap<String, Integer>();
	private Map<String, Integer> wordsCounts = new HashMap<String, Integer>();

	public String getRawWebData() {
		return rawWebData;
	}
	public void setRawWebData(String rawWebData) {
		this.rawWebData = rawWebData;
	}
	public String getAnalysedWebData() {
		return analysedWebData;
	}
	public void setAnalysedWebData(String analysedWebData) {
		this.analysedWebData = analysedWebData;
	}
	public String getMostUsedWord() {
		return mostUsedWord;
	}
	public void setMostUsedWord(String mostUsedWord) {
		this.mostUsedWord = mostUsedWord;
	}
	public Map<String, Integer> getTagsCounts() {
		return tagsCounts;
	}
	public void setTagsCounts(Map<String, Integer> tagsCounts) {
		this.tagsCounts = tagsCounts;
	}
	public Map<String, Integer> getWordsCounts() {
		return wordsCounts;
	}
	public void setWordsCounts(Map<String, Integer> wordsCounts) {
		this.wordsCounts = wordsCounts;
	}

}
