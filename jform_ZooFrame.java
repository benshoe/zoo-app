import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Feb 11 21:17:59 CET 2016
 */



/**
 * @author Jan Hacker
 */
public class ZooFrame extends JFrame {
	public ZooFrame() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Jan Hacker
		label1 = new JLabel();
		centerPanel = new JPanel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		editPanel = new JPanel();
		panel4 = new JPanel();
		label2 = new JLabel();
		textField1 = new JTextField();
		panel5 = new JPanel();
		label3 = new JLabel();
		textField2 = new JTextField();
		panel6 = new JPanel();
		label4 = new JLabel();
		textField3 = new JTextField();
		panel7 = new JPanel();
		label5 = new JLabel();
		textField4 = new JTextField();
		panel8 = new JPanel();
		label6 = new JLabel();
		textField5 = new JTextField();
		buttonPanel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();

		//======== this ========
		setTitle("Zoo Editor");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//---- label1 ----
		label1.setText("Select animal to edit");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label1, BorderLayout.NORTH);

		//======== centerPanel ========
		{

			// JFormDesigner evaluation mark
			centerPanel.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), centerPanel.getBorder())); centerPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(table1);
			}
			centerPanel.add(scrollPane1);

			//======== editPanel ========
			{
				editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.X_AXIS));

				//======== panel4 ========
				{
					panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));

					//---- label2 ----
					label2.setText("Species");
					panel4.add(label2);
					panel4.add(textField1);
				}
				editPanel.add(panel4);

				//======== panel5 ========
				{
					panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));

					//---- label3 ----
					label3.setText("Type");
					panel5.add(label3);
					panel5.add(textField2);
				}
				editPanel.add(panel5);

				//======== panel6 ========
				{
					panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));

					//---- label4 ----
					label4.setText("Name");
					panel6.add(label4);
					panel6.add(textField3);
				}
				editPanel.add(panel6);

				//======== panel7 ========
				{
					panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));

					//---- label5 ----
					label5.setText("Age");
					panel7.add(label5);
					panel7.add(textField4);
				}
				editPanel.add(panel7);

				//======== panel8 ========
				{
					panel8.setLayout(new BoxLayout(panel8, BoxLayout.Y_AXIS));

					//---- label6 ----
					label6.setText("Enclosure Number");
					panel8.add(label6);
					panel8.add(textField5);
				}
				editPanel.add(panel8);
			}
			centerPanel.add(editPanel);
		}
		contentPane.add(centerPanel, BorderLayout.CENTER);

		//======== buttonPanel ========
		{
			buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));

			//---- button1 ----
			button1.setText("New animal");
			buttonPanel.add(button1);

			//---- button2 ----
			button2.setText("Save");
			buttonPanel.add(button2);
		}
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Jan Hacker
	private JLabel label1;
	private JPanel centerPanel;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JPanel editPanel;
	private JPanel panel4;
	private JLabel label2;
	private JTextField textField1;
	private JPanel panel5;
	private JLabel label3;
	private JTextField textField2;
	private JPanel panel6;
	private JLabel label4;
	private JTextField textField3;
	private JPanel panel7;
	private JLabel label5;
	private JTextField textField4;
	private JPanel panel8;
	private JLabel label6;
	private JTextField textField5;
	private JPanel buttonPanel;
	private JButton button1;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
