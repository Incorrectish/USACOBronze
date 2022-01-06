#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <unordered_set>
#define u_s unordered_set<int>
using namespace std;
int main() {
    ifstream fin("factory.in");
    ofstream fout("factory.out");
    int n;
    fin >> n;
    u_s list;
    for(int i=0;i<n-1;i++) {
        int a, b;
        fin >> a >> b;
        list.insert(a);
    }
    u_s possibleCandidates;
    for(int i = 0; i<list.size();i++) {
        if(list.find(i+1) == list.end()) {
            possibleCandidates.insert(i+1);
        }
    }
    int smallest = -1;

    if(possibleCandidates.size()==1) {
        smallest = *possibleCandidates.begin();
    }
    fout << smallest << endl;
    
}