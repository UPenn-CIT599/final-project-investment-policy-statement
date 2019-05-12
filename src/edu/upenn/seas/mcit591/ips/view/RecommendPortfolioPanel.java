package edu.upenn.seas.mcit591.ips.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//Portfolio Panel that displays risk score and securities

public class RecommendPortfolioPanel extends JPanel {

	private static final long serialVersionUID = 5404790883488079749L;

// Set the display of the portfolio recommendation screen
	public RecommendPortfolioPanel() {

		Border innerBorder = BorderFactory.createTitledBorder("Recommend Portfolio");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		JLabel lblBasedOnYour = new JLabel(
				"Based on your current risk tolerance, below is the suggested portfolio allocation.");
		lblBasedOnYour.setFont(new Font("Georgia", Font.BOLD, 15));

		JLabel lblYourRiskTolerance = new JLabel("Your risk tolerance:");
		lblYourRiskTolerance.setFont(new Font("Georgia", Font.PLAIN, 15));

		JLabel lblNeedCalculate = new JLabel("<html>" + DataManager.getRiskScore() + "</html>");
		lblNeedCalculate.setForeground(new Color(0, 0, 255));
		lblNeedCalculate.setFont(new Font("Georgia", Font.PLAIN, 26));

		JLabel lblNewLabel = new JLabel("<html> out of 10 <html>");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
//		lblNewLabel.setForeground(new Color(128, 128, 128));
		// wrap text
		JLabel lblForYourRisk = new JLabel(
				"<html>Based on your risk score, the portfolio allocation recommendation and breakdown with allocation <br/> percent is as below."
						+ "The suggested asset allocation portfolio will generate a return​ of "
						+ String.format("%.2f",DataManager.getPortfolioReturn()*100)
						+ "% and <br/>the risk of the portfolio measured by the portfolio standard deviation is"
						+ String.format("%.2f", DataManager.getPortfolioReturnStdDev()*100) + "%, which means your <br/>  portfolio return can range from "
						+  String.format("%.2f", (DataManager.getPortfolioReturn() - DataManager.getPortfolioReturnStdDev()) * 100) + "%  to "
						+ String.format("%.2f",(DataManager.getPortfolioReturn() + DataManager.getPortfolioReturnStdDev()) * 100)
						+ "%. This data is calculated based on the historical <br/> performance data of the following ETFs during 04/06/2009 - 05/07/2019.");
		lblForYourRisk.setFont(new Font("Georgia", Font.PLAIN, 15));
		// word wrap, and display text

		String[] TableHeading = { "Fund Description", "Percent Allocation", "Fund Name" };
		JTable table = new JTable();
		table.setEnabled(false);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setToolTipText("Allocation Table");
		table.setForeground(new Color(65, 105, 225));
		table.setFont(new Font("Georgia", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(DataManager.getTable(), TableHeading) {
			private static final long serialVersionUID = 7327750379410642910L;
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			public String getColumnName(int col) {
				return TableHeading[col];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setMinWidth(100);
		table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Fund Description");
		table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Percent Allocation");
		table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Fund Name");
		table.setRowHeight(20);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		
		//set the layout of the panel display
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(135)
										.addComponent(lblBasedOnYour, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(120))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(300)
										.addComponent(lblYourRiskTolerance).addContainerGap(347, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(350)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 408,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblNeedCalculate, GroupLayout.DEFAULT_SIZE, 79,
																Short.MAX_VALUE)
														.addGap(350))))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(100)
										.addComponent(lblForYourRisk).addContainerGap(120, Short.MAX_VALUE))
								.addGroup(gl_contentPane
										.createSequentialGroup().addGap(146).addComponent(table,
												GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(191, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(lblBasedOnYour, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblYourRiskTolerance).addGap(5)
				.addComponent(lblNeedCalculate).addGap(5).addComponent(lblNewLabel).addGap(40)
				.addComponent(lblForYourRisk).addGap(31)
				.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(14)));
		this.setLayout(gl_contentPane);
	}
}
