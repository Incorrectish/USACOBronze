import java.io.*;
import java.util.*;
public class cowsignal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(m + " " + n + " " + k);
        for(int i = 0; i<m; i++) {
            String line = br.readLine();
            System.out.println(line+line.length());
            for(int u = 0; u<k; u++) {
            for(int j = 0; j<n;j++) {
                for(int l = 0; l<k; l++) {
                    out.write(line.charAt(j));
                }
            }
            out.println();
        }
        }
        out.close();
        br.close();
    }
}