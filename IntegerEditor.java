import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

//Code appropriated from http://docs.oracle.com/javase/tutorial/uiswing/components/table.html#validtext
public class IntegerEditor extends DefaultCellEditor {
    JFormattedTextField formattedTextField;
    NumberFormat integerFormat;
    private boolean DEBUG = false;
 
    public IntegerEditor() {
        super(new JFormattedTextField());
        formattedTextField = (JFormattedTextField)getComponent();
 
        //Initialize editor
        integerFormat = NumberFormat.getIntegerInstance();
        NumberFormatter intFormatter = new NumberFormatter(integerFormat);

        //Set format and lower bound (Cant be a negative age)
        intFormatter.setFormat(integerFormat);
        intFormatter.setMinimum(0);
 
        formattedTextField.setFormatterFactory(new DefaultFormatterFactory(intFormatter));
        formattedTextField.setValue(0);
        formattedTextField.setHorizontalAlignment(JTextField.TRAILING);
        formattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
 
        //React to user pressing enter
        formattedTextField.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "check");
        
        formattedTextField.getActionMap().put("check", new AbstractAction() {
        
        public void actionPerformed(ActionEvent e) {

            //Invalid input
            if (!formattedTextField.isEditValid()) {
                if (userSaysRevert()) {
                    formattedTextField.postActionEvent();
                }
            } 

            //Valid input
            else try {
                //Implement input
                formattedTextField.commitEdit();
                //End editing cell
                formattedTextField.postActionEvent();
                } catch (java.text.ParseException exc) {}
            }
        });
    }
 
    //Override to invoke setValue on the formatted text field.
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JFormattedTextField formattedTextField = (JFormattedTextField)super.getTableCellEditorComponent(table, value, isSelected, row, column);
        formattedTextField.setValue(value);
        return formattedTextField;
    }
 
    //Override to ensure that the value remains an Integer.
    public Object getCellEditorValue() {
        JFormattedTextField formattedTextField = (JFormattedTextField)getComponent();
        Object o = formattedTextField.getValue();
        if (o instanceof Integer) {
            return o;
        } else if (o instanceof Number) {
            return new Integer(((Number)o).intValue());
        } else {
            if (DEBUG) {
                System.out.println("getCellEditorValue: o isn't a Number");
            }
            try {
                return integerFormat.parseObject(o.toString());
            } catch (ParseException exc) {
                System.err.println("getCellEditorValue: can't parse o: " + o);
                return null;
            }
        }
    }
 
    //Override to check whether the edit is valid.
    public boolean stopCellEditing() {
        JFormattedTextField formattedTextField = (JFormattedTextField)getComponent();
        if (formattedTextField.isEditValid()) {
            try {
                formattedTextField.commitEdit();
            } catch (java.text.ParseException exc) {}
        //Invalid input
        } else {
            //User wants to edit
            if (!userSaysRevert()) {
                //Keep editor active
                return false;
            } 
        }
        return super.stopCellEditing();
    }
    
    //Option pane
    protected boolean userSaysRevert() {
        Toolkit.getDefaultToolkit().beep();
        formattedTextField.selectAll();
        Object[] buttonOptions = {"Input another value", "Use previous value"};
        int answer = JOptionPane.showOptionDialog(
            SwingUtilities.getWindowAncestor(formattedTextField),
            "Please enter a valid number (Greater than 0) ",
            "Invalid Text Entered",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE,
            null,
            buttonOptions,
            buttonOptions[1]);
         
        if (answer == 1) {
            formattedTextField.setValue(formattedTextField.getValue());
        return true;
        }
    return false;
    }
}