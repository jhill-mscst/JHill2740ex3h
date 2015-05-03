package JHill2740ex3H;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.Font;
import java.text.DecimalFormat;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JButton calculateButton;
	private JLabel averageLabel;
	private JLabel maxLabel;
	private JLabel minLabel;
	private JTextField inputMonthTextField;
	private String [] strRainfall = {
			"1.2", "2.7", "2.2", "3.1", "2.9", "5.1",
			"3.2", "2.7", "3.6", "1.8", "2.2", "1.7" };
	DecimalFormat fmt = new DecimalFormat("#0.0");
	private JButton updateButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallForm() {
		setTitle("JHill 2740 Ex3H Rainfall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly Rainfall");
		lblMonthlyRainfall.setFont(new Font("Tempus Sans ITC", Font.BOLD, 11));
		lblMonthlyRainfall.setBounds(20, 11, 104, 25);
		contentPane.add(lblMonthlyRainfall);
		
		JList monthList = new JList();
		monthList.setBackground(UIManager.getColor("Label.background"));
		monthList.setEnabled(false);
		monthList.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthList.setBounds(20, 36, 55, 212);
		contentPane.add(monthList);
		
		rainfallList = new JList(strRainfall);
		rainfallList.setFont(new Font("Tahoma", Font.BOLD, 11));
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				do_rainfallList_valueChanged(arg0);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(83, 36, 55, 196);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(165, 53, 46, 14);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAverage.setBounds(165, 84, 55, 14);
		contentPane.add(lblAverage);
		
		JLabel lblMaximum = new JLabel("Maximum:");
		lblMaximum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaximum.setBounds(165, 118, 68, 14);
		contentPane.add(lblMaximum);
		
		JLabel lblMinimum = new JLabel("Minimum:");
		lblMinimum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMinimum.setBounds(165, 151, 68, 14);
		contentPane.add(lblMinimum);
		
		totalLabel = new JLabel("0.0");
		totalLabel.setLabelFor(lblTotal);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBounds(264, 48, 46, 25);
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		averageLabel.setLabelFor(lblAverage);
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(264, 79, 46, 25);
		contentPane.add(averageLabel);
		
		maxLabel = new JLabel("0.0");
		maxLabel.setLabelFor(lblMaximum);
		maxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maxLabel.setBounds(264, 113, 46, 25);
		contentPane.add(maxLabel);
		
		minLabel = new JLabel("0.0");
		minLabel.setLabelFor(lblMinimum);
		minLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minLabel.setBounds(264, 146, 46, 25);
		contentPane.add(minLabel);
		
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_calculateButton_actionPerformed(arg0);
			}
		});
		calculateButton.setBounds(251, 182, 89, 23);
		contentPane.add(calculateButton);
		
		updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_actionPerformed(e);
			}
		});
		updateButton.setBounds(69, 300, 89, 23);
		updateButton.setEnabled(false);
		contentPane.add(updateButton);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputMonthTextField.setText("0.0");
		inputMonthTextField.setBounds(83, 259, 55, 20);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
	}
	protected void do_calculateButton_actionPerformed(ActionEvent arg0) {
		Rainfall rainfallArray = new Rainfall(strRainfall);
		
		DecimalFormat fmt = new DecimalFormat("0.0");
		totalLabel.setText(fmt.format(rainfallArray.getTotal()));
		averageLabel.setText(fmt.format(rainfallArray.getAverage()));
		minLabel.setText(fmt.format(rainfallArray.getHighest()));
		maxLabel.setText(fmt.format(rainfallArray.getLowest()));
	}
	
	protected void do_updateButton_actionPerformed(ActionEvent e) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();
		
		inputMonthTextField.setText("0.0");
		updateButton.setEnabled(false);
		totalLabel.setText("");
		averageLabel.setText("");
		minLabel.setText("");
		maxLabel.setText("");
	}
	
	protected void do_rainfallList_valueChanged(ListSelectionEvent arg0) {
		updateButton.setEnabled(true);
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();		
	}
}
