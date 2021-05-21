#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

class BooleanArray {
  unordered_map<int, int>* timeMap;
  unordered_map<int, int>* valMap;
  int time;
  int all = -1;
  bool def;

 public:
  BooleanArray() {
    timeMap = new unordered_map<int, int>();
    valMap = new unordered_map<int, int>();
    time = 0;
    def = false;
  }

  void setTrue(int i) {
    (*timeMap)[i] = time++;
    (*valMap)[i] = 1;
  }

  void setFalse(int i) {
    (*timeMap)[i] = time++;
    (*valMap)[i] = 0;
  }

  void setAllTrue() {
    def = true;
    all = time;
  }

  void setAllFalse() {
    def = false;
    all = time;
  }

  bool getValue(int i) {
    if (timeMap->count(i) == 0) {
      return def;
    }
    int t = (*timeMap)[i];
    return t < all ? def : (*valMap)[i] > 0;
  }
};
