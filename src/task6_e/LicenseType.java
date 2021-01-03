package task6_e;

import java.util.Arrays;

/** @author Andrey Egorov */
public enum LicenseType {
  UNKNOWN(0, "Unknown"),
  REGULAR(1, "Regular"),
  PREMIUM(2, "Premium"),
  PRO(3, "Pro");

  private final int id;
  private final String name;

  LicenseType(final int id, final String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static LicenseType getTypeByName(final String name) {
    LicenseType[] licenseTypes = LicenseType.values();
    return Arrays.stream(licenseTypes)
        .filter(x -> x.getName().equalsIgnoreCase(name))
        .findFirst()
        .orElse(LicenseType.UNKNOWN);
    // return LicenseType.valueOf(name.toUpperCase());
  }

  public static LicenseType getTypeById(final Integer id) {
    LicenseType[] licenseTypes = LicenseType.values();
    return Arrays.stream(licenseTypes)
        .filter(x -> x.getId() == id)
        .findFirst()
        .orElse(LicenseType.UNKNOWN);
  }
}
