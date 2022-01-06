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
#define For(i, n) for(int i = 0; i < n; i++)
using namespace std;
struct Cow {
    int milk;
    string name;
};

int main() {
    ifstream fin("notlast.in");
    ofstream fout("notlast.out");
    int n;
    fin >> n;
    vector<Cow> cows(7);
    For(i, 7) {
        cows[i].milk = 0;
    }
    cows[0].name = "Henrietta";
    cows[1].name = "Daisy";
    cows[2].name = "Annabelle";
    cows[3].name = "Bessie";
    cows[4].name = "Elsie";
    cows[5].name = "Maggie";
    cows[6].name = "Gertie";
    vector<string> names(n);
    For(i, n) {
        string s; int v;
        fin >> s >> v;
        For(i, 7) {
            if(cows[i].name == s) {
                cows[i].milk += v;
            }
        }
    }
    sort(cows.begin(), cows.end(), [](Cow a, Cow b) {return a.milk < b.milk;});
    int lowest = cows[0].milk;
    int u = 0;
    int v;
    For(i, 7) {
        if(cows[i].milk > lowest) {
            u = cows[i].milk;
            v = i;
            break;
        }
    }
    if(u==0) {fout << "Tie" << endl; return 0;}
    int counter = 0;
    For(i, 7) {
        if(cows[i].milk == u) {
            counter++;
        }
    }
    if(counter == 1) fout << cows[v].name << endl;
    else fout << "Tie" << endl;
    return 0;
}