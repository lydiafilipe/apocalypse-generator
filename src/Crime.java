public class Crime extends Term {

    Apocalypse apocalypse;

    Suspect suspect;
    Victim victim;
    ActionCommitted actionCommitted;
    StateOfVictim stateOfVictim;
    PoliceRespondTo policeRespondTo;
    VictimAftermath victimAftermath;
    SuspectAftermath suspectAftermath;

    public Crime(Apocalypse apocalypse) {
        super();
        this.apocalypse = apocalypse;
    }

    public void generateCrimeFromApocalypse(){
        suspect = apocalypse.randomSuspect();
        victim = Main.randomVictim();
        actionCommitted = apocalypse.randomActionCommitted(suspect.type);
        stateOfVictim = apocalypse.randomStateOfVictim(actionCommitted.action);
        policeRespondTo = apocalypse.randomPoliceRespondTo(actionCommitted.action);
        victimAftermath = apocalypse.randomVictimAftermath(actionCommitted.injury, stateOfVictim.state, policeRespondTo.speed);
        suspectAftermath = apocalypse.randomSuspectAftermath(actionCommitted.action, policeRespondTo.speed);
    }
}
