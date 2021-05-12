#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

struct BIT {
  int n;
  int* data;

  BIT(int _n) {
    n = _n;
    data = (int*)calloc(n + 1, sizeof(int));
  }

  void add(int idx, int val) {
    for (int i = idx + 1; i <= n; i += lsb(i)) {
      data[i] += val;
    }
  }

  int sum(int idx) {
    int res = 0;
    for (int i = idx + 1; i > 0; i -= lsb(i)) {
      res += data[i];
    }
    return res;
  }

  int sum(int l, int r) { return sum(r) - sum(l - 1); }

  int query(int k) {
    int lo = 0;
    int hi = n;
    while (lo < hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (k > sum(mid)) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }

  int lsb(int i) {
    return i & -i;  // zeroes all the bits except the least significant one
  }
};

BIT* bit;

signed main() {
  fast_io;
  int n, q;
  cin >> n >> q;
  bit = new BIT(n + 5);
  for (int i = 0; i < n; i++) {
    int v;
    cin >> v;
    bit->add(v, 1);
  }
  for (int i = 0; i < q; i++) {
    int v;
    cin >> v;
    if (v < 0) {
      int idx = bit->query(-v);
      bit->add(idx, -1);
    } else {
      bit->add(v, 1);
    }
  }
  int res = bit->query(1);
  if (res == n + 5) {
    cout << 0 << "\n";
  } else {
    cout << res << "\n";
  }
}
