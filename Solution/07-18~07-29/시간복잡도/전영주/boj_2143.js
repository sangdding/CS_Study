//2143 두 배열의 합
const fs = require("fs");
const [T, Anum, a_, Bnum, b_] = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : "5\n" + "4\n" + "1 3 1 2\n" + "3\n" + "1 3 2"
)
  .toString()
  .trim()
  .split("\n");
let a_arr = a_.split(" ").map(Number);
let b_arr = b_.split(" ").map(Number);
// console.log(N,Anum,Bnum,a_arr,b_arr)
// 부분 배열의 합 구하기
// 정렬, 오름차순 내림차순
// 같을 경우 중복 해결
let a_sub = [];
let b_sub = [];
for (let i = 0; i < Anum; i++) {
  for (let j = i + 1; j <= Anum; j++) {
    a_sub.push(
      a_arr.slice(i, j).reduce(function add(s, c) {
        return s + c;
      }, 0)
    );
  }
}
for (let i = 0; i < Bnum; i++) {
  for (let j = i + 1; j <= Bnum; j++) {
    b_sub.push(
      b_arr.slice(i, j).reduce(function add(s, c) {
        return s + c;
      }, 0)
    );
  }
}
a_sub.sort(function (a, b) {
  return a - b;
});
b_sub.sort(function (a, b) {
  return b - a;
});

let aPointer = 0;
let bPointer = 0;
let answer = 0;
let sum = 0;
let N = Number(T);
while (aPointer < a_sub.length || bPointer < b_sub.length) {
  let curA = a_sub[aPointer];
  let curB = b_sub[bPointer];
  sum = a_sub[aPointer] + b_sub[bPointer];
  if (sum < N) {
    aPointer++;
  } else if (sum > N) {
    bPointer++;
  } else {
    let countA = 0;
    let countB = 0;
    while (aPointer < a_sub.length && a_sub[aPointer] === curA) {
      countA++;
      aPointer++;
    }
    while (bPointer < b_sub.length && b_sub[bPointer] === curB) {
      countB++;
      bPointer++;
    }
    answer += countA * countB;
  }
}
console.log(answer);
