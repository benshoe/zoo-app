all:
	javac AssignmentApplication.java

run: all
	java AssignmentApplication

clean:
	rm -f *.class