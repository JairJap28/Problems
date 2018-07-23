/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class LargestEvenNumber {

    public LargestEvenNumber() throws IOException {
        Scanner lea = new Scanner();
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            String numberIn = lea.next();
        
            int biggerNumber = 0;
            int smallerEvenNumber = 10;
            int auxSmaller = 10;

            for (int i = 0; i < numberIn.length(); i++) {
                int aux = Integer.parseInt(numberIn.charAt(i) + "");
                biggerNumber = Math.max(biggerNumber, aux);
                if(aux % 2 == 0 && aux < smallerEvenNumber) smallerEvenNumber = aux;
                auxSmaller = Math.min(auxSmaller, aux);
            }

            int numbers[] = new int[biggerNumber + 1];
            for (int i = 0; i < numberIn.length(); i++) {
                numbers[Integer.parseInt(numberIn.charAt(i) + "")]++;
            }

            for (int i = 1; i < biggerNumber + 1; i++) {
                numbers[i] = numbers[i - 1] + numbers[i];
            }
            

            int out[] = new int[numberIn.length() + 1];

            for (int i = 0; i < numberIn.length(); i++) {
                int aux = Integer.parseInt(numberIn.charAt(i) + "");
                out[numbers[aux]] = aux;
                numbers[aux]--;
            }

            out[0] = -1;

            StringBuilder a = new StringBuilder();

            for (int i = numberIn.length(); i >= 1; i--) {

                try {
                    if(out[i] == smallerEvenNumber && smallerEvenNumber != 10){
                        if(out[i - 1] == smallerEvenNumber) a.append(out[i]);
                    }
                    else if(out[i] == auxSmaller && smallerEvenNumber == 10){
                        if(out[i - 1] == auxSmaller) a.append(out[i]);
                    }
                    else a.append(out[i]);
                } catch (Exception e) {
                }
            }

            if(smallerEvenNumber < 10) a.append(smallerEvenNumber);
            else a.append(auxSmaller);

            System.out.println(a.toString());
        }
        
        
        
        
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new LargestEvenNumber();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
        String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
}
