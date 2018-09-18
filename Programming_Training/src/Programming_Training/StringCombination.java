
package Programming_Training;

import java.util.Map;
import java.util.TreeMap;

public class StringCombination {
    
    void combination(char input[]){
        Map<Character, Integer> countMap = new TreeMap<>();
        //Effective way to count keys
        //This structure sorts it alphabetical
        for(char ch: input){
            countMap.compute(ch, (k, v) -> {
               if(v == null){
                   return 1;
               } 
               else{
                   return v + 1;
               }
            });
        }
        //Contains the letters
        char str[] = new char[countMap.size()];
        //Contains the amount of times each letter appears
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            
            str[index] = key;
            count[index] = value;     
            index++;
        }
        
        char result[] = new char[input.length];
        combinationUtil(str, count, result, 0, 0);
    }
    
    void combinationUtil(char str[], int count[], char rest[], int pos, int len){
        printArray(rest, len);
        for(int i = pos; i < str.length; i++){
            if(count[i] == 0){
                continue;
            }
            rest[len] = str[i];
            count[i]--;
            combinationUtil(str, count, rest, i, len + 1);
            count[i]++;
        }
    }
    
    void printArray(char input[], int len){
        for(int i = 0; i < len; i++){
            System.out.print(input[i]);
        }
        System.out.println("");
    }
    

    public StringCombination() {
        String word = "AABC";
        combination(word.toCharArray());
    }
    
    public static void main(String[] args) {
        new StringCombination();
    }
    
}
