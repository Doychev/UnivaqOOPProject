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
	
	
    public static String analyseData(String data) throws IOException,
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
        String tagged = tagger.tagString(data);
 
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
		
		return sb.toString();        
    }
    
    public static String getRealMeaning(String abbr) {
    	String realMeaning = "";
		switch (abbr) {
		case "CC":
			realMeaning = "Coordinating conjuction";
			break;

		case "CD":
			realMeaning = "Cardinal number";
			break;
			
		case "DT":
			realMeaning = "Determiner";
			break;

		case "EX":
			realMeaning = "Existential there";
			break;
			
		case "FW":
			realMeaning = "Foreign word";
			break;

		case "IN":
			realMeaning = "Preposition or subordinating conjunction";
			break;
			
		case "JJ":
			realMeaning = "Adjective";
			break;

		case "JJR":
			realMeaning = "Adjective, comparative";
			break;
			
		case "JJS":
			realMeaning = "Adjective, superlative";
			break;

		case "LS":
			realMeaning = "List item marker";
			break;
			
		case "MD":
			realMeaning = "Modal";
			break;

		case "NN":
			realMeaning = "Noun, singular or mass";
			break;
			
		case "NNS":
			realMeaning = "Noun, plural";
			break;
			
		case "NNP":
			realMeaning = "Proper noun, singular";
			break;

		case "NNPS":
			realMeaning = "Proper noun, plural";
			break;
			
		case "PDT":
			realMeaning = "Predeterminer";
			break;

		case "POS":
			realMeaning = "Possessive ending";
			break;
			
		case "PRP":
			realMeaning = "Personal pronoun";
			break;

		case "PRP$":
			realMeaning = "Possessive pronoun";
			break;
			
		case "RB":
			realMeaning = "Adverb";
			break;

		case "RBR":
			realMeaning = "Adverb, comparative";
			break;
			
		case "RBS":
			realMeaning = "Adverb, superlative";
			break;

		case "RP":
			realMeaning = "Particle";
			break;
			
		case "SYM":
			realMeaning = "Symbol";
			break;
			
		case "TO":
			realMeaning = "to";
			break;

		case "UH":
			realMeaning = "Interjection";
			break;
			
		case "VB":
			realMeaning = "Verb, base form";
			break;

		case "VBD":
			realMeaning = "Verb, past tense";
			break;
			
		case "VBG":
			realMeaning = "Verb, gerund or present participle";
			break;

		case "VBN":
			realMeaning = "Verb, past participle";
			break;
			
		case "VBP":
			realMeaning = "Verb, non-3rd person singular present";
			break;

		case "VBZ":
			realMeaning = "Verb, 3rd person singular present";
			break;
			
		case "WDT":
			realMeaning = "Wh-determiner";
			break;

		case "WP":
			realMeaning = "Wh-pronoun";
			break;
			
		case "WP$":
			realMeaning = "Possessive wh-pronoun";
			break;
			
		case "WRB":
			realMeaning = "Wh-adverb";
			break;
			
			//TODO: top 3 words

		default:
			break;
		} 
		return realMeaning;
    }
    
    public static void top3Words (String data) {
    	
    }
}
