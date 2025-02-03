// 더하거나 뻬서 타겟 넘버 만들기
function solution(numbers, target) {
  var answer = 0;

  dfs(0, 0);

  // 깊이 우선 탐색
  function dfs(index, sum) {
    if (index === numbers.length) {
      if (sum === target) {
        answer++;
      }
      return;
    }

    // 더하거나 빼서 모든 경우 탐색
    dfs(index + 1, sum + numbers[index]);
    dfs(index + 1, sum - numbers[index]);
  }

  return answer;
}

console.log(solution([1, 1, 1, 1, 1], 3)); // 5
console.log(solution([4, 1, 2, 1], 4)); // 2
