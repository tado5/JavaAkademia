package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private Register register;

	/**
	 * In JDK 6 use Console class instead.
	 * 
	 * @see readLine()
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * Menu options.
	 */
	private enum Option {
		PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
	};

	public ConsoleUI(Register register) {
		this.register = register;
	}

	public void run() {
		while (true) {
			switch (showMenu()) {
			case PRINT:
				printRegister();
				break;
			case ADD:
				addToRegister();
				break;
			case UPDATE:
				updateRegister();
				break;
			case REMOVE:
				removeFromRegister();
				break;
			case FIND:
				findInRegister();
				break;
			case EXIT:
				return;
			}
		}
	}

	private String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private Option showMenu() {
		System.out.println();
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	// TODO: Implement the method printRegister

	private void printRegister() {
		for (int i = 0; i < register.getCount(); i++) {
			Person osoba = register.getPerson(i);
			int j = i + 1;
			System.out.println(j + ". " + osoba.getName() + " "
					+ osoba.getPhoneNumber());
		}
	}

	private void addToRegister() {
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();
		register.addPerson(new Person(name, phoneNumber));
	}

	// TODO: Implement the method updateRegister
	private void updateRegister() {
		System.out.println("Enter person index:");
		int p = Integer.parseInt(readLine());
		System.out
				.println(" For update name PRESS 1 .... for update phone number PRESS 2");
		int i = Integer.parseInt(readLine());
		p = p - 1;
		switch (i) {
		case 1:
			System.out.println("Enter new name: ");
			String s = readLine();
			register.getPerson(p).setName(s);
			break;
		case 2:
			System.out.println("Enter new phone number: ");
			String n = readLine();
			register.getPerson(p).setPhoneNumber(n);
			break;
		default:
			System.out.println("*** ZLY VSTUP ***");
			break;
		}

	}

	// TODO: Implement the method findInRegister
	private void findInRegister() {

		System.out.println(" vyhladasvanie  padla mena PRESS 1 .... Vyhladavanie podla cisla  PRESS 2" );
		int i = Integer.parseInt(readLine());
		switch (i) {
		case 1:
			System.out.println("Zadaj meno na hladanie");
			String name = readLine();
			register.findPersonByName(name);
			break;
		case 2: 
			System.out.println("Zadaj cislo na hladanie");
			String phoneNumber = readLine();
			register.findPersonByPhoneNumber(phoneNumber);
			break;
		default:
			System.out.println("*** ZLY VSTUP ***");
			break;
		}
		
		}


	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);
	}

}
