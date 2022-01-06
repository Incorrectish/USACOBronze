import java.io.*;
import java.util.*;
public class tttt {
    static int[] winCount = new int[2];
    static ArrayList<String> teams = new ArrayList<String>();
    static ArrayList<String> teams1Win = new ArrayList<String>();
    static ArrayList<String> teams2Win = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
        String row1 = br.readLine();
        row1 += br.readLine();
        row1 += br.readLine();
        String[] board = row1.split("");
        teams.add(board[0]);teams.add(board[1]);teams.add(board[2]);
        doSuff();
        teams.add(board[3]);teams.add(board[4]);teams.add(board[5]);
        doSuff();
        teams.add(board[6]);teams.add(board[7]);teams.add(board[8]);
        doSuff();
        teams.add(board[0]);teams.add(board[3]);teams.add(board[6]);
        doSuff();
        teams.add(board[1]);teams.add(board[4]);teams.add(board[7]);
        doSuff();
        teams.add(board[2]);teams.add(board[5]);teams.add(board[8]);
        doSuff();
        teams.add(board[0]);teams.add(board[4]);teams.add(board[8]);
        doSuff();
        teams.add(board[2]);teams.add(board[4]);teams.add(board[6]);
        doSuff();
        out.println(winCount[0]);
        out.println(winCount[1]);
        out.close();
        br.close();
    }
    public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<String>();
        for(int i = 0; i<list.size(); i++) {
            if(!newList.contains(list.get(i))) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
    public static void doSuff() {
        teams = removeDuplicates(teams);
        if(teams.size() == 1 && !search(teams1Win, Character.toString(teams.get(0).charAt(0)))) {
            winCount[0]++;
            teams1Win.add(teams.get(0));
        }
        else if(teams.size() == 2 && !search(teams2Win, teams.get(0)+""+teams.get(1))) {
            winCount[1]++;
            teams2Win.add(teams.get(0)+""+teams.get(1));
            teams2Win.add(teams.get(1)+""+teams.get(0));
        }
        teams.clear();
    }
    public static boolean search(ArrayList<String> list, String str) {
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i).equals(str)) {
                return true;
            }
        }
        return false;
    }
}