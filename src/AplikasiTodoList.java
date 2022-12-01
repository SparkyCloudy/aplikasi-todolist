import java.util.Scanner;

public class AplikasiTodoList {
    public static Scanner input = new Scanner(System.in);
    public static String[] model = new String[10];

    public static void main(String[] args) {
        testRemoveTodoList();
        testShowTodoList();
    }

    /**
     * Menampilkan Todo list
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            String todo = model[i];
            var no = i + 1;

            if(todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        showTodoList();
    }

    /**
     * Menambam Todo ke list
     */
    public static void addTodoList(String todo) {
        // cek apakah model penuh?
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran 2x lipat
        if(isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for(var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // Tambahkan ke posisi yang data arraynya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for(var i = 0; i < 25; i++) {
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

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);
    }
    /**
     * Menampilkan view Todo list
     */
    public static void viewShowTodoList() {

    }

    /**
     * Menampilkan view menambahkan Todo list
     */
    public static void viewAddTodoList() {

    }

    /**
     * Menampilkan view menghapus Todo list
     */
    public static void viewRemoveTodoList() {

    }
}