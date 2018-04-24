# tarmonIsland
Round-Based Game

# Idea
Tarmon Island (http://behindthemirrors.de/ti/) is a Game developed in the 90ies (Play-by-Email). We try to port the idea into nower days with a java based browser multiplayer game. The actual implementation has the following goals:
- learn how to develop with git
- learn how to manage a project (with more the 2 developers)
- improve programming skills
- examine, if programming a this level with a versioning system, could fit into normal computer science lessons

# Workflow
We use git with the following strategie:
- write a description in the issue part to be referenced by the branches
- every feature/hotfix will be developed in a new branch which is deleted afterwards
- we use the following convention: feature/NN-my-new-feature-name-12345 (if there is a named issue in github, then take the issue number afterwards), NN are the initals of your name

# Environment
- we use Netbeans 8.2 with Java SE 8
- we use the Jetty Distribution jetty-distribution-9.4.9.v20180320 (http://central.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.9.v20180320/jetty-distribution-9.4.9.v20180320.zip)
- import the jars into the project and compile our sources

# Project File Structure
/
/src
/nbproject
/lib/jetty-distribution-9.4.9.v20180320 - expand Jetty Distribution here


