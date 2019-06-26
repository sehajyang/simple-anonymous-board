# simple-anonymous-board
심플 익명 게시판   
이 프로젝트는 사내에서 서비스하기 위한 목적으로 만들어 졌습니다.  
회원 가입시 아이디 및 비밀번호만을 수집하며   
아이디& 비밀번호의 이중 암호화로 관리자도 누가 글을 썼는지 알 수 없는 강력한 익명게시판 프로젝트입니다.   
게시글이 일정 수 이상의 '좋아요' 를 받을 시 해당 게시글의 내용은 슬랙으로 특정인에게 발송됩니다.    
[API Document](https://github.com/sehajyang/simple-anonymous-board/wiki) 
[프로젝트 일정관리](https://github.com/sehajyang/simple-anonymous-board/projects/1)

## Skill
- FrontEnd : Handlebars.js, Bootstrap
- BackEnd : Java(JDK 8), Spring boot 2.x
- DB : PostgraSql, H2(test 용)
- ETC : Lombok, JPA
- IDE : Intelli J

## 기능
- 로그인 및 회원가입 이중 암호화(아이디 & 패스워드 암호화)
- 메인화면
  - 게시판별 새글 및 과거,오늘 접속 자 수 차트 표시
  - 인기 게시글 표시
- 익명게시판 
  - 익명의 강아지 등 으로 작성자 랜덤 
  - 좋아요 일정 갯수 이상시 슬랙 발송
  - 게시글 작성시 슬랙 발송 여부 지정
  - 그외 CRUD
- 공지게시판(및 답변) CRUD (상위 고정 게시물 기능)
  - 관리자만 작성 가능
  - 그외 CRUD
- ~투표게시판 (별도)~

소스 참고 : [jojoldu/springboot-webservice](https://github.com/jojoldu/springboot-webservice)
