#include <bits/stdc++.h>
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
      sum += val;
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

SegTree* st;

class PlaylistQueue {
  unordered_map<int, string> mp;
  int last;

 public:
  PlaylistQueue(vector<string>& songs) {
    int n = songs.size() + (int)1e5;
    int* arr = (int*)calloc(n, sizeof(int));
    for (int i = 0; i < songs.size(); i++) {
      mp[i] = songs[i];
      arr[i] = 1;
    }
    st = new SegTree(0, n - 1, arr);
    last = songs.size();
  }

  string play(int i) {
    int idx = st->query(i + 1);
    string res = mp[idx];
    st->update(idx, -1);
    st->update(last, 1);
    mp[last++] = res;
    return res;
  }
};

signed main() {
  vector<string> v = {"a", "b", "c"};
  PlaylistQueue* pq;
  pq = new PlaylistQueue(v);
  cout << pq->play(0) << "\n";
  cout << pq->play(1) << "\n";
  cout << pq->play(2) << "\n";
  cout << pq->play(0) << "\n";
}
