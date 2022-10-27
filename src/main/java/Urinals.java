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
            else if (urinals[i-1] == '0' && urinals[i] == '0' && urinals[i+1] == 0){
                urinals[i] = '1';
                availableUrinals++;
            }
        }
        return availableUrinals;
    }

}
