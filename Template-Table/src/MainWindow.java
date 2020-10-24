import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	private JTable table;
	private PersonModel model;

	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(575, 397);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 419, 346);
		getContentPane().add(scrollPane);
		
		model = new PersonModel();
		table = new JTable(model);
		
		scrollPane.setViewportView(table);
		
		JButton btnNewAdd = new JButton("add");
		btnNewAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person person = new Person();
				person.setName(JOptionPane.showInputDialog("Enter Name: "));
				person.setSurname(JOptionPane.showInputDialog("Enter Surname: "));
				Main.persons.add(person);
				table.updateUI();
			}
		});
		btnNewAdd.setBounds(470, 11, 89, 23);
		getContentPane().add(btnNewAdd);
		
		JButton btnNewRemove = new JButton("remove");
		btnNewRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1 || Main.persons.size()<=0) {return;}
				Main.persons.remove(table.getSelectedRow());
				table.updateUI();
			}
		});
		btnNewRemove.setBounds(470, 45, 89, 23);
		getContentPane().add(btnNewRemove);
		setVisible(true);
	}
}
