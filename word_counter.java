import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class word_counter {
    public static void main(String[] args) throws Exception {
        System.out.println("----------------------------------------");
        System.out.println("--                                    --");
        System.out.println("--            WORD COUNTER            --");
        System.out.println("--   to get all your words in a row   --");
        System.out.println("--                                    --");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("Salutations! You are speaking to the greatest computer program ever written, for I can conduct feats far beyond the capabilities of man!");
        System.out.println("Yes, it is true! I, the magnificent WORD COUNTER shall no doubt shock and awe you!");
        System.out.println();
        System.out.println("Simply provide me with the name of a text file of words and I shall count all of the words in it!");

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.print("Enter anything to continue...");
            scan.nextLine();

            System.out.println();
            System.out.println("Enter the name of a text file and I, the great WORD COUNTER, shall count the number of each word in it.");
            System.out.println("Once you have counted words to your heart's content, you may enter '-1' to quit.");
            System.out.println();
            System.out.print("The file I wish to check is: ");
            String fileName = scan.nextLine();
            System.out.println();

            if (fileName.equals("-1")) {
                scan.close();
                break;
            }

            Map<String, Integer> wordCounts = new HashMap<String, Integer>();

            try {
                File readFile = new File(fileName);
                Scanner readFilScanner = new Scanner(readFile);
                while (readFilScanner.hasNextLine()) {
                    String line = readFilScanner.nextLine().toLowerCase();
                    if (wordCounts.containsKey(line)) {
                        wordCounts.put(line, wordCounts.get(line) + 1);
                    } else {
                        wordCounts.put(line, 1);
                    }
                }
                readFilScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File '" + fileName + "' could not be read.");
                System.out.println("Please make sure that the file you inputed exists and is a valid text file.");
                continue;
            }

            try {
                FileWriter fileWriter = new FileWriter("(counted) " + fileName);

                for (String word : wordCounts.keySet()) {
                    System.out.println(word + " " + wordCounts.get(word));
                    fileWriter.write(word + " " + wordCounts.get(word) + "\n");
                }    

                fileWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the output file.");
                continue;
            }

            System.out.println();
            System.out.println("Output file successfully created!");
        }

        System.out.println("Thank you for using the WORD COUNTER!");
    }
}
