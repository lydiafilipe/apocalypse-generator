public class Crime extends Term {

    Apocalypse apocalypse;

    Suspect suspect;
    Victim victim;
    ActionCommitted actionCommitted;
    StateOfVictim stateOfVictim;
    PoliceRespondTo policeRespondTo;
    VictimAftermath victimAftermath;
    SuspectAftermath suspectAftermath;

    public boolean ready = false;

    public Crime(Apocalypse apocalypse) {
        super();
        this.apocalypse = apocalypse;
        generateCrimeFromApocalypse();
        ready = true;
    }

    public void generateCrimeFromApocalypse(){
        suspect = apocalypse.randomSuspect();
        victim = Main.randomVictim();
        actionCommitted = apocalypse.randomActionCommitted(suspect.type);
        stateOfVictim = apocalypse.randomStateOfVictim(actionCommitted);
        policeRespondTo = apocalypse.randomPoliceRespondTo(actionCommitted);
        victimAftermath = apocalypse.randomVictimAftermath(actionCommitted, stateOfVictim, policeRespondTo);
        suspectAftermath = apocalypse.randomSuspectAftermath(actionCommitted, policeRespondTo);
    }
}
