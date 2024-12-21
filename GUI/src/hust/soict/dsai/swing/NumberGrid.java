package hust.soict.dsai.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NumberGrid extends JFrame {
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete, btnReset;
	private JTextField tfDisplay;

	public NumberGrid() {
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
		addButtons(panelButtons);

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}

	void addButtons(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		for (int i = 1; i <= 9; i++) {
			btnNumbers[i] = new JButton("" + i);
			panelButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(btnListener);
		}

		btnDelete = new JButton("DEL");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);

		btnNumbers[0] = new JButton("0");
		panelButtons.add(btnNumbers[0]);
		btnNumbers[0].addActionListener(btnListener);

		btnReset = new JButton("C");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			
			if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				// Digit button: append the digit to the end of the current text
				tfDisplay.setText(tfDisplay.getText() + button);
			} else if (button.equals("DEL")) {
				// DEL button: delete the last digit
				String currentText = tfDisplay.getText();
				if (!currentText.isEmpty()) {
					tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
				}
			} else if (button.equals("C")) {
				// C button: clear the entire text field
				tfDisplay.setText("");
			}
		}
	}

	// Phương thức main để chạy ứng dụng
	public static void main(String[] args) {
		// Sử dụng SwingUtilities.invokeLater để đảm bảo ứng dụng chạy an toàn trên Event Dispatch Thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new NumberGrid(); // Tạo và hiển thị JFrame
			}
		});
	}
}