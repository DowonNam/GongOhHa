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

## 💡 Key Features & ScreenShots

### 1. 메인 및 일정 관리 (Main & Calendar)
직관적인 메인 UI와 함께, 개인별 학습 계획을 달력(Calendar) 형태로 등록하고 '오늘 할 일'을 체크할 수 있습니다.

| 메인 화면 | 학습 일정 달력 |
| :---: | :---: |
| <img width="100%" alt="메인화면" src="https://github.com/user-attachments/assets/438e6873-c9f6-4026-9b1f-8d395c034128" /> | <img width="100%" alt="달력" src="https://github.com/user-attachments/assets/10998470-708a-46ba-aff6-cb77c6612f6a" /> |

### 2. 정보 공유 커뮤니티 (Group & Community)
스터디 그룹을 생성하거나 가입하여 학습 팁을 공유할 수 있는 게시판 기능을 제공합니다.

<img width="100%" alt="그룹리스트" src="https://github.com/user-attachments/assets/9306cfce-8e03-49fc-b458-22efe6952e47" />

### 3. 회원 관리 (User & Security)
Session 기반의 로그인/로그아웃을 직접 구현하였으며, CSRF 토큰 검증 로직을 적용하여 보안 기초를 다졌습니다.

<img width="600" alt="로그인" src="https://github.com/user-attachments/assets/0fc3f31e-5bdf-4f77-a995-e6acf6d60370" />

<br>
✨ 수정한 점
괄호 삭제: [ 와 ]를 모두 지워서 이미지가 링크처럼 보이지 않고 깔끔하게 출력됩니다.

높이(Height) 삭제: height 값을 지워서, 이미지가 찌그러지지 않고 원본 비율대로 예쁘게 나오게 했습니다.

너비(Width) 조정: 표 안에 들어가는 이미지는 width="100%"로 설정해서 칸에 꽉 차게 맞췄고, 로그인 화면은 너무 크지 않게 적당히 조절했습니다.

이걸로 붙여넣으시면 아주 깔끔하게 나올 거예요! 👍
## 📚 Learning Point (배운 점)
- **DB 모델링의 중요성:** 회원, 게시글, 댓글, 일정 등 엔티티 간의 다대일(N:1) 관계를 직접 설계하며 ERD 작성 능력을 길렀습니다.
- **기록의 생활화:** 개발 과정에서 마주친 문제들을 Velog에 꾸준히 기록하며, 트러블슈팅 습관을 길렀습니다.
- **재사용성 경험:** 본 프로젝트에서 구축한 회원 및 게시판 구조를 기반으로, 추후 팀 프로젝트(MMP)의 핵심 골격으로 확장하며 코드 재사용의 이점을 체감했습니다.

<br>
