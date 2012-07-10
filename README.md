Birthday_Problem
================

Proving the birthday problem holds indeed

Dependancy:
jfreechart-1.0.14-demo.jar

##The Birthday Paradox:
  By pigeonhole principle it can be stated that if 366 people are selected at 
random atleast two people will share same birthdate as number of days in a year
is 365(we ignore leap years as special cases)

But,it is observed that if all days of years are considered equally likely 
for birthdays to fall on(which is not the case in real life),the probability 
that any two persons form a pair sharing birthday crosses 50% with just 23 
persons and becomes 99% with just 57 persons.

Proving that Birthday Paradox holds indeed:
	By defination,
	
	Probability that event x occurs = (No. of times event x occurs)/No. of trials
	
Hence,we conduct n trials^[1] and record the successful outcomes for each trial.
Trials are conducted in following manner,
	We go on selecting persons guessing their birthdates in random^[2] manner until
first pair is found,here the current person no. is minimum no. of persons required
to from a pair in that particular trial.Hence, we increment the succesful outcomes
of all person no.s from current person no. 366 will abviously be the maximum no.
of persons required in a trial as pair is always guaranteed with 366 persons.

	After n trials are complete we calculate the probability as follows,
	
	Probability that pair is found with x persons = No. of succesful outcomes with x persons
	                                      			----------------------------------------			
                                                                 n trials

The, obtained probability then reveals that Birthday Paradox indeed holds
as it matches to expected values assuming the Birthday Paradox holds.Also,
the plotted curve demonstrates the same.								

									
##[1] Number of trials
 Although the nature of curve starts taking shape with trials as low as 10,
more than 600 trials are required to get satisfactorily smooth curve and more
accurate values.

##[2] Random birthdate Generation
 Days of year are modeled from 0 to 364(365 days) using an array.
A random day is selected as birthdate in range 0 to 364 using construct 
random()*365 returning values in range [0,365).
The random() implements linear congruential generator hence even distribution
over the range is mostly guaranteed.
