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
    ifstream fin("whereami.in");
    ofstream fout("whereami.out");
    int n;
    string s;
    fin >> n;
    fin >> s;
    unordered_set<int> lengths;
    For(i, n) lengths.insert(i+1);
    unordered_set<string> substrings;
    For(i, n) {
        FOR(j, i, n) {
            string c = s.substr(i, j-i+1);
            if(substrings.count(c)>0) lengths.erase(c.length()); 
            substrings.insert(c);
        }
    }
    int minLength = n;
    for(int x: lengths) {
        minLength = min(minLength, x);
    }
    fout << minLength << endl;
}