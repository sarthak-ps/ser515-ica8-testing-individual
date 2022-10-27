import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    Urinals urinals = new Urinals();

    @Test
    void isStringValid() {
        String invalidString = "010011000";
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST ONE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void isEmptyStringValid() {
        String invalidString = "";
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST TWO EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void isBlankStringValid() {
        String invalidString = "        ";
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST THREE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void isNullStringValid() {
        String invalidString = null;
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST FOUR EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void stringContainsValidCharsOnly(){
        String invalidString = "00100x";
        assertEquals(false, urinals.isStringValid(invalidString));
        System.out.println("==== Sarthak Patel == TEST ELEVEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void zeroOutOfOneUrinalAvailable() {
        String givenOccupancyState = "1";
        assertEquals(0, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST FIVE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void oneOutOfOneUrinalAvailable() {
        String givenOccupancyState = "0";
        assertEquals(1, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST SIX EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void oneOutOfTwoUrinalAvailable() {
        String givenOccupancyState = "00";
        assertEquals(1, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST SEVEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void zeroOutOfTwoUrinalAvailable() {
        String givenOccupancyState = "01";
        assertEquals(0, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST EIGHT EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void longSequenceUrinalAvailable() {
        String givenOccupancyState = "00010100";
        assertEquals(2, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST NINE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void longSequenceUrinalUnavailable() {
        String givenOccupancyState = "1001010100101";
        assertEquals(0, urinals.countAvailableUrinals(givenOccupancyState));
        System.out.println("==== Sarthak Patel == TEST TEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void fileDoesNotExist(){
        String pathToFile = "";
        assertThrows(FileNotFoundException.class, () -> {
            urinals.openFile(pathToFile);
        });
        System.out.println("==== Sarthak Patel == TEST TWELVE EXECUTED SUCCESSFULLY ====");
    }

    @Test
    void fileOpensSuccessfully(){
        String pathToFile = "src/main/java/input.txt";
        assertDoesNotThrow(() -> {
            urinals.openFile(pathToFile);
        });
        System.out.println("==== Sarthak Patel == TEST THIRTEEN EXECUTED SUCCESSFULLY ====");
    }

    @Test
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

}