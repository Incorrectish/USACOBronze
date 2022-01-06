import java.io.*;
import java.util.*;
public class shuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] transform = new int[2][n];
        String[] AsubI = br.readLine().split(" ");
        String[] idsStrings = br.readLine().split(" ");
        String[] idsStrings2 = new String[idsStrings.length];
        for (int i = 0; i < idsStrings.length; i++) {
            idsStrings2[i] = idsStrings[i];
        }
        for (int i = 0; i < n; i++) {
            transform[1][i] = i+1;
            transform[0][i] = Integer.parseInt(AsubI[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (transform[0][j] > transform[0][j+1]) {
                    int temp = transform[0][j];
                    transform[0][j] = transform[0][j+1];
                    transform[0][j+1] = temp;
                    temp = transform[1][j];
                    transform[1][j] = transform[1][j+1];
                    transform[1][j+1] = temp;
                }
            }
        }
        for( int j = 0; j<3; j++) {
        for(int i = 0; i < n; i++) {
            idsStrings[transform[1][i]-1] = idsStrings2[i];
        }
        for(int i = 0; i < n; i++) {
            idsStrings2[i] = idsStrings[i];
        }
    }
        for (int i = 0; i < n; i++) {
            out.println(idsStrings[i]);
        }
        out.close();
        br.close();
    }
}