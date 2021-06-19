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
    int n, m, i, j;
    cin >> n >> m >> i >> j;
    vector<array<int, 4>> corners;
    corners.push_back({1, 1, n, m});
    corners.push_back({1, m, n, 1});
    ll best = (ll)-1e18;
    array<int, 4> res = {-1, -1, -1, -1};
    for (array<int, 4> curr : corners) {
      ll currBest = abs(curr[0] - i) + abs(curr[1] - j) + abs(curr[2] - i) + abs(curr[3] - j);
      if (currBest > best) {
        best = currBest;
        res = curr;
      }
    }
    printf("%d %d %d %d\n", res[0], res[1], res[2], res[3]);
  }
}
