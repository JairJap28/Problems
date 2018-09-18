
package Programming_Training;

import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {

    void permute(char input[]){
        Map<Character, Integer> countMap = new TreeMap<>();
        //Effective way to count keys
        for(char ch: input){
            countMap.compute(ch, (key, val) ->{
               if(val == null){
                   return 1;
               } 
               else{
                   return val + 1;
               }
            });
        }
        
        char str[] = new char[countMap.size()]; 
        //Contains the letters
        int count[] = new int[countMap.size()]; 
        //Contains the amount of times each letter appears
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            str[index] = key;
            count[index] = value;
            index++;
        }
        //To store the result
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0);
    }
    
    
    void permuteUtil(char str[], int count[], char result[], int level){
        if(level == result.length){
            printArray(result);
            return;
        }
        //Go throught the letters to find the next letter with
        //value greater than zero
        for(int i = 0; i < str.length; i++){
            if(count[i] == 0){
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1);
            //Add 1 to return to the previous value
            count[i]++;
        }
    }
    
    void printArray(char result[]){
        for(char ch: result){
            System.out.print(ch);
        }
        System.out.println("");
    }
    
    public StringPermutation() {
        String word = "Leonardo";
        permute(word.toCharArray());
    }
    
    public static void main(String[] args) {
        new StringPermutation();
    }
    
}
