#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <unordered_set>
#define pb push_back
#define FOR(i, a, n) for(int i = a; i < n; i++)
#define For(i, n) for(int i = 0; i < n; i++)
using namespace std;

int main() {
    ifstream fin("promote.in");
    ofstream fout("promote.out");
    int b[4], a[4];
    For(i, 4) fin >> b[i] >> a[i];
    int d[3] = {a[1]-b[1], a[2]-b[2], a[3]-b[3]};
    int goldCount = 0;
    int silverCount = 0;
    int platCount = 0;
    silverCount += d[0];
    silverCount += d[1];
    silverCount += d[2];
    goldCount += d[1];
    goldCount += d[2];
    platCount += d[2];
    fout << silverCount << endl;
    fout << goldCount << endl;
    fout << platCount << endl;
}