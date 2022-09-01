# 1753 최단경로

import sys
import heapq

input= sys.stdin.readline
V,E=map(int,input().split()) #정점의 개수, 간선의 개수
K=int(input()) # 시작점
INF=11*V
distance=[INF]*(V+1) #거리 배열
distance[K]=0
linked_lst=[[] for _ in range(V+1)] #인접리스트
heap=[]
heapq.heappush(heap,(0,K))
for _ in range(E):
  u,v,w=map(int,input().split())
  linked_lst[u].append((v,w))

while(heap):
  current_w,current_node=heapq.heappop(heap) # 현재 노드와 가중치 pop
  if distance[current_node]<current_w: #  최단 거리가 아닌 경우
    continue
  for next_node, w in linked_lst[current_node]: # 인접 노드 
    next_w=w+current_w
    if distance[next_node]>next_w: # 기존의 가중치와 대소 비교
      distance[next_node]=next_w
      heapq.heappush(heap,(next_w,next_node))

for i in range(1,V+1):
  if distance[i]==INF:
    print("INF")
  else:
    print(distance[i]) 

# // js  코드 미완. 
# //시간복잡도와 E를 보아 다익스트라 알고리즘 가능. 우선순위 큐로 heap 구현
# const fs = require("fs");
# let [VE, K, ..._arr] = (
#   process.platform === "linux"
#     ? fs.readFileSync("/dev/stdin")
#     : `5 6
# 1
# 5 1 1
# 1 2 2
# 1 3 3
# 2 3 4
# 2 4 5S
# 3 4 6`
# )
#   .toString()
#   .trim()
#   .split("\n");

# class MinHeap{
#   constructor(){
#     this.nodes=[]
#   }
#   push(value){
#     if(this.nodes.length>1){
#       this.nodes.push(value);
#       let parentIdx=Math.floor((nodes.length-1)/2);
      

#     }
#   }
#   pop(){

#   }
# }  
# let [V, E] = VE.split(" ").map(Number);
# K = Number(K);
# let w_queue = [];
# let visit = Array(V + 1).fill(false);

# // Array.from의 func에는 {}을 쓸 수 없다. undefined 나옴
# let dij = Array.from({ length: V + 1 }, (v, i) =>
#   Array.from({ length: V + 1 }, (a, b) => (i === b ? 0 : "INT_MAX"))
# );
# // 최단거리 행렬구하기 u->v 인 가중치w
# for (let i = 0; i < E; i++) {
#   let [u, v, w] = _arr[i].split(" ").map(Number);
#   dij[u][v] = w;
#   if (u == K) w_queue.push([u, v, w]);
# }
# let cur_v = Number(K);
# //w_queue는 가중치가 큰 순으로 정렬.
# while (w_queue.length > 0) {
#   w_queue.sort(function (a, b) {
#     return b[2] - a[2];
#   });
#   if (w_queue[w_queue.length - 1][0] === cur_v) {
#     update_w();
#   }
#   if (visit.length === V) break;
# }
# /*
# 힙에서 뺀 vertex가 연결된 정점이 없으면 continue
# 힙에서 뺀 cost가 최단거리 테이블의 cost보다 크면 continue
# 힙에서 뺀 vertex를 거쳐갈 때 cost가 같거나 더 커지면 continue
# else  해당 vertex를 거쳐갈 때의 cost를 최단거리 테이블의 cost로 
# */
# const dijk = (u, v, w) => {
#   for (let i = 0; i < V + 1; i++) {
#     if (!isNaN(dij[v][i])) dij[u][i] = Math.min(dij[u][i], dij[u][i] + w);
#   }
#   //visit에 없으면서 가중치가 최소인 정점
#   let next_v = Math.min(dij[v]);
# };
