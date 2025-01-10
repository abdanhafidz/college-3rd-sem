#include <bits/stdc++.h>
using namespace std;

using ll = long long;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    int ans = 0;
    for (int i = 0; i < N; i++) {
        int P;
        cin >> P;
        if (P > 0) ans -= P;
    }

    for (int i = 0; i < M; i++) {
        int C;
        cin >> C;
        if (C < 0) ans += C;
    }

    cout << ans << '\n';

    return 0;
}