# kotlin-lotto

## 1단계 - 문자열 덧셈 계산기
### 구현대상
1. 표현식에서 구문과 구분자를 build 할 수 있다
```kotlin
Expression("1,2").delimiters() // [",", ":"]
Expression("//;\n1;2;3").delimiters() // [";"]
Expression("1,2").syntax() // "1,2"
```

2. 표현식으로부터 글자 리스트 표현한다
```kotlin
Splitted(Expression("1,2")) // ["1", "2"]
```

3. 숫자 리스트를 빌드한다
```kotlin
NonNegativeIntList(["1", "2"]) // [1, 2]
```

4. 숫자 리스트를 모두 더한다
```kotlin
Sum([1, 2]) // 3
```

## 2단계 - 로또(자동)
### 요구사항
- [x] 입력금액에서 로또 구매수량을 알 수 있다
- [x] 로또 번호를 생성한다
  - 로또번호는 6개이다
- [x] 구매 수량만큼 로또번호들을 생성한다
- [x] 당첨번호가 있다
- [x] 두 번호그룹을 비교하여 일치수를 알 수 있다
- [x] 구매 수량만큼 비교한다
- [x] 등급별 일치수를 센다
- [x] 등급별 당첨액이 있다
- [x] 등급별 당첨액 x 일치수갯수의 총합을 구한다
- [x] 구입금액 대비 당첨금액으로 수익률을 구한다

## 3단계 - 로또(2등)
### 요구사항
- [x] 당첨번호에 보너스 번호가 있다.
- [x] 등급에 보너스볼 일치 등급이 있다
