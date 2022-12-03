package Lab3;

public class ArithmeticMean {
    public static void main(String[] args){
        if(args.length == 0) {
            System.out.println("No arguments");
            System.exit(0);
        }
        int sum = Integer.parseInt(args[0]);
        System.out.print("Average of: ");
        for (String arg : args) {
            sum += Integer.parseInt(arg);
            if (arg.equals(args[args.length - 1])) {
                System.out.print(arg);
            } else {
                System.out.print(arg + ", ");
            }
        }
        int average = sum/args.length;
        int rest = sum % args.length;
        System.out.print(" is " + average + ", rest is: " + rest);
    }
}
