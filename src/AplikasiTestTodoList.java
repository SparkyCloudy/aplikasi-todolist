import java.util.Arrays;
import java.util.Scanner;

public class AplikasiTestTodoList {
    public static Scanner scanner = new Scanner(System.in);
    public static String[] model = new String[10]; // default length 10

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan Todo list
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            String todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        showTodoList();
        System.out.println(Arrays.toString(model));
    }

    /**
     * Menambam Todo ke list
     */
    public static void addTodoList(String todo) {
        // cek apakah model penuh?
        var isFull = true;

        for (String value : model) {
            if (value == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            System.arraycopy(temp, 0, model, 0, temp.length);
        }

        // Tambahkan ke posisi yang data arraynya NULL
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (var i = 0; i < 25; i++) {
            addTodoList("TodoList ke-" + i);
        }

        showTodoList();
    }

    /**
     * Menghapus Todo dari list
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(1);
        System.out.println(result);
    }

    public static String input(String info) {
        System.out.print(info + ": " );
        return scanner.nextLine();
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * Menampilkan view Todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("menu:");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("pilih");

            switch (input) {
                case "1" -> viewAddTodoList();
                case "2" -> viewRemoveTodoList();
                case "x" -> {
                    return;
                }
                default -> System.out.println("Pilihan salah!");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan Todo list
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");

        var todo = input("todo: ");

        if (todo.equals("x")) {
            // keluar dari viewaddtodo
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan view menghapus Todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("nomer yang dihapus (x jika batal)");

        if (number.equals("x")) {
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todoList: " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}