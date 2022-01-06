#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

int main() {
    freopen("paint.in", "r", stdin);
    freopen("paint.out", "w", stdout);
    int a, b, c, d;
    cin >> a >> b;
    cin >> c >> d;
    int e = b>=d?b:d;
    int f = a<=c?a:c;
    if(b<c || d<a)
        cout << ((b-a)+(d-c)) << "\n";
    else 
        cout << abs(e-f) << "\n";
    return 0;
}