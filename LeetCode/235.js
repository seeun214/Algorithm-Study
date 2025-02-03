// 235. Lowest Common Ancestor of a Binary Search Tree
// LCA(최소 공통 조상)란?
// LCA는 두 노드 p와 q가 모두 자손으로 존재하는 가장 낮은(가장 가까운) 조상 노드를 의미합니다. 즉, p와 q를 포함하는 가장 깊은 노드입니다.

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  while (root) {
    // 현재 노드의 값이 p와 q의 값보다 클 경우
    if (root.val > p.val && root.val > q.val) {
      root = root.left; // 왼쪽 이동
      // 현재 노드의 값이 p와 q의 값보다 작을 경우
    } else if (root.val < p.val && root.val < q.val) {
      root = root.right; // 오른쪽 이동
      // 현재 노드의 값이 p와 q의 값 사이에 있을 경우
    } else {
      return root; // 현재 노드가 LCA
    }
  }
  return null;
};

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// 트리 생성
const root = new TreeNode(6);
root.left = new TreeNode(2);
root.right = new TreeNode(8);
root.left.left = new TreeNode(0);
root.left.right = new TreeNode(4);
root.left.right.left = new TreeNode(3);
root.left.right.right = new TreeNode(5);
root.right.left = new TreeNode(7);
root.right.right = new TreeNode(9);

const p = root.left; // Node 2
const q = root.right; // Node 8

console.log(lowestCommonAncestor(root, p, q)); // 출력: Node 6

const p2 = root.left; // Node 2
const q2 = root.left.right; // Node 4

console.log(lowestCommonAncestor(root, p2, q2)); // 출력: Node 2
