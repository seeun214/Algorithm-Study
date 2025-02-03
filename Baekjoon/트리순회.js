let input = "7\nA B C\nB D .\nC E F\nE . .\nF . G\nD . .\nG . .";
const treeInput = input.trim().split("\n");
const N = Number(treeInput.shift());
let result = "";

console.log(N);
console.log(treeInput);

const tree = {};
for (let i = 0; i < N; i++) {
  const [node, left, right] = treeInput[i].split(" ");
  tree[node] = [left, right];
}

// 전위 순회(루트 -> 왼쪽 -> 오른쪽)
function preorder(node) {
  if (node === ".") return;
  const [left, right] = tree[node];
  result += node;
  preorder(left);
  preorder(right);
}

// 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
function inorder(node) {
  if (node === ".") return;
  const [left, right] = tree[node];
  inorder(left);
  result += node;
  inorder(right);
}

// 후위 순회(왼쪽 -> 오른쪽 -> 루트)
function postorder(node) {
  if (node === ".") return;
  const [left, right] = tree[node];
  postorder(left);
  postorder(right);
  result += node;
}
console.log(tree);

preorder("A");
result += "\n";
inorder("A");
result += "\n";
postorder("A");

console.log(result);
