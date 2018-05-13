import java.util.concurrent.ThreadLocalRandom;

public class Main {

    //available to everywhere
    public static PersonType police = new PersonType("police");
    public static PersonType student = new PersonType("a University of Chicago student");
    public static PersonType faculty = new PersonType("a University of Chicago faculty member");
    public static PersonType individual = new PersonType("an individual");
    public static PersonType dog = new PersonType("a dog");
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

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static String describePerson(Person person)
    {
        String describedPerson = "";
        int preCount = 0;
        for (int i = 0; i < person.features.length; i++)
        {
            if (person.features[i] != null && person.features[i].type == PersonFeature.FeatureType.ADJ_PRE) {
                if (preCount > 0)
                    describedPerson = describedPerson + ", ";
                describedPerson = describedPerson + person.features[i].feature;
                preCount ++;
            }
        }
        if (preCount > 0)
            describedPerson = describedPerson + " ";
        describedPerson = describedPerson + person.type.type;
        for (int i = 0; i < person.features.length; i++)
        {
            if (person.features[i] != null && person.features[i].type == PersonFeature.FeatureType.ADJ_SUF) {
                describedPerson = describedPerson + " " + person.features[i].feature;
            }
        }
        return describedPerson;
    }

    public static String generateAdvice(Apocalypse apocalypse)
    {
        String advice = "";
        int adviceCount = randomInt(1, 4);
        int[] picks = {-1, -1, -1};
        adviceCount = adviceCount > apocalypse.advices.length ? apocalypse.advices.length : adviceCount;
        for (int i = 0; i < adviceCount; i++)
        {
            int pick;
            do {
                pick = randomInt(0, apocalypse.advices.length);
            } while (pick == picks[0] || pick == picks[1] || pick == picks[2]);
            picks[i] = pick;
            advice = advice + apocalypse.advices[pick].advice + ". ";
        }
        return advice;
    }

    public static String generateRandomAlert(Apocalypse apocalypse)
    {
        Crime crime = new Crime(apocalypse);
        while(!crime.ready);
        Date date = new Date();
        Time time = new Time();
        Location location = new Location();
        String describedVictim = describePerson(crime.victim);
        String describedSuspect = describePerson(crime.suspect);
        String advice = generateAdvice(apocalypse);

        String alert = "From: Eric M. Heath, Associate VP for Safety and Security <ucpd-pio@uchicago.edu>\n";
        alert = alert + "To: John Schlaak <schlaakja@uchicago.edu>\n";
        alert = alert + date.month + " " + date.day + ", " + date.year + "\n";
        alert = alert + "Security Alert\n";
        alert = alert + "At approximately " + time.hour + ":" + time.minute + " " + time.ampm + ", " + date.weekday + ", " + date.month + " " + date.day + ", " + date.year + " -- ";
        if (crime.policeRespondTo.speed == PoliceRespondTo.Speed.VERYSLOW)
        {
            alert = alert + describedVictim + " ";
            alert = alert + "walking on the sidewalk at approximately " + location.number + " " + location.street + " ";
            alert = alert + "encountered a " + describedSuspect;
            alert = alert + (randomInt(0, 2) == 1 ? ". The " + crime.suspect.type.type + " " : " that ");
            alert = alert + crime.actionCommitted.action + " the victim and then ";
            alert = alert + crime.suspectAftermath.aftermath + ". ";
            alert = alert + "The victim " + crime.stateOfVictim.state + " and " + crime.victimAftermath.aftermath + ". ";
        }
        else
        {
            alert = alert + "Chicago Police and UCPD officers responded to calls of ";
            alert = alert + crime.policeRespondTo.respondTo + " at " + location.number + " " + location.street + ". ";
            alert = alert + "Upon arrival, officers";
            if (crime.policeRespondTo.speed == PoliceRespondTo.Speed.FAST) {
                alert = alert + " encountered a " + describedSuspect + " that " + crime.actionCommitted.action + " " + describedVictim + ". ";
                alert = alert + "The suspect " + crime.suspectAftermath.aftermath + ". ";
                alert = alert + "The victim " + crime.stateOfVictim.state + " and " + crime.victimAftermath.aftermath + ". ";
            }
            else {
                alert = alert + (randomInt(0, 2) == 1 ? " found " : " discovered ") + describedVictim;
                alert = alert + "that " + crime.stateOfVictim.state + ". ";
                alert = alert + "The victim " + crime.victimAftermath.aftermath + ". ";
            }
        }
        alert = alert + "\n" + advice + "\n";
        alert = alert + "Eric M. Heath\n";
        alert = alert + "Associate Vice President for Safety & Security\n";
        alert = alert + "* If you have any information related to this incident or if you witness any suspicious activity, please report it immediately to the Chicago Police Department (911) or the University of Chicago Police Department -- 123 from a University phone or 773.702.8181 from other phones.\n";
        alert = alert + "* More safety and security information is available at safety-security.uchicago.edu.\n";
        alert = alert + "* Security alerts are issued by email and posted to the Department of Safety & Security’s website when an incident occurs that should be brought to the immediate attention of the University community. Security alerts are based on information reported to the University of Chicago Police Department. The reported information may not have been investigated or confirmed at the time the security alert was issued.\n";
        alert = alert + "* Physical descriptions of a suspect, including race, are included in security alerts only when they provide several details that might help distinguish the suspect's appearance from the general population.\n";
        alert = alert +  "Comments or suggestions about security-related issues should be directed to: ucpd-pio@uchicago.edu.\n";
        alert = alert + "PLEASE NOTE: The University of Chicago Police Department patrol area boundaries are 37th Street on the north to 65th Street on the south/Cottage Grove Avenue to Lake Shore Drive (39th Street to 60thStreet)/Evans Avenue to Stony Island Avenue (61st Street to 64th Street)/65th Street (Ellis Avenue to University Avenue).\n";

        return alert;
    }

    public static void main(String args[])
    {
        int apocalypsePick = randomInt(0, 6);
        Apocalypse apocalypse = null;
        switch (apocalypsePick)
        {
            case 0:
                apocalypse = new Meteor();
                break;
            case 1:
                apocalypse = new Zombie();
                break;
            case 2:
                apocalypse = new Pandemic();
                break;
            case 3:
                apocalypse = new AI();
                break;
            case 4:
                apocalypse = new NuclearWar();
                break;
            case 5:
                apocalypse = new Flood();
                break;
        }
        System.out.println(generateRandomAlert(apocalypse));
    }

}
