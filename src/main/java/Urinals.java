import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
Author: Sarthak Patel
*/
public class Urinals {

    public static void main(String[] args) {
        System.out.println("1. Provide Input Using Keyboard");
        System.out.println("2. Take Input From File (src/main/java/resources/urinal.dat)");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter Your Choice (1/2): ");
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        userChoice = scanner.next();
        switch (userChoice) {
            case "1":
                System.out.print("\nProvide Input String: ");
                userChoice = scanner.next();
                if (isStringValid(userChoice)) {
                    System.out.println("Available Urinal Spaces: " +
                            countAvailableUrinals(userChoice.strip()));
                } else {
                    System.out.println("Input string is invalid! Please try again.");
                }
                break;
            case "2":
                try {
                    FileReader fileReader = new FileReader("src/main/resources/urinal.dat");
                    String[] inputStrings = readInputStrings(fileReader);
                    System.out.println("\nSpaces\t|\tInput");
                    System.out.println("-----------------------");
                    List<Integer> outputs = new ArrayList<>();
                    for (String input : inputStrings) {
                        int spaceAvailable;
                        if (isStringValid(input)) {
                            spaceAvailable = countAvailableUrinals(input);
                            System.out.println(spaceAvailable + "\t\t|\t" + input);
                        } else {
                            spaceAvailable = -1;
                            System.out.println(spaceAvailable + "\t\t|\t" + input);
                        }
                        outputs.add(spaceAvailable);
                    }
                    int[] outputIntArray = outputs.stream().mapToInt(Integer::intValue).toArray();
                    File file = uniqueFile();
                    writeOutputToFile(file, outputIntArray);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    static FileReader openFile(String path) throws FileNotFoundException {
        return new FileReader(path);
    }

    static String[] readInputStrings(FileReader fileReader) throws IOException {
        List<String> inputs = new ArrayList<>();
        String line = "";
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null){
            if (line.equals("-1") || line.equals("EOF")){
                break;
            }
            inputs.add(line);
        }
        return inputs.toArray(new String[0]);
    }

    static Boolean isStringValid(String s){
        if (s == null || s.isEmpty() || s.isBlank()){
            return false;
        }
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) != '0' && s.charAt(i) != '1'){
                return false;
            }
            if (s.charAt(i) == '1' && s.charAt(i-1) == '1'){
                return false;
            }
        }
        return true;
    }

    static int countAvailableUrinals(String s) {
        int availableUrinals = 0;
        char[] urinals = s.toCharArray();
        if (s.length() == 1 && s.charAt(0) == '0') {
            return 1;
        }
        if (s.length() == 2 && s.charAt(0) == '0' && s.charAt(1) == '0') {
            return 1;
        }
        for (int i = 0; i < s.length(); i++){
            if (i == 0){
                if (urinals[i] == '0' && urinals[i+1] == '0'){
                    urinals[i] = '1';
                    availableUrinals++;
                }
            }
            else if (i == s.length() - 1){
                if (urinals[i-1] == '0' && urinals[i] == '0'){
                    urinals[i] = '1';
                    availableUrinals++;
                }
            }
            else if (urinals[i-1] == '0' && urinals[i] == '0' && urinals[i+1] == '0'){
                urinals[i] = '1';
                availableUrinals++;
            }
        }
        return availableUrinals;
    }

    static public File uniqueFile() throws IOException {
        File dir = new File("src/main/java/");
        File uniqueFile = null;
        int fileIndexSuffix = 0;
        boolean fileCreated = false;
        while (!fileCreated) {
            if (dir != null) {
                uniqueFile = new File(dir, "rule" + fileIndexSuffix + ".txt");
            } else {
                uniqueFile = new File("rule" + fileIndexSuffix + ".txt");
            }
            fileCreated = uniqueFile.createNewFile();
            fileIndexSuffix++;
        }
        return uniqueFile;
    }

    static public void writeOutputToFile(File file, int[] output) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        for (int num: output) {
            fileWriter.write(num + "");
            fileWriter.newLine();
        }
        fileWriter.close();
    }

}
