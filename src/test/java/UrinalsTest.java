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



}