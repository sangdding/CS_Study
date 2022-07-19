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
let L=0
let sum=0
let answer=0;
let H=1;
while(H<=N){
    // 원하는 수와 같으면 high 다음꺼로
    // 원하는 수 보다 작으면 다음 원소 포함
    // 원하는 수보다 크면 다음 원소부터 시작
    sum=arr.slice(L,H).reduce(function add(s,c){return s+c;},0)
    if(sum===M){
        H++
        answer++
    }else if(sum>M){
        L++
    }else{
        H++
    }}


console.log(answer)
