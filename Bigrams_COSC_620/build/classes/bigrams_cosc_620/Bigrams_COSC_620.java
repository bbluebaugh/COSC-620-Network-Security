package bigrams_cosc_620;

/**
 *
 * @author Brian
 * @version 9/1/18
 */
public class Bigrams_COSC_620 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Input file to be used (compilation of the articles)
        Input file = new Input();
        String article = file.getInput();
        //replace any extraneous characters with a space
        //helpful to make sure all the words are correctly worded.
        article = article.replaceAll("[^a-zA-z0-9\\s]", "");
        //uppercase all of the letter to make sure that every set
        //of the two words are the same I.E (For Us) should not be different than (for us)
        article = article.toUpperCase();
        
        BigramSearch bigram = new BigramSearch(article);
        bigram.countBigrams();
    }
    
}
