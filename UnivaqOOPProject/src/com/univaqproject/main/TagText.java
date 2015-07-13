package com.univaqproject.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class TagText {
	
	//A tokenizer divides text into a sequence of tokens, which roughly correspond to "words".
	
	
    public static void main(String[] args) throws IOException,
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
 
        // The sample string
        String sample = "This is a sample text";
        
        
 
        // The tagged string
        String tagged = tagger.tagString(sample);
 
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
        System.out.println(tagged + "\n");
        
	    System.out.println("Words:");
		for (Map.Entry<String, Integer> entry : wordsCounts.entrySet())
		{
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}

	    System.out.println("\nTags:");
		for (Map.Entry<String, Integer> entry : tagsCounts.entrySet())
		{
			String realMeaning = "";
			switch (entry.getKey()) {
			case "NN":
				realMeaning = "Noun";
				break;

			case "VBZ":
				realMeaning = "Verb";
				break;

			default:
				break;
			} 
		    System.out.println(realMeaning + ": " + entry.getValue());
		}

        
    }
}
