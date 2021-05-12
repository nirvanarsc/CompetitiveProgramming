#include <bits/stdc++.h>
using namespace std;

class VirtuallyCloneableStacks {
  int* arr;
  int idx = 1;

 public:
  VirtuallyCloneableStacks() { arr = (int*)(calloc((int)(1e5 + 5), sizeof(int))); }

  void copyPush(int i) { arr[idx++] = arr[i] + 1; }

  void copyPop(int i) { arr[idx++] = arr[i] - 1; }

  int size(int i) { return arr[i]; }
};
