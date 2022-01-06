#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#define pb push_back
#define vi vector<int>
#define vvi vector<vi>
#define _for(i,n) for(int i=0;i<n;i++)
using namespace std;
int main() {
    ifstream fin("buckets.in");
    ofstream fout("buckets.out");
    vector<string> rows(10);
    for(int i = 0;i< 10;i++) {
        fin >> rows[i];
    }
    for(string i: rows) cout << i << endl;
    vi B(2);
    vi L(2);
    vi R(2);
    _for(i, 10) {
        _for(j, 10) {
            if (rows[i][j] == 'B') {
                B[0] = i;
                B[1] = j;
            }
            if (rows[i][j] == 'L') {
                L[0] = i;
                L[1] = j;
            }
            if (rows[i][j] == 'R') {
                R[0] = i;
                R[1] = j;
            }
        }
    }
    int min = abs(B[0] - L[0]) + abs(B[1] - L[1]);
    if(L[0]==R[0] && R[0]==B[0] && (B[1]>R[1] && R[1]>L[1] || B[1]<R[1] && R[1]<L[1])) {  
        fout << abs(B[1]-L[1])+1 << endl;
    } else if(L[1]==R[1] && R[1]==B[1] && (B[0]>R[0] && R[0]>L[0] || B[0]<R[0] && R[0]<L[0])) {
        fout << abs(B[0]-L[0])+1 << endl;
    }
     else {
        fout << min-1 << endl;
    }
}