#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

int main() {
  fast_io;
  int t;
  cin >> t;
  for (int test = 0; test < t; test++) {
    int n;
    cin >> n;
    string s;
    cin >> s;
    bool* seen = new bool[26];
    fill_n(seen, 26, false);
    bool ok = true;
    for (int i = 0; i < n; i++) {
      if (seen[s[i] - 'A']) {
        ok = false;
        break;
      }
      seen[s[i] - 'A'] = true;
      int j = i;
      while (j < n && s[j] == s[i]) {
        j++;
      }
      i = j - 1;
    }
    if (!ok) {
      cout << "NO"
           << "\n";
    } else {
      cout << "YES"
           << "\n";
    }
  }
}
