package Lab3;

public class TestClass {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments");
            System.exit(0);
        }
        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            Class c = new Class();
        }
        System.out.printf("%nNumbers of objects: " + args[0] + "%n");
    }
}
class Class {
    private static int ID;
    public Class() {
        ID++;
        long time = System.currentTimeMillis();
        System.out.println(ID + ". " + time);

    }

}
