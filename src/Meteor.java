public class Meteor extends Apocalypse
{
    public Meteor ()
    {
        super(null, null, null, null, null, null, null, null, null);

        String name = "Meteor";
        PersonType[] suspectTypes = {new PersonType("meteor"), new PersonType("comet"), new PersonType("stray planet")};
        PersonFeature[] suspectFeatures = { new PersonFeature("firey", PersonFeature.FeatureType.ADJ_PRE),
                                            new PersonFeature("icy", PersonFeature.FeatureType.ADJ_PRE)};
        ActionCommitted[] actionsCommitted = {  new ActionCommitted ("smashed into", ActionCommitted.Injury.SEVERE),
                                                new ActionCommitted ("obliterated", ActionCommitted.Injury.FATAL),
                                                new ActionCommitted ("totally wrecked", ActionCommitted.Injury.FATAL)};
        String[] policeRespondTos = {   "a large object streaking across the sky",
                                        "a massive object blotting out the sun",
                                        "an earth-shattering explosion"};
        StateOfVictim[] statesOfVictims = {  new StateOfVictim("was badly crushed"),
                                            new StateOfVictim("was reduced to smithereens"),
                                            new StateOfVictim("was a pile of ashes")};
        VictimAftermath[] victimAftermaths = {  new VictimAftermath("could not be removed from the pavement"),
                                                new VictimAftermath("was blown away by the wind")};
        SuspectAftermath[] suspectAftermaths = {    new SuspectAftermath("disintegrated"),
                                                    new SuspectAftermath("was still smoldering")};
        Advice[] advices = { new Advice("Make sure to have your confessor on speed-dial"),
                            new Advice("In the event of a meteor strike, there is not much you can do"),
                            new Advice("Try hiding under a table"),
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
        PersonFeature[] suspectFeatures;
        if (suspectType.equals(suspectTypes[0]))
        {
            PersonFeature[] sf1 = {super.suspectFeatures[0]};
            PersonFeature[] sf2 = {null};
            suspectFeatures = Main.randomInt(0, 1) == 1 ? sf1 : sf2;
        }
        else if (suspectType.equals(suspectTypes[1]))
        {
            PersonFeature[] sf1 = {super.suspectFeatures[1]};
            PersonFeature[] sf2 = {null};
            suspectFeatures = Main.randomInt(0, 1) == 1 ? sf1 : sf2;
        }
        else {
            PersonFeature[] sf = {null};
            suspectFeatures = sf;
        }
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
