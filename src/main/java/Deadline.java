public class Deadline extends Task {
    //private String description;
    private String day;
    public Deadline(String description, String day) {
        super(description);
        this.day = day;
    }

    public String getDay(){
        return day;
    }

    @Override
    public String getTypeIcon(){
        return("[D]");
    }

    @Override
    public String toString(){
        return super.toString() + "(by:" + getDay() + ")";
    }
}
