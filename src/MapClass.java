import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
/**
 * MapClass defines the panel for the report values
 */
class MapClass extends JPanel {

	/**
	 * Instantiates a new map class.
	 */
	public MapClass() {
		super();
		mainPanel = new javax.swing.JPanel();
		mapPanel = new javax.swing.JPanel();
		reportLabel = new javax.swing.JLabel();
		nameLabel = new javax.swing.JLabel();
		temperLabel = new javax.swing.JLabel();
		humidityLabel = new javax.swing.JLabel();
		pressLabel = new javax.swing.JLabel();
		windLabel = new javax.swing.JLabel();
		timeLabel = new javax.swing.JLabel();
		skyLabel = new javax.swing.JLabel();
		skyResult = new javax.swing.JLabel();
		timeResult = new javax.swing.JLabel();
		windResult = new javax.swing.JLabel();
		pressResult = new javax.swing.JLabel();
		humidResult = new javax.swing.JLabel();
		tempResult = new javax.swing.JLabel();
		nameResult = new javax.swing.JLabel();
		imgLabel = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		
		reportLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18));
		
		reportLabel.setText("    Report");
		nameLabel.setText("Name");
		temperLabel.setText("Temperature");
		humidityLabel.setText("Humidity");
		pressLabel.setText("Pressure");
		windLabel.setText("Wind");
		timeLabel.setText("Date");
		skyLabel.setText("Sky");
		
		Border b1 = new BevelBorder(BevelBorder.RAISED, Color.pink, Color.pink);

		mapPanel.setBorder(b1);
		mapPanel.add(SearchPNL.map);

		setLayout(new BorderLayout());
		add(mapPanel, BorderLayout.WEST);
		add(data(), BorderLayout.EAST);
		setVisible(true);

	}

	/**
	 *
	 * @return the panel with the data
	 */
	protected static JComponent data() {
		
		dataPanel = new javax.swing.JPanel();
		javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
		dataPanel.setLayout(dataPanelLayout);

		dataPanelLayout.setHorizontalGroup(dataPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(dataPanelLayout.createSequentialGroup().addGroup(dataPanelLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(dataPanelLayout
								.createSequentialGroup()
								.addGap(62, 62,
										62)
								.addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(dataPanelLayout.createSequentialGroup()
												.addGroup(dataPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(temperLabel)
														.addComponent(nameLabel).addComponent(humidityLabel)
														.addComponent(pressLabel))
												.addGap(18, 18, 18)
												.addGroup(dataPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(pressResult, javax.swing.GroupLayout.DEFAULT_SIZE,
																105, Short.MAX_VALUE)
														.addComponent(humidResult, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(tempResult, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(nameResult, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addGroup(dataPanelLayout.createSequentialGroup().addGroup(dataPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(windLabel).addComponent(timeLabel)
												.addGroup(dataPanelLayout.createSequentialGroup().addComponent(skyLabel)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(imgLabel)))
												.addGap(18, 18, 18)
												.addGroup(dataPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(skyResult, javax.swing.GroupLayout.PREFERRED_SIZE,
																119, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(timeResult,
																javax.swing.GroupLayout.PREFERRED_SIZE, 150,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(windResult,
																javax.swing.GroupLayout.PREFERRED_SIZE, 119,
																javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addGroup(dataPanelLayout.createSequentialGroup().addGap(87, 87, 87).addComponent(reportLabel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(86, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						dataPanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 236,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		dataPanelLayout.setVerticalGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(dataPanelLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(reportLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(nameLabel).addComponent(nameResult))
						.addGap(24, 24, 24)
						.addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(temperLabel).addComponent(tempResult))
						.addGap(28, 28, 28)
						.addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(humidityLabel).addComponent(humidResult))
						.addGap(30, 30, 30)
						.addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(pressLabel).addComponent(pressResult))
						.addGap(30, 30, 30)
						.addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(windLabel).addComponent(windResult))
						.addGap(33, 33, 33)
						.addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(timeLabel).addComponent(timeResult))
						.addGap(31, 31, 31)
						.addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(skyLabel).addComponent(skyResult).addComponent(imgLabel,
										javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(21, Short.MAX_VALUE)));
		
		Border b1 = new BevelBorder(BevelBorder.RAISED, Color.pink, Color.pink);
		dataPanel.setBorder(b1);
		dataPanel.setBackground(new Color(255, 255, 230));
		return dataPanel;
	}

	/** The sky label. */
	protected static javax.swing.JLabel skyLabel;
	
	/** The sky result. */
	protected static javax.swing.JLabel skyResult;
	
	/** The data panel. */
	protected static javax.swing.JPanel dataPanel;
	
	/** The humid result. */
	protected static javax.swing.JLabel humidResult;
	
	/** The humidity label. */
	protected static javax.swing.JLabel humidityLabel;
	
	/** The img label. */
	protected static javax.swing.JLabel imgLabel;
	
	/** The j separator 2. */
	protected static javax.swing.JSeparator jSeparator2;
	
	/** The main panel. */
	protected static javax.swing.JPanel mainPanel;
	
	/** The map panel. */
	protected static javax.swing.JPanel mapPanel;
	
	/** The name label. */
	protected static javax.swing.JLabel nameLabel;
	
	/** The name result. */
	protected static javax.swing.JLabel nameResult;
	
	/** The press label. */
	protected static javax.swing.JLabel pressLabel;
	
	/** The press result. */
	protected static javax.swing.JLabel pressResult;
	
	/** The report label. */
	protected static javax.swing.JLabel reportLabel;
	
	/** The temp result. */
	protected static javax.swing.JLabel tempResult;
	
	/** The temper label. */
	protected static javax.swing.JLabel temperLabel;
	
	/** The time label. */
	protected static javax.swing.JLabel timeLabel;
	
	/** The time result. */
	protected static javax.swing.JLabel timeResult;
	
	/** The wind label. */
	protected static javax.swing.JLabel windLabel;
	
	/** The wind result. */
	protected static javax.swing.JLabel windResult;
	// End of variables declaration

}
