#include <bits/stdc++.h>
using namespace std;

struct BIT {
  int n;
  vector<int> data;

  BIT(int _n) {
    n = _n;
    data.resize(n + 1, 0);
  }

  void add(int idx, long val) {
    for (int i = idx + 1; i <= n; i += lsb(i)) {
      data[i] += val;
    }
  }

  long sum(int idx) {
    long res = 0;
    for (int i = idx + 1; i > 0; i -= lsb(i)) {
      res += data[i];
    }
    return res;
  }

  long sum(int l, int r) { return sum(r) - sum(l - 1); }

  int query(int k) {
    int lo = 0;
    int hi = n;
    for (int i = 0; i < 10; i++) {
      cout << sum(i);
    }
    cout << "\n";

auto lambda = [&](auto mid, auto k) -> bool {
  cout << sum(mid) << " " << mid << " " << k << " " << n << "\n";
    return k < sum(mid);
};
  int idx = data.begin() - data.begin();
  int end = data.end() - data.begin();
// cout << idx << " " << end << " " << n << "\n";
cout << lower_bound(data.begin(), data.end(), k, lambda) - data.begin() << "\n";
cout << "\n";
    return lower_bound(data.begin(), data.end(), k, lambda) - data.begin();
    // while (lo < hi) {
    //   int mid = lo + ((hi - lo) >> 1);
    //   if (k > sum(mid)) {
    //     lo = mid + 1;
    //   } else {
    //     hi = mid;
    //   }
    // }
    // return lo;
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
  vector<string> v = {"a", "b", "c", "d", "e", "f", "g" };
  PlaylistQueue* pq;
  pq = new PlaylistQueue(v);
  cout << pq->play(6) << "\n";
  // cout << pq->play(1) << "\n";
  // cout << pq->play(2) << "\n";
  // cout << pq->play(0) << "\n";
}
