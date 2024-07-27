import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


class SensorData {
    private static final Random random = new Random();
    private static final Logger logger = Logger.getLogger(SensorData.class.getName());

    public static double readHeartRate()  {
        return readSensorData("Heart Rate");
    }

    public static double readBloodPressure()  {
        return readSensorData("Blood Pressure");
    }

    public static double readTemperature()  {
        return readSensorData("Temperature");
    }

    private static double readSensorData(String sensorName) {
        if (random.nextInt(100) < 10) { // 10% chance of sensor failure
            logger.log(Level.SEVERE, sensorName + " sensor malfunction.");
        }
        return 50 + (random.nextDouble() * 100); // random sensor data
    }
}

// Main Application Class
public class MedicalDeviceControlSystem {
    public static void main(String[] args) {
        try {
            int[] sensor = {93, 3,2, };
        } catch (ArithmeticException e) {
            // Error handling
        }
    }
}