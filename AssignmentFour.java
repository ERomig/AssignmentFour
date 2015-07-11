import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Emma Romig
 */

public class AssignmentFour<E>{
    double found = 0;
    double notFound = 0;
 
    public void assignmentFour() {
        MyLinkedList[] dictionaryList = new MyLinkedList[26];

        try {
            FileInputStream inf = new FileInputStream(new File("random_dictionary.txt"));
            char let;
            String word = ""; //word to be processed
            int n = 0;
            while ((n = inf.read()) != -1) {
                let = (char) n;
                if (Character.isLetter(let)) {
                    word += Character.toLowerCase(let);
                }
                if ((Character.isWhitespace(let) || let == '-') && !word.isEmpty()) {
                    if (dictionaryList[word.charAt(0) - 97] == null) {
                        dictionaryList[word.charAt(0) - 97] = new MyLinkedList();
                        dictionaryList[word.charAt(0) - 97].add(word);
                    } else {
                        dictionaryList[word.charAt(0) - 97].add(word);
                    }//else null pointer exception catch
                    word = "";
                }//If
            }//While 

            inf.close();
            
            
            FileInputStream olive = new FileInputStream(new File("oliver.txt"));
            while ((n = olive.read()) != -1) {
                let = (char) n;

                if (Character.isLetter(let)) {
                    word += Character.toLowerCase(let);
                }//if character 

                if ((Character.isWhitespace(let) || let == '-') && !word.isEmpty()) {
                    if (dictionaryList[word.charAt(0) - 97].contains(word)){
                        found++;
                    } else {
                        notFound++;
                    }//else
                    word = "";
                }//If
            }//While 
            olive.close();
        }//Try             
        catch (IOException e) {e.printStackTrace();}
       
        }//bringInDictionary

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AssignmentFour run = new AssignmentFour();

        run.assignmentFour();
        
        System.out.println("Found = " + run.found);
        System.out.println("Not Found = " + run.notFound);
        
               
        double total = run.found + run.notFound;
        System.out.println("Total = " + total);
        
        double comWdFnd =  run.found/total;
        double comWdNtFnd =  run.notFound/total;
        
        System.out.println("Comparisons for words found = " +comWdFnd);
        System.out.println("Comparisons for words not found = "+comWdNtFnd );
        System.out.println("Average comparisons for words found = "+ comWdFnd/run.found);
        System.out.println("Average comparisons for words not found = "+ comWdNtFnd/run.notFound);

    }//Main
    
}//Class
