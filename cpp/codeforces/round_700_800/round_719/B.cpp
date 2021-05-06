#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;
using ll = long long;

int main() {
  fast_io;
  int t;
  cin >> t;
  array<ll, 9> s = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  for (int test = 0; test < t; test++) {
    int n;
    cin >> n;
    if (n < 10) {
      cout << n << "\n";
      continue;
    }
    array<ll, 9> c = array<ll, 9>();
    copy(s.begin(), s.end(), c.begin());
    int res = 9;
    while (true) {
      for (int i = 0; i < s.size(); i++) {
        ll curr = c[i] * 10L + s[i];
        if (curr > n) {
          goto end;
        }
        res++;
        c[i] = curr;
      }
    }
  end:
    cout << res << "\n";
  }
}
