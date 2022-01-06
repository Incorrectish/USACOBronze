#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;
int main() {
    freopen("triangles.in", "r", stdin);
    freopen("triangles.out", "w", stdout);
    int n;
    cin >> n;
    vector<int> x(n);
    vector<int> y(n);
    for(int i = 0; i<n; i++) {
        cin >> x[i] >> y[i];
    }
    int maxArea = 0;
    for(int i = 0; i< n; i++) {
        for(int j = i+1; j<n;j++) {
            for(int k = j+1; k<n;k++) {
                if(x[i]==x[j] || x[i]==x[k] || x[j]==x[k]) {
                    if(y[i]==y[j] || y[i]==y[k] || y[j]==y[k]) {
                        maxArea = max(maxArea, abs(x[i]*(y[j]-y[k]) + x[j]*(y[k]-y[i]) + x[k]*(y[i]-y[j])));
                    }
                }
            }
        }
    }
    cout << maxArea << "\n";
    return 0;
    }