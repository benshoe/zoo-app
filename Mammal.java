class Mammal extends Animal {
  public Mammal() {
    super(Animal.Species.MAMMAL);
    System.out.println("New Mammal created of undefined type, unnamed yet.");
  }
  public Mammal(String artName, String givenName) {
    super(Animal.Species.MAMMAL);
    setType(artName);
    setName(givenName);
    System.out.println("New Mammal created of type "+artName+", given name: "+givenName);
  }

  // interface should enforce us to provide something like:
  // public JFrame speciesSpecificEditorPanel ???
}
