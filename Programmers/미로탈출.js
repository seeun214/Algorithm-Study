// 레버를 찾아 당긴 후 문을 통해 빠져나가기

function solution(maps) {
  let n = maps.length;
  let m = maps[0].length;
  let dir = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
  ];

  let start, lever, exit;

  // 시작점, 레버, 출구 위치 찾기
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      // console.log(maps[i]);
      if (maps[i][j] === "S") start = [i, j];
      if (maps[i][j] === "L") lever = [i, j];
      if (maps[i][j] === "E") exit = [i, j];
    }
  }
  // BFS 탐색 함수
  const bfs = (start, target) => {
    let queue = [[start[0], start[1], 0]];
    let visited = Array.from({ length: n }, () => Array(m).fill(false));
    visited[start[0]][start[1]] = true;

    while (queue.length) {
      let [row, col, distance] = queue.shift();
      if (row === target[0] && col === target[1]) return distance;
      for (let [r, c] of dir) {
        let newRow = row + r;
        let newCol = col + c;
        if (
          newRow >= 0 &&
          newRow < n &&
          newCol >= 0 &&
          newCol < m &&
          maps[newRow][newCol] !== "X" &&
          !visited[newRow][newCol]
        ) {
          queue.push([newRow, newCol, distance + 1]);
          visited[newRow][newCol] = true;
        }
      }
    }
    return -1;
  };

  let toLever = bfs(start, lever);
  if (toLever === -1) return -1;

  let toExit = bfs(lever, exit);
  if (toExit === -1) return -1;

  return toLever + toExit;
}

console.log(solution(["SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"])); // 16
console.log(solution(["LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"])); // -1
