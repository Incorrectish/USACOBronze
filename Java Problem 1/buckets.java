import java.io.*;
public class buckets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        int n = Integer.parseInt(br.readLine());
        String[] buckets = br.readLine().split(" ");
        int[] c = new int[n];
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(buckets[i]);
        }
        buckets = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(buckets[i]);
        }
        for(int i = 0; i < n-1; i++) {
            int u = Math.min(c[i+1]-a[i+1], c[i]);
            a[i+1]+= u;
            a[i]-=u;
        }
        for(int i = 0; i < n; i++) {
            out.write(a[i]+" ");
        }
        out.write("\n");
        out.close();
        br.close();
    }

}