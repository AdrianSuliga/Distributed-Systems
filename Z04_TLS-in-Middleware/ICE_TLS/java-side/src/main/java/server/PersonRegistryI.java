package server;

import com.zeroc.Ice.Current;

public class PersonRegistryI implements Contract.PersonRegistry {
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
}
