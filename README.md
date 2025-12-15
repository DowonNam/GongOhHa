[Portfolio] Web Developer 남도원
🔗 GitHub: https://github.com/DowonNam 🔗 Tech Blog: https://velog.io/@ndw4797/posts

1. HoneyBadger (기업용 협업 및 커뮤니케이션 도구)
"NHN Dooray와 유사한 올인원 협업 솔루션 개발 프로젝트"

개발 기간: 2024.07 ~ 2024.08 (6주, 5인 팀 프로젝트)

관련 링크: GitHub Repository 바로가기

주요 역할: 백엔드(전자결재, 메일), 프론트엔드(채팅 UI), CI/CD 구축

사용 기술: Java, Spring Boot, MySQL, JPA, WebSocket(STOMP), Docker, AWS EC2

핵심 구현 내용:

전자결재 시스템: 기안-승인-반려-결재완료로 이어지는 상태값(State) 관리 로직 구현

실시간 채팅: WebSocket과 STOMP 프로토콜을 활용한 실시간 부서별 그룹 채팅 구현

CI/CD 자동화: GitHub Actions와 Docker를 활용하여 AWS EC2에 무중단 배포 환경 구축

Troubleshooting (문제 해결):

API 데이터 불일치: 프론트/백엔드 협업 시 발생하는 데이터 규격 차이를 해결하기 위해 API 명세서를 사전 확정하고 DTO(Data Transfer Object)를 도입하여 커뮤니케이션 비용 절감

배포 환경 경로 오류: 로컬(Windows)과 서버(Linux)의 파일 경로 차이로 인한 업로드 오류를 환경 변수 설정 및 상대 경로 적용으로 해결

2. MMP (Make Muscle Project - 헬스장 전용 관리 웹)
"회원권 관리부터 커뮤니티까지, 헬스장 운영 효율화 플랫폼"

개발 기간: 2024.05 ~ 2024.06 (1개월, 4인 팀 프로젝트)

관련 링크: GitHub Repository 바로가기

주요 역할: 회원 관리(로그인/출석), 챌린지 기능, 서버 배포

사용 기술: Java, Spring Boot, MySQL, AWS EC2

핵심 구현 내용:

회원/이용권 관리: 기간제/횟수제 이용권 차감 자동화 로직 및 출석 체크 기능 구현

챌린지 랭킹: 사용자의 운동 기록 데이터를 기반으로 실시간 랭킹 산정 시스템 개발

Troubleshooting (문제 해결):

Nginx 정적 파일 처리: AWS 배포 후 이미지 로딩 실패 문제를 Nginx의 Reverse Proxy 설정 및 정적 리소스 경로 매핑을 통해 해결

3. 공.오.하 (공부는 오늘부터 하자 - 학습 커뮤니티)
"개인 학습 일정 관리 및 정보 공유 커뮤니티"

개발 기간: 2024.04 ~ 2024.05 (1개월, 개인 프로젝트)

관련 링크: GitHub Repository 바로가기

주요 역할: Full-Stack 개발 (기획, DB설계, 구현 전체)

핵심 구현 내용:

DB 모델링: 회원, 게시판, 일정(Calendar) 간의 관계(ERD) 설계 및 정규화 적용

개발 기록: Velog를 통해 프로젝트 기획부터 구현 단계별 트러블슈팅 과정을 상세히 기록

보안 기초: CSRF 공격 방어를 위한 토큰 검증 로직 학습 및 적용

[문서 내용 복사 끝]
2️⃣ [링크 URL] 입력칸 최종 전략 (3개 입력)
질문하신 대로 허니뱃저만 따로 빼는 전략이 아주 좋습니다. 담당자가 보자마자 클릭하게 만드세요!

[GitHub Project] https://github.com/DowonNam/HoneyBadger

(설명: 🚀 핵심 프로젝트: NHN Dooray 벤치마킹 협업 툴)

[Tech Blog] https://velog.io/@ndw4797/posts

(설명: 🔧 트러블슈팅(동시성 이슈 등) 및 기술 학습 기록)

[GitHub Main] https://github.com/DowonNam

(설명: 📂 전체 프로젝트 소스코드)
