## 힙(Heap)

---

힙은 부모 노드의 키(key)값과 자식 노드의 키값 사이에는 대소관계가 성립하는 성질을 만족하는 완전 이진 트리 자료구조이다. max,와 min 두 타입으로 나뉜다.

형제 노드 간에는 대소관계가 성립하지 않는다.

우선순위 큐를 구현하기 위해 만들어졌다. 우선순위 큐를 구현하는 자료구조 중 제일 효율적이다.(배열, 연결리스트, 힙)  
최대값, 최소값을 쉽게 구할 수 있다.

Max-Heap: 부모 노드의 키는 자식 노드의 키 값들 보다 항상 커야한다.  
Min-Heap: 부모 노드의 키는 자식 노드의 키 값들 보다 작아야한다.

<img src="https://www.geeksforgeeks.org/wp-content/uploads/MinHeapAndMaxHeap.png" height="310px">

---

### 힙의 구현

- 힙을 저장하는 표준적인 자료구조는 배열이다.
- 구현의 편의성을 위해 배열 첫 인덱스인 0은 사용하지 않기도 한다.
- 힙의 연산의 경우 성질을 만족하기 위해 노드들의 위치를 바꾸는 재구조화가 필요하다.
- 삽입, 삭제 연산 자체는 O(1),재구조화 때문에 O(log n)
- 부모 노드와 자식 노드 간에 인덱스 관계

  왼쪽 자식 index = (부모 index) \* 2

  오른쪽 자식 index = (부모 index) \* 2 + 1

  부모 index = (자식 index) / 2

  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbRK3pg%2Fbtq67NfRt99%2FIkS2zcUeZp34sTDnSMHK41%2Fimg.png">  
  <br/><br/>

---

### 힙의 삽입

1. 힙의 삽입은 일단 새로운 노드를 힙의 마지막 노드에 삽입한다. (배열의 마지막에 삽입)
2. 힙의 성질을 만족하기 위해 새로운 노드를 대소 관계에 따라 부모 노드와 교환한다.
3. 이때 노드의 인덱스 관계를 사용하여 부모 노드와 자식 노드에 해당하는 배열 값의 대소관계를 구한다.

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fv9AbB%2Fbtq64Mbqear%2Fiy0RO2oDPQLczVq2lKEyZk%2Fimg.png">

---

### 힙의 삭제

1. 힙의 삭제는 루트 노드의 삭제만 고려한다.
2. 루트 노드가 삭제되면 가장 말단 노드를 루트 노드 자리로 대체한다.
3. 이 후 재구조화 수행.
   <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FemrNmu%2Fbtq65r537uq%2FvyeDeN4VoL6uBuHkUOeZ1K%2Fimg.png">

---

### 우선순위 큐(Priority Queue)와 힙(heap)

선입선출인 일반적인 큐와 달리 우선순위 큐는 우선순위가 높은 데이터 부터 나감.  
이를 힙으로 구현할 수 있다. 직접 연결된 부모-자식 노드 간 대소만 비교하면 됨.

파이썬에서는 우선순위 큐를 구현할 때 PriorityQueue 라이브러리 또는 heapq 라이브러리를 사용할 수 있다.

<br/><br/>
이미지 출처:  
https://www.geeksforgeeks.org/heap-data-structure/  
https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html  
https://yoongrammer.tistory.com/80
