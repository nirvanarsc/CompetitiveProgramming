#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;
using ll = long long;

ll f(vector<int>& a, vector<int>& b, vector<int>& revB, ll mid) {
  ll count = 0;
  for (int num : a) {
    // take pointer only !! use &
    vector<int>& search = num > 0 ? b : revB;
    int lo = 0;
    int hi = (int)b.size();
    while (lo < hi) {
      int m = lo + hi >> 1;
      if ((ll)num * search[m] < mid) {
        lo = m + 1;
      } else {
        hi = m;
      }
    }
    count += lo;
  }
  return count;
}

int solve(vector<int>& a, vector<int>& b, int k) {
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());

  vector<int> revB = vector<int>(b.size());
  copy(b.begin(), b.end(), revB.begin());
  reverse(revB.begin(), revB.end());

  ll lo = (ll)-5e18;
  ll hi = (ll)5e18;

  ll complement = (ll)a.size() * b.size() - k - 1;
  while (lo < hi) {
    ll mid = lo + hi + 1 >> 1;
    if (f(a, b, revB, mid) > complement) {
      hi = mid - 1;
    } else {
      lo = mid;
    }
  }
  return (int)lo;
}
