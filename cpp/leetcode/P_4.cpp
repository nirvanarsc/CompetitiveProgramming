#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll MOD = 1L << 39;

int BASE = 100003;

ll getHash(ll* hash, ll* pow, int l, int r) {
  return (hash[r + 1] - ((__int128)hash[l] * pow[r - l + 1]) % MOD + MOD) % MOD;
}

int longestCommonSubpath(int f, vector<vector<int>>& paths) {
  int n = (int)paths.size();
  int minL = (int)1e9;
  for (auto p : paths) {
    minL = min(minL, (int)p.size());
  }
  ll pow[minL + 1];
  pow[0] = 1L;
  for (int i = 1; i <= minL; i++) {
    pow[i] = pow[i - 1] * BASE % MOD;
  }
  ll** hash = new ll*[n];
  for (int i = 0; i < n; i++) {
    int m = paths[i].size();
    hash[i] = (ll*)calloc(m + 1, sizeof(ll));

    for (int j = 1; j <= m; j++) {
      hash[i][j] = (hash[i][j - 1] * BASE + (paths[i][j - 1] + 1)) % MOD;
    }
  }

  int lo = 0;
  int hi = minL;

  while (lo < hi) {
    int mid = (lo + ((hi - lo) >> 1) + 1);
    int ok = 1;
    unordered_set<ll>* row = nullptr;
    for (int i = 0; i < n; i++) {
      if (row == nullptr) {
        row = new unordered_set<ll>();
        for (int j = 0; j <= (int)paths[i].size() - mid; j++) {
          row->emplace(getHash(hash[i], pow, j, j + mid - 1));
        }
      } else {
        unordered_set<ll>* next = new unordered_set<ll>;
        for (int j = 0; j <= (int)paths[i].size() - mid; j++) {
          if (row->count(getHash(hash[i], pow, j, j + mid - 1))) {
            next->emplace(getHash(hash[i], pow, j, j + mid - 1));
          }
        }
        row = next;
        if (row->empty()) {
          ok = 0;
          break;
        }
      }
    }
    if (ok) {
      lo = mid;
    } else {
      hi = mid - 1;
    }
  }
  return lo;
}
