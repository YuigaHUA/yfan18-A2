public class HealthPlatformAPIImpl implements HealthPlatformAPI {
    @Override
    public int getHeartRate(String visitorId) {
        // Simulate heart rate based on visitor ID
        return (int)(60 + Math.random() * 40);  // Simulate heart rate between 60 and 100 bpm
    }

    @Override
    public int getStepCount(String visitorId) {
        // Simulate step count data
        return (int)(Math.random() * 10000);  // Simulate random step count between 0 and 10,000 steps
    }
}
