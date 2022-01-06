#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

int main() {
    ifstream fin("lifeguards.in");
    ofstream fout("lifeguards.out");
    int n;
    fin >> n;
    vector<int> startTimes(n);
    vector<int> endTimes(n);
    for(int i = 0; i<n; i++) {
        fin >> startTimes[i] >> endTimes[i];
    }
    for(int i = 0; i<n; i++) {
        for(int j = i+1; j<n; j++) {
            if(startTimes[i] > startTimes[j]) {
                swap(startTimes[i], startTimes[j]);
                swap(endTimes[i], endTimes[j]);
            }
        }
    }
    int maxLength = 0;
    for(int i = 0; i<n ; i++) {
        int start = startTimes[i>0? 0 : 1];
        int end = endTimes[i>0? 0 : 1];
        for(int j = 0; j<n;j++) {
            if(j!=i) {
                if(startTimes[j]>end) {
                    start += (startTimes[j]-end);
                } 
                end = max(end, endTimes[j]);
            }
        }
        cout << end-start << endl;
        maxLength = max(maxLength, end-start);
    }
    fout << maxLength << "\n";
    return 0;
}