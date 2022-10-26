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
1)	Java Layer
  A.	AbstractDetectModule을 상속받아 Detect Module을 구현
  B.	Controller Class의 InitModule함수에 신규 Detect Module을 추가
2)	Native Layer
  A.	detect_module.h의 구현된 Structure을 구현
  B.	JNI_detect_engine의 init_detect_module에 신규 Detect Module을 추가
Native Layer의 Detect Module들은 Proxy를 사용하여 Java Layer의 Detect Module을 통해 호출할 수 있다. 이것은 Run time 시 Java Layer의 Detect Module들이 Proxy를 통해 Native Layer의 Detect Module들을 호출할 수 있는 관계가 만들어짐으로 가능하게 된다. 
Rooting Checker Design의 장점은 Rooting을 Check할 수 있는 Module들을 자유롭게 추가 또는 수정하여 유지보수가 용이하다는 점과 Java 개발자, Native 개발자는 각 Layer에만 집중하여 Detect Module을 개발할 수 있다는 것이다.

