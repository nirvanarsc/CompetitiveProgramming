#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

bool isDecimal(string s) {
  int dotIdx = -1;
  bool sign = false;
  for (int i = 0; i < s.length(); i++) {
    char c = s[i];
    if (c == '+' || c == '-') {
      if (i > 0) {
        return false;
      }
      sign = true;
    } else if (c == '.') {
      if (dotIdx != -1) {
        return false;
      }
      dotIdx = i;
    }
  }
  int l = dotIdx - (sign ? 1 : 0);
  int r = s.length() - (dotIdx + 1);
  return l > 0 || r > 0;
}

bool isInteger(string s) {
  if (s.find('.') != string::npos) {
    return false;
  }
  int digits = 0;
  for (int i = 0; i < s.length(); i++) {
    char c = s[i];
    if (c == '+' || c == '-') {
      if (i > 0) {
        return false;
      }
    } else {
      digits++;
    }
  }
  return digits > 0;
}

bool isNumber(string s) {
  int eIdx = -1;
  for (int i = 0; i < s.length(); i++) {
    char c = tolower(s[i]);
    if (c == 'e') {
      if (eIdx != -1) {
        return false;
      }
      eIdx = i;
    } else if ('a' <= c && c <= 'z') {
      return false;
    }
  }
  if (eIdx == -1) {
    return s.find('.') != string::npos ? isDecimal(s) : isInteger(s);
  }
  string l = s.substr(0, eIdx);
  string r = s.substr(eIdx + 1, s.length() - eIdx);
  return isNumber(l) && isInteger(r);
}
