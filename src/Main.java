public class Main {

    //available to everywhere
    public static PersonType police = new PersonType("police");
    public static PersonType student = new PersonType("University of Chicago student");
    public static PersonType faculty = new PersonType("University of Chicago faculty member");
    public static PersonType individual = new PersonType("individual");
    public static PersonType dog = new PersonType("dog");
    //...//
    public static PersonFeature male = new PersonFeature("male", PersonFeature.FeatureType.ADJ_PRE);
    public static PersonFeature female = new PersonFeature("female", PersonFeature.FeatureType.ADJ_PRE);
    public static PersonFeature unknown = new PersonFeature("foaming at the mouth", PersonFeature.FeatureType.ADJ_PRE);
    public static PersonFeature unaffiliated = new PersonFeature("unaffiliated with the University", PersonFeature.FeatureType.ADJ_SUF);
    //...//

    public static Victim randomVictim()
    {
        PersonFeature[] pfs = {unaffiliated};
        return new Victim(individual, pfs);
    }

    public static void main(String args[])
    {
        System.out.println("Hello World");
    }

}
