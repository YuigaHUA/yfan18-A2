public interface WearableDeviceAPI {
    // Simulate fetching data from a wearable device (e.g., smart wristband)
    double getBloodPressure(String visitorId);
    double getOxygenLevel(String visitorId);
}
