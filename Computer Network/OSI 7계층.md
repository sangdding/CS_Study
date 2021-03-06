# OSI 7계층

---
## 1. OSI 7계층이란?
<img src="https://s7280.pcdn.co/wp-content/uploads/2018/06/osi-model-7-layers-1.png">

#### 서론
실생활에서 우편을 보낼 때를 생각해보자. 먼저 우편에 들어 갈 내용을 적고,
봉투에 담아 보내는 사람과 받는 사람의 주소를 적는다.
내용이 분실되지 않도록 봉투를 봉인하고, 우체국을 통해 목적지로 발송한다.
우체국은 목적지의 주소에 따라 집배원을 배정하고, 집배원은 목적지에 안전하게 배송한다.
   
네트워크에서의 데이터 전송도 똑같다. 서로 다른 장치들로 구성된 호스트 사이에서, 
똑같은 과정과 규칙 아래 목적지까지 데이터를 안전하게 전송한다. 여기서 규칙을 계층적으로 표현한 것이
바로 OSI 7계층 모델이다.

#### 구성
* Physical layer
* Data Link layer
* Network layer
* Transport layer
* Session layer
* Presentation layer
* Application layer

## 2. 각 계층의 역할

### Physical Layer
기기와 기기 사이의 물리적인 연결을 담당한다. 
### Data Link Layer   
물리 계층을 이용하여 네트워크 상의 주변 장치들 간 데이터를 전송한다.   
데이터 링크 계층에는 두 가지 주요한 기능이 있다.
1. 주소 할당 : 물리 계층에서 받은 신호들이 알맞은 주소에 도달하게 한다.
2. 오류 감지 : 신호가 전달되는 동안 오류가 발생했는지 감지한다.
### Network Layer
데이터 링크 계층에서 제공하는 인접한 장치 사이의 통신을 너머, 라우터를 활용하여 
멀리 떨어진 위치의 장치까지 데이터를 전송하는 역할을 한다.
주요한 기능은 다음과 같다.
1. 패킷 전달 : 네트워크 계층의 데이터 단위는 패킷이다. 이 패킷을 목적지까지 전달하는 역할을 수행한다.
2. 라우팅 : 패킷을 전달할 때, 가장 효율적인 경로로 전송될 수 있게 경로를 설정한다.
3. 논리적인 주소 사용 : 논리적인 주소를 사용하여 데이터를 목적지까지 전달한다. 이 과정에서 캡슐화 된 데이터에
IP 프로토콜 헤더를 붙여 전송한다.
### Transport Layer
앞서 네트워크 계층에서는 상대방과 논리적인 연결을 맺지 않는다. 하지만 전송계층에서는
송신자와 수신자를 연결하는 통신 서비스를 제공하여 신뢰성 있는 전송 체계를 갖춘다.
주요한 기능은 다음과 같다.
1. 흐름제어와 혼잡제어
네트워크 상황에 따라 데이터를 유연하게 주고받는다.
2. 오류 제어
데이터를 주고 받을 때 발생하는 오류들을 감지, 대응한다.
3. 논리적 연결 제공
ACK를 주고받아 상대방과 논리적인 연결을 구성한다.
### Session Layer
종단간의 호스트 프로세스 간에 세션을 생성, 유지, 종료하는데 필요한 기능을 제공한다.
주요 기능은 다음과 같다.
1. 대화 관리
세션 계층은 토큰을 사용함으로써 대화를 관리한다.
프로세스는 토큰을 가졌을 때 전송할 수 있고, 토큰은 어떤 서비스의 실행을 기동하는 권리를 표하는 것이다.
2. 다중화
여러 세션들이 효율을 높이기 위해 1개의 같은 전송계층 접속을 사용할 수 있다.
반대의 경우도 가능하다.
### Presentation Layer
사람들이 다른 언어를 사용하듯이, 다양한 기기들도 저마다 다른 데이터 표현 방식을 가진다.
따라서 이를 하나의 통일된 형식으로 변환시킬 필요가 있는데, 이를 표현계층에서 담당한다.
주요 기능은 다음과 같다.
1. 다양한 표현 양식을 공통의 형식으로 변환
2. 암호화
3. 압축
4. 코드 변환
서로 다른 형태의 코드변환(ASCII 등)을 수행한다.
### Application Layer
여러 하위 통신 프로토콜 개체에 대해 사용 관점의 사용자 인터페이스를 제공한다.
