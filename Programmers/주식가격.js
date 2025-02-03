function solution(prices) {
  var answer = [];

  for (let i = 0; i < prices.length; i++) {
    let cnt = 0;
    for (let j = i + 1; j < prices.length; j++) {
      if (prices[i] <= prices[j]) {
        cnt++;
      } else {
        cnt++;
        break;
      }
    }
    answer.push(cnt);
  }
  return answer;
}
console.log(solution([1, 2, 3, 2, 3])); // [4, 3, 1, 1, 0]
