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
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    sort(arr, arr + n);
    if (n == 2) {
      cout << arr[0] << " " << arr[1] << "\n";

      continue;
    }
    int best = (int)2e9;
    int split = -1;
    for (int i = 0; i < n - 1; i++) {
      if (best > (arr[i + 1] - arr[i])) {
        best = arr[i + 1] - arr[i];
        split = i + 1;
      }
    }
    for (int i = 0; i < n; i++) {
      cout << arr[split] << " ";
      split = (split + 1) % n;
    }
    cout << "\n";
  }
}
