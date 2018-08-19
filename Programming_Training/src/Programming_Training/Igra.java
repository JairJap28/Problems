/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class Igra {

    public Igra() throws IOException {
        Scanner sc = new Scanner();
        
        while(sc.hasNext()){
            int n = sc.nextInt();
            String sequence = sc.next();

            StringBuilder mirko = new StringBuilder();
            StringBuilder slavko = new StringBuilder();

            boolean flag = true; //true -> mirko turns

            while(sequence.length() > 0){

                if(flag){
                    mirko.append(sequence.charAt(sequence.length() - 1));
                    sequence = sequence.substring(0, sequence.length() - 1);
                    flag = false;
                }
                else{
                    int pos = getPos(sequence);
                    slavko.append(sequence.charAt(pos));
                    if(pos == 0){
                        sequence = sequence.substring(pos + 1);
                    }
                    else{
                        sequence = sequence.substring(0, pos) + sequence.substring(pos + 1);
                    }
                    flag = true;
                }
            }

            int result = slavko.toString().compareTo(mirko.toString());

            if(result >= 0){
                System.out.println("NE");
                System.out.println(slavko.toString());
            }
            else{
                System.out.println("DA");
                System.out.println(slavko.toString());
            }
        }
        
    }
    
    int getPos(String sequence){
        
        int pos = sequence.length() - 1;
        int valueLeter = Character.getNumericValue(sequence.charAt(sequence.length() - 1));
        
        for(int i = 0; i < sequence.length() - 1; i++){
            int numericValue = Character.getNumericValue(sequence.charAt(i));
            if(numericValue < valueLeter){
                valueLeter = numericValue;
                pos = i;
            }
        }
        
        return pos;
    }
    
    public static void main(String[] args) throws IOException {
        Igra obj = new Igra();
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
        boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null){
                    return false;
                }
                if(line.equals("")){
                    spaces++;
                }
                st = new StringTokenizer(line);
            }
            return true;
        }
        
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
