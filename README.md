# Java_Spring_Boot

## ```준비물```
### Oracle 공식 홈페이지에서 자신이 원하는 버전의 JAVA 설치
### (설치 경로 : https://www.oracle.com/java/technologies/downloads/ )

### IntelliJ 무료 Community Edition 설치
### (설치 경로 : https://www.jetbrains.com/ko-kr/idea/ )

##
## ```프로젝트 생성하기```
### [start.spring.io](https://start.spring.io/) 에 접속
### ![image](https://user-images.githubusercontent.com/121095166/209137026-f9c49cd1-d2c0-4b69-94f8-db703329884e.png) 설정 후 GENERATE 후 다운완료 되면 프로젝트 파일 실행

##
## ```spring boot 라이브러리```
### build.gradle에서 프로젝트 생성 할 때 불러 온 라이브러리는 Thymeleaf, web 밖에 없지만,
### External Libraries에서 여러 라이브러리 확인 가능
#### spring-boot-starter-web 라이브러리를 가져오면 그에 필요한 의존관계 라이브러리를 자동으로 가져옴
#### --- spring-boot-starter-tomcat : web server 8080를 소스 라이브러리가 가지고 있음(main 메서드를 실행만 해도 웹서버가 뜸)
#### --- spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(view)
#### --- spring-boot-starter : 스프링 부트 + 스프링 코어 + 로깅

##
## ```테스트 라이브러리```
#### spring-boot-starter-test
####    --- junit : 테스트 프레임워크
####    --- mockito : 목 라이브러리
####    --- assertj : 테스트 코드를 더 편하게 작성하게 도와주는 라이브러리
####    --- spring-test : 스프링 통합 테스트 지원

##
## ```View 환경설정```
#### welcome page 만들기 -> resources/static/index.html
#### https://spring.io/ 공식 홈페이지
#### static에서 index.html을 먼저 찾음
#### template 엔진 -> 현재 깃허브에서는 Thymeleaf 사용
#### https://www.thymeleaf.org/ 공식 홈페이지


```Thymeleaf 템플릿 동작 확인```
#### web 브라우저에서 localhost:8080/hello 을 스프링에게 보내면 톰캣 내장 서버가 스프링 컨테이너(helloController)의 Getmapping에 hello 메서드가 실행
#### 모델에 data=hello를 넣고 return -> (resources/template/hello) 를 찾음
#### 컨트롤러에서 리턴 값을 문자를 반환하면 뷰 리졸버 (viewResolver)가 화면을 찾아서 처리

####  참고 : spring-boot-devtools 라이브러리를 추가하면, html 파일을 컴파일만 해주면 서버 재시작 없이 view 파일 변경이 가능하다

##
## ```Build 하고 실행하기```
```build 하기```
#### ./gradlew build (mac)
#### cd libs
#### java -jar 프로젝트명-0.0.1-SNAPSHOT.jar

##
## ```정적 컨텐츠```
#### = 정적 컨텐츠
#### = MVC와 템플릿 엔진
#### = API
#### 스프링 부트 정적 컨텐츠 기능 자동 제공
```정적컨텐츠 개념원리```
#### 웹 브라우저에서 localhost:8080/hello-static.html 으로 보내면 톰캣내장 서버가 스프링으로 보냄
#### 내부에 있는 static/hello-static.html을 찾음

```MVC와 템프릿 엔진```
#### localhost:8080/(Getmapping 에서 찾는 파일)?name=___

#### 웹 브라이저가 localhost:8080/(Getmapping 에서 찾는 파일)?name=___ 톰캣 내장 서버에 보냄
#### helloController에 mapping 되어있으면 hello-template을 viewResolver에 넘김
#### viewResolver를 html로 변환후 웹브라우저에 전송

#### 정적컨텐츠에서는 html로 변환하지 않고 웹브라우저에 전송
#### MVC에서는 html로 변환 후 웹브라우저에 전송

```API```
#### @ResponseBody 사용
#### HTTP의 BODY에 문자 내용을 직접 반환
#### viewResolver 대신에 HttpMessageConverter가 동작
#### 기본 문자 처리 : String HttpMessageConverter
#### 기본 객체 처리 : MappingJackson2HttpMessageConverter

#### @ResponseBody가 있으면 HTTP 응답에 그대로 데이터 넘김
#### 객체 : 객체가 반환되면 기본 디폴트가 json방식으로 만들어서 반환

#### 문자이면 : StringConverter
#### 객체이면 : JsonConverter

##
## ```비즈니스 요구사항 정리```
#### 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스로 변경할 수 있도록 설계
#### 데이터 저장소는 다양한 저장소를 고민중인 상황으로 가정
#### 개발을 진행하기 위해서 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용
