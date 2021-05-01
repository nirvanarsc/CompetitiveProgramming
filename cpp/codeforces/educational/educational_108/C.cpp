#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using ll = long long;
using namespace std;

signed main() {
  fast_io;
  int t;
  cin >> t;
  for (int test = 0; test < t; test++) {
    int n;
    cin >> n;
    int u[n];
    int s[n];
    vector<vector<int>> g(n);
    for (int i = 0; i < n; i++) {
      cin >> u[i];
      u[i]--;
    }
    for (int i = 0; i < n; i++) {
      cin >> s[i];
      g[u[i]].push_back(s[i]);
    }
    unordered_map<int, vector<ll>> map;
    unordered_map<int, vector<ll>> pre;
    for (int i = 0; i < n; i++) {
      if (g[i].size() > 0) {
        sort(g[i].begin(), g[i].end());
        reverse(g[i].begin(), g[i].end());
        if (!map.count(g[i].size())) {
          map[g[i].size()] = vector<ll>(g[i].size());
        }
        for (int j = 0; j < g[i].size(); j++) {
          map[g[i].size()][j] += g[i][j];
        }
      }
    }
    int maxL = 0;
    for (auto it = map.begin(); it != map.end(); ++it) {
      maxL = max(maxL, it->first);
      pre[it->first] = vector<ll>(it->first + 1);
      for (int j = 1; j <= it->second.size(); j++) {
        pre[it->first][j] = pre[it->first][j - 1] + it->second[j - 1];
      }
    }
    ll* res = (ll*)(calloc(n, sizeof(ll)));
    for (int L = 1; L <= maxL; L++) {
      for (auto it = map.begin(); it != map.end(); ++it) {
        res[L - 1] += pre[it->first][it->first - (it->first % L)];
      }
    }
    for (int i = 0; i < n; i++) {
      cout << res[i] << " ";
    }
    cout << "\n";
  }
}
