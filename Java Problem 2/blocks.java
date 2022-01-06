import java.io.*;
import java.util.*;
public class blocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        int n = Integer.parseInt(br.readLine());
        String[][] a = new String[n][2];
        int[] alphabet = new int[26];
        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = st.nextToken();
            a[i][1] = st.nextToken();
        }
        for(int i = 0; i<n; i++) {
            String z = mergeString(a[i][0], a[i][1]);
            for(int j = 0; j<z.length(); j++) {
                alphabet[z.charAt(j)-'a']++;
            }
        }
        for(int i = 0; i<alphabet.length; i++) {
            out.println(alphabet[i]);
        }
        out.close();
        br.close();
    }
    public static String mergeString(String x, String y) {
        String z = "";
        for(int i = 0; i<x.length(); i++) {
            if(y.contains(Character.toString(x.charAt(i)))) {
                y = y.substring(0, y.indexOf(Character.toString(x.charAt(i))))+y.substring(y.indexOf(Character.toString(x.charAt(i)))+1);
            }
        }
        z += (y+x);
        return z;
    }
}