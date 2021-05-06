#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;
using ll = long long;
using p = pair<int, int>;

int DIRS[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
vector<vector<int>> g;

ll* bfs(int sx, int sy, int n, int m, int w) {
  ll* res = new ll[n * m];
  fill_n(res, n * m, (ll)3e18);
  queue<array<ll, 3>>* q = new queue<array<ll, 3>>();
  q->push({0, sx, sy});
  res[sx * m + sy] = 0;
  while (q->size() > 0) {
    auto curr = q->front();
    q->pop();
    ll cost = curr[0];
    int x = (int)curr[1];
    int y = (int)curr[2];
    if (res[x * m + y] < cost) {
      continue;
    }
    res[x * m + y] = cost;
    for (int i = 0; i < 4; i++) {
      int nx = DIRS[i][0] + x;
      int ny = DIRS[i][1] + y;
      if (0 <= nx && nx < n && 0 <= ny && ny < m && g[nx][ny] != -1) {
        ll nw = cost + w;
        if (res[nx * m + ny] > nw) {
          res[nx * m + ny] = nw;
          q->push({nw, nx, ny});
        }
      }
    }
  }
  return res;
}

int main() {
  fast_io;
  int n, m, w;
  cin >> n >> m >> w;
  g = vector<vector<int>>(n);
  vector<p>* portals = new vector<p>;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      int u;
      cin >> u;
      g[i].push_back(u);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (g[i][j] > 0) {
        portals->push_back(make_pair(i, j));
      }
    }
  }
  ll* start = bfs(0, 0, n, m, w);
  ll* end = bfs(n - 1, m - 1, n, m, w);
  ll res = start[n * m - 1];
  ll left = (ll)3e18;
  ll right = (ll)3e18;
  for (auto pp = portals->begin(); pp != portals->end(); pp++) {
    int u = pp->first;
    int v = pp->second;
    left = min(left, g[u][v] + start[u * m + v]);
    right = min(right, g[u][v] + end[u * m + v]);
  }
  res = min(res, left + right);
  cout << ((res == (ll)3e18) ? -1 : res) << "\n";
}
