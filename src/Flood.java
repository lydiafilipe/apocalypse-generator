public class Flood extends Apocalypse
{
    public Flood ()
    {
        super(null, null, null, null, null, null, null, null, null);

        String name = "Flood";
        PersonType[] suspectTypes = {new PersonType("biblical-scale flood"), new PersonType("ocean of water"), new PersonType("wave containing all the water in the polar ice caps")};
        PersonFeature[] suspectFeatures = { new PersonFeature("icy", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("cold", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("shark-infested", PersonFeature.FeatureType.ADJ_PRE)};
        ActionCommitted[] actionsCommitted = {  new ActionCommitted ("smashed into", ActionCommitted.Injury.SEVERE),
                new ActionCommitted ("engulfed", ActionCommitted.Injury.SEVERE)};
        String[] policeRespondTos = {   "a massive wall of water rapidly moving across land",
                "the entire city receiving several feet of flooding",
                "their offices going dark as the water level rose past their windows"};
        StateOfVictim[] statesOfVictims = {  new StateOfVictim("was submerged in water for several minutes"),
                new StateOfVictim("was trapped in a flooded building"),
                new StateOfVictim("was struck by debris in the fast-moving currents")};
        VictimAftermath[] victimAftermaths = {  new VictimAftermath("was carried away by the water and is still missing"),
                new VictimAftermath("was found washed up dead"),
                new VictimAftermath("was found and transported to hospital and is suffering from severe hypothermia")};
        SuspectAftermath[] suspectAftermaths = {    new SuspectAftermath("is quickly spreading across the entire continent"),
                new SuspectAftermath("is continuing to rise in depth")};
        Advice[] advices = { new Advice("In the event of a flood, seek higher ground. Leave possessions behind"),
                new Advice("Learn how to swim"),
                new Advice("Stay away from water"),
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
        int stateOfVictimIndex = Main.randomInt(0, statesOfVictims.length);
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
        return victimAftermaths[victimAftermathIndex];
    }
    public SuspectAftermath randomSuspectAftermath(ActionCommitted actionCommitted, PoliceRespondTo policeRespondTo)
    {
        int suspectAftermathIndex = Main.randomInt(0, suspectAftermaths.length);
        return suspectAftermaths[suspectAftermathIndex];
    }
}
