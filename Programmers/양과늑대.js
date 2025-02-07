function solution(info, edges) {
  let graph = Array.from({ length: info.length }, () => []);

  // 그래프를 인접 리스트로 변환(노드 i에 연결된 자식 노드들을 저장)
  for (const [parent, child] of edges) {
    graph[parent].push(child);
  }

  let maxSheep = 0;

  // 백트래킹 탐색
  function dfs(sheep, wolf, curNode, availableNodes) {
    // 현재 양의 개수 업데이트
    if (info[curNode] === 0) sheep++;
    else wolf++;

    // 늑대가 양보다 많아지면 중단
    if (wolf >= sheep) return;

    // 최대 양 개수 갱신
    maxSheep = Math.max(maxSheep, sheep);

    console.log(availableNodes);

    // 현재 가능한 이동 노드에서 현재 노드 제거 후, 다음 노드들 추가
    let nextNodes = availableNodes.filter((node) => node !== curNode);
    nextNodes.push(...graph[curNode]);

    // 다음 가능한 모든 노드 탐색 (백트래킹)
    for (const next of nextNodes) {
      dfs(sheep, wolf, next, nextNodes);
    }
  }

  dfs(0, 0, 0, [0]); // 루트(0)에서 시작

  return maxSheep;
}

console.log(
  solution(
    [0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1],
    [
      [0, 1],
      [1, 2],
      [1, 4],
      [0, 8],
      [8, 7],
      [9, 10],
      [9, 11],
      [4, 3],
      [6, 5],
      [4, 6],
      [8, 9],
    ]
  )
);
