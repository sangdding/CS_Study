# Trie

---
## 1. Trie란?
Trie는 효과적인 정보 탐색 자료구조이다. Trie를 사용하면, 검색 시간복잡도를 최적으로 줄일 수 있다.
만약 이진 탐색 트리에 최대 M의 길이를 가진 String과 N개의 key를 저장한다고 가정하면, 대략 O(MlogN)의 시간이 걸린다. 
반면 Trie를 사용한다면, O(M)의 시간복잡도를 얻는다. 

> 참고 : insert와 delete 연산의 시간복잡도는 최악의 경우 문자열의 길이만큼 탐색해야 하므로 O(M)이 걸린다.

## 2. Trie 구현법
먼저 루트노드는 비워두고, 하위 노드에서 차례대로 접두사가 입력된다. 
<img src = https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Trie_example.svg/250px-Trie_example.svg.png>   
예를 들어, {"A", "to", "tea", "ted", "ten", "i", "in", "inn"}의 문자열을 Trie로 표현하면 위와 같다.

## 3. Trie의 단점
Trie는 매우 빠른 문자열 탐색 속도를 가져오지만, key를 가리키기 위한 포인터의 공간이 너무 크다는 단점이 있다.
최악의 경우, 모든 문자열 길이의 합 만큼 포인터가 필요하므로, O(pointer size * number of pointer * number of node)의 공간이 필요하다.
이를 해결하기 위해, 필요한 노드만 메모리를 동적으로 할당하는 방법이 있다.