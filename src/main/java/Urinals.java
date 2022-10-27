/**
Author: Sarthak Patel
*/
public class Urinals {

    public static void main(String[] args) {

    }

    Boolean isStringValid(String s){
        if (s == null || s.isEmpty() || s.isBlank()){
            return false;
        }
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == '1' && s.charAt(i-1) == '1'){
                return false;
            }
        }
        return true;
    }

    int countAvailableUrinals(String s) {
        int availableUrinals = 0;
        if (s.length() == 1 && s.charAt(0) == '0') {
            availableUrinals++;
        }
        if (s.length() == 2 && s.charAt(0) == '0' && s.charAt(1) == '0') {
            availableUrinals++;
        }
        return availableUrinals;
    }

}
