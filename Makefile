
# List files to be concatenated
# ZooApplication_ClassSource.java is special,
# as it imports packages -- thus it must come first here.
SOURCES = ZooApplication_ClassSource.java \
	Animal.java   Bird.java Mammal.java Reptile.java \
	NewAnimalButtonListener.java UpdateAnimalButtonListener.java \
	ZooFrame.java \
	AnimalListPanel.java

# default target: compile app
all: ZooApplication.class

run: ZooApplication.class
	java ZooApplication

ZooApplication.class: ZooApplication.java
	javac -Xlint:unchecked ZooApplication.java

# concat SOURCES into ZooApplication.java
ZooApplication.java: $(SOURCES)
	cat $(SOURCES) > $@

clean:
	rm -f *.class ZooApplication.java
