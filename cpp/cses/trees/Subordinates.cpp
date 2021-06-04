#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

vector<vector<int>> g;
int* res;

void dfs(int u, int p) {
  res[u] = 1;
  for (int v : g[u]) {
    if (v != p) {
      dfs(v, u);
      res[u] += res[v];
    }
  }
}

int main() {
  fast_io;
  int n;
  cin >> n;
  res = (int*)calloc(n, sizeof(int));
  g = vector<vector<int>>(n);
  for (int i = 1; i < n; i++) {
    int u;
    cin >> u;
    u--;
    g[u].push_back(i);
    g[i].push_back(u);
  }
  dfs(0, -1);
  for (int i = 0; i < n; i++) {
    cout << res[i] - 1 << "\n";
  }
}
