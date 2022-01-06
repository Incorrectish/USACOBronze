import java.io.*;
import java.util.*;
public class diamonds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[n];
        for (int i = 0; i < n; i++) {
            diamonds[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        for(int i = 0; i<n;i++) {
            int counter = 0;
            for(int j = 0; j<n;j++) {
                if(diamonds[j]-diamonds[i]<=k && diamonds[j]>=diamonds[i]) {/*second condition 
                    is just in case of negatives, to make sure that the reason [j]-[i] is 
                    less than k is not because it is a negative value*/
                    counter++;
                }
            }
            max = Math.max(max, counter);
        }
        out.println(max);
        out.close();
        br.close();
    }
}