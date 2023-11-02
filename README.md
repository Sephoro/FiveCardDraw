# FiveCardDraw

* Console-based application which deals and evaluates poker hands for a simplified version of the five-card draw variant.
* Has only one in-built player
* Outputs the player's hand and the strength of their hand

  ## Technical Requirements
  * Java 17 or higher
  * Maven
  * Springboot version 3.1.5
  * To run the application, execute the ``run.sh`` script
    * ``run.sh`` runs ``mvn clean install`` silently for the first time, without logs
    * ``run.sh -show-logs`` runs ``mvn clean install`` showing all logs
    * **NB** the ``mvn clean install`` command is only runs on the first execution of the application, from there on the ``run.sh`` script only executes the jar file. To make it ``clean install``  again delete the target folder

