import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

/**
 * SearchPNL the panel for the search input.
 */

public class SearchPNL extends JPanel {

	/** The results. */
	protected static String results[];

	/** The map. */
	protected static JMapViewer map = new JMapViewer();

	/** The panel map. */
	protected static JPanel panelMap = new JPanel();

	/** The city field. */
	protected static javax.swing.JTextField cityField;

	/** The country field. */
	protected static javax.swing.JTextField countryField;

	/** The enter city label. */
	private javax.swing.JLabel enterCityLabel;

	/** The enter country label. */
	private javax.swing.JLabel enterCountryLabel;

	/** The icon label. */
	private javax.swing.JLabel iconLabel;

	/** The thunders panel. */
	private javax.swing.JPanel thundersPanel;

	/** The main label. */
	private javax.swing.JLabel mainLabel;

	/** The results label. */
	private javax.swing.JLabel resultsLabel;

	/** The enter button. */
	protected static javax.swing.JButton enterButton;

	/** The main panel. */
	private javax.swing.JPanel mainPanel;

	/** The user input. */
	protected static JProgressBar userInput = new JProgressBar(0, 50);

	/** The b. */
	Border b;

	/**
	 * Instantiates a new search PNL.
	 */
	public SearchPNL() {
		super();
		ReadJsfile r = new ReadJsfile("src/city.json");
		enterButton = new javax.swing.JButton();
		enterCountryLabel = new javax.swing.JLabel();
		iconLabel = new javax.swing.JLabel();
		enterCityLabel = new javax.swing.JLabel();
		cityField = new javax.swing.JTextField();
		countryField = new javax.swing.JTextField();
		mainLabel = new javax.swing.JLabel();
		resultsLabel = new javax.swing.JLabel();
		resultsLabel.setText("result");
		thundersPanel = new javax.swing.JPanel();

		b = new BevelBorder(BevelBorder.RAISED, Color.gray, Color.gray);

		setLayout(new BorderLayout());
		enterButton.setText("enter");

		userInput();

		mainLabel.setFont(new java.awt.Font("Abadi MT Condensed Extra Bold", 0, 18));
		mainLabel.setText("Global Weather Report");

		enterCountryLabel.setText("Enter the name of the country");
		enterCityLabel.setText("Enter the name of the city ");

		cityField.setBorder(b);
		countryField.setBorder(b);

		ImageIcon icon = createImageIcon("images/thunders.gif");
		iconLabel = new JLabel(icon);

		iconLabel.setBorder(b);
		setLayout(new BorderLayout());
		add(mainPanel(), BorderLayout.CENTER);

		add(iconLabel, BorderLayout.WEST);
		setVisible(true);
	}

	/**
	 *
	 * @return the main panel
	 */
	protected JComponent mainPanel() {
		mainPanel = new javax.swing.JPanel();
		javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(searchPanelLayout);
		searchPanelLayout
				.setHorizontalGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(288, 288, 288))
						.addGroup(searchPanelLayout.createSequentialGroup().addGap(20, 20, 20)
								.addGroup(searchPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(searchPanelLayout.createSequentialGroup().addComponent(enterButton)
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(searchPanelLayout.createSequentialGroup().addGroup(searchPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(enterCountryLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(searchPanelLayout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE).addComponent(enterCityLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE, 187,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(searchPanelLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(cityField, javax.swing.GroupLayout.DEFAULT_SIZE,
																178, Short.MAX_VALUE)
														.addComponent(countryField))
												.addGap(319, 319, 319))))
						.addGroup(searchPanelLayout.createSequentialGroup().addGroup(searchPanelLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(searchPanelLayout.createSequentialGroup().addGap(33, 33, 33).addComponent(
										thundersPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(searchPanelLayout.createSequentialGroup().addGap(139, 139, 139).addComponent(
										userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 339,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		searchPanelLayout.setVerticalGroup(searchPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(searchPanelLayout.createSequentialGroup()
						.addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(searchPanelLayout.createSequentialGroup().addGap(20, 20, 20)
										.addComponent(enterCountryLabel).addGap(31, 31, 31))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										searchPanelLayout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(30, 30, 30)))
						.addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(enterCityLabel).addComponent(cityField,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(25, 25, 25)
						.addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(enterButton).addComponent(userInput,
										javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(thundersPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(18, Short.MAX_VALUE)));

		mainPanel.setBorder(b);
		return mainPanel;

	}

	/**
	 * Returns an ImageIcon, or null if the path was invalid.
	 *
	 * @param path
	 *            the path
	 * @return the image icon
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = SearchPNL.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Gets the results.
	 *
	 * @return the results
	 */
	public static String[] getResults() {
		return results;
	}

	/**
	 * gets the user input and if there is match it sets the map with the input
	 * values
	 */
	public void userInput() {

		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String cityInput = cityField.getText();
				String countryInput = countryField.getText();

				if (!cityField.getText().equals("") && !countryField.getText().equals("")) {
					results = ReadJsfile.getSearchResults(cityInput, countryInput);
					if (ReadJsfile.foundMatch) {

						try {
							System.out.println("cityInput " + cityInput + ", countryInput: " + countryInput);

							System.out.println(Arrays.toString(results));

							Progress p = new Progress();
							p.progress();

							Weather w = new Weather(cityInput, countryInput);

							setMap(results[0], results[1], Double.parseDouble(results[2]),
									Double.parseDouble(results[3]));

						} catch (Exception ex) {
							Logger.getLogger(SearchPNL.class.getName()).log(Level.SEVERE, null, ex);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Try different Values", "Wrong Entry",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Empty Input", "Wrong Entry", JOptionPane.INFORMATION_MESSAGE);
				}

				ReadJsfile.foundMatch = false;
			}
		});
	}

	/**
	 * Sets the map.
	 *
	 * @param country
	 *            the country
	 * @param city
	 *            the city
	 * @param latid
	 *            the latitude
	 * @param longtid
	 *            the longitude
	 */
	public void setMap(String country, String city, double latid, double longtid) {

		new DefaultMapController(map) {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(map.getPosition(e.getPoint()));
			}
		};

		map.setDisplayPosition(new Coordinate(latid, longtid), 6);
		map.addMapMarker(new MapMarkerDot(latid, longtid));
		map.addMapMarker(new MapMarkerDot(city + "/" + MapClass.tempResult.getText(), new Coordinate(latid, longtid)));

	}

}
