#include <bits/stdc++.h>
using namespace std;

vector<int> solve(vector<vector<int>>& relations) {
  unordered_set<int> uniq;
  set<int> ts;
  long n = (long)(1e5);
  for (auto r : relations) {
    uniq.insert(n * r[0] + r[1]);
  }
  for (auto r : relations) {
    if (uniq.count(n * r[1] + r[0])) {
      ts.insert(r[0]);
      ts.insert(r[1]);
    }
  }
  vector<int> res;
  for (int t : ts) {
    res.push_back(t);
  }
  return res;
}
