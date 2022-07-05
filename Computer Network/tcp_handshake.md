## TCP(Transmission Control Protocol)

osi 7계층 transport layer에서 사용하는 인터넷 표준 프로토콜로, Connection-Oriented 패킷 전송 제어하며, 데이터와 패킷이 보내진 순서대로 전달하는 것과 에러가 없음을 보장한다.(높은 신뢰성)  
3-way handshaking 과정을 통해 연결을 설정하고 4-way handshaking을 통해 해제한다.

### 용어정리

SYN(Synchronization): 연결 요청, 세션을 설정하는데 사용되며 초기에 시퀀스 번호를 보냄  
ACK(Acknowledgement): 보낸 시퀀스 번호에 TCP계층에서의 길이 또는 양을 더한 것과 같은 값을 ACK에 포함하여 전송.   

FIN (finish) : 세션을 종료시키는데 사용되며, 더 이상 보낸 데이터가 없음을 나타낸다.

---

## TCP 3-way Handshaking

정확한 전송을 보장하기 위해, 논리적인 접속을 확인하는 과정이다.

<img src="https://t1.daumcdn.net/cfile/tistory/225A964D52F1BB6917"> <br/>

Step 1 SYN From Client – 클라이언트가 서버에 접속을 요청하는 SYN 패킷을 보낸다. (seq : x)

- 송신자가 최초로 데이터를 전송할 때 Sequence Number를 임의의 랜덤 숫자로 지정하고, SYN 플래그 비트를 1로 설정한 세그먼트를 전송한다.
- PORT 상태
  - Client : CLOSED -> SYN/ACK 응답을 기다리는 SYN_SENT 로 변함
  - Server : LISTEN

Step 2 SYN + ACK From Server – 서버는 SYN 요청을 받고 클라이언트에게 요청을 수락한다는 ACK와 SYN 패킷을 발송한다. (seq : y, ACK : x + 1)

- 접속요청을 받은 서버가 요청을 수락했으며, 포트를 열어달라는 메세지를 전송 (SYN-ACK signal bits set)
- ACK Number필드를 Sequence Number + 1 로 지정하고 SYN과 ACK 플래그 비트를 1로 설정한 새그먼트 전송 (Seq=y, Ack=x+1, SYN, ACK)
- PORT 상태
  - Client : CLOSED
  - Server : ACK로 응답하기를 기다리며 SYN_RECEIVED 상태가 된다.

Step 3 Client ACK – 클라이언트는 서버에게 ACK를 보내고 연결이 이루어지고 데이터 전송 시작.

- 마지막으로 클라이언트가 수락 확인의 ACK 보내 연결을 맺음. 전송할 데이터가 있으면 이 단계에서 데이터를 전송할 수 있다.
- PORT 상태
  - Client : ESTABLISED
  - Server : SYN_RCV -> ACK-> ESTABLISED

## TCP 4-way Handshaking

대부분의 TCP의 연결 종료는 2 가지의 연결 해제 방식이 있다.

- Graceful connection release(정상적인 연결 해제) : 정상적인 연결 해제에서는 양쪽이 커넥션이 서로 모두 커넥션을 닫을 때까지 연결되어 있다.
- Abrupt connection release(갑작스런 연결 해제) : 갑자기 한 TCP 엔티티가 연결을 강제로 닫는 경우나 한 사용자가 두 데이터 전송 방향을 모두 닫는 경우

4-way는 graceful에 해당하는 종료 방법이다. <br/>  
Half-Close 기법으로, 연결을 완전히 종료하지 않고 반만 종료하는 것이다. 종료 요청자가 처음 보내는 FIN 패킷에 승인 번호를 함께 담아서 보내게 되는데, 이때 승인 번호의 의미는 "반만 종료하니 이 승인 번호까지 처리했으니까 더 보낼 거 있으면 보내" 가 된다.  
이후 수신자가 남은 데이터를 모두 보내고 나면 다시 요청자에게 FIN 패킷을 보냄으로써 모든 데이터가 처리되었다는 신호 (3) FIN를 보낸다. 그럼 요청자는 그때 나머지 반을 닫으면서 좀 더 안전하게 연결을 종료한다.

<img src="https://t1.daumcdn.net/cfile/tistory/2152353F52F1C02835"> <br/>

STEP 1 Client -> Server : FIN(+ACK) - 클라이언트가 연결을 종료하겠다는 FIN플래그를 전송한다.

STEP 2 Server → Client : ACK - 서버는 확인메시지인 ACK를 보내고 자신의 통신이 끝날때까지 기다린다.   
  - Client : TIME_WAIT
  - Server : CLOSE_WAIT

STEP 3 Server → Client : FIN - 서버가 통신이 끝났으면 연결이 종료되었다고 클라이언트에게 FIN플래그를 전송한다. 이후 승인 번호를 보내줄 때까지 기다니는 LAST_ACK 상태로 들어간다.

STEP 4 Client → Server : ACK - 클라이언트는 확인했다는 ACK를 보낸다.

- 클라이언트는 FIN을 받고, 확인했다는 ACK를 서버에게 보낸다.
- 아직 서버로부터 받지 못한 데이터가 있을 수 있으므로 TIME_WAIT을 통해 기다린다.  
  (TIME_WAIT Client에서 세션을 종료시킨 후 뒤늦게 도착하는 패킷이 있다면 Drop되고 데이터는 유실되는 현상에 대비하여 Client는 Server로부터 FIN을 수신하더라도 일정시간(디폴트 240초) 동안 세션을 남겨놓고 잉여 패킷을 기다리는 과정)

서버는 ACK를 받은 이후 소켓을 닫는다 (Closed)

TIME_WAIT 시간이 끝나면 클라이언트도 닫는다 (Closed)  
<br/>
참고 자료  
https://www.geeksforgeeks.org/tcp-connection-termination/

아래 링크에 정말 자세히 잘 되있습니다.

https://velog.io/@averycode/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-TCPUDP%EC%99%80-3-Way-Handshake4-Way-Handshake
