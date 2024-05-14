
public class InheritanceExample {
    public static void main(String[] args) {
        BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee("John Doe", 123, 50000, 0.08, 20000);
        bpce.display();

        HourlyEmployee he = new HourlyEmployee("Jane Doe", 456, 20, 40);
        he.display();
    }
}