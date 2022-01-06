import java.util.*;

public class daisies {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] daisies = scanner.nextLine().split(" ");
        double[] petals = new double[n];
        for (int i = 0; i < n; i++) {
            petals[i] = Double.parseDouble(daisies[i]);
        }
        double[] petalsSum = new double[n];
        petalsSum[0] = petals[0];
        for(int i = 1; i< petals.length; i++) {
            petalsSum[i] = petalsSum[i-1] + petals[i];
        }
        int counter = 0;
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n;j++){
                if(search(petals, i, j, ((petalsSum[j] - (i==0? 0: petalsSum[i-1]))/(j-i+1)))){
                    counter++;
                }
            }
        }
        System.out.println(counter+petals.length);
        scanner.close();
    }
    public static boolean search(double[] arr, int n, int m, double v) {
        boolean toReturn = false;
        for(int i = n; i<=m; i++) {
            if(arr[i] == v) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }
}