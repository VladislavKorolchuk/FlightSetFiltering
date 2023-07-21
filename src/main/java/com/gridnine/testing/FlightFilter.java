package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilter {

    /**
     * <br> Filtering - departure to the current point in time </br>
     *
     * @param flightList - flight list input
     * @return List<Flight> - returns a list of flights
     * @author Korolchuk Vladislav
     */
    public List<Flight> DepartureToTheCurrentPointInTime(List<Flight> flightList) {

        List<Flight> finalFlightFilter = new ArrayList<>();
        finalFlightFilter.addAll(flightList);

        for (int flightCell = 0; flightCell < flightList.size(); flightCell++) {

            if (flightList.get(flightCell).getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now())) {
                finalFlightFilter.remove(flightList.get(flightCell));
            }

        }
        return finalFlightFilter;

    }


    /**
     * <br> Filtering - there are segments with an arrival date earlier than the departure date </br>
     *
     * @param flightList- flight list input
     * @return List<Flight> - returns a list of flights
     * @author Korolchuk Vladislav
     */
    public List<Flight> thereAreSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(List<Flight> flightList) {

        List<Flight> finalFlightFilter = new ArrayList<>();
        finalFlightFilter.addAll(flightList);

        for (int flightCell = 0; flightCell < flightList.size(); flightCell++) {
            for (int segmentСell = 0; segmentСell < flightList.get(flightCell).getSegments().size(); segmentСell++) {
                LocalDateTime departureDate = flightList.get(flightCell).getSegments().get(segmentСell).getDepartureDate();
                LocalDateTime arrivalDate = flightList.get(flightCell).getSegments().get(segmentСell).getArrivalDate();
                if (departureDate.isAfter(arrivalDate)) {
                    finalFlightFilter.remove(flightList.get(flightCell));
                    break;
                }
            }
        }
        return finalFlightFilter;

    }


    /**
     * <br> Filtering - the total time spent on the ground exceeds two hours (time on the ground is the interval between
     * the arrival of one segment and the departure of the next one after it) </br>
     *
     * @param flightList- flight list input
     * @return List<Flight> - returns a list of flights
     * @author Korolchuk Vladislav
     */
    public List<Flight> totalTimeSpentOnTheGroundExceedsTwoHours(List<Flight> flightList) {

        List<Flight> finalFlightFilter = new ArrayList<>();
        finalFlightFilter.addAll(flightList);

        for (int flightCell = 0; flightCell < flightList.size(); flightCell++) {
            for (int segmentСell = 0; segmentСell < flightList.get(flightCell).getSegments().size()-1; segmentСell++) {
                LocalDateTime arrivalDate = flightList.get(flightCell).getSegments().get(segmentСell).getArrivalDate();
                LocalDateTime departureDate = flightList.get(flightCell).getSegments().get(segmentСell + 1).getDepartureDate();
                if (arrivalDate.plusHours(2).isBefore(departureDate)) {
                    finalFlightFilter.remove(flightList.get(flightCell));
                    break;
                }
            }
        }
        return finalFlightFilter;
    }

}
