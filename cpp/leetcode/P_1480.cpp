#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

vector<int> runningSum(vector<int>& nums) {
  int n = nums.size();
  vector<int> res = vector<int>(n);
  for (int i = 0; i < n; i++) {
    res[i] = nums[i];
    if (i) {
      res[i] += res[i - 1];
    }
  }
  return res;
}
