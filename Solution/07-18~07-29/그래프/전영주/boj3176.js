//3176 도로네트워크
// LCA 시간복잡도 이분 탐색으로 O(log N)
const fs = require("fs");
let [N, ..._arr] = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `5
2 3 100
4 3 200
1 5 150
1 3 50
3
2 4
3 5
1 2`
)
  .toString()
  .trim()
  .split("\n");
N = Number(N);
let K = Number(_arr.slice(N - 1, N));
for (let i = 0; i < N - 1; i++) {
  let [a, b, c] = _arr[i].split(" ").map(Number);
  init_tree();
}
let max_level = Math.ceil(Math.log2(N));
let parent = Array(N + 1).fill([0, 0]);
let tree = Array(N + 1).fill(0);
let level = Array(N + 1).fill(0);
let max_ = Array.from({ length: max_level }, Array.form({ length: N + 1 }, 0));
let min_ = Array.from(
  { length: max_level },
  Array.form({ length: N + 1 }, 1000000)
);
const init_tree = (node, depth) => {};
//공통조상 찾기, 공통에서 각각의 노드까지의 값들 배열에 저장.
const lca = (a, b) => {
  if (level[a] < level[b]) [a, b] = [b, a];
  let diff = level[a] - level[b];
  //이분탐색
  for (let k = 1; diff !== 0; k++) {
    if (diff & 1) a = parent[a][k]; //a의 2^s번째 조상
    diff >>= 1;
  }
  if (a === b) return a;
  for (let i = max_level - 1; i >= 0; i--) {
    if (parent[a][i] !== -1 && parent[a][i] !== parent[v][i]) {
      a = parent[a][i];
      b = parent[b][i];
    }
  }
  return parent[a][0];
};
