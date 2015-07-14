package com.univaqproject.main;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class TagText {
	
	//A tokenizer divides text into a sequence of tokens, which roughly correspond to "words".
	
	
    public static AggregatorData analyseData(AggregatorData data) throws IOException,
            ClassNotFoundException {
    	
    	/*
    	 * DT - determinant
    	 * VBZ - verb
    	 * NN - noun
    	 * ...
    	 */
    	
    	Map<String, Integer> tagsCounts = new HashMap<String, Integer>();
    	Map<String, Integer> wordsCounts = new HashMap<String, Integer>();
 
        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("left3words-wsj-0-18.tagger");
 
 
        // The tagged string
        String tagged = tagger.tagString(data.getRawWebData());
 
        List<String> taggedWords = new ArrayList<String>(Arrays.asList(tagged.split(" ")));
        for (String word : taggedWords) {
        	String[] splitted = word.split("/");
        	
        	if (wordsCounts.get(splitted[0]) == null) {
        		wordsCounts.put(splitted[0], 0);
        	}
        	wordsCounts.put(splitted[0], wordsCounts.get(splitted[0])+1);
        	
        	if (tagsCounts.get(splitted[1]) == null) {
        		tagsCounts.put(splitted[1], 0);
        	}
        	tagsCounts.put(splitted[1], tagsCounts.get(splitted[1])+1);
        }

        // Output the result
        StringBuilder sb = new StringBuilder();
        
        //sb.append(tagged + "\n\n");
        
        sb.append("Words:\n");
		for (Map.Entry<String, Integer> entry : wordsCounts.entrySet())
		{
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}

		sb.append("\nTags:\n");
		for (Map.Entry<String, Integer> entry : tagsCounts.entrySet())
		{
			String realMeaning = getRealMeaning(entry.getKey());
			sb.append(realMeaning + ": " + entry.getValue() + "\n");
		}
		
		data.setAnalysedWebData(sb.toString());
		data.setTagsCounts(tagsCounts);
		data.setWordsCounts(wordsCounts);
		return data;        
    }
    
    public static String getRealMeaning(String abbr) {
    	String realMeaning = "";
		switch (abbr) {
		case "NN":
			realMeaning = "Noun";
			break;

		case "VBZ":
			realMeaning = "Verb";
			break;
			
			//TODO: top 3 words

		default:
			break;
		} 
		return realMeaning;
    }
}
