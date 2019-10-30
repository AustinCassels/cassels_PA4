import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class DuplicateRemover {
    private Set<String> uniqueWords = new HashSet<String>();

    public void remove(String dataFile) {
        //declare variables
        FileInputStream data = null;
        Scanner dataStream;

        //attempt to read file
        try {
            //open file
            data = new FileInputStream(dataFile);

            //create scanner of file
            dataStream = new Scanner(data);

            //store unique
            while(dataStream.hasNext()) {
                uniqueWords.add(dataStream.next());
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
            for (String s : uniqueWords) {
                outFS.println(s);
            }

            //close file
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}
