# Medical Device Control System

## Overview
This Java application simulates a control system for a medical device used in patient monitoring. It involves reading sensor data, analyzing vital signs, and triggering alarms in case of critical readings. The system is designed to handle potential error scenarios such as sensor malfunctions, data transmission issues, and incorrect calculations.

## Components
The application consists of the following main components:

1. SensorData: A class that simulates sensor readings for heart rate, blood pressure, and temperature.
2. SensorException: A custom exception class for handling sensor-related errors.
3. VitalSignsAnalyzer: A class that analyzes the sensor data and triggers alarms if readings are out of predefined safe ranges.
4. MedicalDeviceControlSystem: The main application class that integrates sensor data reading, analysis, and error handling.


## Features
- Simulates sensor data with a 10% chance of malfunction.
- Logs and handles sensor errors using a custom exception.
- Analyzes vital signs and triggers alarms if readings are out of safe ranges.
- Uses Java's logging framework to log information and errors.

## Classes and Methods

### SensorData
Simulates the reading of sensor data and handles sensor malfunctions.
- `readHeartRate()`: Reads heart rate data.
- `readBloodPressure()`: Reads blood pressure data.
- `readTemperature()`: Reads temperature data.
- `readSensorData(String sensorName)`: Simulates sensor data reading with a 10% chance of throwing a SensorException.

### SensorException
A custom exception class for sensor errors.
- `SensorException(String message)`: Constructor to create a new SensorException with a specified error message.

### VitalSignsAnalyzer
Analyzes vital signs and triggers alarms if readings are out of safe ranges.
- `analyzeAndTriggerAlarms(double heartRate, double bloodPressure, double temperature)`: Analyzes the sensor data and logs warnings if any readings are out of predefined safe ranges.

### MedicalDeviceControlSystem

The main application class that integrates sensor data reading, analysis, and error handling.

- `main(String[] args)`: Of cause, the entry point of the application. Reads sensor data, analyzes it, and handles any sensor errors.

## Usage
To run the application, compile and execute the `MedicalDeviceControlSystem` class. The system will read simulated sensor data, analyze the readings, and log any warnings or errors.

## Example Output

```java

Jul 27, 2024 4:06:45 PM MedicalDeviceControlSystem main
INFO: Heart Rate: 68.11036315607939
Jul 27, 2024 4:06:45 PM MedicalDeviceControlSystem main
INFO: Blood Pressure: 79.88294027208376
Jul 27, 2024 4:06:45 PM MedicalDeviceControlSystem main
INFO: Temperature: 108.04603242988031
Jul 27, 2024 4:06:45 PM VitalSignsAnalyzer analyzeAndTriggerAlarms
WARNING: Blood pressure out of range: 79.88294027208376
Jul 27, 2024 4:06:45 PM VitalSignsAnalyzer analyzeAndTriggerAlarms
WARNING: Temperature out of range: 108.04603242988031

```

## Error Handling

The system includes a robust error handling strategy (project call to action):

- Logs sensor malfunctions as severe errors.
- Catches and handles `SensorException` to prevent application crashes.
- Logs warnings for any vital signs that are out of the predefined safe ranges.

## Logging
The application uses Java's [`java.util.logging`](https://docs.oracle.com/javase/8/docs/api/java/util/logging/package-summary.html) framework for logging information, warnings, and errors. Log messages include the severity level and relevant information about the sensor data and any issues encountered.

## Conclusion
This application provides a basic yet robust framework for a medical device control system that reads, analyzes, and handles errors in patient monitoring data. It can be extended and refined for real-world medical applications. 🫶




