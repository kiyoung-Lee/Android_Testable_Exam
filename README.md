# Android_Testable_Exam
안드로이드 탐구영역 풀이

1. 다음 코드를 보고, Testable하지 않은 이유를 설명하고, 알맞
게 고치시오. [1점]

~~~
public LocalDate calculateExpiry(int payAmounts) {
  LocalData now = LocalData.now();
  if(now.getMonth() == 8)
    return now.plusMonths(payAmounts / 5000)
    .plusDays(15);
  else
    return now.plusMonths(payAmounts / 5000);
}

@Test
void calculate() {
  LocalDate date = cal.calculateExpiry(20000);
  assertEquals(LocalData.of(2019, 8, 14), date);
}
~~~

이유: LocalDate가 내부 변수로 선언되어 있어 조건문에 따른 테스트가 불가능하다.

수정:
~~~
public LocalDate calculateExpiry(LocalDate now, int payAmounts) {
  if(now.getMonth() == 8)
    return now.plusMonths(payAmounts / 5000)
    .plusDays(15);
  else
    return now.plusMonths(payAmounts / 5000);
}

@Test
void calculate_8month() {
  LocalDate now = mock(LocalDate.class);
  
  when(now.getMonth()).thenReturn(8);
  
  LocalDate date = cal.calculateExpiry(now, 20000);
  assertEquals(LocalData.of(2019, 8, 14), date);
}

@Test
void calculate_other_month() {
  LocalDate noew = mock(LocalDate.class);
  
  when(now.getMonth()).thenReturn(2);
  
  LocalDate date = cal.calculateExpiry(now, 20000);
  assertEquals(LocalData.of(2019, 8, 14), date);
}
~~~
