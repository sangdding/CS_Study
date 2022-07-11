# HTTP란?
Hypertext Transfer Protocol의 약자로, HTML과 같은 hypermedia documents를 전송하기 위한 프로토콜이다.

## HTTP 메시지 구조

<img src = "https://mdn.mozillademos.org/files/13827/HTTPMsgStructure2.png">

# HTTPS란?
Hypertext Transfer Protocol **Secure**의 약자로, HTTP의 확장버전이다. HTTPS에서는 
communication protocol이 TLS(Transport Layer Security), 혹은 SSL(Secure Sockets Layer)로 암호화된다.

## HTTP vs HTTPS
HTTPS는 크게 두가지 부분에서 HTTP보다 안전하다고 볼 수 있다.
만약 아이디와 비밀번호를 입력하는 기능이 있는 웹 사이트에서, HTTPS를 사용하고 있다면
데이터가 암호화되어 서버로 전송된다.   
즉, 사용자가 서버로 보내는 데이터를 암호화함으로써 제 3자가 데이터를 볼 수 없도록 한다.   
또 다른 하나는, 접속한 사이트가 신뢰할 수 있는 사이트인지 알려준다.    
데이터를 중간에서 피싱할 목적으로
만든 사이트가 존재할 수 있기 때문에, 중요한 정보를 다루는 사이트들은 
인증 기관(CA)에서 HTTPS 인증을 받아 사용자에게 신뢰할 수 있는 사이트라는 것을 알려준다.

## HTTPS의 구현
1. 서버와 클라이언트가 연결을 맺기 위해 Handshaking을 진행할 때, 서버는 인증서를 포함해서
클라이언트에게 전달한다.
2. 클라이언트는 인증서의 진위 여부를 가리기 위해 브라우저에 내장된 CA의 정보를 통해 확인한다.
3. CA의 인증서는 각 CA의 개인키로 암호화되기 때문에, 클라이언트는 CA의 공개키로 복호화를 한다.   
4. 복호화 된 데이터에는 서버의 공개키가 포함되어있고, 이것으로 서버와 통신을 하게 된다.
> 비대칭키로 통신을 하면 보안상의 이점이 있을 수 있지 않을까라고 생각할 수 있지만, 그렇게 되면
> 네트워크에 무리가 가기 때문에, 대칭키를 공유할 때 비대칭키를 사용한다.   
> Handshaking으로 주고 받은   
> 무작위 데이터로 임시키를 생성, 서버의 공개키로 암호화하여 서버로 보내면, 양쪽에서 일련의 과정을 거쳐
> 동일한 대칭키가 생성된다.

---
##### 참고 자료
https://developer.mozilla.org/ko/docs/Web/HTTP/Messages   
https://www.youtube.com/watch?v=H6lpFRpyl14   