import java.io.*;
import java.util.*;

public class gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] rankings = new String[k];
        for(int i = 0; i<k; i++) {
            rankings[i] = br.readLine();
        }
        int counter = 0;
        for(int i =0; i<n;i++ ) {
            for(int j = 0; j<n; j++) {
                int counter1 = 0;
                for(int l = 0; l<k; l++) {
                    String[] v = rankings[l].split(" ");
                    int[]u = new int[v.length];
                    for(int m = 0; m<v.length; m++) {
                        u[m] = Integer.parseInt(v[m]);
                    }
                    if(search(u, (i+1))>search(u, (j+1))) {
                        counter1++;
                    }
                }
                if(counter1 == k) {
                    counter++;
                }
            }
        }
        out.println(counter);
        out.close();
        br.close();
    }
    public static int search(int[] array, int value) {
        for(int i = 0; i<array.length; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}