import java.io.*;
import java.util.*;
public class speeding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] road = new int[n][2];
        st = new StringTokenizer(br.readLine());
        road[0][0] = Integer.parseInt(st.nextToken());
        road[0][1] = Integer.parseInt(st.nextToken());
        for(int i = 1; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            road[i][0] = Integer.parseInt(st.nextToken())+road[i-1][0];
            road[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] drive = new int[m][2];
        st = new StringTokenizer(br.readLine());
        drive[0][0] = Integer.parseInt(st.nextToken());
        drive[0][1] = Integer.parseInt(st.nextToken());
        for(int i = 1; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            drive[i][0] = Integer.parseInt(st.nextToken())+drive[i-1][0];
            drive[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] diff = new int[100];
        int speedlimit = 0;
        int speed = 0;
        for(int i = 0; i<100; i++) {
            for(int j = 0; j< n; j++) {
                if(road[j][0]>=(i+1)){
                    speedlimit = road[j][1];
                    break;
                }
            }
            for(int j = 0; j< m; j++) {
                if(drive[j][0]>=(i+1)){
                    speed = drive[j][1];
                    break;
                }
            }
            diff[i]=(speed-speedlimit);
        }
        Arrays.sort(diff);
        out.println(diff[diff.length-1]>=0?diff[diff.length-1]:0);
        out.close();
        br.close();
    }
}