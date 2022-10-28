import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    Urinals urinals = new Urinals();

    @Test
    @DisplayName("Input String Two Consecutive Urinals Occupied")
    void isStringValid() {
        String invalidString = "010011000";
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST ONE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("Input String Is Empty")
    void isEmptyStringValid() {
        String invalidString = "";
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST TWO EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("Input String Contains Only Whitespace")
    void isBlankStringValid() {
        String invalidString = "        ";
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST THREE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("Input String Is Null")
    void isNullStringValid() {
        String invalidString = null;
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST FOUR EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("Input String Contains Characters Other Than 0/1")
    void stringContainsValidCharsOnly(){
        String invalidString = "00100x";
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST ELEVEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("0/1 Urinal Available")
    void zeroOutOfOneUrinalAvailable() {
        String givenOccupancyState = "1";
        assertEquals(0, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST FIVE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("1/1 Urinal Available")
    void oneOutOfOneUrinalAvailable() {
        String givenOccupancyState = "0";
        assertEquals(1, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST SIX EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("1/2 Urinal Available")
    void oneOutOfTwoUrinalAvailable() {
        String givenOccupancyState = "00";
        assertEquals(1, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST SEVEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("0/2 Urinal Available")
    void zeroOutOfTwoUrinalAvailable() {
        String givenOccupancyState = "01";
        assertEquals(0, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST EIGHT EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("Long Input String Urinal Available")
    void longSequenceUrinalAvailable() {
        String givenOccupancyState = "00010100";
        assertEquals(2, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST NINE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("Long Input String Urinal Unavailable")
    void longSequenceUrinalUnavailable() {
        String givenOccupancyState = "1001010100101";
        assertEquals(0, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST TEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("File To Read Not Found")
    void fileDoesNotExist(){
        String pathToFile = "";
        assertThrows(FileNotFoundException.class, () -> {
            urinals.openFile(pathToFile);
        });
        System.out.println("==== Sarthak Patel == TEST TWELVE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("File Opened Successfully")
    void fileOpensSuccessfully(){
        String pathToFile = "src/main/resources/urinal.dat";
        assertDoesNotThrow(() -> {
            urinals.openFile(pathToFile);
        });
        System.out.println("==== Sarthak Patel == TEST THIRTEEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("File Ends With -1")
    void fileEndNegativeOne(){
        String pathToFile = "src/main/java/TestInput1.txt";
        FileReader fileReader = null;
        try { fileReader = urinals.openFile(pathToFile); }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        try {
            assertArrayEquals(new String[] {"1001010", "001010101"}, urinals.readInputStrings(fileReader));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("==== Sarthak Patel == TEST FOURTEEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("File Ends With Explicit EOF Token")
    void fileEndWithExplicitEOF(){
        String pathToFile = "src/main/java/TestInput2.txt";
        FileReader fileReader = null;
        try { fileReader = urinals.openFile(pathToFile); }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        try {
            assertArrayEquals(new String[] {"1001010", "001010101"}, urinals.readInputStrings(fileReader));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("==== Sarthak Patel == TEST FIFTEEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("File Ends With Implicit EOF Token")
    void fileEndWithImplicitEOF(){
        String pathToFile = "src/main/java/TestInput3.txt";
        FileReader fileReader = null;
        try { fileReader = urinals.openFile(pathToFile); }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        try {
            assertArrayEquals(new String[] {"1001010", "001010101"}, urinals.readInputStrings(fileReader));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("==== Sarthak Patel == TEST SIXTEEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    @DisplayName("Create Unique Rule File")
    void createUniqueOutputFile(){
        List<String> fileNames = Stream.of(new File("src/main/java/").listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());
        int greatestSuffix = 0;
        boolean ruleAlreadyExists = false;
        for (String fileName: fileNames) {
            if (fileName.length() >= 4 && fileName.substring(0, 3).equals("rule")){
                int index = getSuffixIndex(fileName);
                greatestSuffix = Math.max(index, greatestSuffix);
                ruleAlreadyExists = true;
            }
        }
        try {
            File file = urinals.uniqueFile();
            int index = getSuffixIndex(file.getName());
            if (ruleAlreadyExists){
                assertEquals(index, greatestSuffix + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("==== Sarthak Patel == TEST SEVENTEEN EXECUTED SUCCESSFULLY ====");
    }

    private int getSuffixIndex(String fileName){
        return Integer.parseInt(fileName.substring(4, fileName.indexOf('.')));
    }

    @Test
    @DisplayName("Write Output To File")
    void writeOutputToFile(){
        List<Integer> output = new ArrayList<Integer>(Arrays.asList(0, 2, -1, 3, 4, 0));
        File file = new File("src/main/resources/used_for_junit_test.txt");
        try {
            int[] outputIntArray = output.stream()
                                        .mapToInt(Integer::intValue)
                                        .toArray();
            urinals.writeOutputToFile(file, outputIntArray);
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line = null;
            List<Integer> list = new ArrayList<>();
            while ((line = fileReader.readLine()) != null){
                list.add(Integer.parseInt(line));
            }
            assertArrayEquals(outputIntArray, list.stream().mapToInt(Integer::intValue).toArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("==== Sarthak Patel == TEST EIGHTEEN EXECUTED SUCCESSFULLY ====");
    }

}