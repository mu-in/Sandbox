# Sandbox
스터디 및 테스트 저장소입니다.

## TDD 스터디 (BE)
- 멤버 : 강동민, 김하늬
- 스터디 방식 : 스터디 하루 전까지 이슈에 **이해 안 되는 내용**, **더 알아보고 싶은 점**을 등록하고 스터디 당일 발표자가 해당 내용을 발표합니다. 등록된 이슈가 없으면 발표자 임의로 중요한 점을 정리해서 발표합니다.
- 협업 시 적용할 것 : [TDD 스터디(BE) 협업](https://github.com/mu-in/Sandbox/wiki/TDD-%EC%8A%A4%ED%84%B0%EB%94%94(BE)-%ED%98%91%EC%97%85)

## GraphQL 데모 서버 테스트하기
GraphQL 프로젝트에 관한 간략한 [Readme.md](https://github.com/mu-in/Sandbox/tree/main/muin-graphql)
> 프로젝트 환경: Spring Boot2.5, gradle7.1.1, jdk11, h2(in-memory)  
> 의존성 추가: graphql-java-kickstart

프로젝트 구조
- web 하위: restful, graphql 두 가지 방식으로 API 호출을 비교해보세요
  > RESTful: url, method로 api를 호출합니다  
  > GraphQL: 고정된 endpoint(`/graphql`), POST method로 api를 호출합니다
- resources 하위: schema 폴더 안에 필요한 스키마 파일 작성
- `application.yml`: graphql, db 설정

![img](https://user-images.githubusercontent.com/30483337/127783383-e39b3801-bba3-4e13-a6f1-289470f1f234.png)

테스트 하기
- 로컬에서 서버 실행 후 `http://localhost:8080/<툴이름>` 사용해서 API 테스트 툴 사용 가능(각 캡쳐의 url 확인해주세요)
- API 테스트시 스키마에 대한 Document도 확인 가능
- 대체로 한 가지만 넣지만 다양하게 테스트해보시라고 4가지 넣었음


Mutation(생성, 수정, 삭제)
```graphql
mutation{
    saveBook(bookDto:{
        name:"name1"
        author:"author1"
        pages:222
    })
    
    updateBook(bookDto: {
        name:"name_dif"
        author:"author_dif"
        pages:999
    })

    deleteBook(id:1)
    # 주석 처리하여 특정 요청만 실행 가능
}
```
Query(조회)
```graphql
query{
     getBook(id:1){
         name
         author
         pages
     }
     getBooks{
         id
         name
         author
         pages
     }
    # 주석 처리하여 특정 요청만 실행 가능
 }
```
Playground
![image](https://user-images.githubusercontent.com/30483337/127782368-4eccf76e-9108-40c3-8893-a6cdc244025e.png)

Altair
![image](https://user-images.githubusercontent.com/30483337/127782505-61d96824-248c-4a14-a4ce-68a1a8876b7d.png)

GraphiQL
![image](https://user-images.githubusercontent.com/30483337/127782549-b0bf3145-d4fe-4775-b94a-82c3373e1277.png)

Voyager
![image](https://user-images.githubusercontent.com/30483337/127782558-9467003d-c03c-42ec-8868-3af939094d1b.png)
