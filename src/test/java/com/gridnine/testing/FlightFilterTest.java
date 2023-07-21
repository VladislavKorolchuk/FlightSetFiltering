package com.gridnine.testing;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFilterTest {

    private final FlightFilter flightFilter = new FlightFilter();

    private LocalDateTime currentDateAndTime;

    private List<Flight> flight;

    private List<Flight> flightList;

    @BeforeEach
    void beforeEach() {

        currentDateAndTime = LocalDateTime.now();

        flight = Arrays.asList(new Flight(Arrays.asList(
                        new Segment(currentDateAndTime.minusMinutes(1), currentDateAndTime.plusHours(1)),
                        new Segment(currentDateAndTime.plusHours(2), currentDateAndTime.plusHours(3)),
                        new Segment(currentDateAndTime.plusHours(3), currentDateAndTime.plusHours(2)),
                        new Segment(currentDateAndTime.plusHours(5), currentDateAndTime.plusHours(7)))),

                new Flight(Arrays.asList(
                        new Segment(currentDateAndTime.minusMinutes(1), currentDateAndTime.plusHours(2)),
                        new Segment(currentDateAndTime.plusHours(3), currentDateAndTime.plusHours(2)))),

                new Flight(Arrays.asList(
                        new Segment(currentDateAndTime.plusHours(1), currentDateAndTime.plusHours(2)),
                        new Segment(currentDateAndTime.plusHours(3), currentDateAndTime.plusHours(1))))
        );

    }

    @Test
    void departureToTheCurrentPointInTime() {

        flightList = flightFilter.DepartureToTheCurrentPointInTime(flight);

        Assert.assertEquals(flight.size(), 3);
        Assert.assertEquals(flightList.size(), 1);

    }

    @Test
    void thereAreSegmentsWithAnArrivalDateEarlierThanTheDepartureDate() {

        flightList = flightFilter.thereAreSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(flight);

        Assert.assertEquals(flight.size(), 3);
        Assert.assertEquals(flightList.size(), 0);

    }

    @Test
    void totalTimeSpentOnTheGroundExceedsTwoHours() {

        flightList = flightFilter.totalTimeSpentOnTheGroundExceedsTwoHours(flight);

        Assert.assertEquals(flight.size(), 3);
        Assert.assertEquals(flightList.size(), 2);

    }
}