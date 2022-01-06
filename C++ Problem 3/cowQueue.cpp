#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#define pb push_back
#define loop(i, a, n) for(int i = a; i < n; i++)
using namespace std;

int main() {
    ifstream fin("cowqueue.in");
    ofstream fout("cowqueue.out");
    int n;
    fin >> n;
    vector<vector<int>> times(n);
    loop(i, 0, n) {
        int a, b;
        fin >> a >> b;
        times[i] = {a, b};
    }
    sort(times.begin(), times.end());
    int currentTime = times[0][0]+times[0][1];
    loop(i, 1, n) {
        if(times[i][0] > currentTime) {
            currentTime = times[i][0]+times[i][1];
        } else {
            currentTime += times[i][1];
        }
    }
    fout << currentTime << endl;
}