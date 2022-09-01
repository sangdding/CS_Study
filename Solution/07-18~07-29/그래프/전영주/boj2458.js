//2458 키 순서
//N<=500, 모든 노드에서 다른 모든 노드까지의 연결 여부=> N이 큰 편(>50)이지만 계산이 간단해서 플로이드 워셜도 가능
const fs = require("fs");
let [NM, ..._arr] = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `6 7
1 3
1 5
3 4
5 4
4 2
4 6
5 2`
)
  .toString()
  .trim()
  .split("\n");

let [N, M] = NM.split(" ").map(Number);

// 인접 행렬 height[i][j]는 i번째 노드부터 j번째 노드 연결 여부
let height = Array.from({ length: N + 1 }, (v, i) =>
  Array.from({ length: N + 1 }, (a, b) => (i === b ? true : false))
);
for (let i = 0; i < M; i++) {
  let [a, b] = _arr[i].split(" ").map(Number);
  height[a][b] = true;
}
//floyd
for (let i = 1; i <= N; i++) {
  //경유지
  for (let j = 1; j <= N; j++) {
    //출발지
    for (let k = 1; k <= N; k++) {
      //도착지
      if (height[j][i] && height[i][k]) height[j][k] = true; //j->i연결 && i->k 연결 => j-> k연결
    }
  }
}
let answer = 0;
for (let i = 1; i <= N; i++) {
  let count = 0;
  for (let j = 1; j <= N; j++) {
    if (height[i][j] || height[j][i]) count++;
  }
  if (count === N) answer++;
}
console.log(answer);
