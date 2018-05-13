public class Pandemic extends Apocalypse {

    public Pandemic() {

        super(null, null, null, null, null, null, null,
                null, null);

        String name = "Pandemic";
        PersonType[] suspectTypes = {new PersonType("pathogen"), new PersonType("infected human")};
        PersonFeature[] suspectFeatures = {null, new PersonFeature("manic", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("moaning", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("lying on the sidewalk", PersonFeature.FeatureType.ADJ_SUF),
                new PersonFeature("squirming", PersonFeature.FeatureType.ADJ_PRE)};
        ActionCommitted[] actionsCommitted = {new ActionCommitted("invaded", ActionCommitted.Injury.SEVERE),
                new ActionCommitted("attacked", ActionCommitted.Injury.SEVERE),
                new ActionCommitted("coughed on", ActionCommitted.Injury.SEVERE),
                new ActionCommitted("sneezed on", ActionCommitted.Injury.SEVERE)};
        String[] policeRespondTos = {"sneezes", "coughing", "phone call"};
        StateOfVictim[] statesOfVictims = {new StateOfVictim("very grossed out"),
                new StateOfVictim("put on hand sanitizer"),
                new StateOfVictim("got kinda pissed")};
        VictimAftermath[] victimAftermaths = {new VictimAftermath("contracted the disease"),
                new VictimAftermath("did not get infected"),
                new VictimAftermath("was put under quarantine"),
                new VictimAftermath("got infected and died")};
        SuspectAftermath[] suspectAftermaths = {new SuspectAftermath("had run away"),
                new SuspectAftermath("sneezed on police"),
                new SuspectAftermath("convulsed and died"),
                new SuspectAftermath("tried to infect police"),
                new SuspectAftermath("underwent binary fission and multiplied")};
        Advice[] advice = {new Advice("Wash your hands"), new Advice("Don't eat at places that fail health inspections"),
                new Advice("Wear your face mask"), new Advice("Pandemic hookup culture is not safe")};

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

        int actionCommittedIndex = 0;

        if(type.type.equals("pathogen")) {
            actionCommittedIndex = 0;
        } else if (type.type.equals("infected human")) {
            actionCommittedIndex = Main.randomInt(1, actionsCommitted.length);
        }
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

        int afterIndex = 0;

        if(!actionCommitted.action.equals("invaded")) {
            Main.randomInt(0, 4);
        } else {
            Main.randomInt(1, suspectAftermaths.length);
        }

        return suspectAftermaths[afterIndex];
    }
}
