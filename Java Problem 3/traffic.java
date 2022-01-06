import java.io.*;
import java.util.*;
public class traffic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        int n = Integer.parseInt(br.readLine());
        String[] On_or_Off_or_None = new String[n];
        int[] lowerEndpoints = new int[n];
        int[] upperEndpoints = new int[n];
        int lowerEndpointsMax = 0;
        int upperEndpointsMin = 1001;
        for(int i=0; i< n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            On_or_Off_or_None[i] = st.nextToken();
            lowerEndpoints[i] = Integer.parseInt(st.nextToken());
            upperEndpoints[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n-1; i >= 0; i--) {
            if(On_or_Off_or_None[i].equals("none")) {
                lowerEndpointsMax = Math.max(lowerEndpoints[i],lowerEndpointsMax);
                upperEndpointsMin = Math.min(upperEndpoints[i],upperEndpointsMin); 
            }
            else if(On_or_Off_or_None[i].equals("on")) {
                lowerEndpointsMax = Math.max(lowerEndpointsMax-upperEndpoints[i], 0);
                upperEndpointsMin = upperEndpointsMin-lowerEndpoints[i];
            }
            else if(On_or_Off_or_None[i].equals("off")) {
                lowerEndpointsMax+=lowerEndpoints[i];
                upperEndpointsMin = upperEndpointsMin+upperEndpoints[i];
            }
        }
        out.println(lowerEndpointsMax+" "+upperEndpointsMin);
        for(int i = 0; i < n; i++) {
            if(On_or_Off_or_None[i].equals("none")) {
                lowerEndpointsMax = Math.max(lowerEndpoints[i],lowerEndpointsMax);
                upperEndpointsMin = Math.min(upperEndpoints[i],upperEndpointsMin);
            }
            else if(On_or_Off_or_None[i].equals("off")) {
                lowerEndpointsMax = Math.max(lowerEndpointsMax-upperEndpoints[i], 0);
                upperEndpointsMin = upperEndpointsMin-lowerEndpoints[i];
            }
            else if(On_or_Off_or_None[i].equals("on")) {
                lowerEndpointsMax+=lowerEndpoints[i];
                upperEndpointsMin = upperEndpointsMin+upperEndpoints[i];
            }
        }
        out.println(lowerEndpointsMax+" "+upperEndpointsMin);
        out.close();
        br.close();
    }
}