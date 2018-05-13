public class Date extends Term
{
    public String month;
    public String weekday;
    public int day;
    public int year;

    public Date()
    {
        this(null, null, 0, 0);
    }

    public Date(String month)
    {
        this(month, null, 0, 0);
    }

    public Date(String month, String weekday)
    {
        this(month, weekday, 0, 0);
    }

    public Date(String month, String weekday, int day)
    {
        this(month, weekday, day, 0);
    }

    public Date(String month, String weekday, int day, int year)
    {
        generateRandomDate(month, weekday, day, year);
    }

    public void generateRandomDate(String month, String weekday, int day, int year)
    {
        if (month == null)
        {
            int monthIndex = Main.randomInt(0, 12);
            switch (monthIndex)
            {
                case 0:
                    month = "January";
                    break;
                case 1:
                    month = "February";
                    break;
                case 2:
                    month = "March";
                    break;
                case 3:
                    month = "April";
                    break;
                case 4:
                    month = "May";
                    break;
                case 5:
                    month = "June";
                    break;
                case 6:
                    month = "July";
                    break;
                case 7:
                    month = "August";
                    break;
                case 8:
                    month = "September";
                    break;
                case 9:
                    month = "October";
                    break;
                case 10:
                    month = "November";
                    break;
                case 11:
                    month = "December";
                    break;
            }
        }
        if (weekday == null)
        {
            int dayIndex = Main.randomInt(0, 7);
            switch (dayIndex)
            {
                case 0:
                    weekday = "Sunday";
                    break;
                case 1:
                    weekday = "Monday";
                    break;
                case 2:
                    weekday = "Tuesday";
                    break;
                case 3:
                    weekday = "Wednesday";
                    break;
                case 4:
                    weekday = "Thursday";
                    break;
                case 5:
                    weekday = "Friday";
                    break;
                case 6:
                    weekday = "Saturday";
                    break;
            }
        }
        if (day == 0)
        {
            int maxDay;
            if (    month == "January" ||
                    month == "March" ||
                    month == "May" ||
                    month == "July" ||
                    month == "August" ||
                    month == "October" ||
                    month == "December")
            {
                maxDay = 31;
            }
            else if(month == "April" ||
                    month == "June" ||
                    month == "September" ||
                    month == "November")
            {
                maxDay = 30;
            }
            else
            {
                maxDay = 28; //February
            }
            day = Main.randomInt(0, maxDay) + 1;
        }
        if (year == 0)
        {
            year = Main.randomInt(2018, 3018);
        }
        this.month = month;
        this.weekday = weekday;
        this.day = day;
        this.year = year;
    }
}
