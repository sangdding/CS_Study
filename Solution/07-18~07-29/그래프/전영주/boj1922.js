//1922 네트워크 연결
// 무향 그래프. 최소 스패닝 트리
const fs = require("fs");
let [N, M, ..._arr] = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `6
    9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8`
)
  .toString()
  .trim()
  .split("\n");
for (let i = 0; i < M; i++) {
  _arr[i] = _arr[i].split(" ").map(Number);
}
let cost = 0;
N = Number(N);
let arr = Array.from({ length: N + 1 }, (v, i) => i);
_arr.sort(function (a, b) {
  return a[2] - b[2];
});

const union = (a, b) => {
  let aRoot = find(a);
  let bRoot = find(b);
  arr[aRoot] = bRoot;
};
const find = (a) => {
  if (arr[a] === a) return a;
  else return (arr[a] = find(arr[a]));
};

//크루스칼 알고리즘
for (let i = 0; i < M; i++) {
  if (find(_arr[i][0]) != find(_arr[i][1])) {
    union(_arr[i][0], _arr[i][1]);
    cost += _arr[i][2];
  }
}
console.log(cost);
