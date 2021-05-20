#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

struct TreeNode {
  int val;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int _val) { val = _val; }
};

vector<vector<int>> levelOrder(TreeNode* root) {
  deque<TreeNode*>* dq = new deque<TreeNode*>();
  if (root != nullptr) {
    dq->emplace_back(root);
  }

  vector<vector<int>>* res = new vector<vector<int>>();
  for (int level = 0; !dq->empty(); level++) {
    vector<int>* curr = new vector<int>();
    for (int size = (int)dq->size(); size > 0; size--) {
      TreeNode* node = dq->front();
      dq->pop_front();
      curr->push_back(node->val);
      if (node->left != nullptr) {
        dq->emplace_back(node->left);
      }
      if (node->right != nullptr) {
        dq->emplace_back(node->right);
      }
    }
    res->emplace_back(*curr);
  }
  return *res;
}
