import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Practical27 {

    public static void main(String[] args) {
        if (args.length == 0) 
        {
            System.out.println("No files specified.");
            return;
        }

        for (String filename : args) 
        {
            int lineCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
            {
                while (reader.readLine() != null) 
                {
                    lineCount++;
                }
                System.out.println(filename + ": " + lineCount + " lines");
            } 
            catch (IOException e) 
            {
                System.err.println("Error reading file " + filename + ": " + e.getMessage());
            }
        }
    }
}
