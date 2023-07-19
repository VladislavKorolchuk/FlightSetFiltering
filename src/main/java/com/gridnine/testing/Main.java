package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        FlightFilter flightFilter = new FlightFilter();

        System.out.println("List of all flights:");
        flightList.forEach(System.out::println);

        System.out.printf("%nDeparture to the current point in time%n");
        flightFilter.DepartureToTheCurrentPointInTime(flightList).forEach(System.out::println);

        System.out.printf("%nThere are segments with an arrival date earlier than the departure date%n");
        flightFilter.thereAreSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(flightList).forEach(System.out::println);

        System.out.printf("%nTotal time spent on the ground exceeds two hours%n");
        flightFilter.totalTimeSpentOnTheGroundExceedsTwoHours(flightList).forEach(System.out::println);
    }

}
