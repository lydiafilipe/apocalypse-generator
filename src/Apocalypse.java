public abstract class Apocalypse {

    private String name;
    private PersonType[] suspectTypes;
    private PersonFeature[] suspectFeatures;
    private ActionCommitted[] actionsCommitted;
    private PoliceRespondTo[] policeRespondTos;
    private StateOfVictim[] statesOfVictims;
    private VictimAftermath[] victimAftermaths;
    private SuspectAftermath[] suspectAftermaths;
    private Advice[] advices;

    public Apocalypse(String name, PersonType[] suspectTypes, PersonFeature[] suspectFeatures,
                      ActionCommitted[] actionsCommitted, PoliceRespondTo[] policeRespondTos,
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
