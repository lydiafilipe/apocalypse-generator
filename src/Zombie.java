import java.util.concurrent.ThreadLocalRandom;

public class Zombie extends Apocalypse {

    public Zombie() {

        super(null, null, null, null, null, null, null,
                null, null);

        String name = "Zombie";
        PersonType[] suspectTypes = {new PersonType("zombie"), new PersonType("sick human")};
        PersonFeature[] suspectFeatures = {null, new PersonFeature("gurgling", PersonFeature.FeatureType.ADJ_PRE),
                                            new PersonFeature("moaning", PersonFeature.FeatureType.ADJ_PRE),
                                            new PersonFeature("lying on the sidewalk", PersonFeature.FeatureType.ADJ_SUF),
                                            new PersonFeature("failing around", PersonFeature.FeatureType.ADJ_SUF)};
        ActionCommitted[] actionsCommitted = {new ActionCommitted("bit", ActionCommitted.Injury.SEVERE),
                                                new ActionCommitted("attacked", ActionCommitted.Injury.SEVERE),
                                                new ActionCommitted("ate", ActionCommitted.Injury.FATAL)};
        String[] policeRespondTos = {"zombie moans", "human cries", "a trail of blood"};
        StateOfVictim[] statesOfVictims = {new StateOfVictim("was dismembered"),
                                            new StateOfVictim("suffered multiple bite wounds"),
                                            new StateOfVictim("lost a significant amount of blood")};
        VictimAftermath[] victimAftermaths = {new VictimAftermath("turned into a zombie"),
                                              new VictimAftermath("attacked responding officers"),
                                                new VictimAftermath("ate their dog")};
        SuspectAftermath[] suspectAftermaths = {new SuspectAftermath("had walked away"),
                                                 new SuspectAftermath("was shot by police but refused to die")};
        Advice[] advice = {new Advice("Don't play with zombies"), new Advice("Carry a baseball bat at all times"),
                            new Advice("Don't pick up hitchhikers")};

        super.name = name;
        super.suspectTypes = suspectTypes;
        super.suspectFeatures = suspectFeatures;
        super.actionsCommitted = actionsCommitted;
        super.policeRespondTos = policeRespondTos;
        super.statesOfVictims = statesOfVictims;
        super.victimAftermaths = victimAftermaths;
        super.suspectAftermaths = suspectAftermaths;
        super.advices = advice;
    }

    public Suspect randomSuspect() {

        int suspectTypeIndex = Main.randomInt(0, suspectTypes.length);
        PersonType suspectType = suspectTypes[suspectTypeIndex];

        return new Suspect(suspectType, suspectFeatures);
    }
    public ActionCommitted randomActionCommitted(PersonType type) {

        int actionCommittedIndex = Main.randomInt(0, actionsCommitted.length);
        return actionsCommitted[actionCommittedIndex];
    }

    public StateOfVictim randomStateOfVictim(ActionCommitted actionCommitted) {

        int stateIndex = Main.randomInt(0, statesOfVictims.length);
        return statesOfVictims[stateIndex];
    }
    public PoliceRespondTo randomPoliceRespondTo(ActionCommitted actionCommitted) {

        int respondIndex = Main.randomInt(0, policeRespondTos.length);
        return new PoliceRespondTo(policeRespondTos[respondIndex], PoliceRespondTo.pickRandomSpeed());
    }
    public VictimAftermath randomVictimAftermath(ActionCommitted actionCommitted, StateOfVictim stateOfVictim, PoliceRespondTo policeRespondTo){

        int afterIndex = Main.randomInt(0, victimAftermaths.length);
        return victimAftermaths[afterIndex];
    }
    public SuspectAftermath randomSuspectAftermath(ActionCommitted actionCommitted, PoliceRespondTo policeRespondTo) {

        int afterIndex = Main.randomInt(0, suspectAftermaths.length);
        return suspectAftermaths[afterIndex];
    }
}
