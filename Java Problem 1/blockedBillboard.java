import java.util.*;
import java.io.*;
public class blockedBillboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
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
        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int c3 = Integer.parseInt(st.nextToken());
        int c4 = Integer.parseInt(st.nextToken());
        int aArea = (a3-a1)*(a4-a2);
        int bArea = (b3-b1)*(b4-b2);
        int leftCArea = (((c4<a4? c4: a4)-(a2>c2? a2: c2))>=0? ((c4<a4? c4: a4)-(a2>c2? a2: c2)): 0)*(((a3>c3? c3: a3)-(c1<a1? a1: c1))>=0? ((a3>c3? c3: a3)-(c1<a1? a1: c1)): 0); 
        int rightCArea = (((c4>b4? b4: c4)-(c2<b2? b2: c2))>=0? ((c4>b4? b4: c4)-(c2<b2? b2: c2)): 0)*(((c3<b3? c3: b3)-(c1>b1? c1: b1))>=0? ((c3<b3? c3: b3)-(c1>b1? c1: b1)): 0); 
        out.write((aArea+bArea-rightCArea-leftCArea)+"\n");
        out.close();
        br.close();
    }
}