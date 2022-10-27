import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
Author: Sarthak Patel
*/
public class Urinals {

    public static void main(String[] args) {

    }

    FileReader openFile(String path) throws FileNotFoundException {
        return new FileReader(path);
    }

    String[] readInputStrings(FileReader fileReader) throws IOException {
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

    Boolean isStringValid(String s){
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
