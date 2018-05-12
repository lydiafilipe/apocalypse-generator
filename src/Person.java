public class Person extends Term {

    public PersonType type;
    public PersonFeature[] features;

    public Person(PersonType type, PersonFeature[] features)
    {
        super();
        this.type = type;
        this.features = features;
    }

}
