import './App.css';
import ReactDOM from "react-dom/client";
import {Menu} from './Menu';
import {Routes, Route, BrowserRouter} from 'react-router-dom';
import AddAirplane1, {  AddTicket, AddPerson, GrantPilotLicense, Flights, Routes_sub_menu, Airports, ViewsandSimulationCycle, FlightsInTheAir, FlightsOnTheGround, Offer_flight, AssignPilot,
Recycle_crew, Retire_flight, Remove_pilot_role, Remove_passenger_role, AddUpdateLeg, StartRoute, ExtendRoute, AddAirport, FlightLanding, FlightTakeoff,
PassengersBoard, PassengersDisembark, RouteSummary, AlternativeAirports, PeopleInTheAir, PeopleOnTheGround, FlightsOnTheGround} from './Menu';

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Menu />}/>
        <Route path="AddAirplane1" element={<AddAirplane1/>} />
        <Route path="AddPerson" element={<AddPerson/>} />
        <Route path="GrantPilotLicense" element={<GrantPilotLicense/>} />
        <Route path="Flights" element={<Flights/>} />
        <Route path="Routes_sub_menu" element={<Routes_sub_menu/>} />
        <Route path="Airports" element={<Airports/>} />
        <Route path="ViewsandSimulationCycle" element={<ViewsandSimulationCycle/>} />
        <Route path="FlightsInTheAir" element={<FlightsInTheAir/>} />
        <Route path="RouteSummary" element={<RouteSummary/>} />
        <Route path="PeopleInTheAir" element={<PeopleInTheAir/>} />
        <Route path="PeopleOnTheGround" element={<PeopleOnTheGround/>} />
        <Route path="AlternativeAirports" element={<AlternativeAirports/>} />
        <Route path="Tickets" element={<AddTicket/>} />
        <Route path="Offer_flight" element={<Offer_flight/>} />
        <Route path="Assign_pilot" element={<AssignPilot/>} />
        <Route path="Recycle_crew" element={<Recycle_crew/>} />
        <Route path="Retire_flight" element={<Retire_flight/>} />
        <Route path="Remove_pilot_role" element={<Remove_pilot_role/>} />
        <Route path="Remove_passenger_role" element={<Remove_passenger_role/>} />
        <Route path="Add_Update_Leg" element={<AddUpdateLeg/>} />
        <Route path="Start_Route" element={<StartRoute/>} />
        <Route path="Extend_Route" element={<ExtendRoute/>} />
        <Route path="Add_Airport" element={<AddAirport/>} />
        <Route path="Flight_landing" element={<FlightLanding/>} />
        <Route path="Flight_takeoff" element={<FlightTakeoff/>} />
        <Route path="Passengers_board" element={<PassengersBoard/>} />
        <Route path="Passengers_disembark" element={<PassengersDisembark/>} />
        <Route path="FlightsOnTheGround" element={<FlightsOnTheGround/>} />
<<<<<<< HEAD
=======

>>>>>>> edd3cfe2874c5862a26d41c38d60accd6479a875
      </Routes>
    </BrowserRouter>
  );
}




const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Menu />);