package bigrams_cosc_620;

/**import array & array list for storing information, I originally intended to use the 
*singly linked list but time did not allow for finishing the implementation which is why
* it is still left in, may go back in the future to fix.
*/
import java.util.*;
import java.util.Collections;

/**
 *The algorithm portion of searching for bigrams
 * 
 * @author Brian
 */
public class BigramSearch {
    //whole article will house the majority of the article to be split
    String wholeArticle;
    //array list which will split the different information for storing
    String[] splitArticle;
    //list of String array type to hold a list of arrays basically
    List<String[]> listOfStrings = new ArrayList<>();
    //this will contain the whole article in an array for
    //manipulating the bigrams
    String[] wholeList;
    //Making an arraylist of type String array
    //This will hold the count for the amount of times
    //a bigram shows up in the document
    List<String[]> countBigram = new ArrayList<>();
    
    //constructor for what the method will take and give out
    public BigramSearch(String string){
        wholeArticle = string;
    }
    
    //splitting the whole text document to be easily readable
    public void articleSplit(){
        splitArticle = wholeArticle.split("\\s+");
    }
    
    //Making a matrix(2 dimensional array) to hold bigrams
    public void matrix(){
        //call the method above to split the file to be readable
        //this allows it to be stored readable instead of plain
        //text
        articleSplit();
        
        //inputing bigrams into the split arraylist
        for(int i = 0; i < splitArticle.length - 1; i++){
            listOfStrings.add(new String[]{splitArticle[i], splitArticle[i + 1]});
        }
    }
    
    //method for the counting part of the search
    public void countBigrams(){
        //call the matrix method to initialize the array to be looked at
        matrix();
        //new list to store for temporary use when comparing
        //which is why it is the size of the other arraylist
        wholeList = new String[listOfStrings.size()];
        
        //incrementing through originally created list to add bigrams and count
        //Using k so I know which for loop I am looking at
        for(int k = 0; k < listOfStrings.size(); k++){
            wholeList[k] = listOfStrings.get(k)[0] + " " + listOfStrings.get(k)[1];
        }
        
        //incrementing through the second created list that was updated above
        //this will allow for looking for previously made bigrams so we can
        //increase the count and determine which are used most how often
        //I like to use differently named local variables to keep is straight
        //which are used in which part to better determine which if any
        //has a problem
        for(int j = 0; j < wholeList.length; j++){
            //looking at the current bigram in the list for saving
            String currentBigram = wholeList[j];
            if(countBigram.size() == 0){
                //if there is nothing in the bigram count list
                //add the current bigram into it
                countBigram.add(new String[]{currentBigram, "1"});
            }
            else{
                //boolean value to determine if there is a match
                boolean bingo = false;
                for(int l = 0; l < countBigram.size(); l++){
                    //if the current bigram equals something in the whole list
                    //add this to a temp variable for holding to increment the count later
                    //holding array is an array for holding things temporarily so we can individually
                    //increase the count of the bigrams
                    if(currentBigram.equals(countBigram.get(l)[0])){
                        String temp = countBigram.get(l)[1];
                        int tempCount = Integer.parseInt(temp);
                        tempCount++;
                        temp = tempCount + "";
                        String[] holdingArray = new String[2];
                        holdingArray[0] = currentBigram;
                        holdingArray[1] = temp;
                        countBigram.set(l, holdingArray);
                        bingo = true;
                    }
                }
                //if bingo = false then we must not have a matching bigram so we must add a new
                //entry into the list to store this bigram so we can check it later
                if(bingo == false){
                    countBigram.add(new String[]{currentBigram, "1"});
                }
            }
        }
        //Now that we have found them all we need to sort them in ascending order
        //so that we can print out the top 20
        Collections.sort(countBigram, new Comparator<String[]>(){
            @Override
            public int compare(String[] strings, String[] unsortedStrings){
                return Integer.valueOf(strings[1]).compareTo(Integer.valueOf(unsortedStrings[1]));
            }
        });
        String format = "%-40s%s%n";
        System.out.printf(format, "bigram", "|    count");
        System.out.println("-------------------------------------------------");
        for(int m = countBigram.size() - 1; m > countBigram.size() - 21; m--){
            String bigram = countBigram.get(m)[0];
            String count = "|     " + countBigram.get(m)[1];
            System.out.printf(format, bigram, count);
        }
    }
}
