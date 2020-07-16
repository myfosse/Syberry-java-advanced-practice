## TASK 5. ANNOTATIONS, REFLECTION

**Task Requirements**
In the context of this task, it’s a necessity to create a custom ThreadPoolExecutor class that uses reflection to get an annotation and a list of fields of an executed class. The solution must comply with the following requirements:
- Create your own annotation with the ‘Repeat’ name and an integer parameter.
- Create a class called ‘Processor’ that contains one private ‘message’ field. The class must implement the Runnable interface. This class should set a value to the ‘message’ field that it gets through a constructor parameter. Also, this class must have the static string "The Processor class is running..." field. This text should be printed in the Run method.
- Create a ‘CustomThreadPoolExecutor’ class that extends the ‘ThreadPoolExecutor’ class. You must override the ‘execute’ method in the following way: if an instance of Runnable class has the ‘Repeat’ annotation, then its ‘run’ method must be called several times. The amount of the calling defines through the integer parameter in the Repeat annotation.
- Also, the ‘CustomThreadPoolExecutor’ class must have methods to define and display a number and content of the private non-static fields in the Runnable class. After the ‘CustomThreadPoolExecutor’ class has called the Runnable class several times, it must display the list of the above-described fields (names and content).

Here is an example of code:

1. This is a header of the ‘Processor’ class with the custom ‘Repeat’ annotation:
```
@Repeat(3)
public class Processor implements Runnable {
    private final static String LOG_MESSAGE = "The Processor class is running...";

    private String message;
.
.
```
Please, pay attention that the annotation has the '3' integer parameter. This value means that the ‘Processor’ class will be called '3' times.

2. This is an example of creating instances of the ‘Processor’ and the ‘CustomThreadPoolExecutor’ classes. The ‘Processor’ class receives a text message in its constructor, and it should assign this value to the private 'message' field. The ‘CustomThreadPoolExecutor’ class executes the ‘Processor’ class, and it should run this instance '3' times:
```
Processor processor = new Processor("Hello world!");
CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor();
customThreadPoolExecutor.execute(processor);
```

The resulting output should be the same as the following example:
```
The Processor class is running...
The Processor class is running...
The Processor class is running...
message = Hello world!
```

Pay attention, that the instance of the ‘Processor’ class has been run '3' times. Also, we can see the list of its non-static private fields. In this case, it’s only one ‘message’ field.