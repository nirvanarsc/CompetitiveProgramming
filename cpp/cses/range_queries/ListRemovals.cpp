#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

struct SegTree {
  int leftMost;
  int rightMost;
  SegTree* left;
  SegTree* right;
  int sum;

  SegTree(int _leftMost, int _rightMost, int* arr) {
    leftMost = _leftMost;
    rightMost = _rightMost;
    if (leftMost == rightMost) {
      sum = arr[leftMost];
    } else {
      const int mid = leftMost + ((rightMost - leftMost) >> 1);
      left = new SegTree(_leftMost, mid, arr);
      right = new SegTree(mid + 1, _rightMost, arr);
      recalc();
    }
  }

  void recalc() {
    if (leftMost == rightMost) {
      return;
    }
    sum = left->sum + right->sum;
  }

  // leftmost index where sum[0 ... idx] >= k
  int query(int k) {
    if (sum < k) {
      return -1;
    }
    if (leftMost == rightMost) {
      return leftMost;
    }
    const int ll = left->query(k);
    if (ll != -1) {
      return ll;
    }
    return right->query(k - left->sum);
  }

  void update(int idx, int val) {
    if (leftMost == rightMost) {
      sum -= val;
    } else {
      const int mid = leftMost + ((rightMost - leftMost) >> 1);
      if (idx <= mid) {
        left->update(idx, val);
      } else {
        right->update(idx, val);
      }
      recalc();
    }
  }
};

signed main() {
  fast_io;
  int n;
  cin >> n;
  int arr[n];
  int stArr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    stArr[i] = 1;
  }
  SegTree* st = new SegTree(0, n - 1, stArr);
  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;
    int idx = st->query(num);
    st->update(idx, 1);
    cout << arr[idx] << ' ';
  }
  cout << "\n";
}
