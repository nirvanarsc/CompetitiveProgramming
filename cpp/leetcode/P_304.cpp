#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

class NumMatrix {
 public:
  int** dp;

  NumMatrix(vector<vector<int>>& matrix) {
    int n = matrix.size();
    int m = matrix[0].size();
    dp = new int*[n + 1];
    for (int i = 0; i <= n; i++) {
      dp[i] = (int*)calloc(m + 1, sizeof(int));
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
      }
    }
  }

  int sumRegion(int row1, int col1, int row2, int col2) {
    return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
  }
};
