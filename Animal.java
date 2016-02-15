public abstract class Animal {

  public enum Species {
    Mammal,
    Bird,
    Reptile
  }

  private Species speciesType;    // Enum.
  private String name;            // Nickname give to animal, e.g. Leo.
  private int age;                // Animals Age in years.
  private String encolsureNumber; // Enclosure animal lives in.

  public Animal () {}

  //Species get & set
  public void setSpecies(Species s) {
    speciesType = s;
  }

  public Species getSpecies() {
    return speciesType;
  }

  //Name get & set
  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  //Age get & set
  public void setAge(int a) {
    age = a;
  }

  public int getAge() {
    return age;
  }

  //Enclosure set & get
  public void setEnclosure(String e) {
    encolsureNumber = e;
  }

  public String getEnclosure() {
    return encolsureNumber;
  }

}
