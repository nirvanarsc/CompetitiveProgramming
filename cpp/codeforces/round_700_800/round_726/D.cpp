#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;
using ll = long long;

unordered_map<string, int>* dp;

int dfs(int n, int turn) {
  if (n % 2 != 0) return n == 9 || n == 25;
  if (n == 2) return 1;
  string key = n + "," + turn;
  if (dp->count(key) > 0) return (*dp)[key];
  int res = turn ^ 1;
  for (int p = 2; (ll) p * p <= n; p++) {
    if (n % p == 0) {
      if (turn)
        res |= dfs(n - p, 0);
      else
        res &= dfs(n - p, 1);
    }
  }
  return (*dp)[key] = res;
}

int main() {
  fast_io;
  int t;
  cin >> t;
  for (int test = 0; test < t; test++) {
    dp = new unordered_map<string, int>();
    int n;
    cin >> n;
    cout << (dfs(n, 1) == 1 ? "Alice" : "Bob") << "\n";
  }
}
