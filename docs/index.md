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
    > As someone who games for the completion milestone, I use games to challenge myself mentally by dealing with arduous decision-making, I want my access to the content limited unless I work within the intended constraints of the games design.
* Science Fiction Fan
    > As a Science Fiction fan, I want access to quality Science Fiction material, so that I may occupy myself through abstract and creative world-building.


## Functionality
+ Structured stack based gameplay - during each stack the user will need to make a structured series of decisions. Each stack is broken into phases. Each phase will also provide an environment defining photo to compliment the informational text and buttons on the bottom half of the screen. 
+ The first phase starts with visiting the space station. Here you make planetary pathway decisions where you must decide between two paths of three planets total. Each path only shows limited information, for example the user may only see the first two planets. There are also *"hidden"* planets that are never visible in the forecast. At the space station the user may also build materials using their resources stored in their ship.
+ Once the user leaves the space station they enter the Space Phase, but don't let the name fool you. The Space Phase can quickly become the Random Event Phase if a random roll of the dice indicates it to take place of the space phase(internal only or visual representation undecided).
  + The Space Phase simply deducts from the fuel supply and prompts the user to proceed to the first planet.
  + The Random Event Phase has multiple options (also decided by a dice roll). 
    + Gas Leak (Ship Damage)
    + Space Pirate Theft (Mined Resources,Ship Modifiers, Fuel, Ship Damage)
    + Black Hole (Change planet path and disrupt players plans)
    + Material Miner destroyed
    + Hazard Protection destroyed
+ After completing the Space Phase, the user enters the Planet Phase.
+ The planet phase has a set of user interactions
  + The planet automatically hands over a damage value based on its environment type. Most planets provide a damage value of +1, but there are some exceptions. There are two planets that can heal the user, and some planets provide a value of two instead of one.
    + Lush *(hidden)* (+2)
    + Radiation *(hidden)* (-2)
    + Scorched (-1)
    + Frozen (-1)
    + Volcanic (-1)
    + Marsh (+1)
  + The user may view ship status, where they see a list of pertinent information. 
    + Mined Resources
    + Ship Modifiers
    + Ship Health (Max = 3)
    + Fuel (Max = 6)
  + The user may mine their planet for that planet types resources, however they must do this responsibly as there is a chance their mining tool may become destroyed.
  + Lastly, they may depart to the next space phase where that phase will be followed by the next planet or space station depending on their position in the structured stack of events. (three planets must be visited) 
+ As previously mentioned in the beginning of our functionality description, mined resources are to be spent. The user has a list of options.
  + Mining Tool (if previously broken during planet phase)
  + Hazard Protection (*planet type listed here*)
    + Radiation Antioxidant (Radiation)
    + Water Recycler (Scorched)
    + Thermal Insulator (Frozen)
    + Molten Plates (Volcanic)
  + Random Event Protection
    + Cabin Oxygen Sealant (Random Event Gas Leak)
    + Black Hole Response System (Random Event Black Hole)
    + Pirate Response System (Random Event Pirate Theft)
  + Mystery Box (2/3 the price for a random item listed above, but 1/3 chance you get nothing)
  + Fuel
+ At this point the user will be prompted to enter the next phase, where the structured stack repeats. 
+ Performance will be graded and measured, providing a leaderboard and encouraging replayability. 

## Persistent data

+ Game save data
    * Resources
    * Destination and future routes
    * Planets Traveled / Space Stations Visited
+ Full functionality without internet access is preferred, but that will prove to be true or false in development.
    
## Device/external services

+ Photos will be accessible so the player can upload their image into the games profile picture as the "captains photo", the photo can also be listed on the game leaderboards. 

+ Contacts can be utilized to invite friends to play and eventually compare the scores amongst one another. I would like to make this device access optional to not discourage application use. 

## Stretch goals/possible enhancements 

Adding additional versions where for example unlimited random travel destinations spawn while the difficulties raise.  
