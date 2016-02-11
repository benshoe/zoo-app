abstract class Animal {

  private Species animalSpecies;
  private String type;  // Animal type -- tiger, ostrich etc
  private String name;  // Animal name -- john, jack, jim ... ?

  public Animal (Species s) {     // comments from ben:
  /* we could make a constructor with the type and name, then all fields can be made
  final and we can remove the setters. It is not possible to change a
  tiger to a rabbit is it? ;-) Then we have public Animal(Species s,
  String type, String name) and the extending classes use
  super(Species.MAMMAL, “Lion”, “Scar”); or super(Species.BIRD,
  “Canarie”, “Tweety”); But we can change this later. I think the
  location/enclosure should be in the Animal class? Since this can be
  changed, it should not be in the constructor. */
  // ^^^ to be done....

    System.out.println("Animal constructor called, species: "+ s.getSpeciesName());
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

  public String getName() { // <- accidental args removed, thx, ben!
    return name;
  }

  public String toString() {
    // this will be used in animal list view!
    return animalSpecies+": "+name;
  }

  // see also e.g.: Reptile.java: move()
  public void move() {
      System.out.println("I'm an animal and will move now...");
  }

}
