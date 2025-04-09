// OOP Adventure Game - Versi Refactor & Lebih Sempurna
import java.util.*;

class Character {
    private String name;
    private int health;
    private int XP;
    private List<String> items;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.XP = 0;
        this.items = new ArrayList<>();
    }

    public void takeDamage(int damage) {
        this.health = Math.max(this.health - damage, 0);
    }

    public void heal(int amount) {
        this.health = Math.min(this.health + amount, 100);
    }

    public void addXP(int amount) {
        this.XP += amount;
    }

    public void addItem(String item) {
        if (item != null && !item.isEmpty()) {
            items.add(item);
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getXP() {
        return XP;
    }

    public List<String> getItems() {
        return items;
    }
}

class Scene {
    private String description;
    private List<Choice> choices;

    public Scene(String description) {
        this.description = description;
        this.choices = new ArrayList<>();
    }

    public void addChoice(String text, Scene nextScene, int damage, int heal, int xp, String item) {
        choices.add(new Choice(text, nextScene, damage, heal, xp, item));
    }

    public void displayScene() {
        System.out.println("\n" + description);
        for (int i = 0; i < choices.size(); i++) {
            System.out.printf("%c. %s\n", 'A' + i, choices.get(i).text);
        }
        System.out.print("Pilihanmu (A/B/C atau ketik INFO): ");
    }

    public Scene makeChoice(String input, Character player) {
        int index = input.toUpperCase().charAt(0) - 'A';
        if (index < 0 || index >= choices.size()) return null;

        Choice choice = choices.get(index);
        player.takeDamage(choice.damage);
        player.heal(choice.heal);
        player.addXP(choice.xp);
        player.addItem(choice.item);

        return choice.nextScene;
    }

    private static class Choice {
        String text;
        Scene nextScene;
        int damage, heal, xp;
        String item;

        Choice(String text, Scene nextScene, int damage, int heal, int xp, String item) {
            this.text = text;
            this.nextScene = nextScene;
            this.damage = damage;
            this.heal = heal;
            this.xp = xp;
            this.item = item;
        }
    }
}

class Story {
    private Scene startScene;
    private Character player;
    private Scanner scanner = new Scanner(System.in);

    public Story(Scene startScene, Character player) {
        this.startScene = startScene;
        this.player = player;
    }

    public void start() {
        Scene currentScene = startScene;

        while (currentScene != null && player.getHealth() > 0) {
            currentScene.displayScene();
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("INFO")) {
                showInfo();
                continue;
            }

            Scene next = currentScene.makeChoice(input, player);
            if (next == null) {
                System.out.println("Pilihan tidak valid. Coba lagi.");
            } else {
                currentScene = next;
            }
        }

        if (player.getHealth() <= 0) {
            System.out.println("\n=== Kamu gugur dalam petualangan ini... ===");
        }

        System.out.println("\n=== Permainan Selesai ===");
        showInfo();
    }

    private void showInfo() {
        System.out.println("\n=== INFO ===");
        System.out.println("Nama: " + player.getName());
        System.out.println("Health: " + player.getHealth());
        System.out.println("XP: " + player.getXP());
        System.out.println("Item: " + (player.getItems().isEmpty() ? "Tidak ada" : player.getItems()));
    }
}

public class Main {
    public static void main(String[] args) {
        Character player = new Character("Pahlawan", 100);

        // Ending scenes
        Scene endingGood = new Scene("Kamu keluar sebagai pemenang sejati.");
        Scene endingNeutral = new Scene("Kamu duduk merenung. Dunia tetap misteri.");
        Scene endingBad = new Scene("Kamu tersesat dan tidak pernah kembali.");

        // Main scenes
        Scene scene1 = new Scene("Kamu terbangun di hutan. Ada tiga jalan.");
        Scene scene2 = new Scene("Gua gelap di depanmu. Cahaya samar terlihat.");
        Scene scene3 = new Scene("Jembatan tua menghadang jalan.");
        Scene scene4 = new Scene("Dari atas pohon, kamu melihat arah utara.");
        Scene scene5 = new Scene("Roh muncul dan memberi teka-teki.");
        Scene scene6 = new Scene("Menara tua dengan penjaga batu.");
        Scene scene7 = new Scene("Sungai deras harus diseberangi.");
        Scene scene8 = new Scene("Tiga tombol: merah, hijau, biru.");
        Scene scene9 = new Scene("Pedang, tempat istirahat, buku kuno.");
        Scene scene10 = new Scene("Pintu cahaya. Pilihan akhir.");

        // Scene10 - endings
        scene10.addChoice("Masuk ke cahaya", endingGood, 0, 0, 10, null);
        scene10.addChoice("Duduk diam", endingNeutral, 0, 0, 0, null);
        scene10.addChoice("Balik dan kabur", endingBad, 0, 0, 0, null);

        // Scene9
        scene9.addChoice("Ambil pedang", scene10, 0, 0, 20, "Pedang Legendaris");
        scene9.addChoice("Istirahat", scene10, 0, 20, 0, null);
        scene9.addChoice("Baca buku", scene10, 0, 0, 15, null);

        // Scene8
        scene8.addChoice("Tekan merah", scene10, 10, 0, 0, null);
        scene8.addChoice("Tekan hijau", scene10, 0, 0, 15, null);
        scene8.addChoice("Tekan biru", scene10, 10, 10, 0, null);

        // Scene7
        scene7.addChoice("Berenang", scene6, 15, 0, 0, null);
        scene7.addChoice("Buat rakit", scene6, 0, 0, 5, null);
        scene7.addChoice("Istirahat", scene6, 0, 10, 0, null);

        // Scene6
        scene6.addChoice("Bicara", scene9, 0, 0, 0, null);
        scene6.addChoice("Serang", scene9, 20, 0, 0, null);
        scene6.addChoice("Gunakan Lentera", scene9, 0, 0, 10, null);

        // Scene5
        scene5.addChoice("Jawab", scene8, 0, 0, 20, null);
        scene5.addChoice("Serang roh", scene8, 15, 0, 0, null);
        scene5.addChoice("Diam", scene1, 0, 0, 0, null);

        // Scene4
        scene4.addChoice("Tandai dan turun", scene6, 0, 0, 0, null);
        scene4.addChoice("Lompat", scene3, 10, 0, 0, null);
        scene4.addChoice("Terjun", scene1, 20, 0, 0, null);

        // Scene3
        scene3.addChoice("Seberangi", scene6, 0, 0, 0, null);
        scene3.addChoice("Alternatif", scene7, 5, 0, 0, null);
        scene3.addChoice("Kembali", scene1, 0, 0, 0, null);

        // Scene2
        scene2.addChoice("Dekati cahaya", scene5, 0, 0, 0, "Lentera");
        scene2.addChoice("Serang bayangan", scene5, 10, 0, 0, null);
        scene2.addChoice("Kabur", scene1, 0, 0, 0, null);

        // Scene1 (start)
        scene1.addChoice("Masuk gua", scene2, 0, 0, 0, null);
        scene1.addChoice("Ikuti jalan", scene3, 0, 0, 0, null);
        scene1.addChoice("Panjat pohon", scene4, 0, 0, 0, null);

        Story story = new Story(scene1, player);
        story.start();
    }
}