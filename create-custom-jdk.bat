rmdir jre /s/q
set PATH_TO_FX_MODS="javafx-jmods-11.0.2"
jlink --module-path "%PATH_TO_FX_MODS%;target\timeline-1.0-SNAPSHOT.jar" --add-modules=timeline --output jre
