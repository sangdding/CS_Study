# CPU Scheduling

프로그램 실행은 CPU Burst와 I/O Burst의 연속이다.  
여러 종류의 job(process)이 섞여 있기 때문에 CPU 스케쥴링이 필요하다
=>Interative job에게 적절한 response 제공 요망.
=> CPU와 I/O 장치 등 시스템 자원을 골고루 효율적으로 사용.

### 프로세스의 특성 분류

- I/O bound process : CPU를 잡고 계산하는 시간보다 I/O에 많은 시간이 필요한 job(many short CPU bursts)
- CPU bound process : 계산 위추의 job(few very long CPU bursts)

### CPU Scheduler & Dispatcher

- CPU Scheduler: 운영체제의 한 코드로 Ready 상태의 프로세스 중에서 이번에 CPU를 줄 프로세스를 고르는 기능을 한다
- 운영체제의 한 코드로 CPU 제어권을 cPU scheduler에 의해 선택된 프로세스에게 넘긴다. 이 과정을 context switch라고 한다
- 스케쥴링은 preemptive와 nonpreemptive로 나눌 수 있다. (자진 반납& 강제로 뺏김)

### Scheduling Criteria(performance Index)

- CPU utillization: cpu 이용률
- Throughput: 처리량
- Turnaround time: 특정 프로세스의 실행부터 반환까지 소요 시간
- Waiting time: 모든 프로세스의 대기 시간의 합
- Pesponse time: 첫 cpu 응답까지 대기 시간

## 스케줄링 종류
- **FCFS**(First-Come First-Served): 선입 선출. 먼저 온 프로세스가 먼저 실행. Conveoy effect 발생
- **SJF**(Shortes-job First): 각 프로세스의 다음번 cPU burst time을 가지고 스케쥴링에 활용. 짧은 프로세스를 먼저 스케쥴
  - Nonpreemptive: 일단 CPU를 잡으면 완료될 때까지 선점당하지 않음
  - Preemptive: 현재 수행중인 프로세스의 남은 CPU burst time보다 더 짧은 프로세스가 도착하면 CPU를 빼앗김=>SRTF(Shortes-Remaining-Time-First)라고도 불림
  - Preemptive일때 주어진 프로세스들에 대해 minimum average waiting time 보장(optimal)
  - Starvation 현상: 긴 애는 계속 기다려야함
  - 다음번 CPU burst time은 과거 burst time로 추정해서 사용
- **Priority Scheduling**: 우선순위가 높은 프로세스에게 먼저 CPU 할당
  - Starvation 현상 발생=> Aging으로 시간이 지날 수록 우선순위를 높여줌으로 해결
- **Round Robin**(RR): 각 프로세스는 동일한 크기의 할당 시간을 가짐. 시간이 지나면 프로세스는 선점(preemptive)당하고 ready queue 뒤에 다시 들어감. 할당 시간 q(프로세스 개수 - 1) 이상 기다리지 않는다.
  - q가 커지면 FCFS
  - q가 작으면 context switch 오버헤드가 커진다
  - 일반적으로 SJF보다 average turnaround time이 길지만 response time은 더 짧다

### Multilevel Queue
* System processes > Interactive processes > Interactive editing processes > batch processes > student processes  순으로 우선순위가 큼.   
* Ready queue를 여러 개로 분할
* 각 큐는 독립적인 스케쥴링 알고리즘을 가짐
  * foreground : RR(human interactive함)
  * background : FCFS(batch - no interactive)
* 큐에 대한 스케쥴링이 필요(어떤 큐에 cpu를 줄지)
  * Fixed priority scheduling : serve all from foreground then from background 
  * => possibility of starvation
  * => Time slice : 각 큐에 CPU time을 적절한 비율로 할당

### Multilevel Feedback Queue
처음 들어온 프로세스는 가장 상위의 큐에 들어가고 할당시간을 짧게준다. 밑으로 갈수록 할당시간은 길어지고 맨 아래의 큐는 FCFS알고리즘이 적용된다.   

프로세스가 가장 상위에서 할당시간내에 일을 처리못하면 그 밑의 큐로 가게된다. 즉 할당 시간은 늘어나지만 우선순위가 내려간다.   

cpu 사용시간이 짧은 프로세스한테 우선순위를 많이 주는 스케쥴링.

* 프로세스가 다른 큐로 이동가능
* 에이징을 이와 같은방식으로 구현할 수 있다.
* Multilevel-feedback-queue scheduler를 정의하는 파라미터들
  - Queue의 수
  - 각 큐의 scheduling algorithm
  - Process를 상위큐로 보내는 기준
  - Process를 하위큐로 내쫒는 기준
  - 프로세스가 CPU 서비스를 받으려 할 때 들어갈 큐를 결정하는 기준

## Multiple-Processor Scheduling 
- CPU가 여러개인 경우 스케줄링은 더욱 복잡해짐
- Homegeneous processor인 경우
  - queue에 한줄로 세워서 각 프로세서가 알아서 꺼내가게 할 수 있다.
  - 반드시 특정 프로세서에서 수행되어야하는 프로세스가 있는 경우에는 문제가 더 복잡해짐
- Load sharing
  -일부 프로세서에서 job이 몰리지 않도록 부하를 적절히 공유하는 메커니즘이 필요
  - 별개의 큐를 두는 방법 vs 공동 큐를 사용하는 방법
-  Symmetric Multiprocessing(SMP)
  - 각 프로세서가 각자 알아서 스케줄링을 결정
  - 모든 CPU가 대등함!
- Asymmetric multiprocessing
  - 하나의 프로세서가 시스템 데이터의 접근과 공유를 책임지고 나머지 프로세스는 거기에 따름
  - 여러 CPU중 하나가 전담하여 나머지 CPU를 관리
   
## Real-time Scheduling
- Hard real-time scheduling
  - 정해진 시간안에 반드시 끝내도록 스케줄링해야함
- Soft real-time scheduling
  - 데드라인을 반드시 보장하진 못하고 일반 프로세스에 비해 높은 priority를 갖도록 함
## Thread Scheduling
- Local scheduling   
User level thread의 경우 사용자 수준의 thread library에 의해 어떤 thread를 스케줄할지 결정
-운영체제는 스레드를 모름=>운영체제는 프로세스단위로 cpu를 줄지말지 결정하고 프로세스내부에서 스레드에 cpu를 줄지말지 결정
- Global scheduling   
  Kernel level thread의 경우 일반 프로세스와 마찬 가지로 커널의 단기 스케줄러가 어떤 thread를 스케줄할지 결정   
  운영체제가 스레드의 존재를 알고있음, 프로세스 스케줄링하듯이 스레드에게 cpu를 줄지 결정

## Algorithm Evaluation
- Queueing models
  - 확률 분포로 주어지는 arrival rate와 service rate등을 통해 각종 performance index값을 계산
  - 이론적으로는 많이 사용됨
- Implementation(구현) & Measurement(성능 측정)
  - 실제 시스템에 알고리즘을 구현하여 실제작업(workload)에 대해서 성능을 측정 비교
- Simulation(모의 실험)
  - 알고리즘을 모의 프로그램으로 작성 후 trace를 입력으로 하여 결과 비교