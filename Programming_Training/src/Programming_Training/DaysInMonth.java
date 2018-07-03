/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.util.Arrays;
import java.util.Scanner;

public class DaysInMonth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        int cases = lea.nextInt();
        
        for(int k = 0; k < cases; k++){
            int w = lea.nextInt();
            String s = lea.next();
            String out = "";
            switch(s){
                case "mon":
                    out = Arrays.toString(numbers(w, 0)).replaceAll("\\[", "").replaceAll("\\,", "").replaceAll("\\]", "");
                    break;
                case "tues":
                    out = Arrays.toString(numbers(w, 1)).replaceAll("\\[", "").replaceAll("\\,", "").replaceAll("\\]", "");
                    break;
                case "wed":
                    out = Arrays.toString(numbers(w, 2)).replaceAll("\\[", "").replaceAll("\\,", "").replaceAll("\\]", "");
                    break;
                case "thurs":
                    out = Arrays.toString(numbers(w, 3)).replaceAll("\\[", "").replaceAll("\\,", "").replaceAll("\\]", "");
                    break;
                case "fri":
                    out = Arrays.toString(numbers(w, 4)).replaceAll("\\[", "").replaceAll("\\,", "").replaceAll("\\]", "");
                    break;
                case "sat":
                    out = Arrays.toString(numbers(w, 5)).replaceAll("\\[", "").replaceAll("\\,", "").replaceAll("\\]", "");
                    break;
                case "sun":
                    out = Arrays.toString(numbers(w, 6)).replaceAll("\\[", "").replaceAll("\\,", "").replaceAll("\\]", "");
                    break;
            }
            System.out.println(out);                                                                                                                
        }
    }
    
    public static int[] numbers(int days, int start){
        int[] a = new int[7];
        int j = start;
        for(int i = 0; i < days; i++){
            while(i < days && j < 7){
                a[j]++;
                i++;
                j++;
            }
            i--;
            j = 0;
        }
        return a;
    }
}
