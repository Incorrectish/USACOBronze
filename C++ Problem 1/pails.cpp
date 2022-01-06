#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

int main() {
    ifstream fin("pails.in");
    ofstream fout("pails.out");
    int x, y, m;
    fin >> x >> y >> m;
    int v = m/y;
    int max1 = v*y;
    while(v>=0) {
        int sum = v*y;
        while(sum<=m-x) {
            sum += x;
        }
        v--;
        max1 = max(max1, sum);
    }
    
    fout << max1 << "\n";
    return 0;
}