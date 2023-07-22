## Application for filtering a set of flights

#### Developer:
[Korolchuk Vladislav](https://github.com/VladislavKorolchuk)
***
### Application functionality ###
**Implemented an application that filters a set of flights:**
- flight up to the current point in time;
- there are segments with an arrival date earlier than the departure date;
- total time spent on the ground exceeds two hours (time on the ground is the interval between the arrival of one segment and the departure of the next one after it)

***
### Technology stack: ###

- Programming language *Java*
- *JUnit*

***

## Application assembly

git clone https://github.com/VladislavKorolchuk/FlightSetFiltering.git \
cd FlightSetFiltering \
mvn package \
cd target

## Launch
java -jar FlightSetFiltering.jar

