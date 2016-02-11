abstract class Animal {
  // does each animal have it's own JFrame "display logic"?
  //protected String clade; // https://en.wikipedia.org/wiki/Clade ??
  private String[] species = {"undefined","Mamal","Bird","Reptile"};
  public enum Species {
    UNDEFINED ("Please select species"),
    MAMMAL    ("Mammal"),
    BIRD      ("Bird"),
    REPTILE   ("Reptile"),
    INSECT    ("Insect");

    private /* ???? */ String speciesName;

    Species(String name) {
      speciesName = name;
    }
  }
  private Species animalSpecies;
  private String type;  // Animal type -- tiger, ostrich etc
  private String name;  // Animal name -- john, jack, jim ... ?

  public Animal (Species s) {
    System.out.println("Animal constructor called, species: "+ s.speciesName);
    animalSpecies = s;
  }

  public void setType(String t) {
    System.out.println("Setting type to "+t);
    type = t;
  }

  public String getType() {
    return type;
  }

  public void setName(String n) {
    System.out.println("Setting name to "+n);
    name = n;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    // this will be used in animal list view!
    return animalSpecies+": "+name;
  }

}
