# JAVA MISSION CONTROL (JMC)
* JMC - Build for monitoring, profiling and troubleshooting java applications
* It Consists of 
  * 1. `JMX Console` : For monitoring JVM and application in real time
  2. `Java Flight Recorder`: For collecting data about JVM and appliction.
  3. Optional tools via plug-ins (e.g. heap dump analysis, DTrace recording)

* `/usr/lib/jvm/java-8-oracle/bin/jmc`
  
  <img src="images/Java_Mission_Control.png" center="ture" width="1500">

### Mission Control Features

#### Application Features
* A framework for hosting various useful java tools
* A tool for visualizing the contents of java flight recordings, and the results of an automated analysis of the contents
* A JMX Console
* A tool for heap waste analysis

#### Core API Features
* Core APIs for parsing and processing Java flight recordings
* Core API can read recordings from JDK 7 and above
* Core API can run on JDK 8 and above
* Core API contains a framework for handling units of measurement and physical qunatities
* Core API supports headless analysis of Java flight recordings


### References
* https://www.oracle.com/java/technologies/jdk-mission-control.html
* https://github.com/openjdk/jmc
* https://openjdk.java.net/projects/jmc/
  