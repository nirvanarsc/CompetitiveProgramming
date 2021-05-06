#include <bits/stdc++.h>
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

class PlaylistQueue {
  unordered_map<int, string> mp;
  int last;

 public:
  PlaylistQueue(vector<string>& songs) {
    bit = new BIT(songs.size() + (int)1e5);
    for (int i = 0; i < songs.size(); i++) {
      mp[i] = songs[i];
      bit->add(i, 1);
    }
    last = songs.size();
  }

  string play(int i) {
    int idx = bit->query(i + 1);
    string res = mp[idx];
    bit->add(idx, -1);
    bit->add(last, 1);
    mp[last++] = res;
    return res;
  }
};

signed main() {
  vector<string> v = {"a", "b", "c"};
  PlaylistQueue* pq = new PlaylistQueue(v);
  cout << pq->play(0) << "\n";
  cout << pq->play(1) << "\n";
  cout << pq->play(2) << "\n";
  cout << pq->play(0) << "\n";
}
