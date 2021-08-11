---
title: Project Overview
subtitle: "Summary, Intended Users, Functionality, Persistent Data, Device/External Services, Possible Enhancements"
menu: Project Overview
order: 0
---


## Summary

Intergalactic Unknown serves as an exciting android game, more specifically a choice based sci-fi survival game. The user will embark on an intergalactic journey where they must balance their ships needs during space travel. My inspiration comes from a love of fiction and more specifically fantasy or science fiction of all types. 

## Intended users

I plan to diversify my intended user base in hopes I can reach a large market of users.

* Business professionals who enjoy games
    > As a busy professional who uses games to "disconnect" from work during breaks, I want to access all the features of a game easily and directly, so that I don't lose valuable time digging through multiple levels of user interface controls.
* Hardcore Gamer
    > As someone who games for the completion milestone, I use games to challenge myself mentally by dealing with arduous decision-making. I can push myself to visit more planets with each game session. 
* Science Fiction Fan
    > As a Science Fiction fan, I want access to quality Science Fiction material, so that I may occupy myself through abstract and creative world-building.


## Functionality
+ Structured stack based gameplay - during each stack the user will need to make a structured series of decisions. Each stack is broken into phases. Each phase will also provide an environment defining photo to compliment the informational text and buttons on the bottom half of the screen. 
+ The first phase starts with visiting the space station. Here the user makes planetary pathway decisions where they must decide their first planet visited. They will also select a free resource to compliment their journeys needs. After making these choices, they are ready to depart for their trip.
+ Once the user leaves the space station they recieve their random event results. Here they find out if their preferred resource and planet type was changed, there is a one in three chance that this can happen. This information is indicated on a temporary screen.
+ After the random event results, the user enters their first of three landing phases.
+ Each landing phase has a list of information and user choices to be made. 
  + The planet automatically hands over a damage value based on its environment type / resource needs and the users resource inventory. After being used that resource is diminished and must be replaced.
    + Scorched 
    + Frozen 
    + Volcanic 

  + The user may view ship status, where they see a list of pertinent information. 
    + Mined Resources Available
    + Health Remaining

  + The user may mine their planet for that planet types resources, however they must do this responsibly as there is a chance their mining is unsuccessful, and in return they will lose a resource instead.
  + Lastly, they may depart to the next space phase where that phase will be followed by the next planet or space station depending on their position in the structured stack of events. (three planets must be visited) 
  
+ At this point the user will be prompted to enter the phase, where the game lifecycle repeats. 
+ Performance on planets visited will be graded and measured, providing a leaderboard, encouraging replayability. 

## Persistent data

+ Game save data
    * Planets Visited
    * Resources Available (if game is still active)


## Device/external services

+ Game will be connected to the Nasa Exoplanet API. This will provide real planet names to the planets the user will be traveling. I need assistance accessing the API still, but from what I can tell it is completely free and is [exactly what I wanted](https://exoplanetarchive.ipac.caltech.edu/docs/program_interfaces.html).

+ User will be prompted to sign in to google account, this will assist with User Ids for the leaderboard.

+ The game will need a small handful of images to represent each phase, I want the same images to be reused to reinforce what planet the user is on. 

## Stretch goals/possible enhancements 

Opportunity for user to modify the games difficulty is a stretch goal I would like to exlore. 
