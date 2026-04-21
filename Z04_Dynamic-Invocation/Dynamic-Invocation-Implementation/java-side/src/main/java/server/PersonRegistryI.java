package server;

import com.zeroc.Ice.Current;
import java.util.List;
import java.util.ArrayList;

public class PersonRegistryI implements Contract.PersonRegistry {
    private final List<Contract.Person> people = new ArrayList<>();

    @Override
    public String echo(Current __current) {
        System.out.println("Servant " + __current.id + " echoing");
        return "ECHO";
    }

    @Override
    public double net(int salary, int age, Current __current) {
        System.out.println("Servant " + __current.id + " calculating net salary from " + salary + " PLN.");
        return age <= 26 ? salary * 0.78 : salary * 0.66;
    }

    @Override
    public Contract.PersonDescription describe(Contract.Person person, Current __current) {
        System.out.println("Servant " + __current.id + " describing " + person.firstName + " " + person.lastName + ".");
        double avgSalary = 0.0;

        for (int number : person.previousSalaries) {
            avgSalary += number;
        }

        avgSalary /= person.previousSalaries.length;

        String description = person.firstName + " " + person.lastName + " (age " + person.age + ") lives at " +
                            person.address + " and earns " + person.salary + " PLN per month.";

        return new Contract.PersonDescription(description, avgSalary);
    }

    @Override
    public Contract.Person[] add(Contract.Person person, Current __current) {
        System.out.println("Servant " + __current.id + " adding " + person.firstName + " " + person.lastName);

        people.add(person);

        return people.toArray(new Contract.Person[0]);
    }
}
