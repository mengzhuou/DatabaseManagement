import './App.css';
import ReactDOM from "react-dom/client";
import {Menu} from './Menu';
import {Routes, Route, BrowserRouter} from 'react-router-dom';
//import AddAirplane1 from './Menu';
import AddAirplane1, { AddPerson, GrantPilotLicense } from './Menu';
//import AddPerson from './Menu';


export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Menu />}/>
        <Route path="AddAirplane1" element={<AddAirplane1/>} />
        <Route path="AddPerson" element={<AddPerson/>} />
        <Route path="GrantPilotLicense" element={<GrantPilotLicense/>} />
      </Routes>
    </BrowserRouter>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Menu />);
