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
    ifstream fin("angry.in");
    ofstream fout("angry.out");
    int n;
    fin >> n;
    vector<int> haybales(n);
    For(i, n) {
        fin >> haybales[i]; 
    }
    sort(haybales.begin(), haybales.end());
    for(int i: haybales) {
        cout << i << " ";
    }
    cout << endl;
    int globalMax = 0;
    int i = 9;
    For(i, n) {
        unordered_set<int> haybalesClone;
        for(int v: haybales) haybalesClone.insert(v);
        haybalesClone.erase(haybales[i]);
        int t = 1;
        int j =i, k=i;
        bool kBurstMore = true, jBurstMore = true;
        while(true) {
            int orK = k;
            int orJ = j;
            if(kBurstMore) {
            for(int l = k+1; l<n;l++) {
                if(haybales[k]+t<haybales[l]) {
                    k = l-1;
                    haybalesClone.erase(haybales[k]);
                    break;
                } else if(haybales[k]+t>haybales[l]) {
                    haybalesClone.erase(haybales[l]);
                }
                if(l==n-1) {
                   kBurstMore = false;
                }
            }
            }
            if(k == orK) kBurstMore = false;
            if(jBurstMore) {
            for(int l = j-1; l>=0;l--) {
                if(haybales[j]-t>haybales[l]) {
                    j = l+1;
                    haybalesClone.erase(haybales[j]);
                    break;
                } else if(haybales[j]-t<haybales[l]) {
                    haybalesClone.erase(haybales[l]);
                }
                if(l==0) {
                   jBurstMore = false;
                }
            }
            }
            if(j == orJ) jBurstMore = false;
            if(!kBurstMore && !jBurstMore) break;
            t++;
        }
        int hayBalesBurst = (haybales.size()-haybalesClone.size());
        cout << hayBalesBurst << endl;
        globalMax = max(hayBalesBurst , globalMax);
    }
    fout << globalMax << endl;
    return 0;
}