public class NuclearWar extends Apocalypse
{
    public NuclearWar ()
    {
        super(null, null, null, null, null, null, null, null, null);

        String name = "Nuclear War";
        PersonType[] suspectTypes = {new PersonType("nuclear missile"), new PersonType("experimental nuclear weapon"), new PersonType("ICBM")};
        PersonFeature[] suspectFeatures = { new PersonFeature("Russian", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("Chinese", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("North Korean", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("Alien", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("Iranian", PersonFeature.FeatureType.ADJ_PRE)};
        ActionCommitted[] actionsCommitted = {  new ActionCommitted ("exploded on", ActionCommitted.Injury.FATAL),
                new ActionCommitted ("released an explosion centered upon", ActionCommitted.Injury.FATAL),
                new ActionCommitted ("emitted radiation upon", ActionCommitted.Injury.SEVERE)};
        String[] policeRespondTos = {"sightings of a missile streaking across the sky",
                "a mushroom cloud blotting out the sun",
                "the entire city being leveled in a massive explosion"};
        StateOfVictim[] statesOfVictims = {  new StateOfVictim("was instantly disintegrated"),
                new StateOfVictim("was blasted into pieces"),
                new StateOfVictim("was fatally poisoned by radiation")};
        VictimAftermath[] victimAftermaths = {  new VictimAftermath("was carried away by the wind as dust"),
                new VictimAftermath("was left piled under mountains of debris"),
                new VictimAftermath("developed several rapidly progressing tumors")};
        SuspectAftermath[] suspectAftermaths = {    new SuspectAftermath("left the city infested with radiation for centuries to come"),
                new SuspectAftermath("became a massive crater where the city once was")};
        Advice[] advices = { new Advice("In the event of nuclear war, hide in an underground bunker. Wear a hazmat suit before going outside"),
                new Advice("In the event of nuclear war, hope that U.S. missiles can eliminate all enemy missles before your city is nuked"),
                new Advice("To prevent future nuclear war, vote for politicians that will keep us out of nuclear war"),
        };

        super.name = name;
        super.suspectTypes = suspectTypes;
        super.suspectFeatures = suspectFeatures;
        super.actionsCommitted = actionsCommitted;
        super.policeRespondTos = policeRespondTos;
        super.statesOfVictims = statesOfVictims;
        super.victimAftermaths = victimAftermaths;
        super.suspectAftermaths = suspectAftermaths;
        super.advices = advices;
    }

    public Suspect randomSuspect()
    {
        int suspectTypeIndex = Main.randomInt(0, suspectTypes.length);
        PersonType suspectType = suspectTypes[suspectTypeIndex];
        PersonFeature[] suspectFeatures = {this.suspectFeatures[Main.randomInt(0, this.suspectFeatures.length)]};
        return new Suspect(suspectType, suspectFeatures);
    }
    public ActionCommitted randomActionCommitted(PersonType type)
    {
        int actionCommittedIndex = Main.randomInt(0, actionsCommitted.length);
        return actionsCommitted[actionCommittedIndex];
    }
    public StateOfVictim randomStateOfVictim(ActionCommitted actionCommitted)
    {
        int stateOfVictimIndex = Main.randomInt(0, statesOfVictims.length - 1);
        if (actionCommitted.equals(actionsCommitted[2])) {stateOfVictimIndex = 2;}
        return statesOfVictims[stateOfVictimIndex];
    }
    public PoliceRespondTo randomPoliceRespondTo(ActionCommitted actionCommitted)
    {
        int policeRespondToIndex = Main.randomInt(0, policeRespondTos.length);
        return new PoliceRespondTo(policeRespondTos[policeRespondToIndex], PoliceRespondTo.pickRandomSpeed());
    }
    public VictimAftermath randomVictimAftermath(ActionCommitted actionCommitted, StateOfVictim stateOfVictim, PoliceRespondTo policeRespondTo)
    {
        int victimAftermathIndex = Main.randomInt(0, victimAftermaths.length);
        if (actionCommitted.equals(actionsCommitted[2])) {victimAftermathIndex = 2;}
        return victimAftermaths[victimAftermathIndex];
    }
    public SuspectAftermath randomSuspectAftermath(ActionCommitted actionCommitted, PoliceRespondTo policeRespondTo)
    {
        int suspectAftermathIndex = Main.randomInt(0, suspectAftermaths.length);
        return suspectAftermaths[suspectAftermathIndex];
    }
}
