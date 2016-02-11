// argh, just for concat sake, removed...
// public
enum Species {
    MAMMAL    ("Mammal"),
    BIRD      ("Bird"),
    REPTILE   ("Reptile"),
    INSECT    ("Insect");

    private String speciesName;

    Species(String name) {
      speciesName = name;
    }

    String getSpeciesName() {
      return speciesName;
    }
}
