import java.util.*;
import java.io.*;
public class squarePasture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int a3 = Integer.parseInt(st.nextToken());
        int a4 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int b3 = Integer.parseInt(st.nextToken());
        int b4 = Integer.parseInt(st.nextToken());
        int cx = Math.max(b3, a3);
        int cy = Math.max(b4, a4);
        int cx1 = Math.min(b1, a1);
        int cy1 = Math.min(b2, a2);
        int cs = Math.max(cx-cx1, cy-cy1);
        out.write((cs*cs)+"\n");
        out.close();
        br.close();
    }
}