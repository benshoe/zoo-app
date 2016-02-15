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
		//http://stackoverflow.com/questions/3179136/jtable-how-to-refresh-table-model-after-insert-delete-or-update-the-data
		// http://stackoverflow.com/questions/4392722/how-to-repaint-a-jpanel-after-have-drawn-on-it
		return animals.size();
	}

	@Override
	public int getRowCount() {
		return animals.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return "Species";
			case 1:
				return "Name";
			case 2:
				return "Age (Years)";
			case 3:
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
			case 3:
				return String.class;
			case 2:
				return Integer.class;
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
				return animal.getName();
			case 2:
				return animal.getAge();
			case 3:
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
				animal.setName((String) aValue);
				break;
			case 2:
				animal.setAge((Integer) aValue);
				break;
			case 3:
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
