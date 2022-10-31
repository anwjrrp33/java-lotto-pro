# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 학습테스트 실습
### String 클래스에 대한 학습 테스트
#### 요구사항 1
* [x] "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
* [x] "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
#### 요구사항 2
* [x] "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
#### 요구사항 3
* [x] "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
* [x] String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
* [x] JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
### Set Collection에 대한 학습 테스트
#### 요구사항 1
* [x] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
#### 요구사항 2
* [x] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
  * [x] JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
#### 요구사항 3
* [x] 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
* [x] 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

### 피드백
* [x] SetTest contains isTrue 제거 
* [x] given/when/then에 대한 주석 제거
* [x] 로컬 변수 없이 구현
  * substring에 대한 로컬 변수를 제거하라고 피드백을 주지 않은 이유는 substring 할 때 로컬 변수의 length 값을 참조할수 있기때문이라고 생각한다.

## 2단계 학습테스트 실습
### 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습
#### 기능 요구사항
* [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
* [x] 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
#### 프로그래밍 요구사항
* [x] indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
  * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* [x] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  * method가 한 가지 일만 하도록 최대한 작게 만들어라.
* [x] else를 사용하지 마라.

### 피드백
* [x] StringAddCalculator 역할과 책임 분리
* [x] 메서드명은 영어로 작성하고 해당 메서드를 자세히 설명하는 것은 @DisplayName을 사용
* [x] Pattern.compile을 미리 compile해서 사용
* [x] 범위가 너무 큰 RuntimeException대신 IllegalArgumentException 사용
* [x] 테스트 시 값이 0인 경우 isEqualTo(0) -> isZero() 사용
* [x] SplitNumber 의 ZERO를 public으로 사용
* [x] Calculation 클래스명 좀더 직관적으로 변경
* [x] getSplitNumbers 메서드에 대한 필요유무
* [x] static 사용여부 정리

## 3단계 학습테스트 실습
### 로또(자동)
#### 기능 요구사항
* 입력
  * [x] 구입 금액 입력
  * [x] 지난 주 당첨 번호 입력
* 로또 번호
  * [x] 1이상 45이하의 숫자만 가능하도록 유효성 검사
  * [x] 유효성 범위를 벗어났을 경우 에러 발생
* 로또
  * [x] 로또 번호가 6개 입력됬는지 유효성 검사
  * [x] 중복된 로또 번호가 입력됬는지 유효성 검사
  * [x] 다른 로또와 일치하는 숫자 비교
* 로또 목록
  * [x] 로또가 존재하는지 유효성 검사
* 금액
  * [x] Null 또는 빈 값의 유효성 검사
  * [x] 숫자 유효성 검사
  * [x] 양수 유효성 검사
  * [x] 금액별 로또 개수
* 통계
  * [x] 등수별 일치 개수
  * [x] 수익률 계산
* 출력
  * [x] 구입할 로또 금액 입력 안내 출력
  * [x] 구입한 로뜨 개수 출력
  * [x] 지난 주 당첨번호 입력 안내 출력
  * 당첨 통계
    * [x] 등수별 당첨 금액, 당첨 개수 출력
    * [x] 수익률 출력
#### 프로그래밍 요구사항
* [x] 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
#### 피드백
* [x] 기능 요구사항 정리
* [x] 로또 번호 생성기 캐싱 사용
* [x] 로또 번호 static factory 메서드 적용
* [x] 로또 랭크 Null 리턴이 아닌 의미있는 값 적용
* [x] 로또 목록 누락된 변수 적용
* [x] 겹치는 상수 공통으로 사용
* [x] LottoRank.generateRankInfo() 작업 위치 변경
* [x] 총 금액을 구하는 로직 도메인 쪽으로 변경
* [x] 로또 번호 생성기 도메인 패키지로 이동
* [x] 로또 목록 로또 번호 생성 랜덤값 의존
* [x] 로또 목록 생성자 private 적용
* [x] 부동 소수점 계산 BigDecimal 사용

## 4단계 학습테스트 실습
### 로또(자동)
#### 기능 요구사항
* 입력
  * [x] 보너스 볼 번호 입력
* 당첨 로또
  * [x] 로또 번호, 보너스 번호가 동일하지 않은지 유효성 검사
  * [x] 로또 등수 계산
* 통계
  * [x] 등수별 일치 개수
* 출력
  * 당첨 통계
    * [x] 등수별 당첨 금액, 당첨 개수 출력
#### 피드백
* [ ] reverse 등수가 추가될때마다 수정되는 방식보다 상금에 따라서 Sort 후 return
* [ ] 단순 getter, 메세지를 전달해서 처리
* [ ] static factory method 에서 인자가 2개면 관습적으로 보통 of를 사용
