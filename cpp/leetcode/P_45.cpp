#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

int* dp;

int jump(vector<int>& nums) {
  dp = (int*)malloc(nums.size() * sizeof(int));
  for (int i = 0; i < nums.size(); i++) {
    dp[i] = -1;
  }
  return dfs(nums, 0);
}

int dfs(vector<int>& nums, int idx) {
  if (idx == (int)nums.size() - 1) {
    return 0;
  }
  if (dp[idx] != -1) {
    return dp[idx];
  }
  int res = (int)1e9;
  for (int j = 1; j <= nums[idx] && idx + j < (int)nums.size(); j++) {
    res = min(res, 1 + dfs(nums, idx + j));
  }
  return dp[idx] = res;
}
