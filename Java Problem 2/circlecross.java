import java.io.*;

public class circlecross {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
        String map = br.readLine();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int counter = 0;
        for(int i = 0; i<alphabet.length; i++) {
            for(int j = 0; j<alphabet.length; j++) {
                int[] first = findFirstTwo(map, alphabet[i]);
                int[] second = findFirstTwo(map, alphabet[j]);
                if(second[0]>first[0] && second[0]<first[1] && second[1]>first[1]) {
                    counter++;
                }
            }
        }
        out.println(counter);
        out.close();
        br.close();
        }
        /*create a method that takes in a string and a character and returns the first two occurences of the character in the string*/
        public static int[] findFirstTwo(String s, String c) {
            int[] result = new int[2];
            int count = 0;
            for(int i = 0; i<s.length(); i++) {
                if(Character.toString(s.charAt(i)).equals(c)) {
                    result[count] = i;
                    count++;
                    if(count == 2) {
                        return result;
                    }
                }
            }
            return result;
        }
}