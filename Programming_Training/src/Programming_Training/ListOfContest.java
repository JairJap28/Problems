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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author Hermanos-Jimenez
 */
public class ListOfContest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            int n = lea.nextInt();
            HashMap<String, Integer> list = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String in = lea.nextLine();
                int index = 0;
                int tam = 0;
                for (int j = 0; j < in.length(); j++) {
                    if(Character.isAlphabetic(in.charAt(j))){
                        if(tam == 0) index = j;
                        tam++;
                    }
                    else if(!Character.isAlphabetic(in.charAt(j)) && tam > 0){
                        break;
                    }
                }
                
                String pais = in.substring(index, index + tam);

                if(list.containsKey(pais)){
                    list.put(pais, list.get(pais) + 1);
                }
                else{
                    list.put(pais, 1);
                }
                
            }
            
            Map mapOrdenado = new TreeMap(list);
            Set ref = mapOrdenado.keySet();
            
            Iterator it = ref.iterator();
            while (it.hasNext()) {
                String aux = it.next().toString();
                System.out.println(aux + " " + list.get(aux));
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
