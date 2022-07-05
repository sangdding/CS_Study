## UDP

User Datagram Protocol Transport계층의 통신 프로토콜 중 하나로 ICMP의 문제를 해결하기 위해 나옴.

- 신뢰성이 낮은 프로토콜로써, 완전성을 보증하지 않는다.
- 가상회선을 굳이 확립할 필요가 없고, 유연하며 실시간적 응용의 데이터 전송에 적합하다.
- 비연결성이다(서버와 클라이언트 구분이 없다. 소켓 대신 IP 기반으로 데이터 전송)
- 신뢰성이 없다.
  - 순서제어 없음(TCP 헤더와 달리 순서 번호 필드 없음)
  - 흐름제어 없음
  - 검사합(check sum)을 제외한 특별한 오류 검출 및 제어 없음
  - 논리적인 가상회선 연결이 필요없음(handshaking ㄴㄴ, 데이터그램 지향의 전송계층용 프로토콜)
- 실시간 응용 및 멀티캐스팅 가능
- 헤더가 단순함(고정 크기의 8바이트 만 사용)
- 데이터 전송 단위 : 메세지(<=>TCP는 세그먼트)
- 최대 데이터 크기는 65,507 바이트 = 65,535 바이트 - UDP 헤더 8 바이트 - IP 헤더 20 바이트

## UDP Header

<img src="https://camo.githubusercontent.com/97937857395944ea8fa05caa629426bed8f78fbfd22c72d5a397b5344bc8609a/68747470733a2f2f74312e6461756d63646e2e6e65742f6366696c652f746973746f72792f323732413541333835373539323637423336">

- Destination port : 도착지 포트
- Length : 길이
- Checksum\_ : 오류 검출

## TCP와 차이

<img src="https://velog.velcdn.com/images%2Fdaon9apples%2Fpost%2Ff4f756e7-c6f5-41bd-8467-e381517be404%2Fimage.png">    
<br/><br/>

참고 링크  
https://mangkyu.tistory.com/15  
https://github.com/gyoogle/tech-interview-for-developer/blob/master/Computer%20Science/Network/UDP.md#20190826%EC%9B%94-bym-udp%EB%9E%80
