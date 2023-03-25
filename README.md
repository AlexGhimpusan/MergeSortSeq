# MergeSort sequential version

### Details of the project:
Google Docs for the details: https://docs.google.com/document/d/15gRVRgnXWFDvQoWy9gUt4qWQ1tWoIQ2WVy8AB2HwMGY/edit

### FYI:
The "input" file contains on the first line the count of the numbers and on the second line the numbers separated by a space

I used an algorithm to write the file, than to run it for sorting.

### Algorith to generate random numbers to file:

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteRandomNumbersToFile {

    public static void main(String[] args) {
        String fileName = "PATH TO: input";
        int numCount = 350000000; // How many numbers you want to generate

        try {
            FileWriter fileWriter = new FileWriter(fileName);

            // Write the count of numbers on the first line
            fileWriter.write(numCount + "\n");

            // Generate and write the random numbers on the second line
            Random random = new Random();
            for (int i = 0; i < numCount; i++) {
                int randomNumber = random.nextInt(numCount); // Generate a random number between 0 and numCount
                fileWriter.write(randomNumber + " ");
            }
            fileWriter.write("\n");

            fileWriter.close();

            System.out.println("Successfully wrote " + numCount + " random numbers to file " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to file " + fileName);
            e.printStackTrace();
        }
    }
}
