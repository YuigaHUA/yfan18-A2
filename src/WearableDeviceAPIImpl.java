public class WearableDeviceAPIImpl implements WearableDeviceAPI {
    @Override
    public double getBloodPressure(String visitorId) {
        // Simulate fetching blood pressure data
        return 110 + Math.random() * 20;  // Simulate blood pressure between 110 and 130
    }

    @Override
    public double getOxygenLevel(String visitorId) {
        // Simulate fetching oxygen level data
        return 95 + Math.random() * 5;  // Simulate oxygen level between 95% and 100%
    }
}
