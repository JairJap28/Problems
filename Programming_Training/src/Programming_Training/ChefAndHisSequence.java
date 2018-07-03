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
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class ChefAndHisSequence {
    public static void main(String[] args) throws IOException {
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int t = lea.nextInt();
            for (int x = 0; x < t; x++) {
                int n = lea.nextInt();
                //StringBuilder s1 = new StringBuilder();
                String s1 = "";
                for (int i = 0; i < n; i++) {
                    s1 += lea.nextInt() + " ";
                    //s1.append(lea.nextInt());
                    //s1.append(" ");
                }

                n = lea.nextInt();
                //StringBuilder s2 = new StringBuilder();
                String s2 = "";
                for (int i = 0; i < n; i++) {
                    s2 += lea.nextInt() + " ";
                    //s2.append(lea.nextInt());
                    //s2.append(" ");
                }
                so.println(s1.contains(s2) ? "Yes" : "No");
                //so.println(kmp(s1.toString(), s2.toString()) ? "Yes" : "No");
            }
        }
    }
    
    static ArrayList<Integer> table(String pattern){
        int m = pattern.length();
        ArrayList<Integer> border = new ArrayList<>();
        border.add(0);
        int temp;
        for (int i = 1; i < m; i++) {
            border.add(border.get(i - 1));
            temp = border.get(i);
            while(temp > 0 && pattern.charAt(i) != pattern.charAt(temp)){
                if(temp <= i + 1){
                    border.set(i, border.get(temp - 1));
                    temp =  border.get(i);
                }
            }
            if(pattern.charAt(i) == pattern.charAt(temp)){
                border.set(i, temp + 1);
            }
        }
        return border;
    }
    
    static boolean kmp(String cadena, String pattern){
        int n = cadena.length();
        int m = pattern.length();
        ArrayList<Integer> tab = table(pattern);
        int seen = 0;
        
        for (int i = 0; i < n; i++) {
            while(seen > 0 && cadena.charAt(i) != pattern.charAt(seen)){
                seen = tab.get(seen - 1);
            }
            if(cadena.charAt(i) == pattern.charAt(seen)) seen++;
            if(seen == m){
                return true;
            }
        }
        return false;
    }
    
    static class Scanner{
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
}
