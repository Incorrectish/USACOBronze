import java.io.*;
import java.util.*;

public class shellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        int n = Integer.parseInt(br.readLine());//3
        String[] lines = new String[n];//length 3
        for(int i = 0; i < n; i++) {
            lines[i] = br.readLine();//[1 2 1, 3 2 1, 1 3 1]
        }
        int one = 0;
        int two = 0;
        int three = 0;
        int current = 2;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(lines[i]);
            int a1 = Integer.parseInt(st.nextToken());//1, 3, 1
            int a2 = Integer.parseInt(st.nextToken());//2, 2, 3
            int a3 = Integer.parseInt(st.nextToken());//1, 1, 1\
            if(current == a1) {//nope
                current = a2;
            } else if(current == a2) {//nope
                current = a1;//current = 1
            }
            if(current == a3) {
                two++;
            }
        }
        current = 1;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(lines[i]);
            int a1 = Integer.parseInt(st.nextToken());//1, 3, 1
            int a2 = Integer.parseInt(st.nextToken());//2, 2, 3
            int a3 = Integer.parseInt(st.nextToken());//1, 1, 1
            if(current == a1) {
                current = a2;
            } else if(current == a2) {
                current = a1;
            }
            if(current == a3) {
                one++;
            }
        }//one = 1
        current = 3;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(lines[i]);
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int a3 = Integer.parseInt(st.nextToken());
            if(current == a1) {
                current = a2;
            } else if(current == a2) {
                current = a1;
            }
            if(current == a3) {
                three++;
            }
        }
        out.write(Math.max(one, Math.max(two, three))+"\n");
        out.close();
        br.close();
    }   
}
