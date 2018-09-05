all:
	find . -name "*.java" > sources.txt
	javac -sourcepath . @sources.txt
clean:
	rm -rf ./avaj/java/*.class
fclean: clean
	rm -rf sources.txt
re: fclean all