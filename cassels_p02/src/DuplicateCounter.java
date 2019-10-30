import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class DuplicateCounter {
    private Map<String, String> wordCounter = new HashMap<String, String>();

    public void count(String dataFile) {
        //declare variables
        FileInputStream data = null;
        Scanner dataStream;
        String word;
        int count;

        //attempt to read file
        try {
            //open file
            data = new FileInputStream(dataFile);

            //create scanner of file
            dataStream = new Scanner(data);

            //store and count unique
            while(dataStream.hasNext()) {
                //store current entry
                word = dataStream.next();

                //check if already stored
                if (wordCounter.containsKey(word))
                    //increment count
                    count = Integer.parseInt(wordCounter.get(word)) + 1;
                else
                    //start counting
                    count = 1;

                //store key and value
                wordCounter.put(word, Integer.toString(count));
            }

            //close file
            data.close();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    public void write(String outputFile) {
        //declare variables
        FileOutputStream outputStream = null;
        PrintWriter outFS = null;

        //attempt to write file
        try {
            outputStream = new FileOutputStream(outputFile, false); //creates file if it does not exist
            outFS = new PrintWriter(outputStream, true);

            //print unique words to file
            for (String s : wordCounter.keySet()) {
                outFS.printf("%s: %s\n", s, wordCounter.get(s));
            }

            //close file
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}
