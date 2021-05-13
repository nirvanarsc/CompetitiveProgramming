#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

vector<string> ambiguousCoordinates(string s) {
  vector<string>* res = new vector<string>();
  for (int i = 2; i < s.length() - 1; i++) {
    for (string l : f(s.substr(1, i - 1))) {
      for (string r : f(s.substr(i, s.length() - i - 1))) {
        res->push_back("(" + l + ", " + r + ")");
      }
    }
  }
  return *res;
}

vector<string> f(string w) {
  vector<string>* res = new vector<string>();
  if (ok(w)) {
    res->push_back(w);
  }
  if (w[w.length() - 1] == '0') {
    return *res;
  }
  for (int i = 1; i < w.length(); i++) {
    string l = w.substr(0, i);
    string r = w.substr(i);
    if (ok(l)) {
      res->push_back(l + "." + r);
    } else {
      break;
    }
  }
  return *res;
}

bool ok(string w) { return w.length() == 1 || w[0] != '0'; }
