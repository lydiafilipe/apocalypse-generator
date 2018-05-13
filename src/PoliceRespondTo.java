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

    public static Speed pickRandomSpeed() {
        int enumChooser = Main.randomInt(0, 3);
        Speed speed = null;

        switch (enumChooser) {
            case 0:
                speed = PoliceRespondTo.Speed.FAST;
                break;
            case 1:
                speed = PoliceRespondTo.Speed.SLOW;
                break;
            case 2:
                speed = PoliceRespondTo.Speed.VERYSLOW;
                break;
        }
        return speed;
    }
}
