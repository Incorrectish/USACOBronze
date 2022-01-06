#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

int main() {
    ifstream fin("balancing.in");
    ofstream fout("balancing.out");
    int n, B;
    fin >> n >> B;
    vector<int> x(n);
    vector<int> y(n);
    for (int i = 0; i < n; i++) {
        fin >> x[i] >> y[i];
    }
    for(int i = 0; i<n;i++) {
        cout << x[i] << " " << y[i] << endl;
    }
    int min1 = 9999999999999999;
    for(int i = 0; i<n; i++) {
        int u = 0;
        for(int j = 0; j<n; j++) {
            int a = x[i]+1;
            int b = y[j]+1;
            int Q1 = 0, Q2 = 0, Q3 = 0, Q4 = 0;
            for (int k = 0; k < n; k++) {
            if (x[k] < a && y[k] < b) {
                Q1++;
            } else if (x[k] > a && y[k] < b) {
                Q2++;
            } else if (x[k] > a && y[k] > b) {
                Q3++;
            } else if (x[k] < a && y[k] > b) {
                Q4++;
            }
        }
            cout << Q1 << " " << Q2 << " " << Q3 << " " << Q4 << endl;
            u = max(max(Q1, Q2), max(Q3, Q4));
            min1 = min(min1, u);
        }
    }
    fout << min1 << "\n";
    return 0;
}