import javax.swing.JFrame;


public class Kopfrechner {

	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(new FlatLightLaf());
//		}  catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// 1. Create the frame.
		MainFrame frame = new MainFrame();
//		Container contentPane = frame.getContentPane();
//		contentPane.setLayout(new BoxLayout(contentPane, 1));
//		// 2. Optional: What happens when the frame closes?
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		// 3. Create components and put them in the frame.
//		// ...create emptyLabel...
//		contentPane.add(new JLabel("Test"), BorderLayout.CENTER);
//		JCheckBox ad = new JCheckBox("Addieren");
//		JCheckBox sh = new JCheckBox("Subtrahieren");
//		JCheckBox mp = new JCheckBox("Multiplizieren");
//		JCheckBox dv = new JCheckBox("Dividieren");
//		contentPane.add(ad);
//		contentPane.add(sh);
//		contentPane.add(mp);
//		contentPane.add(dv);
//		JTextField textField = new JTextField(20);
//		textField.addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					System.out.print("Enter");
//				}
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		contentPane.add(textField);
//		JButton b2 = new JButton("Fertig");
//		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
//		b2.setHorizontalTextPosition(AbstractButton.CENTER);
//		b2.setMnemonic(KeyEvent.VK_M);
//		contentPane.add(b2);

		// 4. Size the frame.
		frame.pack();

		// 5. Show it.
		frame.setVisible(true);
	}

}