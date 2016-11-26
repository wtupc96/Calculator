package front;

import static front.CalBtn.open;
import static front.CalBtn.save;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -904161841520616291L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

	public MainFrame() {
		// TODO Auto-generated constructor stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				setLayout(new BorderLayout(5, 5));

				JMenuBar jMenuBar = new JMenuBar();
				JMenu jMenuOpen = new JMenu("Options");
				jMenuBar.add(jMenuOpen);
				JMenuItem jMenuItemOpen = new JMenuItem("Open");
				JMenuItem jMenuItemSave = new JMenuItem("Save");
				jMenuOpen.add(jMenuItemOpen);
				jMenuOpen.addSeparator();
				jMenuOpen.add(jMenuItemSave);

				jMenuItemOpen.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						open();
					}
				});
				jMenuItemSave.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						save();
					}
				});

				setJMenuBar(jMenuBar);
				add(new CalBtn(), BorderLayout.CENTER);

				setTitle("Calculator");
				setSize(300, 500);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
				setVisible(true);
			}
		});

	}

}
