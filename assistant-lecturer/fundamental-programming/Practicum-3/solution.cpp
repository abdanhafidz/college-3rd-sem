#include <iostream>
#include <unordered_map>
using namespace std;
const long long MOD = 1e9 + 7;
unordered_map<long long, long long> memo;

long long f(long long n) {
    // Base case: if the result is already computed, return it from the memoization map
    if (memo.find(n) != memo.end()) {
        return memo[n];
    }

    // Base cases for small values of n
    if (n <= 0) {
        return 0;
    } else if (n == 1 || n == 2 || n == 3) {
        return 1;
    } else if (n == 4) {
        return 2;
    }

    // Recursively compute the result and store it in the memoization map
    memo[n] = ( (f(n - 2)%MOD) + (f(n - 3)%MOD) + (f(n - 4)%MOD) )%MOD;
    return memo[n];
}

int main() {
    int n;
    cin >> n;
    cout << f(n) << endl;
    return 0;
}
