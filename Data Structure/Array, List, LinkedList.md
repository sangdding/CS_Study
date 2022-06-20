<h2>배열</h2>
<br/>
<img src="https://media.geeksforgeeks.org/wp-content/uploads/array-2.png">
<br/>
<br/>
아이템의 모음. 연속된 메모리 주소에 저장. 
같은 타입의 다중의 아이템 저장에 사용.
<br/>
=선언 시 크기와 데이터 타입 지정 필요.
<br/><br/>
각 원소의 위치를 계산하는데 쉬움. base value=첫 원소에 offset(index)을 더함으로 계산 가능. 각 원소는 인덱스로 식별함.
<br/> 
= 인덱스는 값에 대한 식별자. 논리적 저장 순서와 물리적 저장 순서가 일치.
<br/>
<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/Array-In-C.png">
<br/>
---
<br/>
<h3>배열의 크기</h3>
<br/>
C에서 배열의 크기는 한번 고정하면 바뀔 수 없다. 축소, 확대 둘다 불가. 최대 사이즈를 알 수 없는 상황에는 부적합.
<br/>
(만약 크기를 변경하면 다음 메모리 주소가 사용 가능한지 불확실해짐. 축소는 배열을 선언할때 메모리가 정적으로 할당되기 때문에 컴파일러가 거부한다)
<br/>
---
<h3>배열의 장점</h3>
* 배열은 원소의 random access가 가능하다. = 원소 접근이 빠르다<br/>
* 좋은 cache locality를 갖는다. performance에 큰 차이를 만듬.<br/>
* 하나의 이름으로 다수의 data items를 대표한다.
  
<br/><br/>
<h3>배열의 단점</h3>
* fixed size. 선언을 하면 배열의 크기를 바꿀 수 없다. <br/>
* 원소 삽입, 삭제가 매우 비효율적<br/>
=> 원소 삭제 시 그에 따른 빈 공간을 낭비. O(n)의 시간복잡도 <br/>
=> 원소 삽입은 원소들이 연속된 메모리 주소에 저장되있기 때문에 삽입 위치 이후 원소들이 RSH. O(n)의 시간복잡도   <br/>
*

<br/>
<h3>배열의 사용</h3>
* 행렬 문제<br/>
* 데이터베이스 record 자료구조<br/>
* 정렬 알고리즘<br/>
* CPU scheduling에도 자주 사용됨<br/>
<br/><br/>

<h2>리스트(=sequence)</h2>
유한한 원소들의 나열. 배열 인덱스의 장점을 버리고 빈틈없는 데이터의 적재라는 장점 추가한 data 구조.<br/>
배열과 달리 크기를 정해주지 않아도 되고 인덱스가 아닌 순서가 중요. 인덱스는 식별자가 아닌 순서의 의미를 가짐.<br/>
포인터를 통한 접근을하며 불연속적으로 메모리 공간을 차지한다.
<br/><br/>
<h3>리스트의 장점</h3>
* 배열보다 삽입 삭제에 용이<br/>
* 크기가 동적이다.<br/>
* 배열보다 메모리 재사용이 편리하다 = 공간 낭비가 없다
<br/><br/>
<h3>리스트의 단점</h3>
* 순차성을 보장하지 못하기 때문에 spacial locality가 좋지 않다.<br/>
* 인덱스가 식별의 역할을 못하므로 검색 성능이 좋지 않다.<br/>
* 포인터를 통해 다음 데이터를 가르키므로 추가적인 메모리 필요
<br/><br/>
<h3>리스트의 사용</h3>
* C에는 리스트가 없기 때문에 배열이나 linked list로 구현함.<br/>
* 자바스크립트에서는 배열에 리스트 기능 추가<br/>
* 파이썬에서는 리스트만 내장(자바스크립트와 기능 유사)<br/>
* 자바에서는 구현 방법에 따른 list를 구분하여 제공.<br/><br/>
<img src="https://s3.ap-northeast-2.amazonaws.com/opentutorials-user-file/module/1335/2884.png"><br/><br/>
* Array List : 추가/삭제 느림, 인덱스 조회 빠름<br/>
* Linked List : 추가/삭제 빠름, 인덱스 조회 느림<br/>
<br/>  
<h2>연결 리스트</h2><br/>
노드 간에 연결을 통해 리스트로 구현된 자료구조.<br/>
각 노드는 값과 다음 노드 정보를 가짐.<br/>
인덱스가 없기 때문에 순차 접근만 가능. <br/><br/>
<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2013/03/Linkedlist.png"><br/>

<h3>연결 리스트의 삽입/삭제/조회</h3><br/>
* 삽입의 경우 삽입할 노드를 만들고 넣을 위치를 head부터 조회하여 이전 노드의 참조값을 삽입하는 노드로 변경.<br/>
* 삭제의 경우 삭제할 노드를 head부터 조회하여 이전 노드의 참조값을 그 다음 노드값으로 변경.<br/>
* 조회의 경우 head부터 순차적으로 접근해야 함. 시간 복잡도 O(n)
<br/>
<br/>
참고 링크
https://opentutorials.org/module/1335  <br/>
https://www.geeksforgeeks.org/data-structures/?ref=shm
