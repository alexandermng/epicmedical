# EPIC Medical

For the CSE 360 Group Project. Implemented in Java using JavaFX. Using Gradle as a build tool.

We use JavaFX's FXML utilities to define our UI declaratively and follow the Model-View-Controller design pattern.
In this way, we can separate the application logic and functionality from the visual UI.

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

Click `File > Import...`, and import the project as `Gradle > Existing Gradle Project`. After going through the wizard, it should be added under "app". If this option was not present, you need to ensure the Eclipse [BuildShip](https://marketplace.eclipse.org/content/buildship-gradle-integration) plugin is installed from the marketplace.

To run it, under the `Gradle Tasks` pane, right-click under `epicmedical > application > run` and select `Open Gradle Run Configuration`. Save this new configuration, and after running it once you should be able to use the normal Run button. If not, right click the Run button and select the Gradle task as the run config.

## Running

If you're on the command-line, you can always do (Linux/Mac)
```
./gradlew run
```