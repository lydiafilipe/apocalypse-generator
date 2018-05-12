public class ActionCommitted extends Term
{
    enum Injury {
        NONE, MINOR, SEVERE, FATAL
    }

    public String action;
    public Injury injury;

    public ActionCommitted(String action, Injury injury)
    {
        super();
        this.action = action;
        this.injury = injury;
    }
}
