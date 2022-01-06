import java.io.*;
import java.util.*;
public class mowing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer[]> adj = new ArrayList<Integer[]>();
        adj.add(new Integer[]{0,0});
        for(int i =0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if(direction.equals("N")) {
                for(int j = 0; j<x; j++) {
                    adj.add(new Integer[]{adj.get(adj.size()-1)[0], adj.get(adj.size()-1)[1]+1});
                }
            }
            else if(direction.equals("S")) {
                for(int j = 0; j<x; j++) {
                    adj.add(new Integer[]{adj.get(adj.size()-1)[0], adj.get(adj.size()-1)[1]-1});
                }
            }
            else if(direction.equals("E")) {
                for(int j = 0; j<x; j++) {
                    adj.add(new Integer[]{adj.get(adj.size()-1)[0]+1, adj.get(adj.size()-1)[1]});
                }
            }
            else if(direction.equals("W")) {
                for(int j = 0; j<x; j++) {
                    adj.add(new Integer[]{adj.get(adj.size()-1)[0]-1, adj.get(adj.size()-1)[1]});
                }
            }
        }
        ArrayList result = findDistanceBetweenDuplicateElements(adj);
        Collections.sort(result);
        out.println((result.size()>0?result.get(0):-1));
        out.close();
        br.close();
    }
    public static ArrayList<Integer> findDistanceBetweenDuplicateElements(ArrayList<Integer[]> list) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i<list.size(); i++) {
            for(int j = i+1; j<list.size(); j++) {
                if(Arrays.equals(list.get(i), list.get(j))) {
                    result.add(j-i);
                }
            }
        }
        return result;
    }
}