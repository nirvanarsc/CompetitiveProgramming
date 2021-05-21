#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
  vector<string>* res = new vector<string>();
  int n = pattern.length();
  for (string w : words) {
    if (match(pattern, n, w)) {
      res->push_back(w);
    }
  }
  return *res;
}

bool match(string& pattern, int n, string& w) {
  char mapL[26];
  char mapR[26];
  memset(mapL, '*', sizeof mapL);
  memset(mapR, '*', sizeof mapR);
  for (int i = 0; i < n; i++) {
    int l = w[i] - 'a';
    int r = pattern[i] - 'a';
    if (mapL[l] != '*') {
      if (mapL[l] != pattern[i]) {
        return false;
      }
    } else {
      mapL[l] = pattern[i];
    }
    if (mapR[r] != '*') {
      if (mapR[r] != w[i]) {
        return false;
      }
    } else {
      mapR[r] = w[i];
    }
  }
  return true;
}
