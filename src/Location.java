public class Location extends Term
{
    public int number;
    public String street;

    public static String[] streets = {  "E. 37th Street", "E. 38th Street", "E. 39th Street", "E. 40th Street", "E. 41st Street",
                                        "E. 42nd Street", "E. 43rd Street", "E. 44th Street", "E. 45th Street", "E. 46th Street",
                                        "E. 47th Street", "E. 48th Street", "E. 49th Street", "E. 50th Street", "E. 51st Street",
                                        "E. 52nd Street", "E. 53rd Street", "E. 54th Street", "E. 55th Street", "E. 56th Street",
                                        "E. 57th Street", "E. 58th Street", "E. 59th Street", "E. 60th Street", "E. 61st Street",
                                        "E. 62nd Street", "E. 63rd Street", "S. Cottage Grove Avenue", "S. Drexel Avenue",
                                        "S. Ingleside Avenue", "S. Greenwood Avenue", "S. University Avenue", "S. Woodlawn Avenue",
                                        "S. Kimbark Avenue", "S. Ellis Avenue", "S. Maryland Avenue", "S. Kenwood Avenue",
                                        "S. Dorchester Avenue", "S. Blackstone Avenue", "S. Harper Avenue", "S. Lake Park Avenue",
                                        "S. Stony Island Avenue", "S. Cornell Avenue", "S. Hyde Park Boulevard", "S. Everett Avenue",
                                        "S.E. View Park", "S. Lake Shore Drive", "E. Hyde Park Boulevard", "E. Madison Park", "Midway Plaisance"};

    public Location()
    {
        this(0, null);
    }

    public Location(int number)
    {
        this(number, null);
    }

    public Location(int number, String street)
    {
        generateRandomAddress(number, street);
    }

    public void generateRandomAddress(int number, String street)
    {
        if (street == null)
            street = streets[Main.randomInt(0, streets.length)];
        if (number == 0) {
            if (street.startsWith("E."))
                number = Main.randomInt(800, 1700);
            else
                number = Main.randomInt(3700, 6400);
        }
        this.street = street;
        this.number = number;
    }
}
