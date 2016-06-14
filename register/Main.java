package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new ArrayRegister(20);

        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("Jozo Lukac", "0264852349"));
        register.addPerson(new Person("Tomas Bortnak", "15234568491"));
        register.addPerson(new Person("Brano Popadic", "25452545255"));
        
        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}
