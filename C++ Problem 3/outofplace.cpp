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
#define For_(i, n) for(int i = n - 1; i >= 0; i--)
#define all(v) v.begin(), v.end()
#define rall(v) v.rbegin(), v.rend()
#define sz(v) ((int)(v).size())
#define print(v) cout << v << endl
#define printLoop(v) FOR(i, 0, sz(v)) { cout << v[i] << " "; } cout << endl
using namespace std;

int binarySearch(vector<int> v, int x) {
    int l = 0, r = sz(v) - 1;
    while(l <= r) {
        int m = (l + r) / 2;
        if(v[m] == x) return m;
        if(v[m] < x) l = m + 1;
        else r = m - 1;
    }
    return -1;
}

int main() {
    ifstream fin("outofplace.in");
    ofstream fout("outofplace.out");
    int n;
    fin >> n;
    vector<int> cowHeights(n);
    For(i, n) fin >> cowHeights[i];
    int bessiePos = -1;
    int bessieHeight = -1;
    if(cowHeights[0]>cowHeights[1] && cowHeights[0] > cowHeights[2])
    {
        bessiePos = 0;
        bessieHeight = cowHeights[0];
    } else if(cowHeights[n-1]<cowHeights[n-2] && cowHeights[n-1] < cowHeights[n-3]){
        bessiePos = n-1;
        bessieHeight = cowHeights[n-1];
    } else {
    FOR(i, 1,  n-1) {
       if((cowHeights[i]>cowHeights[i-1] && cowHeights[i] > cowHeights[i+1])) {
           if(cowHeights[i+1] > cowHeights[i-1]) {
               bessiePos = i;
               bessieHeight = cowHeights[i];
           } else if(cowHeights[i+1] < cowHeights[i-1]) {
               bessiePos = i+1;
               bessieHeight = cowHeights[i+1];
           }
           break;
       } else if((cowHeights[i]<cowHeights[i-1] && cowHeights[i] < cowHeights[i+1])) {
           bessiePos = i;
            bessieHeight = cowHeights[i];
            break;
       }
   } 
    }
    cout << bessiePos << bessieHeight << endl;
    sort(cowHeights.begin(), cowHeights.end());
    int posBessieShouldBe = binarySearch(cowHeights, bessieHeight);
    cout << posBessieShouldBe << endl;
    vector<int> heightsBetweenBessieAndPosBessieShouldBe(abs(posBessieShouldBe-bessiePos)+1);
    int v = 0;
    for(int i = min(bessiePos, posBessieShouldBe); i<=max(bessiePos, posBessieShouldBe); i++) {
        heightsBetweenBessieAndPosBessieShouldBe[i-min(bessiePos, posBessieShouldBe)] = cowHeights[i];
    }
    printLoop(heightsBetweenBessieAndPosBessieShouldBe);
    unordered_set<int> heightsBetweenBessieAndPosBessieShouldBeSet(all(heightsBetweenBessieAndPosBessieShouldBe));

    fout << heightsBetweenBessieAndPosBessieShouldBeSet.size()-1  << endl;
}