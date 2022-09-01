//2805 나무자르기
const fs = require("fs");
const [NM, _arr] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let [N, M] = NM.split(" ").map(Number);
let arr = _arr.split(" ").map(Number);
let height = Math.max(...arr);
let depth = Math.max(...arr) - M;
let mid = 0;
//sum>m :s=m+1
//sum=m: 종료
//sum<m:endpoint =m+1
while (height >= depth) {
  mid = Math.floor((height + depth) / 2);
  let sum = 0;
  arr.forEach((e) => {
    if (e >= mid) sum += e - mid;
  });
  if (sum == M) {
    console.log(mid);
    break;
  } else if (sum >= M) depth = mid + 1;
  else height = mid - 1;
}
if (height < depth) console.log(height);
