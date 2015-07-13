package com.univaqproject.main;

import java.io.IOException;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class TagText {
	
	//A tokenizer divides text into a sequence of tokens, which roughly correspond to "words".
	
	
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

 
        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("left3words-wsj-0-18.tagger");
 
        // The sample string
        String sample = "This is a sample text";
        
        
 
        // The tagged string
        String tagged = tagger.tagString(sample);
 
        // Output the result
        System.out.println(tagged);
    }
}
