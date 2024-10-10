import java.io.*;

public class Practical31 
{

    public static void main(String[] args) 
    {
        if (args.length != 1) 
        {
            System.out.println("Usage: java StreamExample <output_file>");
            return;
        }

        String outputFileName = args[0];

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFileName))) 
             {

            System.out.println("Enter text (type 'exit' to finish):");

            String line;
            while (!(line = consoleReader.readLine()).equalsIgnoreCase("exit")) 
            {
                fileWriter.write(line);
                fileWriter.newLine(); 
            }

            System.out.println("Text written to " + outputFileName);

        } 
        catch (IOException e) 
        {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Reading from the output file using byte stream:");

        try (FileInputStream fileInputStream = new FileInputStream(outputFileName);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) 
             {

            int currentByte;
            while ((currentByte = bufferedInputStream.read()) != -1) 
            {
                System.out.print((char) currentByte); 
            }
            System.out.println(); 

        } 
        catch (IOException e) 
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
