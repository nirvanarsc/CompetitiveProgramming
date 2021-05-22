#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

class Tree {
 public:
  int val;
  Tree* left;
  Tree* right;
};

bool dfs(Tree* node, int target, int idx) {
  if (idx == -1) {
    return node != nullptr;
  }
  if (node == nullptr) {
    return false;
  }
  return (target & (1 << idx)) ? dfs(node->right, target, idx - 1) : dfs(node->left, target, idx - 1);
}

bool solve(Tree* root, int target) {
  int n = 0;
  for (int i = 31; i >= 0; i--) {
    if (target & (1 << i)) {
      n = i;
      break;
    }
  }
  return target && dfs(root, target, n - 1);
}
