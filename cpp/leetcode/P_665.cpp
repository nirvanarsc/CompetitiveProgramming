#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

bool checkPossibility(vector<int>& nums) {
  int n = nums.size();
  for (int i = 0; i < n - 1; i++) {
    if (nums[i] > nums[i + 1]) {
      int t = nums[i + 1];
      nums[i + 1] = nums[i];
      if (isIncreasing(nums, n)) {
        return true;
      }
      nums[i] = nums[i + 1] = t;
      return isIncreasing(nums, n);
    }
  }
  return true;
}

bool isIncreasing(vector<int>& nums, int n) {
  for (int i = 0; i < n - 1; i++) {
    if (nums[i] > nums[i + 1]) {
      return false;
    }
  }
  return true;
}
