public abstract class Animal {

  public enum Species {
    Mammal,
    Bird,
    Reptile
  }

  private Species speciesType;
  private String name;                  // Nickname given to the animal, e.g. Leo.
  private String type;                  // Type of animal e.g Lion
  private int age;                      // Animals Age in years.
  private String encolsureNumber;       // Enclosure animal lives in.

  public Animal () {}

  //Species get
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

  // Type get & set
  public void setType(String t) {
    type = t;
  }

  public String getType() {
    return type;
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
