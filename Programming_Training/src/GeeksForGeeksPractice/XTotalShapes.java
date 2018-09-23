/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeeksForGeeksPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class XTotalShapes {

    int MAX = 1001;
    boolean visited[][];
    char matrix[][];
    int dx[] = {0,0, 1, -1};
    int dy[] = {1, -1, 0, 0};
    int counter;
    
    void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(matrix[x][y], x, y));
        boolean flag = true;
        while(!q.isEmpty()){
            Node c = q.poll();
            visited[c.x][c.y] = true;
            if(c.val == 'X'){
                
                if(flag){
                    counter++;
                    flag = false;
                }
                
                for(int i = 0; i < 4; i++){
                    int nx = dx[i] + c.x;
                    int ny = dy[i] + c.y;
                    
                    try{
                        if(!visited[nx][ny] && matrix[nx][ny] == 'X'){
                            q.add(new Node(matrix[nx][ny], nx, ny));
                        }
                        else if(!visited[nx][ny] && matrix[nx][ny] == 'O'){
                            visited[nx][ny] = true;
                        }
                    }catch(Exception e){
                        
                    }
                }
            }
        }  
    }
    
    
    public XTotalShapes() throws IOException {
        Scanner sc = new Scanner();
        
        int t = sc.nextInt();
        for(int cases = 0; cases < t; cases++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            matrix = new char[n][m];
            visited = new boolean[n][m];
            counter = 0;

            String in[] = sc.nextLine().split(" ");
            for(int i = 0; i < n; i++){
                matrix[i] = in[i].toCharArray();
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!visited[i][j]){
                        bfs(i, j);
                    }
                }
            }
            System.out.println(counter);
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        new XTotalShapes();
    }
    
    class Node{
        char val;
        int x;
        int y;

        public Node(char val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        int spaces;
        
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
        
        String next() throws IOException{
            spaces = 0;
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
