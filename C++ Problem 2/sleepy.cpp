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
#define FOR_(i, a, n) for(int i = a; i >= n; i--)
#define For(i, n) for(int i = 0; i < n; i++)
using namespace std;

int main() {
    ifstream fin("sleepy.in");
    ofstream fout("sleepy.out");
    int n;
    fin >> n;
    vector<int> cows(n);
    For(i, n) fin >> cows[i];
    int largestOutOfOrder = n-1;
    FOR_(i, n-2, 0) {
        if(cows[i] < cows[i+1])
			largestOutOfOrder = i;
		else
			break;
    }
    fout << largestOutOfOrder << endl;
}