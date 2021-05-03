#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;
using ll = long long;
using p = pair<int, int>;

const int MAXN = 2e5 + 10;
vector<p> g[MAXN];

int tin[MAXN], low[MAXN], comp[MAXN], root[MAXN];
int c_time, n, m, ncomps;
ll can[MAXN], dis[MAXN];
vector<int> curcomp;

void dfs(int u) {
  tin[u] = ++c_time;
  low[u] = tin[u];
  curcomp.push_back(u);
  for (auto p : g[u]) {
    int v = p.first;
    if (!tin[v]) {
      dfs(v);
      low[u] = min(low[u], low[v]);
    } else if (!comp[v])
      low[u] = min(low[u], tin[v]);
  }
  if (low[u] == tin[u]) {
    ncomps++;
    int x;
    root[ncomps] = u;
    do {
      x = curcomp.back();
      curcomp.pop_back();
      comp[x] = ncomps;
    } while (x != u);
  }
}

void dfs2(int u, ll d = 0) {
  dis[u] = d;
  for (auto p : g[u]) {
    int v = p.first;
    int c = p.second;
    if (comp[v] != comp[u]) continue;
    if (dis[v] == -1)
      dfs2(v, d + c);
    else {
      can[comp[u]] = gcd(can[comp[u]], abs(d + c - dis[v]));
    }
  }
}

int main() {
  fast_io;

  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int a, b, l;
    cin >> a >> b >> l;
    g[a].push_back(make_pair(b, l));
  }

  memset(dis, -1, sizeof dis);

  for (int i = 1; i <= n; i++)
    if (!comp[i]) dfs(i);

  for (int cc = 1; cc <= ncomps; cc++) dfs2(root[cc]);

  int q;
  cin >> q;
  while (q--) {
    int u, s, t;
    cin >> u >> s >> t;
    int cc = comp[u];
    if (can[cc] == 0) {
      if (s == 0)
        cout << "YES\n";
      else
        cout << "NO\n";
      continue;
    }
    ll curr_gcd = gcd(can[cc], t);
    if (s % curr_gcd != 0)
      cout << "NO\n";
    else
      cout << "YES\n";
  }
}
