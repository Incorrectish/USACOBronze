#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <unordered_map>
#include <unordered_set>
#define pb push_back
#define u_s unordered_set
#define loop(i, a, n) for(int i = a; i < n; i++)
using namespace std;
int n;
u_s<string> allCharacteristics;
vector<vector<string>> characteristics;
bool search(string a, string b) {
    bool hasAnotB = false, hasBnotA = false, hasAandB = false;
    loop(i, 0, n) {
        bool hasA = false, hasB = false;
        loop(j, 0, characteristics[i].size()) {
            if(characteristics[i][j] == a) {
                hasA = true;
            } else if(characteristics[i][j] == b) {
                hasB = true;
            }
        }
        if(hasA && !hasB) {
            hasAnotB = true;
        } else if(!hasA && hasB) {
            hasBnotA = true;
        } else if(hasA && hasB) {
            hasAandB = true;
        }
    }
    if(hasAnotB && hasBnotA && hasAandB) {
        return true; 
    } else {
        return false;
    }
}
int main() {
    ifstream fin("evolution.in");
    ofstream fout("evolution.out");
    fin >> n;
    loop(i, 0, n) {
        int m;
        fin >> m;
        vector<string> temp;
        loop(j, 0, m) {
            string s;
            fin >> s;
            temp.pb(s);
            allCharacteristics.insert(s);
        }
        characteristics.pb(temp);
    }
    bool possibleTree = true;
    for(string i: allCharacteristics) {
        for(string j: allCharacteristics) {
            if(i!=j && search(i, j)) {
                    possibleTree = false;
            }
        }
    }
    if(possibleTree) {
        fout << "yes" << endl;
    } else {
        fout << "no" << endl;
    }
}