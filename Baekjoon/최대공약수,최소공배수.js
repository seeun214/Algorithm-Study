// const fs = require("fs");
// const input = fs
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split(" ")
//   .map((item) => Number(item));

let [a, b] = [24, 18];

// * 유클리드 호제법 (최대공약수 찾는 방법)
// a와 b라는 자연수를 나눈 나머지가 r이다.
// r이 0이 되는 순간까지 반복한다. 그 때의 b가 최대공약수이다.

//1. 최대공약수(두 수의 공통된 약수 중 가장 큰 값)
const gcd = (x, y) => {
  while (y !== 0) {
    [x, y] = [y, x % y];
  }
  return x;
};

// 2. 최소공배수(두 수의 공톤된 배수 중 가장 작은 값)
//두 수의 곱 / 최대공약수
const lcm = (a, b, gcdValue) => (a * b) / gcdValue;

// 계산 시작
const gcdValue = gcd(a, b);
const lcmValue = lcm(a, b, gcdValue);

// 결과 출력
console.log(gcdValue);
console.log(lcmValue);
