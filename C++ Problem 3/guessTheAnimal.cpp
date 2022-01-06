#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
#include <set>
using namespace std;
int commonTraits(vector<string> animal1, vector<string> animal2) {
    int commonTraits = 0;
    for(int i = 0; i<animal1.size(); i++) {
        for(int j = 0; j<animal2.size(); j++) {
            if(animal1[i] == animal2[j]) {
                commonTraits++;
                break;
            }
        }
    }
    return commonTraits;
}
int main() {
    ifstream fin("guess.in");
    ofstream fout("guess.out");
    int n;
    fin >> n;
    vector<string> animals(n);
    vector<vector<string>> characteristics(n);
    int temp;
    for (int i = 0; i < n; i++) {
        fin >> animals[i] >> temp;
        characteristics[i] = vector<string>(temp);
        for (int j = 0; j < temp; j++) {
            fin >> characteristics[i][j];
        }
    }
    int maxC = 0;
    for(int i = 0; i<n;i++) {
        for(int j = i+1; j<n; j++) {
            maxC = max(maxC, commonTraits(characteristics[i], characteristics[j]));
        }
    }
    fout << maxC+1 << endl;
    return 0;
}