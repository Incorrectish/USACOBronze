#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#define pb push_back
#define vi vector<int>
#define vvi vector<vi>
#define for(i,n) for(int i=0;i<n;i++)
using namespace std;
int main() {
    ifstream fin("speeding.in");
    ofstream fout("speeding.out");
    int n, m;
    fin >> n >> m; 
    vvi road(n);
    vvi drive(m);
    road[0] = vi(2);
    fin >> road[0][0] >> road[0][1];
    for(i, n-1) {
        road[i+1] = vi(2);
        fin >> road[i+1][0] >> road[i+1][1];
        road[i+1][0]+=road[i][0];
    }
    drive[0] = vi(2);
    fin >> drive[0][0] >> drive[0][1];
    for(i, m-1) {
        drive[i+1] = vi(2);
        fin >> drive[i+1][0] >> drive[i+1][1];
        drive[i+1][0]+=drive[i][0];
    }
    int maxDiff = 0;
    int speed = 0;
    int speedlimit = 0;
    for(i, 100) {
        for(j, n) {
            if(road[j][0]>=(i+1)){
                speedlimit = road[j][1];
                break;
            }
        }
        for(j, m) {
            if(drive[j][0]>=(i+1)){
                speed = drive[j][1];
                break;
            }
        }
            maxDiff = max(speed-speedlimit, maxDiff);
    }
    fout << maxDiff << endl;
}