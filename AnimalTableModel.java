import javax.swing.event.*;
import javax.swing.table.*;
import java.util.*;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 2/12/16.
 */
public class AnimalTableModel extends AbstractTableModel {

	private List<Animal> animals = new ArrayList<>();

	public AnimalTableModel(List<Animal> animals) {
		this.animals = animals;
	}

	public int addRow(Animal a) {
		// adds row to table and returns new row's index (NOTYET)
		animals.add(a);
		fireTableRowsInserted(animals.size(), animals.size());
		return animals.size();
	}

	@Override
	public int getRowCount() {
		return animals.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return "Species";
			case 1:
				return "Type";
			case 2:
				return "Name";
			case 3:
				return "Age (Years)";
			case 4:
				return "Enclosure (No.)";
			default:
				throw new IllegalArgumentException("We don't have columnIndex of " + columnIndex);
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
			case 0:
			case 1:
			case 2:
				return String.class;
			case 3:
				return Integer.class;
			case 4:
				return String.class;
			default:
				throw new IllegalArgumentException("We don't support columns > 3");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex > 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Animal animal = animals.get(rowIndex);
		switch(columnIndex) {
			case 0:
				return animal.getSpecies();
			case 1:
				return animal.getType();
			case 2:
				return animal.getName();
			case 3:
				return animal.getAge();
			case 4:
				return animal.getEnclosure();
			default:
				throw new IllegalArgumentException("We don't support columns > 3");
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Animal animal = animals.get(rowIndex);
		switch (columnIndex) {
			case 0:
				break;
			case 1:
				animal.setType((String) aValue);
				break;
			case 2:
				animal.setName((String) aValue);
				break;
			case 3:
				animal.setAge((Integer) aValue);
				break;
			case 4:
				animal.setEnclosure((String) aValue);
				break;
			default:
				throw new IllegalArgumentException("We don't support columns > 3");
		}
		fireTableRowsUpdated(rowIndex, columnIndex);
		fireTableChanged(new TableModelEvent(this, rowIndex));
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		super.addTableModelListener(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		super.removeTableModelListener(l);
	}
}
