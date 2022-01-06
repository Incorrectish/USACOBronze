import java.util.*;
import java.io.*;
public class fencePainting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = b>=d?b:d;
        int f = a<=c?a:c;
        if(d<a || b<c){
            out.write(((b-a)+(d-c))+"\n");
        } else{
        out.write((Math.abs(e-f))+"\n");
        }
        out.close();
        br.close();
    }
}