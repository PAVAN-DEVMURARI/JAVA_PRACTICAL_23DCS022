import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Practical29 
{

    public static void main(String[] args) 
    {
        // Check if the correct number of arguments is provided
        if (args.length != 2) 
        {
            System.out.println("Usage: java WordSearch <filename> <word>");
            return;
        }

        String filename = args[0];
        String wordToSearch = args[1];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] words = line.split("\\W+");
                for (String word : words) 
                {
                    Integer wordLength = Integer.valueOf(word.length());
                    if (word.equalsIgnoreCase(wordToSearch)) 
                    {
                        count++;
                        System.out.println("Found '" + wordToSearch + "' in line with word length: " + wordLength);
                    }
                }
            }
            System.out.println("The word '" + wordToSearch + "' appears " + count + " times in " + filename);
        } 
        catch (IOException e) 
        {
            System.err.println("Error reading file " + filename + ": " + e.getMessage());
        }
    }
}
