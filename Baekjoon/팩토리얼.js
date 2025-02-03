// const fs = require("fs");
// const input = parseInt(fs.readFileSync("/dev/stdin").toString().trim());

// *0일때 고려하기
const factorial = (n) => {
  if (n === 1 || n === 0) return 1;
  return n * factorial(n - 1);
};

console.log(factorial(10)); // 3628800
console.log(factorial(0));
