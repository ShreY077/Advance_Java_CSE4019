
public class BasePlusCommissionEmployee extends Employee2 {
    private double commissionRate;
    private double grossSales;

    public BasePlusCommissionEmployee(String name, int id, double salary, double commissionRate, double grossSales) {
        super(name, id, salary);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Commission Rate: " + commissionRate);
        System.out.println("Gross Sales: " + grossSales);
    }
}