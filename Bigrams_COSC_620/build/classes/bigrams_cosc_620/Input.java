package bigrams_cosc_620;

//import the java IO package for getting the file
import java.io.*;
/**
 *This class is a helper class, based on similar classes used in the past
 * to help get input from a file
 * 
 * @author Brian
 * @param file used to store the name of the file so I can use a relative path
 * for the file instead of hard coding a static path
 */
public class Input {
    public String getInput() throws Exception{
        File file = new File("Security_in_computing.txt");
        String articleInfo = "";
        
        //Buffered reader used in conjuction with file reader to read the file in
        //the variable "file"
        //@param read, holding the file to be read
        BufferedReader read = new BufferedReader(new FileReader(file));
        //initialize variable text as null for use with the while loop
        //while text is not null read the article file
        String text = null;
        while((text = read.readLine()) != null){
            articleInfo = articleInfo + text;
        }
        return articleInfo;
    }
}
