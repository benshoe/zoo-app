class Mammal extends Animal {
  public Mammal() {
    super(Species.MAMMAL);
    System.out.println("New Mammal created of undefined type, unnamed yet.");
  }
  public Mammal(String artName, String givenName) {
    super(Species.MAMMAL);
    setType(artName);
    setName(givenName);
    System.out.println("New Mammal created of type "+artName+", given name: "+givenName);
  }
}
