/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigrams_cosc_620;
import java.io.*;
/**
 *
 * @author bbluebaugh
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
