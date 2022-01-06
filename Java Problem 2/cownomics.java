import java.io.*;
import java.util.*;

public class cownomics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] spottyCows = new String[n][m];
        String[][] nonSpottyCows = new String[n][m];
        for(int i = 0; i<n; i++) {
            spottyCows[i] = br.readLine().split("");
        }
        for(int i = 0; i<n; i++) {
            nonSpottyCows[i] = br.readLine().split("");
        }
        int counter = 0;
        for(int i = 0; i<m; i++) {
            int counter1 = 0;
            Set<String> list = new HashSet<String>();
            for(int j = 0; j<n; j++) {
                list.add(spottyCows[j][i]);
            }
            for(int j = 0; j<n; j++) {
                if(!search(list, nonSpottyCows[j][i])){
                    counter1++;
                }
                if(counter1 == n) {
                    counter++;
                }
                }
            }
            out.println(counter);
            out.close();
            br.close();
        }
    public static boolean search(Set<String> set, String s) {
        for(String str : set) {
            if(str.equals(s)) {
                return true;
            }
        }
        return false;
    }
}