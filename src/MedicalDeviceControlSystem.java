import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


class SensorData {
    private static final Random random = new Random();
    private static final Logger logger = Logger.getLogger(SensorData.class.getName());

    public static double readHeartRate() throws SensorException {
        return readSensorData("Heart Rate");
    }

    public static double readBloodPressure() throws SensorException {
        return readSensorData("Blood Pressure");
    }

    public static double readTemperature() throws SensorException {
        return readSensorData("Temperature");
    }

    private static double readSensorData(String sensorName) throws SensorException {
        if (random.nextInt(100) < 10) { // 10% chance of sensor failure
            logger.log(Level.SEVERE, sensorName + " sensor malfunction.");
            throw new SensorException(sensorName + " sensor malfunction.");
        }
        return 50 + (random.nextDouble() * 100); // random sensor data
    }
}


// Sensor Exception
class SensorException extends Exception {
    public SensorException(String message) {
        super(message);
    }
}

// Vital Signs Analyzer
class VitalSignsAnalyzer {
    private static final double MAX_HEART_RATE = 100.0;
    private static final double MIN_HEART_RATE = 60.0;
    private static final double MAX_BLOOD_PRESSURE = 140.0;
    private static final double MIN_BLOOD_PRESSURE = 90.0;
    private static final double MAX_TEMPERATURE = 38.0;
    private static final double MIN_TEMPERATURE = 36.0;
    private static final Logger logger = Logger.getLogger(VitalSignsAnalyzer.class.getName());

    public void analyzeAndTriggerAlarms(double heartRate, double bloodPressure, double temperature) {
        if (heartRate < MIN_HEART_RATE || heartRate > MAX_HEART_RATE) {
            logger.log(Level.WARNING, "Heart rate out of range: " + heartRate);
        }
        if (bloodPressure < MIN_BLOOD_PRESSURE || bloodPressure > MAX_BLOOD_PRESSURE) {
            logger.log(Level.WARNING, "Blood pressure out of range: " + bloodPressure);
        }
        if (temperature < MIN_TEMPERATURE || temperature > MAX_TEMPERATURE) {
            logger.log(Level.WARNING, "Temperature out of range: " + temperature);
        }
    }
}


// Main Application Class
public class MedicalDeviceControlSystem {
    private static final Logger logger = Logger.getLogger(MedicalDeviceControlSystem.class.getName());

    public static void main(String[] args) {
        SensorData sensorData = new SensorData();
        VitalSignsAnalyzer analyzer = new VitalSignsAnalyzer();

        try {
            double heartRate = SensorData.readHeartRate();
            double bloodPressure = SensorData.readBloodPressure();
            double temperature = SensorData.readTemperature();

            logger.log(Level.INFO, "Heart Rate: " + heartRate);
            logger.log(Level.INFO, "Blood Pressure: " + bloodPressure);
            logger.log(Level.INFO, "Temperature: " + temperature);

            analyzer.analyzeAndTriggerAlarms(heartRate, bloodPressure, temperature);
        } catch (SensorException e) {
            logger.log(Level.SEVERE, "Sensor error occurred: " + e.getMessage());
        }
    }
}