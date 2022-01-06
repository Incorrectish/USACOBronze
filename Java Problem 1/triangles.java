import java.io.*;
import java.util.*;

public class triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int maxArea = 0;
    for(int i = 0; i< n; i++) {
        for(int j = i+1; j<n;j++) {
            for(int k = j+1; k<n;k++) {
                if(x[i]==x[j] || x[i]==x[k] || x[j]==x[k]) {
                    if(y[i]==y[j] || y[i]==y[k] || y[j]==y[k]) {
                        maxArea = Math.max(maxArea, Math.abs(x[i]*(y[j]-y[k]) + x[j]*(y[k]-y[i]) + x[k]*(y[i]-y[j])));
                    }
                }
            }
        }
    }
    out.println(maxArea);
    out.close();
    br.close();
    }
}