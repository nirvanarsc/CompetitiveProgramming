#include <bits/stdc++.h>
#define fast_io                \
  ios::sync_with_stdio(false); \
  cin.tie(nullptr);
using namespace std;

struct ListNode {
  int val;
  ListNode* next;
  ListNode(int _val, ListNode* _next) {
    val = _val;
    next = _next;
  }
};
struct TreeNode {
  int val;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int _val) { val = _val; }
};

TreeNode* sortedListToBST(ListNode* head) {
  if (head == nullptr) {
    return nullptr;
  }
  if (head->next == nullptr) {
    return new TreeNode(head->val);
  }
  ListNode* dummy = new ListNode(-1, head);
  ListNode* slow = dummy;
  ListNode* fast = dummy;
  while (fast->next != nullptr && fast->next->next != nullptr) {
    fast = fast->next->next;
    slow = slow->next;
  }
  ListNode* right = slow->next->next;
  ListNode* root = slow->next;
  slow->next->next = nullptr;
  slow->next = nullptr;
  TreeNode* res = new TreeNode(root->val);
  res->left = sortedListToBST(dummy->next);
  res->right = sortedListToBST(right);
  return res;
}
