* 자세한 내용은 "2_Rooting_Checker_개발_문서.docx"와 "3_Rooting_Checker_탐지_우회_방안.docx" 참조

# rooting_checker
## 1. 개발 설계
### A. Class Diagram
<img width="100%" src="https://user-images.githubusercontent.com/77768139/198032465-d792fab3-ded1-4c9b-9fa8-77ce440e915b.jpg"/>

### B. Dynamic View Class Digram
<img width="100%" src="https://user-images.githubusercontent.com/77768139/198032506-8e2cbb27-7121-4a08-9025-ffa980f1eb50.jpg"/>

### C. Sequence Diagram - Initialization
<img width="100%" src="https://user-images.githubusercontent.com/77768139/198032577-17bb623d-2b2a-449a-b60c-c3435780caf8.jpg"/>

### D. Sequece Diagram - Start Detect
<img width="100%" src="https://user-images.githubusercontent.com/77768139/198032536-95f0ba82-1fa6-43b6-816f-4fd561165ad6.jpg"/>

### E. Descritption
Rooting Checker은 연속된 Detect Module이 동작할 수 있도록 설계하였고, Detect Module의 추가 또는 수정이 용이할 수 있도록 중점을 두어 설계를 진행하였다. 각각의 Detect Module은 Rooting을 Check할 수 있는 방법을 구현한 Module이며 Rooting Checker은 Detect Module들이 연속적으로 동작하면서 Rooting을 Check 한다. 이것은 Rooting 확인하는 새로운 방법이 새로 추가될 경우 혹은 방법이 변경될 경우 유지보수가 용이하도록 하였다. 
Rooting Checker은 Native Layer의 Detect Module 그리고 Java Layer의 Detect Module을 모두 추가할 수 있으며, 각각은 Composite Pattern을 적용함으로 Detect Module의 추가 또는 수정 뿐 만 아니라, Detect Module들을 카테고리화 시켜 적용할 수도 있다.
Java Layer의 경우 각각의 DetectModule들은 Abstract Class인 “AbstractDetectModule”을 상속받아 구현함으로 Composite Pattern을 구현하였고, Native Layer의 경우 함수 포인터를 응용하여 각각의 DetectModule에서 detect_module.h를 구현하게하여 Composite Pattern을 구현하였다.
Native Layer 개발자 또는 Java 개발자는 다른 Layer을 바라보지 않고 각 Layer에서 Detect Module을 구현하여 추가할 수 있다. 방법은 아래와 같다.
* Java Layer
  * AbstractDetectModule을 상속받아 Detect Module을 구현
  * Controller Class의 InitModule함수에 신규 Detect Module을 추가
* Native Layer
  * detect_module.h의 구현된 Structure을 구현
  * JNI_detect_engine의 init_detect_module에 신규 Detect Module을 추가
Native Layer의 Detect Module들은 Proxy를 사용하여 Java Layer의 Detect Module을 통해 호출할 수 있다. 이것은 Run time 시 Java Layer의 Detect Module들이 Proxy를 통해 Native Layer의 Detect Module들을 호출할 수 있는 관계가 만들어짐으로 가능하게 된다. 
Rooting Checker Design의 장점은 Rooting을 Check할 수 있는 Module들을 자유롭게 추가 또는 수정하여 유지보수가 용이하다는 점과 Java 개발자, Native 개발자는 각 Layer에만 집중하여 Detect Module을 개발할 수 있다는 것이다.

## 2. 개발 검증
### A. Descritpion
각 Detect Module에 대해 검증을 수행. Android Framework에서 제공하는 Unit Test를 최대한 활용하여 작성한다. Java Layer의 Detect Module들은 Junit을 활용하여 Unit Test로 작성하고, Native Layer의 Module들은 InstrumentedTest를 활용하여 작성한다. 
각 Detect Module들은 Java Native 함수 또는 C Native 함수를 활용하여 작성된 경우가 많다. 따라서, 각 Detect Module들이 Logic을 검증하기 위해서는 각 Layer의 Native 함수들을 Mocking하여 결과값을 제어할 필요가 있다. Java Layer의 경우 Junit과 같이 사용할 수 있는 mockito 또는 PowerMockito를 활용하여 사용하면 된다. 하지만 C로 작성되는 Native Layer의 경우, cpputest 등 Test Framework을 활용할 수 있으나, 본 과제에서는 최대한 개발 Tool인 Android Studio를 활용하고자 Native Layer를 Mocking 하여 Test할 수 있는 Class를 개발하여 검증을 진행한다.

## B. Native Layer Test Design
<img width="100%" src="https://user-images.githubusercontent.com/77768139/198032671-1c5ec25a-7db4-4aa3-b1cd-bc86db311fce.jpg"/>
Test Target에서의 구현은 Mocking할 API는 library_abstract_layer에 구현된 API로 대체하여 구현한다. 즉, Test Target에서 C Library중 access 함수를 사용한다면 해당 함수는 library_abstract_layer의 sal_access함수로 대체한다. library_abstract_layer에서 제공하는 함수들은 테스트 설정 여부에 따라 실제 C Library 함수 또는 Mocking 함수로 변환 제공된다. 
Test Suite에서 Test Target에 대해 테스트를 수행하는 절차는 아래와 같다.
* Ctest를 통해 enableTest를 호출한다.
* Ctest를 통해 Mocking 함수에서 원하는 값을 설정한다.
* Test Target의 함수를 호출하여 테스트를 진행한다.


