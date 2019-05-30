package bigrams_cosc_620;

import java.util.*;
import java.util.Collections;

/**
 *
 * @author bbluebaugh
 */
public class BigramSearch {
    String[] bigramArray;
    int[] countArray;
    String[] allWords;
    
    String[] splitForBigrams;
    String whole;
    
    //constructor for what the method will take and give out
    public BigramSearch(String string){
        whole = string;
    }
    
    //splitting the whole text document to be easily readable
    public void articleSplit(){
        splitForBigrams = whole.split("\\s+");
        bigramArray = new String[splitForBigrams.length - 1];
    }
    
    public void bigramcreation(){
        String temp;
        for(int i = 0; i < splitForBigrams.length - 1; i++){
            
            temp = splitForBigrams[i] + " " + splitForBigrams[i + 1];
            bigramArray[i] = temp;
        }
        /**
        for(int i = 0; i < bigramArray.length; i++){
            System.out.println(bigramArray[i]);
        }
        */
    }
    
    public void frequencies(String[] pizza){
        
        List<Integer> frequency = new ArrayList<>();
        List<String> bigramCount = new ArrayList<>();
        
        
        for(int i = 0; i < bigramArray.length; i++){
            boolean alreadyHere = false;
            if(bigramCount.size() == 0){
                bigramCount.add(bigramArray[i]);
                frequency.add(1);
            }
            for(int j = 0; j < bigramCount.size(); j++){
                if(bigramArray[i].equals(bigramCount.get(j))){
                    int current = frequency.get(j);
                    frequency.set(j, current + 1);
                    alreadyHere = true;
                }
            }
            
            if(alreadyHere == false){
                bigramCount.add(bigramArray[i]);
                frequency.add(1);
            }
        }
        
        for(int i = 0; i < 20; i++){
            boolean found = false;
            for(int j = 0; j < frequency.size(); j++){
                if(frequency.get(j) == Collections.max(frequency) && found == false){
                    System.out.println("bigram: " + bigramCount.get(j) + "  Count: " + frequency.get(j));
                    frequency.remove(j);
                    bigramCount.remove(j);
                    found = true;
                }
            }
            
        }
    }
    
    
}
