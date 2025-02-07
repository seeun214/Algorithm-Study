// n*n 체스판에서 n개의 퀸을 서로 공격할 수 없도록 배치하는 경우의 수
const n = Number(8);
const queens = [];
let count = 0;

function isValid(x, y) {
  for (const [a, b] of queens) {
    // 같은 행,열에 있는 경우
    if (a === x || b === y) return false;
    // 대각선에 있는 경우
    if (Math.abs(a - x) === Math.abs(b - y)) return false;
  }
  return true;
}

function dfs(row) {
  // 모든 행에 퀸이 배치되어있다면 경우의 수 증가
  if (row === n) {
    count++;
    return;
  }

  // 현재 행에서 모든 열을 탐색하기
  for (let i = 0; i < n; i++) {
    if (!isValid(row, i)) continue;
    // 퀸 배치 후 다음 행으로 이동
    queens.push([row, i]);
    dfs(row + 1);
    // 백트래킹
    queens.pop();
  }
}

dfs(0);
console.log(count);
