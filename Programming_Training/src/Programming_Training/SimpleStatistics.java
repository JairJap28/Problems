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
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class SimpleStatistics {

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
                int n = lea.nextInt();
                int k = lea.nextInt();

                ArrayList<Integer> numbers = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    int aux = lea.nextInt();
                    numbers.add(aux);
                }

                Collections.sort(numbers); //organiza de menor a mayor

                double sum = 0;
                for (int i = k; i < n - k; i++) {
                    sum += numbers.get(i);
                }

                sum /= n - (2 * k);
                System.out.printf("%.6f\n", sum);
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
