import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Practical30 
{

    public static void main(String[] args) 
    {
        if (args.length != 2) 
        {
            System.out.println("Usage: java FileCopy <source_file> <destination_file>");
            return;
        }

        String sourceFile = args[0];
        String destinationFile = args[1];

        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(destinationFile)) 
             {

            int currentChar;

            while ((currentChar = reader.read()) != -1) 
            {
                writer.write(currentChar);
            }

            System.out.println("File copied from " + sourceFile + " to " + destinationFile);
        } 
        catch (IOException e) 
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
