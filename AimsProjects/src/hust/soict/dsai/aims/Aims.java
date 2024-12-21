package hust.soict.dsai.aims;

import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Playable;

public class Aims {
    public static Store store = new Store();
    public static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some initial media to the store
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 124, "George Lucas"));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f, 90, "John Musker"));

        int choice;
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
        System.out.println("AIMS: ");
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
            store.displayItems();
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
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
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
        Media media = store.searchByTitle(title);

        if (media != null) {
            media.displayInfo();
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                cart.addMedia(media);
                break;
            case 2:
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("This media cannot be played.");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

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
                addMedia();
                break;
            case 2:
                removeMedia();
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void addMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        System.out.print("Enter media category: ");
        String category = scanner.nextLine();
        System.out.print("Enter media cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter director: ");
        String director = scanner.nextLine();
        System.out.print("Enter length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, cost, length, director);
        store.addMedia(newDVD);
    }

    public static void removeMedia() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        store.removeMedia(title);
    }

    public static void seeCurrentCart() {
        cart.displayItems();
        cartMenu();
    }

    public static void cartMenu() {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

    public static void filterCart() {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Media media = cart.searchById(id);
            if (media != null) {
                media.displayInfo();
            } else {
                System.out.println("No media found with this ID.");
            }
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            Media media = cart.searchByTitle(title);
            if (media != null) {
                media.displayInfo();
            } else {
                System.out.println("No media found with this title.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void sortCart() {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            cart.sortByTitle();
            System.out.println("Cart sorted by title.");
        } else if (choice == 2) {
			cart.sortByCost();
            System.out.println("Cart sorted by cost.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void playMediaFromCart() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void placeOrder() {
        System.out.println("An order is created.");
        cart = new Cart(); // Empty the current cart
    }
}