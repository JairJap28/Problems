/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class TheMadNumerologist {
    
    ArrayList<Node> data[] = new ArrayList[10];

    public TheMadNumerologist() throws IOException {
        Scanner lea = new Scanner();
        
        
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                for (int i = 0; i < 10; i++) 
                    data[i] = new ArrayList<>();

                int j = 1;

                for (int i = 'A'; i <= 'Z'; i++) {
                    if(j <= 9){
                        char a = (char) i;
                        data[j].add(new Node(0, a));
                        j++;
                    }
                    if(j > 9) j = 1;
                }

                int n = lea.nextInt();
                ArrayList<Character> consonants = new ArrayList<>();
                ArrayList<Character> vowels = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if(i % 2 == 0){
                        vowels.add(getVowel());
                    }
                    else{
                        consonants.add(getConsonant());
                    }
                }

                Collections.sort(consonants);
                Collections.sort(vowels);

                StringBuilder out = new StringBuilder("");

                for (int i = 0; i < Math.min(consonants.size(), vowels.size()); i++) {
                    out.append(vowels.get(i));
                    out.append(consonants.get(i));
                }

                if(n % 2 == 1) out.append(vowels.get(vowels.size() - 1));

                so.println("Case " + (t + 1) + ": " + out.toString());
            }
        }
        
        
    }
    
    char getVowel(){
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < data[i].size(); j++) {
                if(data[i].get(j).can < 21 && isVowel(i, j)){
                    data[i].get(j).can =  data[i].get(j).can + 1;
                    return data[i].get(j).val;
                }
            }
        }
        return ' ';
    }
    
    char getConsonant(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < data[i].size(); j++) {
                if(data[i].get(j).can < 5 && !isVowel(i, j)){
                    data[i].get(j).can =  data[i].get(j).can + 1;
                    return data[i].get(j).val;
                }
            }
        }
        
        return ' ';
    }
    
    boolean isVowel(int i, int j){
        return (data[i].get(j).val == 'A' || data[i].get(j).val == 'E' || data[i].get(j).val == 'I' || data[i].get(j).val == 'O' || data[i].get(j).val == 'U');
    }
    
    class Node{
        int can;
        char val;

        public Node(int can, char val) {
            this.can = can;
            this.val = val;
        }    
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
        public String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new TheMadNumerologist();
    }
    
}
