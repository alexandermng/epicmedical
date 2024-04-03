# EPIC Medical

For the CSE 360 Group Project. Implemented in Java using JavaFX. Using Gradle as a build tool.

## Project Structure

```
.
├── app
│  ├── bin                          # Eclipse build directory
│  ├── build.gradle.kts             # Application Config
│  └── src
│     ├── main                      # Main application code
│     │  ├── java
│     │  │  └── edu
│     │  │     └── asu
│     │  │        └── cse360s24     # Source code (Java)
│     │  └── resources
│     │     └── edu
│     │        └── asu
│     │           └── cse360s24     # Resources (FXML, CSS, etc)
│     └── test                      # Tests
│        ├── java
│        └── resources
├── gradle                          # Gradle internals
├── gradlew                         # Linux/Mac build script
├── gradlew.bat                     # Windows build script
└── settings.gradle.kts             # Project config
```

## Installation

First, clone the repository:
```
git clone https://github.com/alexandermng/epicmedical.git
```

### Eclipse

Click `File > Import...`, and import the project as `Gradle > Existing Gradle Project`. After going through the wizard, it should be added under "app".

To run it, under the `Gradle Tasks` pane, right-click under `epicmedical > application > run` and select `Open Gradle Run Configuration`. Save this new configuration, and after running it once you should be able to use the normal Run button. If not, right click the Run button and select the Gradle task as the run config.