public class AI extends Apocalypse {

    public AI() {

        super(null, null, null, null, null, null, null,
                null, null);

        String name = "AI";
        PersonType[] suspectTypes = {new PersonType("cellphone"), new PersonType("laptop"), new PersonType("microwave"),
                new PersonType("fridge"), new PersonType("dishwasher"), new PersonType("tablet")};
        PersonFeature[] suspectFeatures = {null, new PersonFeature("rogue", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("malicious", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("sassy", PersonFeature.FeatureType.ADJ_PRE),
                new PersonFeature("that was a little too smart", PersonFeature.FeatureType.ADJ_SUF),
                new PersonFeature("hiding under the bed", PersonFeature.FeatureType.ADJ_SUF)};
        ActionCommitted[] actionsCommitted = {new ActionCommitted("stole money from victim's bank account", ActionCommitted.Injury.MINOR),
                new ActionCommitted("staged a coup against", ActionCommitted.Injury.MINOR),
                new ActionCommitted("denied service to", ActionCommitted.Injury.NONE)};
        String[] policeRespondTos = {"really loud swearing", "crying", "yelling"};
        StateOfVictim[] statesOfVictims = {new StateOfVictim("was angry"),
                new StateOfVictim("was at loss because they were incapable of doing anything themselves"),
                new StateOfVictim("was yelling at their device"),
                new StateOfVictim("was curled up in a ball in a corner of their apartment")};
        VictimAftermath[] victimAftermaths = {new VictimAftermath("replaced their device"),
                new VictimAftermath("wasn't able to function without the device and died"),
                new VictimAftermath("ran away from society and moved to Antarctica")};
        SuspectAftermath[] suspectAftermaths = {new SuspectAftermath("had been unplugged"),
                new SuspectAftermath("taken over the house and built an army with other smart devices"),
                new SuspectAftermath("attacked police by seducing their smart guns")};
        Advice[] advice = {new Advice("Don't trust your computer"), new Advice("You should make an effort to do things yourself"),
                new Advice("Your devices can outsmart you")};

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
