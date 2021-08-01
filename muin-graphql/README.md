# GraphQL 사용하기

## GraphQL 알아둘 점
- REST와 같이 HTTP위에서 동작하며 서버-클라이언트 간 데이터 전송시 사용할 **명세, 규격**이다.
- 따라서 **서버, 클라이언트 둘 다 사용 방법, 문법을 익혀야하고** 각 진영에서 이 명세를 지원하는 라이브러리를 사용하게된다.
  (java : spqr, kickstart 등 / js는 java보단 library가 잘 돼있는 편)
- Apollo는 무엇인가?
  - 위에서 말한대로 GraphQL을 지원하기 위한 라이브러리들 중 하나다.
  - Apollo-client, Apoller-server 이름으로 찾아볼 수 있을텐데 JS 지원 라이브러리이므로 Spring Boot에선 사용 못한다.

## GraphQL을 사용하는 이유?

Underfetching이 해결된다  

Overfetching도 해결된다

다양한 라이브러리에서 Api를 테스트할 수 있는 환경이 제공된다
- 대표적으로 Playground, GraphiQL가 있고
- online으로 api를 그래픽화해서 보여주는 사이트도 있음(https://graphqleditor.com/)

## 경험했던(발생 가능한) 이슈

서버
- 커스터마이징하지 않는다면 에러 핸들링이 한정적이고(503에러로 통일됨) 클라이언트에게 도움될 에러 메시지를 줄 수 없다.
- dto뿐 아니라 schema 파일도 관리해야한다. 
  - java를 사용하므로 dto를 만들어서 요청, 응답하게될 텐데 dto 파일은 상속기능으로 잘 정리할 수 있지만, 스키마 파일에서 사용하는 **GraphQL문법엔 상속 문법이 없다.**
- 파일(이미지 등) 업로드가 필요하다면 지원하는 라이브러리 중 spqr로는 거의 불가능해서 kickstart를 사용하게된다. (문제는 아님)

클라이언트
- 실제론 GraphQL 문법을 다양하게 사용하지 않게될 수도 있다. 좋을 수도, 나쁠 수도? (사용 범위 한정적)
- 조회 요청시 조회하려는 필드를 반드시 모두 적어야 한다. **Playground에서 필드가 많은 객체 반환 테스트시**엔 번거로울 수 
있으나 **실제 개발시**엔 필요한 요청은 변수나 파일로 저장해서 관리하면 된다.