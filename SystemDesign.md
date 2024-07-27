# System Design

## Overview

The system is designed to monitor patient vital signs using simulated sensors. It reads sensor data for heart rate, blood pressure, and temperature, analyzes the data against predefined thresholds, and triggers alarms if readings are critical. It includes robust error handling to manage sensor malfunctions and ensure reliable operation.

## Architecture

1. **Sensor Layer**: Simulates the sensors for heart rate, blood pressure, and temperature. Handles sensor data reading and simulates malfunctions.
2. **Application Layer**: Integrates sensor data reading, analysis, and error handling. This is where the main application logic resides.
3. **Analysis Layer**: Analyzes the sensor data to determine if the readings are within safe ranges and triggers alarms if necessary.
4. **Logging and Error Handling**: Logs information, warnings, and errors using Java's logging framework. Handles exceptions to ensure the system remains robust.

## Components

1. SensorData Class
- - Responsible for simulating sensor data.
- - Handles potential sensor malfunctions and throws `SensorException` if a malfunction occurs.

2. SensorException Class

- - Custom exception class for handling sensor-related errors.

3. VitalSignsAnalyzer Class

- - Analyzes sensor data to check if readings are within predefined safe ranges.
- - Triggers alarms by logging warnings if any readings are critical.

4. MedicalDeviceControlSystem Class
- - Main application class.
- - Reads sensor data, analyzes it using `VitalSignsAnalyzer`, and handles errors.

## Data Flow

1. **Data Reading**: The `SensorData` class reads data from the simulated sensors. Each sensor (heart rate, blood pressure, and temperature) has a 10% chance of malfunctioning, which is simulated by throwing a `SensorException`.
2. **Data Analysis**: The `VitalSignsAnalyzer` class analyzes the sensor data. It checks if the readings are within predefined thresholds and logs warnings if any readings are out of range.
3. **Error Handling**: If a sensor malfunction occurs, a `SensorException` is thrown and caught in the `MedicalDeviceControlSystem` class. The error is logged as a severe message to indicate a critical issue.
4. **Logging**: The system logs all readings, warnings, and errors using Java's logging framework. This ensures that all operations and issues are recorded for review and debugging.

## Sequence Diagram

```text
+-----------------------------+
|  MedicalDeviceControlSystem |
+-----------------------------+
             |
             v
+-----------------------------+
|        SensorData           |
+-----------------------------+
| readHeartRate()             |
| readBloodPressure()         |
| readTemperature()           |
+-----------------------------+
             |
             v
+-----------------------------+
|    VitalSignsAnalyzer       |
+-----------------------------+
| analyzeAndTriggerAlarms()   |
+-----------------------------+
             |
             v
+-----------------------------+
|         Logger              |
+-----------------------------+
| log(Level.INFO, ...)        |
| log(Level.WARNING, ...)     |
| log(Level.SEVERE, ...)      |
+-----------------------------+
```

## Error Handling Strategy
1. Sensor Malfunctions: Simulated with a 10% chance of occurrence. When a malfunction is detected, a SensorException is thrown, and the error is logged.
2. Data Analysis Errors: Any readings outside predefined thresholds are logged as warnings.
3. System Robustness: The application continues to run even if some sensors malfunction, ensuring continuous monitoring as long as at least one sensor is operational.

## Technology Stack
- **Programming Language**: [Java](https://www.java.com/)
- **Logging Framework**: [java.util.logging](https://docs.oracle.com/javase/8/docs/api/java/util/logging/package-summary.html)

## Future Enhancements
- **Real Sensors Integration**: Replace simulated sensors with actual hardware interfaces.
- **Network Communication**: Enable remote monitoring by transmitting data over a network.
- **User Interface**: Develop a graphical user interface (GUI) for real-time monitoring.
- **Advanced Analytics**: Implement more sophisticated algorithms for detecting anomalies and trends in vital signs.

## Conclusion
This system design provides a robust framework for a patient monitoring system with simulated sensors. It ensures accurate readings, triggers alarms for critical readings, and handles errors effectively. This design can be extended and enhanced for real-world medical applications, providing a foundation for reliable patient monitoring.