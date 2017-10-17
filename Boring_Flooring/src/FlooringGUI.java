import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class FlooringGUI extends JFrame {

	private JButton btnArea, btnCost, btnSubmit, btnConfirm, btnRefresh;
	private JRadioButton radWood, radCarpet;
	private JTextField txtLength, txtWidth, txtFName, txtLName, txtAddress, txtZip;
	private JLabel lblFloorTag, lblFloorType, lblAreaTag, lblArea, lblCostTag, lblCost, lblName, lblAddress, lblZip, lblFloorTypeSum, lblFloorAreaSum, lblCostSum;
	private JTable custTable;

    private JMenuItem newOrder, exit;
    private int pricePerSqFt;
    private String floorType;
	private JTabbedPane tab;
	
	 private double area = 0, cost=0;
	private Customer customer = new Customer();
    
	public FlooringGUI()
	{	
		super("Boring Flooring");
		tab = new JTabbedPane();
		JPanel container = new JPanel();
		JPanel inputTab = new JPanel();
		JPanel infoTab = new JPanel();
		JPanel sumTab = new JPanel();
		JPanel listTab = new JPanel();
		JPanel subSumPan = new JPanel();
		JPanel subInputPan = new JPanel();
		JPanel custInputPan = new JPanel();
		JPanel summaryPan = new JPanel();
		JPanel listPan = new JPanel();
		
		
		tab.addTab("Floor Input", null, inputTab, "Input Order");
		tab.addTab("Customer Information", null, infoTab, "Input Customer Info");
		tab.addTab("Order Summary", null, sumTab, "Order Summary");
		tab.addTab("Order List", null, listTab, "Order List");
		
		
		
		JMenu mnuFile = new JMenu("File");
		newOrder = new JMenuItem("New Order");
		exit = new JMenuItem("Exit");	
		mnuFile.add(newOrder);
		mnuFile.add(exit);
		
		JMenuBar bar =new JMenuBar();
		bar.add(mnuFile);
		
		container.setLayout(new BorderLayout());
		container.add(tab);
		
		setLayout(new BorderLayout());
		add(bar, BorderLayout.NORTH);
		add(container);
		
		ButtonGroup btns = new ButtonGroup();
		btns.add(radWood);
		btns.add(radCarpet);
		
		radWood = new JRadioButton("Wood");
		radCarpet = new JRadioButton("Carpet");
		
		txtLength = new JTextField(10);
		
		txtWidth = new JTextField(10);

		txtFName = new JTextField(20);
		txtFName.setEditable(false);
		txtLName = new JTextField(20);
		txtLName.setEditable(false);
		txtAddress = new JTextField(50);
		txtAddress.setEditable(false);
		txtZip = new JTextField(10);
		txtZip.setEditable(false);
		
		btnArea = new JButton("Calc. Area");
		btnCost = new JButton("Calc. Cost");
		btnSubmit = new JButton("Submit");
		btnConfirm = new JButton("Confirm Order");
		btnConfirm.setVisible(false);
		btnRefresh = new JButton("Refresh");
		
        custTable = new JTable();
		
		subInputPan.setPreferredSize(new Dimension(300,350));
		subInputPan.setLayout(new GridLayout(0,3));
		
		subInputPan.add(new JLabel("Floor Type: "));
		subInputPan.add(radWood);
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(radCarpet);
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel("Length: "));
		subInputPan.add(txtLength);
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel("Width: "));
		subInputPan.add(txtWidth);
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));
		subInputPan.add(new JLabel(""));

		subInputPan.add(btnArea);
		subInputPan.add(new JLabel(""));
		subInputPan.add(btnCost);
		subInputPan.add(new JLabel(""));
		subInputPan.add(btnSubmit);
		subInputPan.add(new JLabel(""));
		
		Font font = new Font("Verdana", Font.BOLD, 15);
		Color custom = new Color (214, 172, 36);
		
		lblFloorType = new JLabel("");
		lblFloorType.setFont(font);
		lblFloorType.setForeground(custom);
		lblArea = new JLabel("");
		lblArea.setFont(font);
		lblArea.setForeground(custom);
		lblCost = new JLabel("");
		lblCost.setFont(font);
		lblCost.setForeground(custom);
		lblFloorTag= new JLabel("Floor Type:");
		lblFloorTag.setFont(font);
		lblFloorTag.setForeground(custom);
		lblAreaTag=new JLabel("Area: ");
		lblAreaTag.setFont(font);
		lblAreaTag.setForeground(custom);
		lblCostTag = new JLabel("Cost: ");
		lblCostTag.setFont(font);
		lblCostTag.setForeground(custom);
		
		subSumPan.setLayout(new GridLayout(0,2));
		subSumPan.add(lblFloorTag, BorderLayout.CENTER);
		subSumPan.add(lblFloorType);
		subSumPan.add(lblAreaTag);
		subSumPan.add(lblArea);
		subSumPan.add(lblCostTag);
		subSumPan.add(lblCost);
		
		
		inputTab.setLayout(new FlowLayout());
		inputTab.add(subInputPan);
		inputTab.add(subSumPan);
		
		
		custInputPan.setPreferredSize(new Dimension(300,350));
		custInputPan.setLayout(new GridLayout(0,2));
		custInputPan.add(new JLabel(""));
		custInputPan.add(new JLabel(""));
		custInputPan.add(new JLabel("First Name: "));
		custInputPan.add(txtFName);		
		custInputPan.add(new JLabel("Last Name: "));
		custInputPan.add(txtLName);
		custInputPan.add(new JLabel("Address: "));
		custInputPan.add(txtAddress);
		custInputPan.add(new JLabel("Zip: "));
		custInputPan.add(txtZip);
		custInputPan.add(new JLabel(""));
		custInputPan.add(new JLabel(""));
		custInputPan.add(new JLabel(""));
		custInputPan.add(btnConfirm);
				
		infoTab.setLayout(new FlowLayout());
		infoTab.add(custInputPan);

		lblName = new JLabel("");
		lblAddress = new JLabel("");
		lblZip= new JLabel("");
		lblFloorTypeSum= new JLabel("");
		lblFloorAreaSum= new JLabel("");
		lblCostSum= new JLabel("");
		
		summaryPan.setLayout(new GridLayout(0,4));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel("	Name: "));
		summaryPan.add(lblName);
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel("	Address: "));
		summaryPan.add(lblAddress);
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel("	Zip: "));
		summaryPan.add(lblZip);
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel("	Floor Type: "));
		summaryPan.add(lblFloorTypeSum);
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel("	Floor Area: "));
		summaryPan.add(lblFloorAreaSum);
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel("	Cost: "));
		summaryPan.add(lblCostSum);
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		summaryPan.add(new JLabel(""));
		
		sumTab.setLayout(new BorderLayout());
		sumTab.add(summaryPan, BorderLayout.CENTER);
		

		listPan.setLayout(new BorderLayout());
		listPan.setPreferredSize(new Dimension(620,400));
	    listPan.add(new JLabel("Customer Table"), BorderLayout.NORTH);
	    listPan.add(new JScrollPane(custTable));
		listPan.add(btnRefresh, BorderLayout.SOUTH);		
		listTab.add(listPan);
	     

		
		ButtonHandler handler = new ButtonHandler();
		btnArea.addActionListener(handler);
		btnCost.addActionListener(handler);
		btnSubmit.addActionListener(handler);
		
		btnRefresh.addActionListener(handler);
		radWood.addActionListener(handler);
		radCarpet.addActionListener(handler);
		
		confirmHandler newHandler = new confirmHandler();
		btnConfirm.addActionListener(newHandler);
		
		RefreshHandler rHandler = new RefreshHandler();
		btnRefresh.addActionListener(rHandler);
		
		MenuHandler m =new MenuHandler();
		exit.addActionListener(m);
		newOrder.addActionListener(m);
	}
	
	protected class ButtonHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()== btnArea)
			{
				if(txtLength.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Length");
				}
				else
				{
					try
					{
				area = Integer.parseInt(txtLength.getText())*Integer.parseInt(txtWidth.getText());
				lblArea.setText(String.valueOf(area));
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Input Error " + ex.toString());
					}
				}
			}
			else if (e.getSource()== btnCost)
			{
				if(!radWood.isSelected() && !radCarpet.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Select Floor type");
				}
				else if(area <= 0)
				{
					JOptionPane.showMessageDialog(null, "Calculate Floor Dimensions");
				}
				else
				{
					cost = area * pricePerSqFt;
					lblCost.setText(String.valueOf(String.valueOf(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(cost))));
				}
			}
			else if (e.getSource()== btnSubmit)
			{
				if(cost == 0)
				{
					JOptionPane.showMessageDialog(null, "Complete input first");
				}
				else
				{
					
					customer.setFloorType(floorType);
					customer.setArea(area);
					customer.setCost(cost);
					txtFName.setEditable(true);
					txtLName.setEditable(true);
					txtAddress.setEditable(true);
					txtZip.setEditable(true);
					btnConfirm.setVisible(true);
					tab.setSelectedIndex(1);
				}
			}
			else if(radWood.isSelected())
			{
				floorType = "Wood";
				lblFloorType.setText(floorType);
				pricePerSqFt = 20;
			}
			else if(radCarpet.isSelected())
			{
				floorType = "Carpet";
				lblFloorType.setText(floorType);
				pricePerSqFt = 10;
			}
		}
	}
	
	protected class confirmHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()== btnConfirm)
			{
				if(txtFName.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter First Name");
				}
				else if(txtLName.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Last Name");
				}
				else if(txtAddress.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Address");
				}
				else if(txtZip.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter Zip Code");
				}
				else
				{
					customer.setName(txtFName.getText()+" "+txtLName.getText());
					customer.setAddress(txtAddress.getText());
					customer.setZip(txtZip.getText());
					lblName.setText(customer.getName());
					lblAddress.setText(customer.getAddress());
					lblZip.setText(customer.getZip());
					lblFloorTypeSum.setText(customer.getFloorType());
					lblFloorAreaSum.setText(String.valueOf(customer.getArea()));
					lblCostSum.setText(String.valueOf(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(customer.getCost())));
					
					FlooringDB floorOrder = new FlooringDB();
					
					floorOrder.addOrder(customer.getName(), customer.getAddress(), customer.getFloorType(), customer.getArea(), customer.getCost(), customer.getZip());
					
					tab.setSelectedIndex(2);
				}
			}
		}
		
	}
	
	private class RefreshHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()== btnRefresh)
			{
				FlooringDB floorOrder = new FlooringDB();
				
				custTable.setModel(floorOrder.getList());
			}
		}
	}
	
	private class MenuHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()== exit)
				System.exit(0);
			else if(e.getSource() == newOrder)
			{	
				Customer customer = new Customer();
				tab.setSelectedIndex(0);
				lblName.setText("");
				lblAddress.setText("");
				lblZip.setText("");
				lblFloorTypeSum.setText("");
				lblFloorAreaSum.setText("");
				lblCostSum.setText("");
				lblFloorType.setText("");
				lblArea.setText("");
				lblCost.setText("");
				txtLength.setText("");
				txtWidth.setText("");
				txtFName.setText("");
				txtLName.setText("");
				txtAddress.setText("");
				txtZip.setText("");
				radWood.setSelected(false);
				radCarpet.setSelected(false);
				
				txtFName.setEditable(false);				
				txtLName.setEditable(false);				
				txtAddress.setEditable(false);
				txtZip.setEditable(false);
				btnConfirm.setVisible(false);
				
				area=0;
				cost=0;
				pricePerSqFt=0;
			}
		}
			
	}

		
	
		
		
			
		
			
	
	
}
