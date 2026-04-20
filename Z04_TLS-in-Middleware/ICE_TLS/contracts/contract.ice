module Contract
{
    sequence<int> IntSeq;

    struct Person
    {
        string firstName;
        string lastName;
        string address;
        int age;
        int salary;
        IntSeq previousSalaries;
    };

    struct PersonDescription
    {
        string description;
        double avgSalary;
    };

    interface PersonRegistry
    {
        idempotent string echo();
        idempotent double net(int salary, int age);
        idempotent PersonDescription describe(Person person);
    };
}
