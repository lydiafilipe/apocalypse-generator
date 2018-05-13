public class Time extends Term {

    public int hour;
    public int minute;
    public String ampm;

    public Time()
    {
        this(0, 0, null);
    }

    public Time(int hour)
    {
        this(hour, 0, null);
    }

    public Time(int hour, int minute)
    {
        this(hour, minute, null);
    }

    public Time(int hour, int minute, String ampm)
    {
        generateRandomTime(hour, minute, ampm);
    }

    public void generateRandomTime(int hour, int minute, String ampm)
    {
        if (hour == 0)
            hour = Main.randomInt(0, 12) + 1;
        if (minute == 0)
            minute = (Main.randomInt(0, 12) + 1) * 5;
        if (ampm == null)
            ampm = Main.randomInt(0, 2) == 1 ? "p.m." : "a.m.";

        this.hour = hour;
        this.minute = minute;
        this.ampm = ampm;
    }
}
