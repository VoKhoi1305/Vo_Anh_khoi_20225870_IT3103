package hust.soict.dsai.aims.screen;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
public static AddDVDscreen addDVDscreen;
public static AddCDscreen addCDscreen;
public static AddBookscreen addBookscreen;
	public static CartScreen cartScreen;
	private Store store;

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;

	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(new MenuItemListener());
		smUpdateStore.add(addDVD);

		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new MenuItemListener());
		smUpdateStore.add(addCD);

		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new MenuItemListener());
		smUpdateStore.add(addBook);

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));

		JMenuItem viewcart = new JMenuItem("View cart");
		viewcart.addActionListener(new MenuItemListener());
		menu.add(viewcart);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cart = new JButton("View cart");
		cart.addActionListener(new ButtonListener());
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}

	public StoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String button = e.getActionCommand();
			if (button.equals("View cart")) {
				setVisible(false);
				cartScreen = new CartScreen(Aims.cart);
				cartScreen.setSize(1024, 768);
			}

		}
	}

	public class MenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String menuitem = e.getActionCommand();
	        	if(menuitem.equals("Add DVD"))
	        		  {  setVisible(false);
	        		  	addDVDscreen= new AddDVDscreen();
	        		  	addDVDscreen.setSize(934,595);
	        		    
	        		  }
	        	else if(menuitem.equals("Add CD"))
	        	{
	        		setVisible(false);
	        		addCDscreen=new AddCDscreen();
	        		addCDscreen.setSize(934,595);
	        	
	        	}
	        	else if(menuitem.equals("Add Book"))
	        	{
	        		setVisible(false);
	        		addBookscreen=new AddBookscreen();
	        		addBookscreen.setSize(934,595);
	        	}
	        	else if (menuitem.equals("View cart")) {
				setVisible(false);
				cartScreen = new CartScreen(Aims.cart);
				cartScreen.setSize(1024, 768);
			}

		}
	}
	public class MediaStore extends JPanel{
		   private Media media;
		   public MediaStore(Media media) {
			    this.media = media;
			    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			    
			    JLabel title = new JLabel(media.getTitle());
			    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20)); 
			    title.setAlignmentX(CENTER_ALIGNMENT);
			    
			    JLabel cost = new JLabel("" + media.getCost() + " $"); 
			    cost.setAlignmentX(CENTER_ALIGNMENT);
			    
			    JPanel container = new JPanel();
			    container.setLayout(new FlowLayout(FlowLayout.CENTER));
			    
			    JButton addToCartButton = new JButton("Add to Cart");
			    addToCartButton.addActionListener(e -> handleAddToCartButton(media, Aims.cart)); // Call handleAddToCartButton
			    container.add(addToCartButton); 
			    
			    if (media instanceof Playable) {
			        JButton playButton = new JButton("Play");
			        playButton.addActionListener(e -> handlePlayButton(media)); // Call handlePlayButton
			        container.add(playButton);
			    }

			    this.add(Box.createVerticalGlue());
			    this.add(title); 
			    this.add(cost);
			    this.add(Box.createVerticalGlue());
			    this.add(container);
			    
			    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			   
		   
		   private void handlePlayButton(Media media) {
			    if (media instanceof Playable) {
			        Playable playableMedia = (Playable) media;

			        JDialog dialog = new JDialog();
			        dialog.setTitle("Playing Media");
			        dialog.setSize(300, 200);
			        dialog.setLayout(new BorderLayout());

			        JLabel message = new JLabel("Now Playing: " + ((Media) playableMedia).getTitle(), SwingConstants.CENTER);
			        message.setFont(new Font("Arial", Font.PLAIN, 18));
			        dialog.add(message, BorderLayout.CENTER);

			        JButton okButton = new JButton("OK");
			        okButton.addActionListener(e -> dialog.dispose());
			        dialog.add(okButton, BorderLayout.SOUTH);

			        dialog.setLocationRelativeTo(null); // Center on screen
			        dialog.setVisible(true);
			    } else {
			        JOptionPane.showMessageDialog(null, 
			            "This media type cannot be played!", 
			            "Error", 
			            JOptionPane.ERROR_MESSAGE);
			    }
			}
		   
		   private void handleAddToCartButton(Media media, Cart cart) {
			   cart.addItem(media);
			}
		}
	public static void main(String[] args) {
		// Tạo store và cart
		Store store = new Store();
		Cart cart = new Cart();

		List<String> authors2 = new ArrayList<String>();
		authors2.add("Author 2A");
		authors2.add("Author 2B");

		List<String> authors7 = new ArrayList<String>();
		authors7.add("Author 7A");

		List<String> authors8 = new ArrayList<String>();
		authors8.add("Author 8A");
		authors8.add("Author 8B");
		authors8.add("Author 8C");

		// Thêm media mẫu
		store.addMedia(new DigitalVideoDisc("DVD1's Title", "Category", 76.0f, 120, "Director"));
		store.addMedia(new Book(2, "Book2's Title", "Category", 61.0f, authors2));
		store.addMedia(new CompactDisc(1, "CD3's Title", "Category", 59.9f, 90, "Director3", "Artist3"));
		store.addMedia(new CompactDisc(2, "CD4's Title", "Category", 58.0f, 85, "Director4", "Artist4"));
		store.addMedia(new DigitalVideoDisc("DVD5's Title", "Category", 43.0f, 120, "Director"));
		store.addMedia(new CompactDisc(3, "CD6's Title", "Category", 95.0f, 75, "Director6", "Artist6"));
		store.addMedia(new Book(7, "Book7's Title", "Category", 24.0f, authors7));
		store.addMedia(new Book(8, "Book8's Title", "Category", 78.0f, authors8));
		store.addMedia(new CompactDisc(4, "CD9's Title", "Category", 95.0f, 88, "Director9", "Artist9"));
		// Khởi chạy giao diện
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new StoreScreen(store);
			}
		});
	}
}