#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;
using ll = long long;

int main() {
  fast_io;
  int t;
  cin >> t;
  for (int test = 0; test < t; test++) {
    int n;
    cin >> n;
    int* arr = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      sum += arr[i];
    }
    if (sum == n) {
      cout << 0 << "\n";
      continue;
    } else if (sum < n) {
      cout << 1 << "\n";
    } else {
      cout << sum - n << "\n";
    }
  }
}
