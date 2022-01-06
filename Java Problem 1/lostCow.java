import java.io.*;
import java.util.*;
public class lostCow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int copyX = x;
        int y = Integer.parseInt(st.nextToken());
        int distance = 0;
        int toIncrease = 1;
        if(x<y) {
            while(true){
                copyX = x+toIncrease;
                distance+=Math.abs(toIncrease);
                if(copyX==y){
                    break;
                } else if(copyX>y){
                    distance -= (copyX-y);
                    break;
                }
                distance+=Math.abs(toIncrease);
                toIncrease*=-2;
            }
        } else if(x>y) {
            while(true){
                copyX = x+toIncrease;
                distance+=Math.abs(toIncrease);
                if(copyX==y){
                    break;
                } else if(copyX<y){
                    distance -= (y-copyX);
                    break;
                }
                distance+=Math.abs(toIncrease);
                toIncrease*=-2;
            }
        }
        out.println(distance);
        out.close();
        br.close();
    }
}