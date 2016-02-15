import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 * Created by ben on 10-02-16.
 */
class ZooFrame extends JFrame {

    private AnimalTableModel tableModel;
    private JTable table;
    private JPanel animalListPanel;

    public ZooFrame() {
        super("Zoo Application");
        setLayout(new BorderLayout());
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();

        List<Animal> animals = loadAnimals();
        animalListPanel = getAnimalListPanel(animals);
        add(animalListPanel, BorderLayout.CENTER);

        // add button at window bottom
        add(buttonNew(), BorderLayout.PAGE_END);

        setVisible(true);

    }

    private JPanel getAnimalListPanel(List<Animal> animals) {
        JPanel p = new JPanel(new GridLayout(1,1)); // just take up all space

        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setVisible(true);

        tableModel = new AnimalTableModel(animals);
        table = new JTable(tableModel);
        p.add(new JScrollPane(table));

        p.setVisible(true);
        return p;
    }

    private List<Animal> loadAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Mammal("Chris", 18, "e51"));
        animals.add(new Bird("Hawk", 8, "k11"));
        animals.add(new Reptile("Monitor Lizzard", 3, "f31"));
        animals.add(new Mammal("Elephant", 12, "d57"));
        return animals;
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("Could not load look and feel " + e);
        }
    }

    private JButton buttonNew() {
        // add new item to ArrayList<Animals>, show editor
        JButton button = new JButton("Add new...");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ADD NEW pressed..." + tableModel);
                Animal.Species species = (Animal.Species) JOptionPane.showInputDialog(ZooFrame.this, "Select species", "New animal", JOptionPane.PLAIN_MESSAGE, null, Animal.Species.values(), null);
                if(species == null) { // This happens when the user clicks on 'Cancel'
                    return;
                }
                System.out.println("Adding new animal with species: " + species);
                Animal animal;
                switch (species) {
                    case Bird:
                        animal = new Bird("", 0, "");
                        break;
                    case Reptile:
                        animal = new Reptile("", 0, "");
                        break;
                    case Mammal:
                        animal = new Mammal("", 0, "");
                        break;
                    default:
                        throw new IllegalArgumentException("We don't know this species: " + species);
                }
                tableModel.addRow( animal );
            }
        });
        return button;
    }
}
