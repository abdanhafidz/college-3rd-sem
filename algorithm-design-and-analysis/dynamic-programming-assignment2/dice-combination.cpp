#include <iostream>
#include <unordered_map>
using namespace std;

const int MOD = 1e9 + 7;
unordered_map<int, int> memo;

int dp(int x) {
    if (memo.find(x) != memo.end()) {
        return memo[x];
    } else {
        if (x < 0) return 0;
        if (x == 0) return 1;

        long long ret = 0;
        for (int i = 1; i <= 6; i++) {
            ret += dp(x - i);
            ret %= MOD;  // Apply MOD while summing to prevent overflow
        }
        memo[x] = ret % MOD;
        return memo[x];
    }
}

int main() {
    int N;
    cin >> N;
    cout << dp(N) << endl;
    return 0;
}
