/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class PrintLinkedListElements {
    
    Node head;
    
    void addToTheLast(Node node){
        if(head == null){
            head = node;
        }
        else{
            Node tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
    
    void printList(Node head){
        
        Node tmp = head;
        
        while(tmp.next != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println(tmp.data);
    }

    public PrintLinkedListElements() throws IOException {
        Scanner lea = new Scanner();
        
        int t = lea.nextInt();
        for (int cases = 0; cases < t; cases++) {
            int n = lea.nextInt();
        
            Node node = null;

            for (int i = 0; i < n; i++) {
                int aux = lea.nextInt();
                node = new Node(aux);
                addToTheLast(node);
            }

            printList(head);
            head = null;
        }
    }
    
    

    public static void main(String[] args) throws IOException {
        new PrintLinkedListElements();        
    }
    
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;
        
        String nextLine() throws IOException{
            if(spaces > 0){
                spaces--;
                return "";
            }
            else if(st.hasMoreTokens()){
                StringBuilder out = new StringBuilder();
                while(st.hasMoreTokens()){
                    out.append(st.nextToken());
                    if(st.countTokens() > 0){
                        out.append(" ");
                    }
                }
                return out.toString();
            }
            return br.readLine();
        }
        
        boolean hasNext() throws IOException{
            while(!st.hasMoreTokens()){
                String line = br.readLine();
                if(line == null) return false;
                if(line.equals("")) spaces++;
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

class Node {

    Node next;
    int data;

    public Node(int d) {
        this.next = null;
        this.data = d;
    }
}
