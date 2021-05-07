#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

int dp[505][505];

int dfs(string& w1, string& w2, int i, int j) {
  if (i == w1.length() || j == w2.length()) {
    return 0;
  }
  if (dp[i][j] != -1) {
    return dp[i][j];
  }
  int res = max(dfs(w1, w2, i + 1, j), dfs(w1, w2, i, j + 1));
  if (w1[i] == w2[j]) {
    res = max(res, 1 + dfs(w1, w2, i + 1, j + 1));
  }
  return dp[i][j] = res;
}

int minDistanceDFS(string word1, string word2) {
  for (int i = 0; i <= word1.length(); i++) {
    for (int j = 0; j <= word2.length(); j++) {
      dp[i][j] = -1;
    }
  }
  return word1.length() + word2.length() - 2 * dfs(word1, word2, 0, 0);
}

int minDistance(string word1, string word2) {
  int n = word1.length();
  int m = word2.length();
  int dp[n + 1][m + 1];

  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= m; j++) {
      dp[i][j] = 0;
    }
  }

  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (word1[i] == word2[j]) {
        dp[i + 1][j + 1] = dp[i][j] + 1;
      } else {
        dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
      }
    }
  }

  int lcs = dp[n][m];
  return n + m - 2 * lcs;
}
