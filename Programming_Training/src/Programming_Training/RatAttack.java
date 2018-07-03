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
public class RatAttack {
    
    static int SIZE = 1025;
    static int grid[][] = new int[SIZE][SIZE];
    static int killed[][] = new int[SIZE][SIZE];
    static node aux;
    static int d;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                fill();
                aux = new node(-1, -1, -1);
                d = lea.nextInt();
                int n = lea.nextInt();

                ArrayList<node> coordinates = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    int row = lea.nextInt();
                    int col = lea.nextInt();
                    int population = lea.nextInt();
                    grid[row][col] = population;
                    coordinates.add(new node(row, col, population));
                }

                for (int i = 0; i < coordinates.size(); i++) {
                    calculate(coordinates.get(i));
                }
                so.println(aux.xRow + " " + aux.yCol + " " + aux.population);
            }
        }
    }
    
    
    static void fill(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = 0;
                killed[i][j] = 0;
            }
        }
    }
    
    static class node{
        int xRow;
        int yCol;
        int population;

        public node(int x, int y, int p) {
            this.xRow = x;
            this.yCol = y;
            this.population = p;
        }
    }
    
    static void calculate(node coord){
        for (int i = Math.max(coord.xRow - d, 0); i <= Math.min(coord.xRow + d, SIZE - 1) && i >= 0 && i < SIZE; i++) {
            for (int j = Math.max(coord.yCol - d, 0); j <= Math.min(coord.yCol + d, SIZE - 1) && j >= 0 && j < SIZE; j++) {
                killed[i][j] += coord.population;
                if(killed[i][j] > aux.population){
                    aux = new node(i, j, killed[i][j]);
                }
                else if(killed[i][j] == aux.population && (aux.xRow > i || (aux.xRow == i && aux.yCol > j))){
                    aux = new node(i, j, killed[i][j]);
                }
            }
        }
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int espacios = 0;
        
        public String nextLine() throws IOException{
            if(espacios > 0){
                espacios--;
                return "";
            }
            else if(st.hasMoreElements()){
                StringBuilder salida = new StringBuilder();
                while(st.hasMoreTokens()){
                    salida.append(st.nextToken());
                    if(st.countTokens() > 0){
                        salida.append(" ");
                    }
                }
                return salida.toString();
            }
            return br.readLine();
        }
        
        public String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        public boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String linea = br.readLine();
                if(linea == null){
                    return false;
                }
                if(linea.equals("")){
                    espacios++;
                }
                st = new StringTokenizer(linea);
            }
            return true;
        }
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        
        public long nextLong() throws IOException{
            return Long.parseLong(next());
        }
    }
}
