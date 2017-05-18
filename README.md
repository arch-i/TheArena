# TheArena
Comparing Github Users 
(uses gson-2.8.0.jar)


This is a simple java program where 2 users on GitHub are compared based on their contributions on GitHub using their personal GitHub access tokens in stdin.

It returns -

 -Total number of commits
 
 -Last week’s number of commits
 
 -Total repos each owns
  
 -Stars and forks on each repo, and whether there is any contribution by that user in the repo (in case the repo is forked)
 
 -Most active programming language
 
### Build Instructions
 
1. Clone TheArena repo (zip format)
2. Download gson-2.8.0.jar file
    -(http://central.maven.org/maven2/com/google/code/gson/gson/2.8.0/gson-2.8.0.jar)
3. Open Eclipse IDE
    -File -> Open Projects from File System
    -Archieve the location of TheArena-master.zip -> finish
    -add the gson external jar
   

A input could be the users' access tokens:

8271279fb6524461a515837bbccd7593 d7c1589917d04b739b57ad85d29e168f

And output could be:

	User A:
	 Total commits: 10
	 Last week’s commits: 3
	 Total repos: 15
			Repo 1: Stars - 1, Forks - 0, commits - 8
			…
			…

		Most active programming language: Python
    
	User B:
	 Total commits: 11
	 Last week’s commits: 1
	 Total repos: 16
			Repo 1: Stars - 1, Forks - 1, commits - 7
			…
			…

		Most active programming language: Java
    
