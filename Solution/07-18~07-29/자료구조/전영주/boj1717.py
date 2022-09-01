#1717 집합의 표현

import sys
input = sys.stdin.readline
print = sys.stdout.write


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    root1 = find(a)
    root2 = find(b)
    if root1 != root2:
        if rank[root1] > rank[root2]:
            parent[root2] = root1
        else:
            parent[root1] = root2
            if rank[root1] == rank[root2]:
                rank[root2] += 1


N, M = map(int, input().split())
parent = [i for i in range(N+1)]
rank = [0 for i in range(N+1)]

for i in range(M):
    cmd, a, b = map(int, input().split())
    if cmd==0:
        union(a, b)
    else:
        if find(a) == find(b):
            print("YES\n")
        else:
            print("NO\n")

            
# //js code 런타임 에러남.
# // const fs = require("fs");
# // const [NM,..._arr] = (
# //     process.platform === "linux"
# //         ? fs.readFileSync("/dev/stdin")
# //         : fs.readFileSync('input.txt')
# // )
# //     .toString()
# //     .trim()
# //     .split("\n");
# // let [N,M]=NM.split(" ").map(Number)
# // let arr=Array.from(Array(N).keys());
# // let answer=""
# // const union=(a,b)=>{
# //     let aRoot=find(a);
# //     let bRoot=find(b);
# //     arr[aRoot]=bRoot;
# // }
# // const find=(a)=>{
# //     if(arr[a]===a) return a;
# //     else return arr[a]=find(arr[a])
# // }
# // for(let i=0;i<M;i++){
# //     let [k,a,b]=_arr[i].split(" ").map(Number)
# //     if(k===0) union(a,b);
# //     else {
# //         if(find(a)===find(b)) answer+=`YES\n`
# //
# //         else answer+=`NO\n`
# //
# //     }
# // }
# // console.log