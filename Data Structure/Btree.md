## B tree & B + tree

balanced tree로 모든 리프 노드들이 같은 레벨을 가질 수 있도록 자동으로 균형을 맞추는 이진 트리이다.  
B -Tree는 이진 트리와 다르게 하나의 노드에 여러 자료를 가질 수 있다. 한 노드에 자료가 N개라면 N차 B-tree라고 부른다.

이진 트리는 자식 노드의 한계와 균형이 맞지 않으면 검색 효율이 선형검색 급으로 떨어지지만, B-tree는 군형 이진트리의 연속이기 때문에 최악의 경우에도 검색 성능은 O(logN)이다. <br/><br/>

<img src="https://velog.velcdn.com/images%2Femplam27%2Fpost%2Fddbae2c9-da94-457d-bad8-77ff6791255b%2FB%ED%8A%B8%EB%A6%AC%20%EA%B8%B0%EB%B3%B8%20%ED%98%95%ED%83%9C.png">   
ㄴ3차 b 트리   
<br/><br/>

### 특징

- 루트 노드는 적어도 2개 이상의 자식을 가져야한다
- 노드의 자료수가 N개라면 자식의 수는 N+1이어야 한다.
- 각 노드의 자료는 정렬되어 있다
- 자료는 중복되지 않는다
- 모든 Leaf node는 같은 레벨에 있다.
- 루트 노드를 제외한 모든 노드는 적어도 차수/2개의 자료를 가지고 있어야 한다.

---

## B + tree

B-tree는 탐색을 위해 노드를 찾아 이동해야 하는 단점을 갖는데, B+ tree는 색인구조에서 순차접근에 대한 문제의 해결책으로 제시되었다.

B-트리의 변형 구조로 index 부분과 leaf 노드로 구성된 순차 data 부분으로 이루어진다. Index 부분의 key 값은 leaf에 있는 key 값을 직접 찾아 가는데 사용하고 모든 key 값은 leaf 노드에 나열된다. 즉, index 부분의 key 값도 leaf 노드에 다시 한 번 나열된다. Leaf 노드는 순차적으로 linked list를 구성하고 있어서 순차적 처리가 가능하다.  
<br/>

<img src="https://velog.velcdn.com/images%2Femplam27%2Fpost%2Fbcbce100-d475-4cda-aebe-946d1813949c%2FB%ED%94%8C%EB%9F%AC%EC%8A%A4%20%ED%8A%B8%EB%A6%AC%20%EA%B8%B0%EB%B3%B8%20%ED%98%95%ED%83%9C.jpg"> 
<br/><br/>

B + tree는 같은 레벨의 모든 키 값들이 정렬되어, 같은 레벨의 형제 node는 연결 리스트 형태로 이어져 있다. 탐색에 매우 유리하다.  
leaf node가 아닌 노드는 인덱스 노드라 부르고 leaf node는 데이터 노드라고 부른다.

### 장점

- 블럭 사이즈를 더 많이 이용할 수 있다.(key 값에 대한 하드디스크 액세스 주소가 없기 때문)
- leaf 노드끼리 연결 리스트로 연결되어 있어서 범위 탐색에 매우 유리함

### 단점

B-tree의 경우 최상 케이스에서는 루트에서 끝날 수 있지만, B+tree는 무조건 leaf 노드까지 내려가봐야 한다.

---

## B - tree & B + tree

B-tree와 각 노드에 데이터가 저장이 되지만 B+tree의 경우엔 인덱스노드와 리프노드가 분리되어서 존재한다. 그리고, 리프노드는 서로 연결되어 있어서 임의접근과 순차접근모드 성능이 우수하다.

### 공통점

- 모든 leaf의 depth가 같다
- 2. 각 node에는 k/2 ~ k 개의 item이 들어있어야 한다3. search가 비슷하다
- 4. add시 overflow가 발생하면 split 한다
- 5. delete 시 underflow가 발생하면 redistribution하거나 merge 한다.

### 차이점

- B-tree의 각 노드에서는 key 뿐만 아니라 data도 들어갈 수 있다. 여기서 data는 disk block으로의 포인터가 될 수 있다.  B+tree는 각 node에서는 key만 들어가야 한다. 그러므로 B+tree에서는 data는 오직 leaf에만 존재한다.
- B+tree는 B-tree와는 달리 add, delete가 leaf에서만 이루어진다.
- B+ tree는 leaf node 끼리 linked list로 연결되어 있다.

참고 링크:  
https://potatoggg.tistory.com/174  
https://ssocoit.tistory.com/217  
https://velog.io/@emplam27/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-B-Tree
