package register;

import java.io.IOException;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
	/** register.Person array. */
	public Person[] persons;

	/** Number of persons in this register. */
	public int count;

	/**
	 * Constructor creates an empty register with maximum size specified.
	 * 
	 * @param size
	 *            maximum size of the register
	 */
	public ArrayRegister(int size) {
		persons = new Person[size];
		count = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getCount()
	 */
	@Override
	public int getCount() {
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getSize()
	 */
	@Override
	public int getSize() {
		return persons.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#getPerson(int)
	 */
	@Override
	public Person getPerson(int index) {
		return persons[index];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#addPerson(register.Person)
	 */
	@Override
	public void addPerson(Person person) {
		persons[count] = person;
		count++;
	}

	// TODO: Implement the method findPersonByName
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
	@Override
	public Person findPersonByName(String name) {

		Person person = null;
		for (int i = 0; i < persons.length; i++) {
			person = getPerson(i);
			if (person.getName().equals(name)) {
				System.out.println(person);
				return person;
			}
		}
		System.out.println("Person not found.");
		return person;
	}

	// TODO: Implement the method findPersonByPhoneNumber
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
	@Override
	public Person findPersonByPhoneNumber(String phoneNumber) {

		Person person = null;
		for (int i = 0; i < persons.length; i++) {
			person = getPerson(i);
			if (person.getPhoneNumber().equals(phoneNumber)) {
				System.out.println(person);
				return person;
			}
		}
		System.out.println("Person not found.");
		return person;

	}

	// TODO: Implement the method removePerson
	/*
	 * (non-Javadoc)
	 * 
	 * @see register.Register#removePerson(register.Person)
	 */
	@Override
	public void removePerson(Person person) {
		for (int i = 0; i < persons.length; i++) {
			if (person.equals(getPerson(i))) {
				persons[i] = null;

			}
		}

	}
}
