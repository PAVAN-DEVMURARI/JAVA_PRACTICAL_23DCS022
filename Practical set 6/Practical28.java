import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Practical28 {

    public static void main(String[] args) 
    {
        if (args.length != 2) 
        {
            System.out.println("Usage: java CharacterCount <filename> <character>");
            return;
        }

        String filename = args[0];
        char characterToCount = args[1].charAt(0);
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            int currentChar;
            while ((currentChar = reader.read()) != -1) 
            {
                if (currentChar == characterToCount) 
                {
                    count++;
                }
            }
            System.out.println("The character '" + characterToCount + "' appears " + count + " times in " + filename);
        } 
        catch (IOException e) 
        {
            System.err.println("Error reading file " + filename + ": " + e.getMessage());
        }
    }
}
