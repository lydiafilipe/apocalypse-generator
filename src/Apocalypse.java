public abstract class Apocalypse {

    protected String name;
    protected PersonType[] suspectTypes;
    protected PersonFeature[] suspectFeatures;
    protected ActionCommitted[] actionsCommitted;
    protected String[] policeRespondTos;
    protected StateOfVictim[] statesOfVictims;
    protected VictimAftermath[] victimAftermaths;
    protected SuspectAftermath[] suspectAftermaths;
    protected Advice[] advices;

    public Apocalypse(String name, PersonType[] suspectTypes, PersonFeature[] suspectFeatures,
                      ActionCommitted[] actionsCommitted, String[] policeRespondTos,
                      StateOfVictim[] statesOfVictims, VictimAftermath[] victimAftermaths,
                      SuspectAftermath[] suspectAftermaths, Advice[] advices)
    {
        this.name = name;
        this.suspectTypes = suspectTypes;
        this.suspectFeatures = suspectFeatures;
        this.actionsCommitted = actionsCommitted;
        this.policeRespondTos = policeRespondTos;
        this.statesOfVictims = statesOfVictims;
        this.victimAftermaths = victimAftermaths;
        this.suspectAftermaths = suspectAftermaths;
        this.advices = advices;
    }

    public abstract Suspect randomSuspect();
    public abstract ActionCommitted randomActionCommitted(PersonType type); //Suspect.type
    public abstract StateOfVictim randomStateOfVictim(String action); //ActionCommitted.action
    public abstract PoliceRespondTo randomPoliceRespondTo(String action); //ActionCommitted.action
    public abstract VictimAftermath randomVictimAftermath(ActionCommitted.Injury injury, String state, PoliceRespondTo.Speed speed); //StateOfVictim.state
    public abstract SuspectAftermath randomSuspectAftermath(String action, PoliceRespondTo.Speed speed); //ActionCommitted.action

}
