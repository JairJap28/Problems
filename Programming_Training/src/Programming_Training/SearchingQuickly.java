/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SearchingQuickly {
    
    ArrayList<String> ignoreWords = new ArrayList<>();
    ArrayList<Pair> titles = new ArrayList<>();
        
    Set<String> key = new HashSet<>();
    ArrayList<Node> out = new ArrayList<>();

    public SearchingQuickly() throws IOException {
        BufferedReader lea = new BufferedReader(new InputStreamReader(System.in));
        
        String in = lea.readLine();
        
        while(!in.equals("::")){
            ignoreWords.add(in);
            in = lea.readLine();
        }
        
        int t = 0;
        while(lea.ready()){
            in = lea.readLine();
            titles.add(new Pair(in, t));
            t++;
        }
        
        for (int i = 0; i < titles.size(); i++) {
            search(titles.get(i).in.toLowerCase());
        }
        
        for (int i = 0; i < titles.size(); i++) {
            replace(titles.get(i).in.toLowerCase(), titles.get(i).index);
        }
        
        Collections.sort(out);
        
        for (int i = 0; i < out.size(); i++) {
            System.out.println(out.get(i).sentence);
        }
        
    }
    
    void search(String word){
        
        ArrayList<String> aux = new ArrayList<>();
        int pos = 0;
        String ap = "";
        while (pos < word.length()) {
            if(Character.isAlphabetic(word.charAt(pos))) ap += word.charAt(pos);
            else
                if(!ap.isEmpty()){
                    aux.add(ap);
                    ap = "";
                }
            pos++;
        }
        
        if (!ap.isEmpty()) {
            aux.add(ap);
            ap = "";
        }
        
        for (int i = 0; i < ignoreWords.size(); i++) {
            
            for (int j = 0; j < aux.size(); j++) {
                if(aux.get(j).equals(ignoreWords.get(i)) && !aux.get(j).equals("")) aux.remove(j);
            }
        }
        
        for(String a: aux)
            key.add(a);
    }
    
    void replace(String word, int index){
        
        for(String keyValue: key){
            ArrayList<Integer> positions = check(keyValue, word, index);
            while(!positions.isEmpty()){
                out.add(new Node(keyValue.toUpperCase(), word.substring(0, positions.get(0)) + keyValue.toUpperCase() + word.substring(positions.get(0) + keyValue.length()), index));
                positions.remove(0);
            }
        }
        
    }
    
    ArrayList<Integer> check(String keyValue, String word, int index){
        
        ArrayList<Integer> positions = new ArrayList<>();
        
        StringBuilder a = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        int pos = 0;

        boolean flag = false;
        String change = "";

        while (pos < word.length()) {
            if (Character.isAlphabetic(word.charAt(pos))) {
                a.append(word.charAt(pos));
            }
            else if(a.length() > 0){
                if(a.toString().equals(keyValue)){
                    if(flag){
                        positions.add(pos - keyValue.length());
                        sentence.append(a);
                    }
                    else{
                        sentence.append(keyValue.toUpperCase());
                        change = keyValue.toUpperCase();
                    }
                    
                    flag = true;
                    sentence.append(word.charAt(pos));
                }
                else{
                    sentence.append(a);
                    sentence.append(word.charAt(pos));
                }
                a.setLength(0);
            }
            else sentence.append(word.charAt(pos));
            pos++;
        }
        
        if (a.length() > 0) {
            if (a.toString().equals(keyValue)) {
                if (flag) {
                    positions.add(pos - keyValue.length());
                    sentence.append(a);
                } else {
                    sentence.append(keyValue.toUpperCase());
                    change = keyValue.toUpperCase();
                }

                flag = true;
            } 
            else {
                sentence.append(a);
            }
        }
        
        if (flag) {
            out.add(new Node(change, sentence.toString(), index));
        }
        
        
        return positions;
    }
    
    class Node implements Comparable<Node>{
        String word;
        String sentence;
        int index;

        public Node(String word, String sentence, int index) {
            this.word = word;
            this.sentence = sentence;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            
            if(this.word.compareTo(o.word) == 0){
                return (this.index < o.index) ? -1 : 1;
            }
            
            return this.word.compareTo(o.word);
        }
    }
    
    class Pair{
        String in;
        int index;

        public Pair(String in, int index) {
            this.in = in;
            this.index = index;
        }        
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new SearchingQuickly();
    }
    
}
