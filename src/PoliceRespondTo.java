public class PoliceRespondTo extends Term
{
    enum Speed {
        FAST, SLOW, VERYSLOW
    }

    public String respondTo;
    public Speed speed;

    public PoliceRespondTo(String respondTo, Speed speed)
    {
        super();
        this.respondTo = respondTo;
        this.speed = speed;
    }
}
