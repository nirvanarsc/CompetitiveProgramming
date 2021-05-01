#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

int n, m;
int MOD = (int)(1e9 + 7);
vector<vector<int>> g;
int dp[20][1 << 20];

signed main() {
  fast_io;
  cin >> n >> m;
  g = vector<vector<int>>(n);
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    u--;
    v--;
    g[u].push_back(v);
  }
  dp[0][1] = 1;
  for (int mask = 1; mask < 1 << n; mask++) {
    for (int u = 0; u < n - 1; u++) {
      if (!dp[u][mask]) {
        continue;
      }
      for (int v : g[u]) {
        if (!(mask & (1 << v))) {
          dp[v][mask | (1 << v)] = (dp[v][mask | (1 << v)] + dp[u][mask]) % MOD;
        }
      }
    }
  }
  cout << dp[n - 1][(1 << n) - 1] << "\n";
}
