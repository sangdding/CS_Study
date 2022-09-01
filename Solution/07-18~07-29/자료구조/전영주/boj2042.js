//2042 구간 합 구하기
const fs = require("fs");
const input = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin")
    : `5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5`
)
  .toString()
  .trim()
  .split("\n");
let [N, M, K] = input.shift().split(" ").map(Number);
let arr = [];
for (let i = 0; i < N; i++) {
  arr.push(Number(input.shift()));
}
// 입력완료

const init_tree = (start, end, index) => {
  // s랑 e가 같다면 리프 노드
  if (start == end) {
    tree[index] = arr[start - 1];
    return tree[index];
  }
  let mid = Math.floor((start + end) / 2);
  // 노드는 자식 노드들의 합
  // init은 bottom-up방식으로
  tree[index] =
    init_tree(start, mid, index * 2) + init_tree(mid + 1, end, index * 2 + 1);
  return tree[index];
};

const get_sum = (start, end, index, b, c) => {
  // start~end 범위가 b~c를 넘을 경우
  if (start > b || end < c) return 0;
  // start~end 범위가 node 값인 구간합 경우
  if (start >= b && end <= c) return tree[index];
  // get_sum은 top-down 방식
  let mid = Math.floor((start + end) / 2);
  let left = get_sum(start, mid, index * 2, b, c);
  let right = get_sum(mid + 1, end, index * 2 + 1, b, c);
  return left + right;
};

const update = (start, end, cur_index, update_index, diff) => {
  if (start > update_index || end < update_index) return;
  tree[cur_index] += diff;
  // 자식노드까지 바꿔주기
  if (start == end) return;
  let mid = Math.floor((start + end) / 2);
  // update는 top-down방식으로
  update(start, mid, cur_index * 2, update_index, diff);
  update(mid + 1, end, cur_index * 2 + 1, update_index, diff);
};

// 인덱스 트리 만들기
let tree = Array(N * 2).fill(0);
// 현재 노드 값은 index*2 의 값+ index*2+1의 값
init_tree(1, N, 1);
for (let i = 0; i < M + K; i++) {
  let [a, b, c] = input.shift().split(" ").map(Number);

  if (a == 1) {
    update(1, N, 1, b, c - arr[b - 1]);
    arr[b - 1] = c;
  } else {
    console.log(get_sum(1, N, 1, b, c));
  }
}
