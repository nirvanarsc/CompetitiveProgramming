#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

vector<int> solve(vector<vector<int>>& requests, int k) {
  int n = requests.size();
  vector<vector<int>>* req = new vector<vector<int>>(n);

  copy(requests.begin(), requests.end(), req->begin());

  auto byStart = [](vector<int>& l, vector<int>& r) -> bool { return l[0] < r[0]; };
  auto byEnd = [](vector<int>& l, vector<int>& r) -> bool { return l[1] < r[1]; };

  sort(req->begin(), req->end(), byStart);
  int earliest = (*req)[k][0];
  sort(req->begin(), req->end(), byEnd);
  int latest = (*req)[k][1];

  vector<int>* res = new vector<int>();
  for (int i = 0; i < n; i++) {
    if (earliest <= requests[i][1] && requests[i][0] <= latest) {
      res->push_back(i);
    }
  }
  return *res;
}
