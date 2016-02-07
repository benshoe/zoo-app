class NewAnimalButtonListener implements ActionListener {
  private DefaultListModel<Animal> list;
  public NewAnimalButtonListener(DefaultListModel<Animal> l) {
    list = l;
  }
  public void actionPerformed(ActionEvent e) {
      System.out.println("ADD NEW pressed...");
      // should add new item to inhabitants
      // FIXME:
      // how to add yet-type-undefined Animal if it's abstract? :-(
      list.addElement( new Mammal("UNDEFINED","UGLY") );
  }
}
