## Threads

a thread is a basic of cPU utilization
program counter만 여러개,즉 프로세스 하나에 CPU 수행 단위만 여러개 두고 있는 것

- Thread의 구성(독립적인 부분)
  - program counter
  - register set
  - stack space
- Thread가 동료 thread와 공유하는 부분(=task)
  - code section
  - data section
  - OS resources
- 전통적인 개념의 heavyweight process는 하나의 thread를 가지고 있는 task로 볼 수 있다.

- 다중 스레드로 구성된 태스크 구조에서는 하나의 서버 스레드가 blocked(waiting) 상태인 동안에도 동일한 태스크 내의 다른 스레드가 실행되어 빠른 처리를 할 수 있다(= 빠른 응답성)
- 동일한 일을 수행하는 다중 스레드가 협력하여 높은 처리율과 성능 향상을 얻을 수 있다.
- 스레드를 사용하면 병렬성을 높일 수 있다.

## Threads의 장점
* Responsiveness(응답성) :  eg) multi-threaded Web에서 만약 한 쓰레드(network thread)가 블럭되도 다른 쓰레드(display thread)로 응답할 수 있다.
* Resource Sharing : n threads cand share binary code, data, resource of the process
* Economy : creating & CPU switching thread rather than a process cf) Solaris의 경우 overhead가 각각 30배, 5배
* Utilization of MP Architectures : each thread may be running in parallel on a different pocessor  (=멀티 프로세서 환경에서 서로 다른 cpu에서 병렬적으로 일을 할 수 있다.)

## Implementation of Threads
* Kernel Threads : Kernel을 통해 지원됨.커널(운영체제)은 멀티 쓰레드인 것을 알고 있다. 커널이 cpu 스케듈링 하듯이 넘겨줌
  * windows 95/98/NT
  * Solaris
  * Digital UNIX, Mach
* User Threads : Library를 통해 지원됨.  프로세스 안에 쓰레드가 여러개 인것을 운영체제는 모름. 유저 프로그램이 스스로 여러 쓰레드 관리. 
  * POSIX Pthreads
  * Mach C-threads
  * Solaris threads
* real-time threads : real-time을 지원하는 theads