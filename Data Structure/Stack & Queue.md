# Stack
___
## 1. Stack이란?
Stack은 LIFO(Last-in First-out)의 순서로 연산이 수행되는 선형 자료구조이다. 
## 2. Stack의 연산
* push() : stack에 item을 추가한다. 만약 stack이 가득 차 있다면, overflow가 발생한다.
* pop() : stack에서 item을 제거한다. item이 push된 순서의 반대로 pop된다. 만약 stack이 비어있다면, underflow가 발생한다.
* top() : stack의 가장 윗 부분의 element를 반환한다.
* isEmpty() : stack이 비어있다면 true를, 아니라면 false를 반환한다.
* size() : stack의 크기를 반환한다.
> 참고 : stack의 연산들은 모두 O(1)의 시간복잡도를 가진다.
## 3. Stack의 사용
* Register Stack : 적은 양의 data를 담을 때 사용한다. 메모리 stack에 비해 크기가 매우 작기 때문에, 항상 크기가 제한되어 있다.
* Memory Stack : 많은 양의 메모리 데이터를 다루기 때문에, 크기가 가변적이다.
## 4. Stack의 장단점
##### 장점
1. 필요에 따라 runtime 중에 크기가 증가하거나 감소할 수 있다. (Linked List)
2. JVM과 같은 많은 가상 머신에서 사용된다.
3. 쉽게 변경되지 않기 때문에 안전하고 신뢰성 있는 자료구조이다.
4. 스택은 객체를 자동적으로 정리한다.
##### 단점
1. 포인터가 사용되기 때문에 추가적인 메모리가 요구된다. (Linked List)
2. 스택에서는 랜덤으로 item에 접근하지 못한다.
3. 스택의 크기는 선언하기 전에 미리 정해야 한다. (Arrays)
4. 스택이 메모리의 범위를 넘어서면 비정상적인 종료로 이어질 수 있다.   
   
   
# Queue
___
## 1. Queue란?
Stack과 비슷하게, 자료를 저장할 때 특정 순서로 연산이 수행되는 선형 자료구조이다. 하지만 Stack과는 달리 FIFO(First-in First-out) 순서로 연산이 수행된다.
## 2. Queue의 연산
* enqueue() : queue의 끝에서 item을 삽입한다.
* dequeue() : queue의 앞쪽 끝에서 item을 삭제하고 반환한다.
* front() : 앞쪽 끝의 item을 삭제하지 않고 반환한다.
* rear() : 끝의 item을 삭제하지 않고 반환한다.
* isEmpty() : queue가 비어있다면 true를, 아니라면 false를 반환한다.
* size() : queue의 크기를 반환한다.
> 참고 : stack과 마찬가지로 queue의 연산들은 모두 O(1)의 시간복잡도를 가진다.
## 3. Queue의 종류
* Circular Queue : Circular Queue에서는, element들이 순환 고리처럼 동작한다. 
선형 queue와 유사하지만 마지막 element가 첫번째 element와 연결되어 있다는 점이 다르다. 이것의 장점은 메모리를 효율적으로 사용할 수 있다는 것인데, 
그 이유는 만약 queue의 특정 위치에 element가 없다면, 쉽게 그 자리에 다른 element를 추가할 수 있기 때문이다.
* Priority Queue : Priority Queue는 element들을 특정 우선순위에 따라 정렬하여 저장한다. 예를 들어 가장 높은 값을 가진 element가 우선순위를 가지고,
따라서 값이 감소하는 순서로 queue가 만들어진다. 반대로 값이 증가하는 순서로 queue가 만들어질 수도 있다.
* Dequeue : Dequeue는 Double ended queue라고도 알려져있다. 
이름에서부터 알 수 있듯이, 다른 queue와는 달리 element가 양 끝 지점에서 삽입 혹은 삭제 될 수 있다.
### 4. Queue의 사용
Queue는 즉각적인 처리가 필요하지 않고, FIFO의 순서대로 연산이 수행되어야 할 때 사용된다.
* Scheduling Queue : 디스크와 CPU의 scheduling에 사용된다.
* IO Buffers, pipes, file IO, etc : data가 두 프로세서 사이에서 비동기적으로 처리될 때 사용된다.
### 5. Queue의 장단점
##### 장점
1. 구현이 쉽다. (Arrays)
##### 단점
1. 고정된 크기의 정적 자료구조이다. (Arrays)
2. 만약 enqueue와 dequeue 연산이 많은 횟수로 일어난다면, queue가 비어있더라도 element를 삽입하지 못할 수 있다. 
이 문제는 Circular Queue를 사용함으로써 해결할 수 있다. (Arrays)