# 3830 교수님은 기다리지 않는다

import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

def find(node):
  if parent[node]==node: 
    return node
  else:
    pnode=find(parent[node])
    weight[node]+=weight[parent[node]]
    parent[node]=pnode
    return parent[node]

def compare(a,b,w):
  rootA = parent[a]
  rootB = parent[b]
  if rootA != rootB:
    weight[rootB] = weight[a] - weight[b] + w
    parent[rootB] = rootA

while True:
  N,M=map(int,input().split())
  if N==0 and M==0:
    break
  weight=[0 for i in range(N+1)]
  parent=[i for i in range(N+1)]
  for i in range(M):
    testcase=list(map(str,input().split()))
    find(int(testcase[1]))
    find(int(testcase[2]))
    if testcase[0]=="!":
      compare(int(testcase[1]),int(testcase[2]),int(testcase[3]))
    else:
      if parent[int(testcase[1])] ==parent[int(testcase[2])]:
        print(weight[int(testcase[2])] - weight[int(testcase[1])])
      else: 
        print("UNKNOWN")


# js stack overflow 미해결
# LCA는 트리가 고정된 경우 이분 탐색 가능(NlogN) => 이 문제에선 사용 불가
# 따라서 시간 복잡도를 고려하여 N^2가 아닌 NlogN의 알고리즘 생각하기
# disjoint set (union-find) 알고리즘 사용(NlogN)
# const fs = require("fs");
# let input = (
#   process.platform === "linux"
#     ? fs.readFileSync("/dev/stdin")
#     : `2 2
# ! 1 2 1
# ? 1 2
# 2 2
# ! 1 2 1
# ? 2 1
# 4 7
# ! 1 2 100
# ? 2 3
# ! 2 3 100
# ? 2 3
# ? 1 3
# ! 4 3 150
# ? 4 1
# 0 0`
# )
#   .toString()
#   .toString()
#   .trim()
#   .split("\n");

# // 부모는 자식보다 무겁게. weight[k]=k'th노드와 parent[k]노드의 무게 차이
# for (let i = 0; i < input.length; i++) {
#   let [N, M] = input[i].split(" ").map(Number);
#   let weight = Array(N + 1).fill(0);
#   let parent = Array.from({ length: N + 1 }, (v, i) => i);
  
#   const find = (node) => {
#     if (parent[node] === node) return node;
#     let pnode = find(parent[node]);
#     weight[node] += weight[parent[node]]; // root까지의 무게 update
#     return (parent[node] = pnode);
#   };
#   const compare = (a, b, w) => {
#     let rootA = parent[a];
#     let rootB = parent[b];
#     if (rootA === rootB) return;
#     weight[rootB] = weight[a] - weight[b] + w;
#     parent[rootB] = rootA;
#   };

#   for (let j = 1; j <= M; j++) {
#     if (input[i + j].slice(0, 1) === "!") {
#       let [job, a, b, w] = input[i + j].split(" ").map(Number);
#       compare(a, b, w);
#     } else {
#       let [job, a, b] = input[i + j].split(" ").map(Number);
#       if (find(a) !== find(b)) console.log("UNKNOWN");
#       else console.log(weight[b] - weight[a]);
#     }
#   }
#   i += M;
# }
