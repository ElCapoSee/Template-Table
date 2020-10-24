import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PersonModel implements TableModel {
	private ArrayList<TableModelListener> listener;

	public PersonModel() {
		listener = new ArrayList<>();
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		listener.add(l);
		
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		String return_string = "";
		switch(columnIndex) {
		case 0:
			return_string = "Name";
			break;
		case 1:
			return_string = "Surname";
			break;
		}
		return return_string;
	}

	@Override
	public int getRowCount() {
		return Main.persons.size();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object return_object = null;
		switch(columnIndex) {
		case 0:
			return_object =  Main.persons.get(rowIndex).getName();
			break;
		case 1:
			return_object =  Main.persons.get(rowIndex).getSurname();
			break;
		}
		return return_object;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			Main.persons.get(rowIndex).setName((String) aValue);
			break;
		case 1:
			Main.persons.get(rowIndex).setSurname((String) aValue);
			break;
		}
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listener.remove(l);
		
	}

}
