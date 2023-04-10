## 1. CPU

:cpu는 매 클럭마다 메모리에서 읽어온 명령을 실행하는 역할

메모리는 cpu의 작업공간, cpu는 메모리에서 기계어를 읽어서 실행.  
cpu안에는 메모리보다 빠르면서 정보를 저장할 수 있는 register가 있다.  
프로그램이 직접 I/O작업하는건 불가능하여, 메모리에 있는 프로그램이 I/O작업이 필요할때는 CPU를 OS한테 넘겨주고 OS가 처리하도록 해야한다.

## 2. Mode bit

: 사용자 프로그램의 잘못된 수행으로 다른 프로그램 및 운영체제에 피해가 가지 않도록 하기 위한 보호 장치.  
Mode bit을 통해 하드웨어적으로 두가지 모드의 operation 지원.

- 1 사용자 모드: 사용자 프로그램 수행
- 0 모니터 모드(=커널모드, 시스템 모드)OS 코드 실행

Interrupt나 Exception 발생시 하드웨어가 mode bit을 0으로 바꿈
사용자 프로그램에게 CPU를 넘기기 전에 mode bit을 1로 셋팅

## 3 Timer

:정해진 시간이 흐른 뒤 운영체제에게 제어권이 넘어가도록 인터럽트를 발생시킴

- 타이머는 매 클럭 틱 때마다 1씩 감소
- 타이머 값이 0이 되면 타이머 인터럽트 발생
- CPU를 특정 프로그램이 독점하는 것으로부터 보호

## 4. Device Controller

- I/O device controller : 해당 I/O 장치 유형을 관리하는 일종의 작은 CPU->hardware  
  제어 정보를 위해 control register, status register를 가짐. local buffer를 가짐(data register)
- I/O는 실제 device와 local buffer사이에서 일어남
- Device controller는 I/O가 끝났을 경우 interrupt로 CPU에 그 사실을 알림
- device driver(장치구동기) : 커널의 코드로서 컴퓨터가 I/O장치별 처리하기 위한 루틴->software

## 5. 입출력(I/O)의 수행

모든 입출력 명령은 특권 명령.

- 사용자 프로그램은 시스템 콜을 통해 운영체제에게 I/O를 요청한다.

- trap을 사용해 인터럽트 벡터의 특정 위치로 이동

- 제어권이 인터럽트 벡터가 가리키는 인터럽트 서비스 루틴으로 이동

- 올바른 I/O 요청인지 확인 후 I/O 수행

- I/O 완료 시 제어권을 시스템콜 다음 명령으로 옮김

## 6. 인터럽트 (Interrupt)

인터럽트 당한 시점의 레지스터와 program counter를 save 후 CPU의 제어를 인터럽트 처리 루틴에 넘긴다.

- interrupt (넚은 의미) : 하드웨어가 발생시킨 인터럽트

- trap (소프트웨어 인터럽트)

  - Exception : 프로그램이 오류를 범한 경우
  - System call : 프로그램이 커널 함수를 호출하는 경우

- 용어 정리

  인터럽트 벡터 : 해당 인터럽트의 처리 루틴 주소를 가지고 있는 것. 인터럽트 번호, 주소 의 쌍을 가지고 있음

  인터럽트 처리 루틴(Interrupt Service Routine,인터럽트 핸들러) : 해당 인터럽트를 처리하는 커널 함수

---
