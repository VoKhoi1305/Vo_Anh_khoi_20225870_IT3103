//package hust.soict.dsai.aims.swing;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.SwingUtilities;
//
//import hust.soict.dsai.aims.cart.Cart;
//import hust.soict.dsai.aims.media.Media;
//import hust.soict.dsai.aims.media.Playable;
//import hust.soict.dsai.aims.store.Store;
//
//public class StoreScreen extends JFrame {
//    private Store store;
//    private Cart cart;
//
//    public StoreScreen(Store store, Cart cart) {
//        this.store = store;
//        this.cart = cart;
//        
//        Container cp = getContentPane();
//        cp.setLayout(new BorderLayout());
//        
//        cp.add(createNorth(), BorderLayout.NORTH);
//        cp.add(createCenter(), BorderLayout.CENTER);
//        
//        setTitle("Store");
//        setSize(1024, 768);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//    
//    private JPanel createNorth() {
//        JPanel north = new JPanel();
//        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
//        north.add(createMenuBar());
//        north.add(createHeader());
//        return north;
//    }
//    
//    private JMenuBar createMenuBar() {
//        JMenuBar menuBar = new JMenuBar();
//        
//        JMenu menu = new JMenu("Options");
//        
//        JMenuItem viewStore = new JMenuItem("View store");
//        menu.add(viewStore);
//        
//        menuBar.add(menu);
//        return menuBar;
//    }
//    
//    private JPanel createHeader() {
//        JPanel header = new JPanel();
//        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
//        
//        JLabel title = new JLabel("AIMS");
//        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
//        title.setForeground(Color.CYAN);
//        
//        header.add(Box.createHorizontalGlue());
//        header.add(title);
//        header.add(Box.createHorizontalGlue());
//        
//        return header;
//    }
//    
//    private JPanel createCenter() {
//        JPanel center = new JPanel();
//        center.setLayout(new GridLayout(3, 3, 2, 2));
//        
//        for (Media media : store.getItemsInStore()) {
//            MediaStore cell = new MediaStore(media);
//            center.add(cell);
//        }
//        
//        return center;
//    }
//    
//    private class MediaStore extends JPanel {
//        private Media media;
//        
//        public MediaStore(Media media) {
//            this.media = media;
//            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//            
//            JLabel title = new JLabel(media.getTitle());
//            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
//            title.setAlignmentX(CENTER_ALIGNMENT);
//            
//            JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
//            cost.setAlignmentX(CENTER_ALIGNMENT);
//            
//            JPanel buttons = new JPanel();
//            buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
//            
//            JButton addToCartBtn = new JButton("Add to cart");
//            buttons.add(addToCartBtn);
//            
//            if (media instanceof Playable) {
//                JButton playBtn = new JButton("Play");
//                buttons.add(playBtn);
//                
//                playBtn.addActionListener(e -> {
//                    ((Playable) media).play();
//                });
//            }
//            
//            addToCartBtn.addActionListener(e -> {
//                cart.addMedia(media);
//            });
//            
//            add(Box.createVerticalGlue());
//            add(title);
//            add(cost);
//            add(Box.createVerticalGlue());
//            add(buttons);
//            
//            setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        }
//    }
//    
//    public static void main(String[] args) {
//        Store store = new Store();
//        Cart cart = new Cart();
//        
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new StoreScreen(store, cart);
//            }
//        });
//    }
//}
package hust;

