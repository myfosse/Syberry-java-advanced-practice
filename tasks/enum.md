## TASK 6. ENUM

**Task Requirements**

In the context of this task, it’s a necessity to create an enum named LicenseType. This enum must contain licenses. The solution must comply with the following requirements:

- The LicenseType enum must contain the following licenses: REGULAR, PREMIUM, PRO;
- Each license must have an integer identifier and a string name;
- The enum must also have two next public methods: 'LicenseType getTypeById(final Integer id)' and 'LicenseType getTypeByName(final String name)'. These methods will return the license type by an identifier or by a name.


Here is an example of code:

```
System.out.println("License Type = " + LicenseType.getTypeById(2));
System.out.println("License Type = " + LicenseType.getTypeByName("pRO"));
System.out.println("License Type = " + LicenseType.getTypeById(8));
System.out.println("License Type = " + LicenseType.getTypeByName("QWErty"));
```

The resulting output should be the same as the following example:
```
License Type = PREMIUM
License Type = PRO
License Type = UNKNOWN
License Type = UNKNOWN
```