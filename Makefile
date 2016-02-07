
# List files to be concatenated
# AssignmentApplication_ClassSource.java is special,
# as it imports packages -- thus it must come first here.
SOURCES = AssignmentApplication_ClassSource.java Animal.java Bird.java Mammal.java NewAnimalButtonListener.java Reptile.java UpdateAnimalButtonListener.java ZooEditor.java

# default target: compile app
all: AssignmentApplication.class

run: AssignmentApplication.class
	java AssignmentApplication

AssignmentApplication.class: AssignmentApplication.java
	javac -Xlint:unchecked AssignmentApplication.java

# concat SOURCES into AssignmentApplication.java
AssignmentApplication.java: $(SOURCES)
	cat $(SOURCES) > $@

clean:
	rm -f *.class AssignmentApplication.java
