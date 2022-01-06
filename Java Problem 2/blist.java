import java.io.*;
import java.util.*;
public class blist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        int n = Integer.parseInt(br.readLine());
        int[] s_I = new int[n];
        int[] t_I = new int[n];
        int[] b_I = new int[n];
        for(int i=0; i< n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s_I[i] = Integer.parseInt(st.nextToken());
            t_I[i] = Integer.parseInt(st.nextToken());
            b_I[i] = Integer.parseInt(st.nextToken());
        }
        int[] max_Buckets = new int[1000];
        for(int i=0; i<1000; i++) {
            int tempBuckets = 0;
            for(int j=0; j<n; j++) {
                if(s_I[j] <=(i+1) && t_I[j] >= (i+1)) {
                    tempBuckets += b_I[j];
                }
            }
            max_Buckets[i] = tempBuckets;
        }
        Arrays.sort(max_Buckets);
        out.println(max_Buckets[999]);
        out.close();
        br.close();
    }
}