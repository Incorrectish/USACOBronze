import java.io.*;
public class censor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("censor.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder(S.length());
        String T = br.readLine();
        int tl = T.length();
        for (int i = 0; i < S.length(); i++) {
            sb.append(S.charAt(i));

            int sl = sb.length();

            if (sl >= tl) {
                if (sb.substring(sl - tl).equals(T)) {
                    sb.delete(sl - tl, sl);
                }
            }

        }
        out.println(sb.toString());
        out.close();
        br.close();
    }
}