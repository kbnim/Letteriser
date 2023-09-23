public class Main {
    public static void main(String[] args) {
        Letteriser letteriser = new Letteriser();
        String input = "";

        while (!input.equals("exit")) {
            System.out.print("> ");
            input = System.console().readLine();
            System.out.println(letteriser.letterise(input));
        }
    }
}
