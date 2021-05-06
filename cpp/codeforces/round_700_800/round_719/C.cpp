#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

vector<vector<int>> g;

int main() {
  fast_io;
  int t;
  cin >> t;
  for (int test = 0; test < t; test++) {
    int n;
    cin >> n;
    if (n == 1) {
      cout << 1 << "\n";
    } else if (n == 2) {
      cout << -1 << "\n";
    } else {
      int count = 0;
      g = vector<vector<int>>(n);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          g[i].push_back(0);
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = (i % 2 ? 1 : 0); j < n; j += 2) {
          g[i][j] = ++count;
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = (!(i % 2) ? 1 : 0); j < n; j += 2) {
          g[i][j] = ++count;
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          cout << g[i][j] << " ";
        }
        cout << "\n";
      }
    }
  }
}
