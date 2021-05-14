#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int _val) { val = _val; }
};

void flatten(TreeNode *root) { dfs(root); }

vector<TreeNode *> dfs(TreeNode *node) {
  if (node == nullptr) {
    return vector<TreeNode *>(2);
  }
  vector<TreeNode *> l = dfs(node->left);
  vector<TreeNode *> r = dfs(node->right);
  node->left = nullptr;
  node->right = (TreeNode *)l[0];
  if (l[1] != nullptr) {
    l[1]->right = (TreeNode *)r[0];
  } else {
    node->right = (TreeNode *)r[0];
  }
  return {node, r[1] == nullptr ? l[1] == nullptr ? node : l[1] : r[1]};
}
