function solution(x, y, n) {
  //x에서 y로 이동할 때 최소한의 연산 횟수를 구하는 동적 계획법 알고리즘
  const dp = Array(y + 1).fill(0);
  console.log(dp);

  for (let i = x; i <= y; i++) {
    if (i !== x && dp[i] === 0) {
      dp[i] = -1;
      continue;
    }

    if (i * 2 <= y) {
      //10 * 2 dp[20] = dp[10] + 1 = 1
      //20 * 2 dp[40] = dp[20] + 1 = 2
      dp[i * 2] = dp[i * 2] === 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
    }

    if (i * 3 <= y) {
      dp[i * 3] = dp[i * 3] === 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
    }

    if (i + n <= y) {
      dp[i + n] = dp[i + n] === 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
    }
  }

  return dp[y];
}

// 예제 실행
console.log(solution(10, 40, 5));
