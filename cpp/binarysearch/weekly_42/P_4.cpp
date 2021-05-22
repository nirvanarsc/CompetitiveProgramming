#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

int diff(string& l, string& r) {
  int res = 0;
  for (int i = 0; i < 3; i++) {
    if (l[i] != r[i]) {
      res++;
    }
  }
  return res;
}

int solve(vector<string>& itinerary, vector<vector<string>>& edges) {
  unordered_map<string, int>* map = new unordered_map<string, int>();
  vector<string>* map2 = new vector<string>();
  int n = 0;
  for (vector<string> e : edges) {
    for (string u : e) {
      if (map->count(u) == 0) {
        (*map)[u] = n++;
        map2->push_back(u);
      }
    }
  }
  unordered_map<int, vector<int>>* g = new unordered_map<int, vector<int>>();
  for (vector<string> e : edges) {
    int u = (*map)[e[0]];
    int v = (*map)[e[1]];
    (*g)[u].push_back(v);
  }
  int m = itinerary.size();

  int** dp = new int*[n];
  for (int i = 0; i < n; i++) {
    dp[i] = (int*)malloc(m * sizeof(int));
    fill_n(dp[i], m, (int)1e9);
  }
  for (int i = 0; i < n; i++) {
    dp[i][m - 1] = diff(itinerary[m - 1], (*map2)[i]);
  }
  for (int idx = m - 2; idx >= 0; idx--) {
    for (int u = 0; u < n; u++) {
      if (g->count(u) == 0) {
        continue;
      }
      for (int v : (*g)[u]) {
        int cost = diff(itinerary[idx], (*map2)[u]);
        dp[u][idx] = min(dp[u][idx], dp[v][idx + 1] + cost);
      }
    }
  }
  int res = (int)1e9;
  for (int i = 0; i < n; i++) {
    res = min(res, dp[i][0]);
  }
  return res;
}
