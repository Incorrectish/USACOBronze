#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;
bool search(vector<double> vector, int n, int m, double v);

int main() {
    int n;
    cin >> n;
    vector<double> petals(n);
    for(int i = 0; i<n; i++) {
        cin >> petals[i];
    }
    vector<double> petalsSum(n);
    petalsSum[0] = petals[0];
    for(int i = 1; i<n; i++) {
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
    cout << counter+n << "\n";
}
bool search(vector<double> vector, int n, int m, double v) {
    bool toReturn = false;
        for(int i = n; i<=m; i++) {
            if(vector[i] == v) {
                toReturn = true;
                break;
            }
        }
        return toReturn;
}