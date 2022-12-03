package Lab3;

public class FloatArithmeticMean {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments");
            System.exit(0);
        }
        double sum = 0;
        for (String arg : args) {
            sum += Double.parseDouble(arg);
            double doubleArg = Double.parseDouble(arg);
            System.out.printf("%10.3f%n", doubleArg);
        }
        double average = sum / args.length;
        System.out.println("-----------");
        System.out.printf("%10.3f%n%n", sum);
        System.out.print("Average is: ");
        System.out.printf("%.4f", average);
    }
}

