class Bird extends Animal {
  private double wingSpan;
  /*
                 ^^^--- ben comments:
   I like this, but a getter/setter is necessary
   And maybe we can add a boolean capableToFly?
  */
  public Bird() {
    super(Species.BIRD);
  }
}
