// [
//   [1, 0, 1, 1, 1],
//   [1, 0, 1, 0, 1],
//   [1, 0, 1, 1, 1],
//   [1, 1, 1, 0, 1],
//   [0, 0, 0, 0, 1],
// ];

function solution(maps) {
  let n = maps.length;
  let m = maps[0].length;
  let dir = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
  ]; // 상하좌우

  const bfs = () => {
    let queue = [[0, 0, 1]]; // 행, 열, 이동거리
    maps[0][0] = 0; // 이동한 위치 0으로 표시

    while (queue.length > 0) {
      console.log(queue);
      //큐가 비어있지 않는 동안 반복
      let [row, col, distance] = queue.shift();

      // 도착시 값 리턴
      if (row == n - 1 && col == m - 1) {
        return distance;
      }

      // 이동가능한지 상하좌우로 확인
      for (let [r, c] of dir) {
        let newRow = row + r;
        let newCol = col + c; //현재 위치에서 상하좌우로 이동한 새로운 위치

        // 새로운 위치가 맵 내에 있고 벽이 아닐 시 이동 가능
        if (
          newRow >= 0 &&
          newRow < n &&
          newCol >= 0 &&
          newCol < m &&
          maps[newRow][newCol] === 1
        ) {
          queue.push([newRow, newCol, distance + 1]);
          maps[newRow][newCol] = 0; // 방문한 위치를 0으로 표시
        }
      }
    }
    return -1;
  };

  return bfs();
}

console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 1],
    [0, 0, 0, 0, 1],
  ])
); //11
