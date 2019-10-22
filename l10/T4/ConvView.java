import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ConvView extends JFrame {
	
	//constants
	private static final String INITIAL_VALUE=" ";
	
	//components
	private JTextField sum_tf = new JTextField(5);
	private JTextField result_tf = new JTextField(5);
	private JButton convert_button = new JButton(">>");
	private JList<String> convert_from_list = new JList<>();
    private JList<String> convert_to_list = new JList<>();
    
    private JLabel convertion_ratio_label = new JLabel(INITIAL_VALUE);
    private JLabel initial_sum_label = new JLabel("Suma:");
    private JLabel result_label = new JLabel("Rezultat:");
    private JLabel from_label = new JLabel("   ");
    private JLabel to_label = new JLabel("   ");
    
    private ConvModel m_model;
    
    ConvView (ConvModel model)
    {
    	super("Currency Converter");
    	m_model=model;
    	
    	result_tf.setText(INITIAL_VALUE);
    	result_tf.setEditable(false);
    	convert_button.setForeground(Color.WHITE);
    	convert_button.setBackground(Color.BLUE);
    	
    	DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("RON");
        listModel.addElement("EUR");
        listModel.addElement("USD");

        convert_from_list.setModel(listModel);
        convert_to_list.setModel(listModel);

        convert_from_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        convert_from_list.setLayoutOrientation(JList.VERTICAL);
        convert_from_list.setVisibleRowCount(-1);
        convert_to_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        convert_to_list.setLayoutOrientation(JList.VERTICAL);
        convert_to_list.setVisibleRowCount(-1);

        JScrollPane convertFromScroll = new JScrollPane(convert_from_list);
        JScrollPane convertToScroll = new JScrollPane(convert_to_list);

        convertFromScroll.setPreferredSize(new Dimension(100, 100));
        convertToScroll.setPreferredSize(new Dimension(100, 100));

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(convertFromScroll);
        centerPanel.add(convert_button);
        centerPanel.add(convertToScroll);

        JPanel initSum = new JPanel(new FlowLayout(FlowLayout.CENTER));
        initSum.add(initial_sum_label);
        initSum.add(sum_tf);
        initSum.add(from_label);

        JPanel resultSum = new JPanel(new FlowLayout(FlowLayout.CENTER));
        initSum.add(result_label);
        initSum.add(result_tf);
        initSum.add(to_label);
        
        
        JPanel convertOps = new JPanel(new FlowLayout(FlowLayout.CENTER));
        convertOps.add(initSum);
        convertOps.add(resultSum);
        
        JPanel pageStart = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pageStart.add(convertion_ratio_label);

        JPanel content = new JPanel(new BorderLayout());
        content.add(pageStart, BorderLayout.NORTH);
        content.add(convertOps, BorderLayout.PAGE_END);
        content.add(centerPanel, BorderLayout.CENTER);
        
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	
    }
    
    public String getInput() {
        return sum_tf.getText();
    }

    public void setResult(String result) {
        result_tf.setText(result);
    }
    
    public void addButtonListener(ActionListener btn) {
        convert_button.addActionListener(btn);
    }

    public String getFromCurrency() {
        return convert_from_list.getSelectedValue();
    }

    public String getToCurrency() {
        return convert_to_list.getSelectedValue();
    }
    
    public void showError(String err) {
        JOptionPane.showMessageDialog(this, err);
    }

    public void setLabelValue(String from, String to) 
    {
        from_label.setText(from);
        to_label.setText(to);

        switch (from) {
            case "EUR":
                if (to.equals("RON")) {
                    convertion_ratio_label.setText("1 EUR = 4.66 RON");
                } else if (to.equals("USD")) {
                    convertion_ratio_label.setText("1 EUR = 1.14 USD");
                } else {
                    convertion_ratio_label.setText("1 EUR = 1 EUR");
                }

                break;
            case "USD":
                if (to.equals("RON")) {
                    convertion_ratio_label.setText("1USD = 4.07 RON");
                } else if (to.equals("EUR")) {
                    convertion_ratio_label.setText("1 USD = 0.88 EUR");
                } else {
                    convertion_ratio_label.setText("1 USD = 1 USD");
                }

                break;
            case "RON":
                if (to.equals("EUR")) {
                    convertion_ratio_label.setText("1 RON = 0.22 EUR");
                } else if (to.equals("USD")) {
                    convertion_ratio_label.setText("1 RON = 0.25 USD");
                } else {
                    convertion_ratio_label.setText("1 RON = 1 RON");
                }
        }
    }
    

}
