//
// 아직 미해결
// 이분 탐색으로 해야함
//
const fs = require("fs");
const [NM,_arr] = (
    process.platform === "linux"
        ? fs.readFileSync("/dev/stdin")
        : fs.readFileSync('input.txt')
)
    .toString()
    .trim()
    .split("\n");
let [N,M]=NM.split(" ").map(Number)
let arr=_arr.split(" ").map(Number)
let sum=0;
let height=Math.max(...arr);
let depth=Math.max(...arr)-M;
let start=0;
//sum>m :s=m+1
//sum=m: 종료
//sum<m:endpoint =m+1
while(true) {


}
check(height,depth);

function check(h,d){
    let sum=0;
    arr.forEach(e=>{
        if(e>=height) sum+=(e-height)
    })
    if(sum>M) {// depth를 올려야함
        check(h, d + 1)
        if (sum <= M) return console.log(height);
        height++;
    }else{// height를 내려야
        if(sum>=M) return console.log(height)
        height--;
        
        }
}
