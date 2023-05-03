import './App.css';
import ReactDOM from "react-dom/client";
import {Menu} from './Menu';
import {Routes, Route, BrowserRouter} from 'react-router-dom';
import AddAirplane1, {  AddTicket, AddPerson, GrantPilotLicense, Flights, Routes_sub_menu, Airports, ViewsandSimulationCycle, FlightsInTheAir, Offer_flight, Assign_pilot,
Recycle_crew, Retire_flight, Remove_pilot_role, Remove_passenger_role} from './Menu';

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
        <Route path="Tickets" element={<AddTicket/>} />
        <Route path="Offer_flight" element={<Offer_flight/>} />
        <Route path="Assign_pilot" element={<Assign_pilot/>} />
        <Route path="Recycle_crew" element={<Recycle_crew/>} />
        <Route path="Retire_flight" element={<Retire_flight/>} />
        <Route path="Remove_pilot_role" element={<Remove_pilot_role/>} />
        <Route path="Remove_passenger_role" element={<Remove_passenger_role/>} />

      </Routes>
    </BrowserRouter>
  );
}




const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Menu />);