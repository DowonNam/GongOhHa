# 📝 공.오.하 (공부는 오늘부터 하자)
> **"나만의 학습 일정을 관리하고 공유하는 커뮤니티 서비스"**
> Spring Boot와 JPA를 활용한 웹 애플리케이션 개발 입문 개인 프로젝트입니다.

<br>

## 📅 프로젝트 소개
- **개발 기간:** 2024.04 ~ 2024.05 (1개월)
- **개발 인원:** 1명 (Personal Project)
- **주요 목표:**
  - 기획부터 DB 설계, 기능 구현까지 웹 서비스 전반의 프로세스 경험
  - RDB(MySQL) 설계를 통한 데이터 관계(ERD) 이해 및 정규화 적용

<br>

## 🛠️ Tech Stack
- **Language:** Java, JavaScript
- **Framework:** Spring Boot, Spring Security
- **Database:** MySQL
- **Frontend:** HTML/CSS, Thymeleaf (Server-side Rendering)
- **Tools:** IntelliJ, Git

<br>

## 💡 Key Features (주요 기능)

### 1. 학습 일정 관리 (Scheduler)
- 개인별 학습 계획을 달력(Calendar) 형태로 등록 및 수정 기능
- '오늘 할 일' 체크리스트 관리

### 2. 정보 공유 게시판 (Community)
- 회원 간 학습 팁 공유를 위한 게시글 CRUD(작성, 조회, 수정, 삭제)
- 카테고리별 게시글 분류 및 페이징(Pagination) 처리

### 3. 회원 관리 (User)
- Spring Security를 활용하지 않은 상태에서, Session 기반의 로그인/로그아웃 직접 구현
- CSRF 토큰 검증 로직 학습 및 적용을 통한 보안 기초 이해

<br>

## 📚 Learning Point (배운 점)
- **DB 모델링의 중요성:** 회원, 게시글, 댓글, 일정 등 엔티티 간의 다대일(N:1) 관계를 직접 설계하며 ERD 작성 능력을 길렀습니다.
- **기록의 생활화:** 개발 과정에서 마주친 문제들을 Velog에 꾸준히 기록하며, 트러블슈팅 습관을 길렀습니다.

<br>
