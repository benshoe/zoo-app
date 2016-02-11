/* imports moved to ZooApplication to aid concatenation for submission; jan */

/**
 * Created by ben on 10-02-16.
 */
////// Originally, by ben: public
////// dropped by jan, only to make it compilable in a concatenated file :(
class AnimalListPanel extends JPanel {

    public AnimalListPanel(DefaultListModel<Animal> animals) {
        super();
        JPanel p = new JPanel(new GridLayout(2,1));
        p.setLayout(new GridLayout(3, 1));
        p.add( new JLabel("Select animal...", JLabel.CENTER) );
        // USE THIS??? :
        // https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
        JList<Animal> l = new JList<>(animals);
        l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroller = new JScrollPane(l);
        p.add(listScroller);
        p.setVisible(true);
    }
}
