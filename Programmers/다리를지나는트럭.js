function solution(bridge_length, weight, truck_weights) {
  var answer = 0;
  const queue = Array(bridge_length).fill(0);

  while (queue.length) {
    console.log(queue);
    queue.shift();
    console.log(queue);
    if (truck_weights.length) {
      if (queue.reduce((a, b) => a + b, 0) + truck_weights[0] <= weight) {
        queue.push(truck_weights.shift());
      } else {
        queue.push(0);
      }
    }
    answer++;
  }

  return answer;
}

console.log(solution(2, 10, [7, 4, 5, 6])); // 8
// console.log(solution(100, 100, [10])); // 101
// console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10])); // 110
