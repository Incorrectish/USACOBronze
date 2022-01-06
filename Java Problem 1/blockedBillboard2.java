import java.util.*;
import java.io.*;
public class blockedBillboard2 {
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
        int aArea = (a3-a1)*(a4-a2);
        int coveredAREA = 0;
        if(b4>=a4 && b2<=a2 && b3>= a3 && b1<= a1) {
            coveredAREA = aArea;
        } else if(b4>a2 && b2<=a2 && b1 <= a1 && b3>= a3) {
            coveredAREA = (a3-a1)*(b4-a2);
        } else if(b2<a4 && b4>=a4 && b1 <= a1 && b3>= a3) {
            coveredAREA = (a3-a1)*(a4-b2);
        } else if(b1<a3 && b3>=a3 && b2 <= a2 && b4>= a4) {
            coveredAREA = (a4-a2)*(a3-b1);
        } else if(b3>a1 && b1<=a1 && b2 <= a2 && b4>= a4) {
            coveredAREA = (a4-a2)*(b3-a1);
        }
        out.write((aArea-coveredAREA)+"\n");
        out.close();
        br.close();
    }
}