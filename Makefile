
# List files to be considered for md5 checksum -- .java files
SOURCES = $(shell echo *.java)
# build md5 checksum for .zip file creation
SOURCEMD5 = $(shell cat *.java | openssl md5)

# default target: compile app
all: ZooApplication.class

run: ZooApplication.class
	java ZooApplication

ZooApplication.class:
	javac -Xlint:all ZooApplication.java

clean:
	rm -f *.class

# this will create a .zip, named ../<this-FolderName>-<codeCheckSum>.zip
zip:
	SelfDir=`basename "$$(pwd)"`; \
		cd .. ; \
		zip -x '*.git*' -r $$SelfDir-$(SOURCEMD5).zip $$SelfDir; \
		echo .zip saved to: ../$$SelfDir-$(SOURCEMD5).zip

# this may only suit me: diff current directory (a git repo
# containing our sources) against our google drive code base
diff:
	diff -u ~/Google\ Drive/Week56-Project/SourceCode .
