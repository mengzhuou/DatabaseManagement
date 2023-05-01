package com.gtbackend.gtbackend.dao;

import com.gtbackend.gtbackend.model.FlightOnTheGround;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightOnTheGroundDao extends JpaRepository<FlightOnTheGround, String> {

    @Query(value = "create or replace view flights_on_the_ground (departing_from, num_flights, flight_list, earliest_arrival, latest_arrival, airplane_list) as select departure, num_flights, flightID, earlist_arrival, latest_arrival, locationID from (select departure, arrival, num_flights, flightID, next_time as earlist_arrival, next_time as latest_arrival, support_tail from (select routeID, departure, arrival, num_flights from (select leg.legID, departure, arrival, count(flightID) as num_flights from (select flightID, legID from (select flightID, routeID, progress, next_time as earlist_arrival, next_time as latest_arrival from flight where airplane_status='on_ground') as temp join route_path on temp.routeID = route_path.routeID and progress+1=sequence) as temp1 join leg on temp1.legID = leg.legID group by leg.legID) as temp2 right outer join route_path on route_path.legID = temp2.legID) as temp3 join flight on temp3.routeID=flight.routeID and flight.airplane_status = 'on_ground' and departure != 'null') as temp4 join airplane on temp4.support_tail=airplane.tail_num;", nativeQuery = true)
    void createFlightsOnTheGroundView();

    @Query("SELECT f FROM FlightOnTheGround f")
    List<FlightOnTheGround> getFlightsOnTheGround();

}
