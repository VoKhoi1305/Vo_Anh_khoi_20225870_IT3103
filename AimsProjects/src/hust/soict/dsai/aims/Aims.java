import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Playable;

public class Aims {
    private static Store store = new Store(); // Store instance
    private static Cart cart = new Cart();   // Cart instance
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        store.addMedia(new DigitalVideoDisc("The Lion King", "action","a" 89, 19.99));
        store.addMedia(new DigitalVideoDisc("Star Wars", "action","b" 121, 24.99));
        store.addMedia(new DigitalVideoDisc("Aladdin", "action","c" 128, 14.99));
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() {
        int choice;
        do {
            store.displayItems(); // Display all media in the store
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            media.displayInfo(); // Display media details
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    System.out.println("Returning to store menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void updateStore() {
        System.out.println("Update Store:");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                // Logic to add media
                System.out.print("Enter media title: ");
                String title = scanner.nextLine();
                System.out.print("Enter media cost: ");
                double cost = scanner.nextDouble();
                scanner.nextLine();
                Media newMedia = new Media(title, cost);
                store.addMedia(newMedia);
                System.out.println("Media added to store.");
                break;
            case 2:
                // Logic to remove media
                System.out.print("Enter media title to remove: ");
                title = scanner.nextLine();
                if (store.removeMedia(title)) {
                    System.out.println("Media removed from store.");
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 0:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void seeCurrentCart() {
        cart.displayItems(); // Display items in the cart
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    // Filtering logic
                    break;
                case 2:
                    cart.sortItems(); // Use comparators for sorting
                    break;
                case 3:
                    // Remove media logic
                    break;
                case 4:
                    // Play media logic
                    break;
                case 5:
                    // Place order logic
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
