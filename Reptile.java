class Reptile extends Animal {
  private int footCount;
  public Reptile() {
    super(Species.REPTILE);
  }

  // ben:
  // This method is not declared in Animal, so it doesn’t override,
  // but I like that idea so let’s introduce it.
  @Override
  public void move() {
      System.out.println("I'm a reptile");
  }
}
