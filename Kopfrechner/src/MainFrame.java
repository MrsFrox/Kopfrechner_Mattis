import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class MainFrame extends JFrame {

	protected JPanel mainPanel = null;

	protected JPanel topPanel_left;

	protected JPanel leftPanel;

	protected JPanel topPanel_right;

	protected JLabel infoText;

	protected JTextField timerTextField;

	protected JTextField inputTextField;

	protected JLabel taskLabel;

	protected JSpinner questionTextField;

	protected JButton startButton;

	protected JTable wertungTable;

	private static List<String> checkboxList;

	static int value;

	private int counter;

	private int fehlerCounter;

	private List<Aufgabe> aufgaben;

	private List<Wertung> wertungen = new ArrayList<>();

	protected int timer;

	int int_sec = 0;
	int int_min = 0;
	int int_mil = 0;

	Thread thread = new Thread(new Runnable() {
		@Override
		public void run() {
			long now = System.currentTimeMillis();
			while (true) {
				if (shouldCount) {
					if (System.currentTimeMillis() - now >= 100) {
						now = System.currentTimeMillis();
						int_mil++;
						if (int_mil > 9) {
							int_mil = 0;
							int_sec++;
							if (int_sec >= 60) {
								int_sec = 1;
								int_min++;
							}
						}
					}
				}
			}
		}
	});

	{
		checkboxList = new ArrayList<>();
		checkboxList.add(Controller.ADDIEREN);
		checkboxList.add(Controller.SUBTRAHIEREN);
		checkboxList.add(Controller.MULTIPLIZIEREN);
		checkboxList.add(Controller.DIVIDIEREN);

	}
	public static Map<String, String> map2;
	{
		map2 = new HashMap<>();
		map2.put(Controller.ADDIEREN, "+");
		map2.put(Controller.MULTIPLIZIEREN, "-");
		map2.put(Controller.MULTIPLIZIEREN, "*");
		map2.put(Controller.DIVIDIEREN, "/");

	}

	Map<String, JCheckBox> checkBoxValueMap = new HashMap<>();

	protected boolean shouldCount = true;

	public MainFrame() {
		setSize(300, 500);
		getContentPane().add(getMainPanel(), BorderLayout.CENTER);
		counter = 0;

	}

	public JPanel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc_TopPanel_left = new GridBagConstraints();
			gbc_TopPanel_left.gridy = 0;
			gbc_TopPanel_left.gridx = 0;
			gbc_TopPanel_left.gridwidth = 1;
			gbc_TopPanel_left.fill = GridBagConstraints.BOTH;
			gbc_TopPanel_left.weightx = 1;
			gbc_TopPanel_left.weighty = 1;
			mainPanel.add(getTopPanel_left(), gbc_TopPanel_left);

			GridBagConstraints gbc_topPanel_right = new GridBagConstraints();
			gbc_topPanel_right.gridx = 1;
			gbc_topPanel_right.gridy = 0;
			gbc_topPanel_right.gridwidth = 1;
			gbc_topPanel_right.fill = GridBagConstraints.BOTH;
			gbc_topPanel_right.weightx = 1;
			gbc_topPanel_right.weighty = 1;
			mainPanel.add(gettopPanel_right(), gbc_topPanel_right);

			GridBagConstraints gbc_leftPanel = new GridBagConstraints();
			gbc_leftPanel.gridy = 1;
			gbc_leftPanel.gridx = 0;
			gbc_leftPanel.fill = GridBagConstraints.BOTH;
			;
			gbc_leftPanel.weightx = 1;
			gbc_leftPanel.weighty = 1;
			mainPanel.add(getLeftPanel(), gbc_leftPanel);

			GridBagConstraints gbc_TablePanel = new GridBagConstraints();
			gbc_TablePanel.gridy = 1;
			gbc_TablePanel.gridx = 1;
			gbc_TablePanel.fill = GridBagConstraints.BOTH;
			;
			gbc_TablePanel.weightx = 1;
			gbc_TablePanel.weighty = 1;
			mainPanel.add(getWertungTable(), gbc_TablePanel);

		}
		return mainPanel;
	}

	public JPanel getTopPanel_left() {
		if (topPanel_left == null) {
			topPanel_left = new JPanel();
			topPanel_left.setLayout(new GridBagLayout());
			topPanel_left.setBackground(new Color(132, 174, 186));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridy = 0;

			for (int i = 0; i < checkboxList.size(); i++) {
				JCheckBox cb = new JCheckBox(checkboxList.get(i));
				cb.setPreferredSize(new Dimension(200, 20));
				gbc.gridx = i;
				gbc.gridy = 0;
				gbc.weighty = 1d;
				gbc.anchor = GridBagConstraints.NORTHWEST;
				topPanel_left.add(cb, gbc);
				checkBoxValueMap.put(checkboxList.get(i), cb);
			}

			GridBagConstraints gbc_textfield1 = new GridBagConstraints();
			gbc_textfield1.gridy = 0;
			gbc_textfield1.gridx = 5;
			gbc_textfield1.weighty = 1d;
			gbc_textfield1.gridwidth = checkboxList.size() - 3;
			gbc_textfield1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textfield1.anchor = GridBagConstraints.NORTH;

			topPanel_left.add(getQuestionTextField(), gbc_textfield1);

			GridBagConstraints gbc_checkbox = new GridBagConstraints();
			gbc_checkbox.gridy = 1;
			gbc_checkbox.gridx = checkboxList.size() - 1;
			gbc_checkbox.anchor = GridBagConstraints.NORTH;

		}
		return topPanel_left;
	}

	public JPanel gettopPanel_right() {
		if (topPanel_right == null) {
			topPanel_right = new JPanel();
			topPanel_right.setLayout(new GridBagLayout());
			topPanel_right.setBackground(new Color(200, 174, 186));
			GridBagConstraints gbc_Fragen = new GridBagConstraints();
			gbc_Fragen.gridx = 1;
			gbc_Fragen.gridy = 0;
			gbc_Fragen.anchor = GridBagConstraints.NORTHWEST;
			gbc_Fragen.gridwidth = 1;
			// SpinnerModel fragen = new SpinnerNumberModel();
			// topPanel_right.add(fragen,gbc_Fragen);

			GridBagConstraints gbc_timer = new GridBagConstraints();
			gbc_timer.weightx = 1;
			gbc_timer.anchor = GridBagConstraints.NORTH;
			topPanel_right.add(getTimerTextField(), gbc_timer);
			GridBagConstraints gbc_start = new GridBagConstraints();
			gbc_start.gridy = 2;
			gbc_start.gridx = 0;
			gbc_start.anchor = GridBagConstraints.NORTH;
			topPanel_right.add(getStartButton(), gbc_start);

		}
		return topPanel_right;
	}

	public JPanel getLeftPanel() {
		if (leftPanel == null) {
			leftPanel = new JPanel();
			leftPanel.setLayout(new GridBagLayout());
			leftPanel.setBackground(new Color(132, 174, 186));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.CENTER;
			gbc_label.gridy = 0;
			gbc_label.gridx = 0;
			gbc_label.insets = new Insets(5, 0, 0, 0);
			JLabel l2 = new JLabel("");
			leftPanel.add(l2, gbc_label);

			GridBagConstraints gbc_task = new GridBagConstraints();
			gbc_task.gridy = 1;
			gbc_task.gridx = 0;
			gbc_task.weightx = 1;
			// gbc_task.fill = GridBagConstraints.BOTH;
			gbc_task.anchor = GridBagConstraints.CENTER;
			gbc_task.insets = new Insets(5, 5, 0, 0);
			leftPanel.add(getTaskLabel(), gbc_task);

			GridBagConstraints gbc_infoText = new GridBagConstraints();
			gbc_infoText.anchor = GridBagConstraints.PAGE_START;
			gbc_infoText.gridy = -1;
			gbc_infoText.gridx = 0;
			gbc_infoText.insets = new Insets(0, 5, 50, 0);
			leftPanel.add(getinfoText(), gbc_infoText);

			GridBagConstraints gbc_input = new GridBagConstraints();
			gbc_input.gridx = 0;
			gbc_input.gridy = 2;
			gbc_input.gridwidth = 1;
			gbc_input.insets = new Insets(5, 0, 0, 0);
			gbc_input.anchor = GridBagConstraints.CENTER;
			leftPanel.add(getInputTextField(), gbc_input);

			GridBagConstraints gbc_fill = new GridBagConstraints();
			gbc_fill.gridy = 2;
			gbc_fill.gridx = 1;
			gbc_fill.fill = GridBagConstraints.VERTICAL;
			gbc_fill.weighty = 1d;
			leftPanel.add(new JLabel(""), gbc_fill);
		}
		return leftPanel;
	}

	public JButton getStartButton() {
		if (startButton == null) {
			startButton = new JButton("Start");
			startButton.addActionListener(l -> {

				List<String> collect = checkBoxValueMap.entrySet().stream().filter(e -> e.getValue().isSelected())
						.map(e -> e.getKey()).collect(Collectors.toList());
				repaint();
				List<Aufgabe> aufgaben = Controller.getInstance()
						.start(Integer.valueOf(getSpinnerTextField().getText().toString()), collect);
				if (aufgaben == null) {
					return;
				}
				this.aufgaben = aufgaben;
				getTaskLabel().setText(aufgaben.get(counter).toString());

				thread.start();
				Timer timer = new Timer();
				timer.scheduleAtFixedRate(new TimerTask() {

					@Override
					public void run() {
						update(int_sec, int_min, int_mil);

					}
				}, 0, 100);
				repaint();

			});
		}
		return startButton;
	}

	public JLabel getinfoText() {
		if (infoText == null) {
			infoText = new JLabel("");
			infoText.setFont(new Font("arial", Font.BOLD, 20));
		}

		return infoText;

	}

	public JTextField getTimerTextField() {
		if (timerTextField == null) {
			timerTextField = new JTextField();
			timerTextField.setPreferredSize(new Dimension(180, 50));
			timerTextField.setFont(new Font("arial", Font.BOLD, 45));
			timerTextField.setHorizontalAlignment(JTextField.CENTER);
		}
		return timerTextField;

	}

	public JTextField getInputTextField() {
		if (inputTextField == null) {
			inputTextField = new JFormattedTextField(NumberFormat.getIntegerInstance());
			inputTextField.setPreferredSize(new Dimension(150, 50));
			inputTextField.setFont(new Font("arial", Font.BOLD, 30));
			inputTextField.addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						Aufgabe aufgabe = aufgaben.get(counter);
						String text = inputTextField.getText();
						Double input = Double.valueOf(text);

						if (input.equals(aufgabe.getErgebnis())) {
							if (counter < aufgaben.size() - 1) {
								counter++;
								getinfoText().setText("");
								inputTextField.setBackground(new Color(255, 255, 255));
								getTaskLabel().setText(aufgaben.get(counter).toString());
								inputTextField.setText(null);

							} else {
								thread.stop();
								getTaskLabel().setText("Du hast es geschafft");
								getinfoText().setText("Du hast " + fehlerCounter + " Frage/n falsch beantwortet");
								
								
							}

							// Eingabe korrekt

						} else {
							inputTextField.setBackground(new Color(255, 0, 0));
							getinfoText().setText("Versuche es erneut");
							fehlerCounter++;
							repaint();

						}
						// Fehler ausgeben
						// Fehlercounter einbauen

					}
					// TODO Auto-generated method stub

				}
			});

		}
		return inputTextField;
	}

	public JLabel getTaskLabel() {
		if (taskLabel == null) {
			taskLabel = new JLabel("Hello");
			taskLabel.setFont(new Font("arial", Font.BOLD, 30));
		}
		return taskLabel;
	}

	public JTable getWertungTable() {
		if (wertungTable == null) {
			TableModel model = new AbstractTableModel() {

				@Override
				public int getRowCount() {
					// TODO Auto-generated method stub
					return wertungen.size();
				}

				@Override
				public int getColumnCount() {
					// TODO Auto-generated method stub
					return Wertung.class.getDeclaredFields().length;
				}
				
				@Override
				public String getColumnName(int column) {
				
					return "";//	Wertung.class.getFields()[column].getName();
				}

				@Override
				public Object getValueAt(int rowIndex, int columnIndex) {
					Wertung wertung = wertungen.get(rowIndex);
					String columnName = getColumnName(columnIndex);

					try {
						return wertung.getClass().getField(columnName).get(wertung);
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
							| SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}

			};
			TableColumnModel cModel = new DefaultTableColumnModel();
			Stream.of(Wertung.class.getDeclaredFields()).forEach(e -> {
				TableColumn c = new TableColumn();
				c.setHeaderValue(e.getName());
				cModel.addColumn(c);
			});
			
			
			wertungTable = new JTable(model);
			wertungTable.setTableHeader(new JTableHeader(cModel));
			Wertung e = new Wertung();
			e.setName("Name");
			e.setAnzahlFehler(1);
			e.setAnzahlFragen(4);
			e.setOperatoren(Arrays.asList("+", "-"));
			wertungen.add(e);
			wertungTable.repaint();
		}
		return wertungTable;
	}

	public boolean getshouldCount() {

		return shouldCount;

	}

	public void setshouldCount(boolean a) {
		shouldCount = a;
	}

	public JSpinner getQuestionTextField() {
		if (questionTextField == null) {
			questionTextField = new JSpinner();

		}
		return questionTextField;
	}

	public JFormattedTextField getSpinnerTextField() {
		JComponent editor = getQuestionTextField().getEditor();
		if (editor instanceof JSpinner.NumberEditor) {
			return ((JSpinner.NumberEditor) editor).getTextField();
		}
		return null;

	}

	public void update(int s, int minute, int m) {
		String sec = Integer.toString(s);
		String min = Integer.toString(minute);
		String mil = Integer.toString(m);
		if (s <= 10) {
			sec = "0" + sec;
		}

		getTimerTextField().setText(min + ":" + sec + "," + mil);
	}

}
