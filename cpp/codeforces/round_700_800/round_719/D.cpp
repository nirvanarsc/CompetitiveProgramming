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
    ll res = 0;
    unordered_map<int, int>* mp = new unordered_map<int, int>();
    for (int i = 0; i < n; i++) {
      int curr = arr[i] - i;
      res += (*mp)[curr]++;
    }
    cout << res << "\n";
  }
}
