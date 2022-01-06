import java.io.*;
import java.util.*;
public class measurement {
    static int[] cows = {7, 7, 7};
    static String[] cowNames = {"Bessie", "Elsie", "Mildred"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        int n = Integer.parseInt(br.readLine());
        int[] days = new int[n];
        String[] names = new String[n];
        int[] amounts = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            names[i] = st.nextToken();
            amounts[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(days[j] > days[j + 1]) {
                    int temp = days[j];
                    days[j] = days[j + 1];
                    days[j + 1] = temp;
                    String temp2 = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp2;
                    int temp3 = amounts[j];
                    amounts[j] = amounts[j + 1];
                    amounts[j + 1] = temp3;
                }
            }
        }
        int counter = 0;
        for(int i = 0; i < n; i++) {
            int[] clones = {cows[0], cows[1], cows[2]};
            for(int j = 0; j< 3; j++) {
                if(names[i].equals(cowNames[j])) {
                    cows[j] += amounts[i];
                }
            }
            if(bubbleSort() || (cows[1]==cows[2] && clones[1] != clones[2]) || (clones[1]==clones[2] && cows[1] != cows[2]) || (cows[1]==cows[2] && cows[1]==cows[0] && clones[1] != clones[0]) || (clones[0]==clones[2] && cows[1] != cows[0])) {
                counter++;
                continue;
            }
        }
        out.println(counter);
        out.close();
        br.close();
    }
    public static boolean bubbleSort() {
        boolean sorted = false;
        if(cows[0]> cows[2]) {
            int temp = cows[0];
            cows[0] = cows[2];
            cows[2] = temp;
            sorted = true;
            String temp1 = cowNames[0];
            cowNames[0] = cowNames[2];
            cowNames[2] = temp1;
        }
        if(cows[1]> cows[2]) {
            int temp = cows[1];
            cows[1] = cows[2];
            cows[2] = temp;
            sorted = true;
            String temp1 = cowNames[1];
            cowNames[1] = cowNames[2];
            cowNames[2] = temp1;
        }
        if(cows[0]> cows[1]) {
            int temp = cows[0];
            cows[0] = cows[1];
            cows[1] = temp;
            String temp1 = cowNames[0];
            cowNames[0] = cowNames[1];
            cowNames[1] = temp1;
        }
        return sorted;
    }
}