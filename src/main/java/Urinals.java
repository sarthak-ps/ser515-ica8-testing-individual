/**
Author: Sarthak Patel
*/
public class Urinals {

    public static void main(String[] args) {

    }

    Boolean isStringValid(String s){
        if (s.isEmpty() || s.isBlank()){
            return false;
        }
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == '1' && s.charAt(i-1) == '1'){
                return false;
            }
        }
        return true;
    }

}
