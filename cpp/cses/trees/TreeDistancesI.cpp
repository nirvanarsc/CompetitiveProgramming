#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

vector<vector<int>> g;
int* dd;

void dfs(int u, int p, int d) {
  dd[u] = max(dd[u], d);
  for (int v : g[u]) {
    if (v != p) {
      dfs(v, u, d + 1);
    }
  }
}

int main() {
  fast_io;
  int n;
  cin >> n;
  g = vector<vector<int>>(n);
  for (int i = 0; i < (n - 1); i++) {
    int u, v;
    cin >> u >> v;
    u--;
    v--;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  dd = new int[n];
  fill_n(dd, n, 0);
  dfs(0, -1, 0);
  int l = 0;
  for (int i = 0; i < n; i++) {
    if (dd[i] > dd[l]) {
      l = i;
    }
  }
  fill_n(dd, n, 0);
  dfs(l, -1, 0);
  int r = 0;
  for (int i = 0; i < n; i++) {
    if (dd[i] > dd[r]) {
      r = i;
    }
  }
  dfs(r, -1, 0);
  for (int i = 0; i < n; i++) {
    cout << dd[i] << "\n";
  }
}
