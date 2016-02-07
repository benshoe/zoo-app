class ZooEditor {
  // main window and its size
  private JFrame f;
  private final int editorWindowWidth = 600;
  private final int editorWindowHeight = 400;
  // Editor data storage
  //private ArrayList<Animal> inhabitants;
  private int selectedAnimal; // should point to item in list
  // instead of ArrayList<Animal> inhabitants:
  DefaultListModel<Animal> inhabitants;

  public ZooEditor () {
    // set up data structures
    // inhabitants = new ArrayList<Animal>();
    // add some initial inhabitants to the Zoo
    // inhabitants.add(new Mammal("Human","Ben"));
    // inhabitants.add(new Mammal("Human","Chris"));
    // alternative way ...
    // Mammal jan = new Mammal();
    // jan.setName("Jan");
    // jan.setType("Human");
    // inhabitants.add(jan);
    //inhabitants.add(new Bird("Foo","Bar"));

    /// better Alternative? Eases listing using JList -> animalChooserPanel()
    inhabitants = new DefaultListModel<Animal>();
    inhabitants.addElement( new Mammal("Human","Ben") );
    inhabitants.addElement( new Mammal("Human","Chris") );
    inhabitants.addElement( new Mammal("Human","Jan") );

    // set up main window
    setupMainWindow();
  }

  private void setupMainWindow() {
    f = new JFrame("Zoo Editor (v2016.0.1)");
    f.setLayout(new GridLayout(3,1)); // 3 rows, 1 cols
    f.setPreferredSize(new Dimension(editorWindowWidth,editorWindowHeight));

    // first row (head / title)
    f.add( new JLabel("Zoo", JLabel.CENTER) );

    // second row (split into two columns: animal chooser and editor)
    JPanel windowCenterRow = new JPanel(new GridLayout(1,2));
    windowCenterRow.add( animalChooserPanel() );
    windowCenterRow.add( animalEditorPanel() );
    f.add(windowCenterRow);

    // third row, buttons
    JPanel buttons = new JPanel(new GridLayout(1,2));
    buttons.add( buttonNew() );
    buttons.add( buttonSave() );
    f.add(buttons);

    f.pack();
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  private JButton buttonNew() {
    // add new item to ArrayList<Animals>, show editor
    JButton button = new JButton("Add new...");
    button.addActionListener(new NewAnimalButtonListener(inhabitants));
    return button;
  }

  private JButton buttonSave() {
    // add ev listener to actually save when pressed...
    JButton button = new JButton("Save");
    button.addActionListener(new UpdateAnimalButtonListener());
    return button;
  }

  public JPanel animalChooserPanel() {
    JPanel p = new JPanel(new GridLayout(2,1));
    p.add( new JLabel("Select animal...", JLabel.CENTER) );
    // USE THIS??? :
    // https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
    JList l = new JList<Animal>(inhabitants);
    l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane listScroller = new JScrollPane(l);
    p.add(listScroller);
    return p;
  }

  public JPanel animalEditorPanel( /* optional existing Record */ ) {
    // should receive events animalSelected/Added and re-fire?
    JPanel p = new JPanel(new GridLayout(3,2));
    p.add( new JLabel("Editor, base data plus specifics", JLabel.CENTER) );
    // I think this panel should be half static, half dynamic:
    // static: "type" input field and "species" dropdown
    // dynamic: species-specific panel-contents, a la
    // p.add( existingRecord.showSpeciesSpecificPanel()? )
    return p;
  }

  public JPanel speciesChooserPanel(int speciesId) {
    // lists available species, .onChange: show species-specific edit form below
    // speciesId is pre-selected
    JPanel p = new JPanel(new GridLayout(3,2));
    p.add( new JLabel("DROPDOWN", JLabel.CENTER) );
    return p;
  }

}
