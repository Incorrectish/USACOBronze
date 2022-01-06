import java.io.*;
import java.util.*;
public class mixmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c3 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int[] c = {c1, c2, c3};
        int[] m = {m1, m2, m3};
        for(int i = 0; i<100; i++) {
            int u = Math.min(c[(i+1)%3]-m[(i+1)%3], m[i%3]);
            m[(i+1)%3] += u;
            m[i%3] -= u;
        }
        out.println(m[0]);
        out.println(m[1]);
        out.println(m[2]);
        out.close();
        br.close();
    }
}