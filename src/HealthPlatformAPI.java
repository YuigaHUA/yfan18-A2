public interface HealthPlatformAPI {
    // Simulate getting health data from an external health platform (e.g., heart rate, steps, etc.)
    int getHeartRate(String visitorId);
    int getStepCount(String visitorId);
}
