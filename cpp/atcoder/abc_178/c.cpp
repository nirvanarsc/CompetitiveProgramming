#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

int MOD = (int)(1e9 + 7);

int** dp;

int dfs(int n, int idx, int mask) {
  if (idx == n) {
    return mask == 3 ? 1 : 0;
  }
  if (dp[idx][mask] != -1) {
    return dp[idx][mask];
  }
  int res = 0;
  for (int i = 0; i < 10; i++) {
    if (i == 0) {
      res = (res + dfs(n, idx + 1, mask | 1)) % MOD;
    } else if (i == 9) {
      res = (res + dfs(n, idx + 1, mask | 2)) % MOD;
    } else {
      res = (res + dfs(n, idx + 1, mask)) % MOD;
    }
  }
  return dp[idx][mask] = res;
}

int main() {
  fast_io;
  int n;
  cin >> n;
  dp = new int*[n];
  for (int i = 0; i < n; i++) {
    dp[i] = new int[4];
    dp[i][0] = dp[i][1] = dp[i][2] = dp[i][3] = -1;
  }
  cout << dfs(n, 0, 0) << "\n";
}
