
public class HourlyEmployee extends Employee2 {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String name, int id, double hourlyRate, double hoursWorked) {
        super(name, id, hourlyRate * hoursWorked);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
    }
}