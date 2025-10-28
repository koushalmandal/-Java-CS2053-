import java.util.LinkedList;
import java.util.Scanner;

public class linkedlist {
    LinkedList<String> playlist;

    // Constructor
    public linkedlist() {
        playlist = new LinkedList<>();
    }

    // Add song at beginning or end
    public void addSong(String song, boolean atBeginning) {
        if (atBeginning)
            playlist.addFirst(song);
        else
            playlist.addLast(song);
        System.out.println(" Song added successfully!");
    }

    // Remove first or last song
    public void removeSong(boolean fromBeginning) {
        if (playlist.isEmpty()) {
            System.out.println(" Playlist is empty!");
            return;
        }

        if (fromBeginning)
            playlist.removeFirst();
        else
            playlist.removeLast();
        System.out.println(" Song removed successfully!");
    }

    // Replace a song at given index
    public void replaceSong(int index, String newSong) {
        if (index < 0 || index >= playlist.size()) {
            System.out.println(" Invalid index!");
            return;
        }
        playlist.set(index, newSong);
        System.out.println("Song replaced successfully!");
    }

    // Display complete playlist
    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }
        System.out.println("\n🎶 Current Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }

    // Main method (Menu-driven)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        linkedlist pm = new linkedlist();
        int choice;

        do {
            System.out.println("\n----- PLAYLIST MENU -----");
            System.out.println("1. Add Song at Beginning");
            System.out.println("2. Add Song at End");
            System.out.println("3. Remove First Song");
            System.out.println("4. Remove Last Song");
            System.out.println("5. Replace Song at Index");
            System.out.println("6. Display Playlist");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    pm.addSong(sc.nextLine(), true);
                    break;
                case 2:
                    System.out.print("Enter song name: ");
                    pm.addSong(sc.nextLine(), false);
                    break;
                case 3:
                    pm.removeSong(true);
                    break;
                case 4:
                    pm.removeSong(false);
                    break;
                case 5:
                    System.out.print("Enter index (starting from 0): ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new song name: ");
                    pm.replaceSong(index, sc.nextLine());
                    break;
                case 6:
                    pm.displayPlaylist();
                    break;
                case 7:
                    System.out.println(" Exiting Playlist Manager. Goodbye!");
                    break;
                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}
