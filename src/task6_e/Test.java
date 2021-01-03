package task6_e;

/** @author Andrey Egorov */
public class Test {
  public static void main(String[] args) {

    System.out.println("License Type = " + LicenseType.getTypeById(2));
    System.out.println("License Type = " + LicenseType.getTypeByName("pRO"));
    System.out.println("License Type = " + LicenseType.getTypeById(8));
    System.out.println("License Type = " + LicenseType.getTypeByName("QWErty"));

  }
}
