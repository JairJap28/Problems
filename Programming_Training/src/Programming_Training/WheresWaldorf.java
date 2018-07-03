/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Hermanos-Jimenez
 */
public class WheresWaldorf {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    static int max = 100;
    static int n, m;
    static char letters[][] = new char[max][max];
    static int counter = 0;
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        //try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            m = lea.nextInt();
            n = lea.nextInt();

            for (int i = 0; i < m; i++) {
                letters[i] = lea.next().toCharArray();
            }
            int aux1, aux2;
            int k = lea.nextInt();
       
            for (int i = 0; i < k; i++) {
                String in = lea.next();
                node a = location(in);
                aux1 = a.row;
                aux2 = a.column;
                System.out.println(1 + " " + 1);
                counter = 0;
            }
            if(t < cases - 1) System.out.println("");
        }
            
            
        //}
    }
    
    static boolean UpRight(int i, int j, int pos, String word){
        counter = pos;
        while((i - 1) >= 0 && (j + 1) < n && pos < word.length()){
            if(letters[i - 1][j + 1] == Character.toLowerCase(word.charAt(pos)) || letters[i - 1][j + 1] == Character.toUpperCase(word.charAt(pos))) UpRight(i - 1, j + 1, pos + 1, word);
            break;
        }
        return counter == word.length();
    }
    
    static boolean UpLeft(int i, int j, int pos, String word){
        counter = pos;
        while((i - 1) >= 0 && (j - 1) >= 0 && pos < word.length()){
            if(letters[i - 1][j - 1] == Character.toLowerCase(word.charAt(pos)) || letters[i - 1][j - 1] == Character.toUpperCase(word.charAt(pos))) UpLeft(i - 1, j + 1, pos + 1, word);
            break;
        }
        return counter == word.length();
    }
    
    static boolean DownRight(int i, int j, int pos, String word){
        counter = pos;
        while((i + 1) < m && (j + 1) < n && pos < word.length()){
            if(letters[i + 1][j + 1] == Character.toLowerCase(word.charAt(pos)) || letters[i + 1][j + 1] == Character.toUpperCase(word.charAt(pos))) DownRight(i + 1, j + 1, pos + 1, word);
            break;
        }
        return counter == word.length();
    }
    
    static boolean DownLeft(int i, int j, int pos, String word){
        counter = pos;
        while((i + 1) < m && (j - 1) >= 0 && pos < word.length()){
            if(letters[i + 1][j - 1] == Character.toLowerCase(word.charAt(pos)) || letters[i + 1][j - 1] == Character.toUpperCase(word.charAt(pos))) DownLeft(i + 1, j - 1, pos + 1, word);
            break;
        }
        return counter == word.length();
    }
    
    static boolean Up(int i, int j, int pos, String word){
        counter = pos;
        while((i - 1) >= 0 && pos < word.length()){
            if(letters[i - 1][j] == Character.toLowerCase(word.charAt(pos)) || letters[i - 1][j] == Character.toUpperCase(word.charAt(pos))) Up(i - 1, j, pos + 1, word);
            break;
        }
        
        return counter == word.length();
    }
    
    static boolean Down(int i, int j, int pos, String word){
        counter = pos;
        while((i + 1) < m && pos < word.length()){
            if(letters[i + 1][j] == Character.toLowerCase(word.charAt(pos)) || letters[i + 1][j] == Character.toUpperCase(word.charAt(pos))) Down(i + 1, j, pos + 1, word);
            break;
        }
        return counter == word.length();
    }
    
    static boolean Left(int i, int j, int pos, String word){
        counter = pos;
        while((j - 1) >= 0 && pos < word.length()){
            if(letters[i][j - 1] == Character.toLowerCase(word.charAt(pos)) || letters[i][j - 1] == Character.toUpperCase(word.charAt(pos))) Left(i, j - 1, pos + 1, word);
            break;
        }
        return counter == word.length();
    }
    
    static boolean Right(int i, int j, int pos, String word){
        counter = pos;
        while((j + 1) < n && pos < word.length()){
            if(letters[i][j + 1] == Character.toLowerCase(word.charAt(pos)) || letters[i][j + 1] == Character.toUpperCase(word.charAt(pos))) Right(i, j + 1, pos + 1, word);
            j = n;
        }
        return counter == word.length();
    }
    
    static node location(String word){
        
        node a = new node(0,0);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(letters[i][j] == Character.toLowerCase(word.charAt(0)) || letters[i][j] == Character.toUpperCase(word.charAt(0))){
                    if(Up(i, j, 1, word)){
                        a.row = i + 1;
                        a.column = j + 1;
                        return a;
                    }
                    else if(Down(i, j, 1, word)){
                        a.row = i + 1;
                        a.column = j + 1;
                        return a;
                    }
                    else if(Left(i, j, 1, word)){
                        a.row = i + 1;
                        a.column = j + 1;
                        return a;
                    }
                    else if(Right(i, j, 1, word)){
                        a.row = i + 1;
                        a.column = j + 1;
                        return a;
                    }
                    else if(UpRight(i, j, 1, word)){
                        a.row = i + 1;
                        a.column = j + 1;
                        return a;
                    }
                    else if(UpLeft(i, j, 1, word)){
                        a.row = i + 1;
                        a.column = j + 1;
                        return a;
                    }
                    else if(DownRight(i, j, 1, word)){
                        a.row = i + 1;
                        a.column = j + 1;
                        return a;
                    }
                    else if(DownLeft(i, j, 1, word)){
                        a.row = i + 1;
                        a.column = j + 1;
                        return a;
                    }
                }
            }
        }
        return null;
    }
    
    static class node{
        
        int row;
        int column;

        public node(int row, int column) {
            this.row = row;
            this.column = column;
        }
        
    }
}
