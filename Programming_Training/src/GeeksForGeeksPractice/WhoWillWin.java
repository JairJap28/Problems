package GeeksForGeeksPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhoWillWin {
    
    int binarySearch(int low, int hight, int t, int data[], int store[]){
        store[0]++;
        int middle = (low + hight) / 2;
        if(data[middle] == t){
            return middle;
        }
        if(data[middle] > t){
            return binarySearch(low, middle - 1, t, data, store);
        }
        else{
            return binarySearch(middle + 1, hight, t, data, store);
        }  
    }
    
    int simpleSearch(int t, int data[], int store[]){
        for(int i = 0; i < data.length; i++){
            store[1]++;
            if(data[i] == t){
                return i;
            }
        }
        return -1;
    }
    

    public WhoWillWin() throws IOException {
        Scanner sc = new Scanner();
        
        int cases = sc.nextInt();
        for(int c = 0; c < cases; c++){
            int n = sc.nextInt();
        
            int data[] = new int[n];
            int store[] = new int[2];

            for(int i = 0; i < n; i++){
                data[i] = i + 1;
            }

            int position = sc.nextInt(); //this is m, in the original problem
            int g = sc.nextInt();
            int s = sc.nextInt();

            int firstGuest = simpleSearch(position, data, store);
            int secondGuest = binarySearch(0, n - 1, position, data, store);


            if(s * store[0] < g * store[1]){
                System.out.println("2");
            }
            else if(s * store[0] == g * store[1]){
                System.out.println("0");
            }
            else{
                System.out.println("1");
            }
        }
        
        
        
    }
    
    public static void main(String[] args) throws IOException {
        WhoWillWin obj = new WhoWillWin();
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
        
        String next() throws IOException{
            spaces = 0;
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
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
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
}
