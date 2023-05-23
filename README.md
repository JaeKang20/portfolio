# 최재강 portfolio & study
🔥AWS로 서버배포한 환경 바로 가보기 클릭: (베포하고 서버 내렸습니다.)

![Snipaste_2023-05-08_00-05-10](https://user-images.githubusercontent.com/100588597/236685649-93e95eb3-a116-416c-abc8-137ccca0e6fa.png)

**🔥기획의도**

```
- 최재강 개발자의 포트폴리오로 사용하기 위함입니다.
- 공부한 내용을 깃허브와 블로그에 꾸준히 업로드 중입니다.
- 게시판 활용
```
**🔥요구사항 분석**

``` 
◼ 게시판 기능
·게시글 조회
·게시글 등록
·게시글 수정
·게시글 삭제
```
``` 
◼ 회원기능
·구글 / 네이버 로그인
·로그인한 사용자 글 작성 권한
·본인 작성 글에 대한 권한 관리
```

**🔥시스템 구성**

```
1.DB Server: AWS RDS - MySQL
2.WEB Server: AWS EC2
  -Spring boot: Spring MVC + Mustache (*Web packacge*)
  -HTML, js, bootStrap 화면 구성 (*telmplete package*)
3.Spring Security를통한 Oauth2기능 구현, 구글,네이버 로그인 구현기능 (*Config package*)
```

**🔥적용 기술 및 라이브러리**

```
- JAVA 17
- Spring Boot 2.6
- Junit 4
- DB: MySQL
- Mushache
- JS
- BootStrap
- AWS EC2
- AWS RDS
- OAuth2: google,naver
```

**🔥ERD**

![erd](https://user-images.githubusercontent.com/100588597/236685379-4cc4657a-dff9-4a8e-a5ba-93f98a036ec9.png)




[개발자 블로그 바로가기](https://keyboardwarrior.tistory.com/)
