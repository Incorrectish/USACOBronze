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
#define pb push_back
#define printLoop(v) FOR(i, 0, sz(v)) { cout << v[i] << " "; } cout << endl
using namespace std;
struct intersection {
    int cow1, cow2, time1, time2;
};
bool compare(intersection a, intersection b) {
    return a.time2 < b.time2;
}
int main() {
    int n;
    cin >> n;
    vector<char> direction(n);
    vector<int> x(n), y(n);
    For(i, n) {
        cin >> direction[i] >> x[i] >> y[i];
    }
    vector<intersection> intersections;
    For(i, n) {
        FOR(j, i+1, n) {
            int east = i, north = j;
            if(direction[east]!=direction[north]) {
            if(direction[east] == 'N') swap(east, north);
            if(y[north]<y[east] && x[east]<x[north]) {
                int intersectionEast = x[north] - x[east];
                int intersectionNorth = y[east] - y[north];
                if(intersectionEast>intersectionNorth) intersections.pb({north, east, intersectionNorth, intersectionEast});
                else if(intersectionNorth>intersectionEast) intersections.pb({east, north, intersectionEast, intersectionNorth});
            }
            }
        }
    }
    sort(all(intersections), compare);
    const int Infinity = 2e9;
    vector<int> stopLocation(n, Infinity);
    for(auto i: intersections) {
        if(i.time1 < stopLocation[i.cow1] && i.time2 < stopLocation[i.cow2]) {
            stopLocation[i.cow2] = i.time2;
        }
    }
    For(i, sz(stopLocation)){
        if(stopLocation[i] == Infinity) cout << "Infinity" << endl;
        else cout << stopLocation[i] << endl;
    }
}