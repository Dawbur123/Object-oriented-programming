package Lab2;

public class CommandLineArguments {
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("No arguments.");
        } else {
            System.out.println("Number of arguments: " + args.length);
            for(int i = 0; i < args.length; i++){
                System.out.println((i+1) + ". " + args[i]);
            }
        }
    }
}
