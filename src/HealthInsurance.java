import java.util.Date;

public class HealthInsurance extends Insurance{

    public HealthInsurance(String insuranceName, double insurancePrice, Date startDate, Date endDate) {
        super(insuranceName, insurancePrice, startDate, endDate);
    }

    @Override
    public double calculate() {
        return 1;
    }
}
