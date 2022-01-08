#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <unordered_set>
#include <map>
#define pb push_back
#define FOR(i, a, n) for(int i = a; i < n; i++)
#define For(i, n) for(int i = 0; i < n; i++)
using namespace std;

int main() {
    ifstream fin("herding.in");
    ofstream fout("herding.out");
    int n, m, k;
    fin >> n >> m >> k;
    if(k-m==1 && m-n ==1) {
        fout << 0 << endl;
        fout << 0 << endl;
        return 0;
    }else if(k-m==2 && m-n ==2) {
        fout << 1 << endl;
        fout << 1 << endl;
        return 0;
    }else if(k-m==2 || m-n ==2) {
        fout << 1 << endl;
        fout << max(k-m, m-n)-1 << endl;
        return 0;
    } else {
        fout << 2 << endl;
        fout << max(k-m, m-n)-1 << endl;
    }
}