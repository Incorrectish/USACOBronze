import java.io.*;
public class cbarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i< n; i++) {
            int tempDist = 0;
            for(int j = 0; j< n; j++) {
                tempDist+=(j)*a[j];
            }
            distance = Math.min(distance, tempDist);
            a = rotate(a);
        }
        out.println(distance);
        out.close();
        br.close();
    }
    public static int[] rotate(int[] a) {
        int temp = a[0];
        for(int i = 0; i<a.length-1; i++) {
            a[i] = a[i+1];
        }
        a[a.length-1] = temp;
        return a;
    }
}