# Tree

---
## 1. Tree란?
Tree는 node와 link로 구성된 계층적 자료 구조이다.
## 2. Tree에서의 용어
<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/20201129105858/Tree-Basic-Terminology.png"> 

* Parent Node : link로 연결되어있는 이전 node를 현재 node의 parent node라고 한다.
위의 그림에서 2번 node는 6, 7번 node의 parent node이다.
* Child Node : link로 연결되어있는 바로 다음 노드를 child node라고 한다. 
6, 7번 node는 2번 node의 child node이다.
* Root Node : Tree의 가장 높은 node를 말한다. Root node는 parent node를 가지지 않는다.
1번이 root node이다. 
Tree는 무조건 하나의 root node를 가져야 하며, 모든 node는 root노드와 하나의 경로로 연결되어 있다.
* Degree of Node : Node에 붙어있는 subtree들의 갯수를 뜻한다. 따라서 최하단 node의 degree는 0이며,
Tree의 degree는 node중 가장 큰 degree와 같다. 
* Leaf Node : Child node를 가지지 않는 말단의 node를 말한다. 6, 14, 8...번 node가 leaf node이다.
* Ancestor of a Node : Root node부터 현재 node까지의 경로 상의 모든 node를 말한다.
1번과 2번 node가 7번 node의 ancestor node이다. 
* Descendant : 현재 node에서 leaf node까지 경로상의 node를 말한다. 7, 14번 node는 2번 node의 descendant node이다.
* Sibiling : 같은 parent node를 가진 child node들을 parent node의 sibling이라 한다. 8, 9, 10번 node는 3번 node를 공유하는 sibling이다.
* Depth of a Node : Root부터 현재 node까지 edge 수를 말한다. 14번 node의 depth는 3이다.
* Height of a Node : 현재 node에서 leaf node까지의 경로 중 가장 멀리 떨어져 있는 경로상의 edge 개수를 의미한다.
3번 node의 height는 2이다.
* Height of a Tree : Root node로부터 가장 깊이 있는 leaf node까지의 경로 중 edge의 개수를 의미한다.
위 tree의 height는 3이다.
* Level of a node : 현재 node와 root node사이 경로상의 edge 개수를 말한다. Root node의 level은 0이다.
* Internal Node : 적어도 하나의 child를 가지고 있는 node를 internal node라 한다.
* Neighbor of a Node : 해당 node의 Parent or child nodes를 neighbor node라 한다.
* Subtree : 현재 node의 descendant로 구성된 모든 tree를 말한다.
## 3. Tree의 종류
##### 1. General Tree
Node 개수에 제한이 없는 tree를 말한다. 즉, parent node는 어떠한 수의 child node라도 가질 수 있다.
##### 2. Binary Tree
Binary Tree는 child node의 개수가 2개를 넘지 못한다.
##### 3. Balanced Tree
<img src="https://media.geeksforgeeks.org/wp-content/uploads/20211127152300/imi-300x258.png"> <br>

만약 left subtree와 right subtree의 개수가 같거나 1개만 다를 때, 그 tree는 balanced tree라 한다.
## 4. Tree의 활용
* Spanning Tree : 네트워크에서, 라우터가 패킷을 목적지로 보낼 최단 경로를 설정할 때 활용된다.
* Binary Search Tree : 정렬된 일련의 data들을 유지하는데 도움이 되는 자료 구조이다.
* Storing hierarchical data : 계층적으로 표현된 data들을 저장하는데 적합하다.
* Syntax tree : 프로그래머의 source code 구조를 표현하는데 쓰이는 tree이다. Compiler가 사용한다.
* Trie : spell checking하는 가장 효율적이고 빠른 방법이다. 집합 내 특정한 key를 위치시키는데에도 사용된다.
* Heap : array 형태를 tree로 표현할 수 있는 자료구조이다. Priority queue를 구현하는데 사용된다.
# Binary Search Tree

---
## 1. Binary Search Tree란?
다음과 같은 성질을 만족하는 tree를 BST라 부른다.
* left subtree의 node는 현재 node의 key보다 항상 적은 값을 가진다.
* right subtree의 node는 현재 node의 key보다 항상 큰 값을 가진다.
* 현재 node의 subtree 또한 위 성질을 만족해야 한다.   
   
이러한 성질들 덕분에, 탐색, minimum, maximum 값을 찾는 연산이 빠르게 수행될 수 있다. 
만약 순서가 없는 tree라면, 모든 key를 다 탐색해야 하기에 연산의 수행이 매우 느릴 것이다.

## 2. BST에서의 탐색
어떠한 값을 찾을 때, 정렬된 array를 가지고 있다면 binary search를 이용해서 탐색을 수행할 수 있다.
Binary search를 수행한다면, 기준값보다 크거나 작은 값은 더 이상 탐색하지 않아도 되기 때문에, n개의 element중 2/n개의 element는 참조하지 않아도 된다.
Binary search Tree도 이러한 과정과 유사하다. 만약 찾아야 할 값이 node보다 작다면, left subtree를 탐색해야 할 것이고 크다면, right subtree를 탐색하면 된다.
만약 balanced tree에서 탐색을 한다면, 탐색할 node의 level에 따라 탐색할 공간이 2/(n^level)만큼 줄어들기 때문에 엄청난 효율성을 가져올 수 있다.

## 3. BST에서의 시간 복잡도
* Search and insert operation : h가 tree의 height라 하자. BST의 탐색과 삽입은 총 O(h)의 시간복잡도의 연산이다.
가장 최악의 경우, tree의 leaf node까지 탐색을 하기 때문이다. 
---
> 참고 링크 및 이미지 출처 <br>
> https://www.geeksforgeeks.org/introduction-to-tree-data-structure/ <br>
> https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/