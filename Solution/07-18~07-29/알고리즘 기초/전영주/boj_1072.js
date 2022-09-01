//1072 게임
const fs = require("fs");
const [X, Y] = (
  process.platform === "linux" ? fs.readFileSync("/dev/stdin") : "10 8"
)
  .toString()
  .trim()
  .split(" ")
  .map(Number);
let Z = Math.floor((100 * Y) / X);
if (Math.floor((100 * (Y + X)) / (2 * X)) === Z) console.log(-1);
else {
  let s = 0;
  let e = X;
  let count = 0;
  let answer = 0;
  while (s <= e) {
    count = Math.floor((s + e) / 2);
    let score = Math.floor(((Y + count) / (X + count)) * 100);
    //count는 0~X X/2부터 시작하여 이분 탐색
    if (score === Z) s = count + 1;
    else if (score > Z) {
      e = count - 1;
      answer = count;
    }
  }
  console.log(answer);
}
