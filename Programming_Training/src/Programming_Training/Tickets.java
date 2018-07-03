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
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class Tickets {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {

            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                String in = lea.next();
                char x = in.charAt(0);
                char y = in.charAt(1);

                boolean flag = false;
                int counter = 0;

                if (x != y) {
                    counter = 2;
                    for (int i = 2; i < in.length(); i++) {
                        if (in.charAt(i) == x && !flag) {
                            flag = true;
                            counter++;
                        } else if (in.charAt(i) == y && flag) {
                            flag = false;
                            counter++;
                        } else {
                            break;
                        }
                    }
                }

                if (counter == in.length()) {
                    so.println("YES");
                } else {
                    so.println("NO");
                }
            }

        }
    }

    static class Scanner {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

}
