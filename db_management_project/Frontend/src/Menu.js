import React, { Component, useState } from 'react';
import {addAirplane} from './connector';
import './App.css';

export function Menu() {
  const [activeTab, setActiveTab] = useState('AddAirplane1','AddPerson');
  const openTab = (url) => {
      window.open(url, "_blank");
    };
  const handleTabClick = (tabName) => {
    setActiveTab(tabName);
  };
  return (
    <div className="Menu">
    <br />
    Simple Airline Management System (SAMS)
      <div className="sidebar">
        <div
          className={activeTab === 'AddAirplane1' ? 'active' : ''}
          onClick={() => openTab("/AddAirplane1")}
        >
        <br />
         <button><a href="/AddAirplane1">Airplanes</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Pilots' ? 'active' : ''}
          onClick={() => openTab("/GrantPilotLicense")}
        >
          <button><a href="/GrantPilotLicense">Pilots</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'People' ? 'active' : ''}
          onClick={() => openTab("/AddPerson")}
        >
          <button><a href="/AddPerson">People</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Flights' ? 'active' : ''}
          onClick={() => openTab("/Flights")}
        >
          <button><a href="/Offer_Flight">Flights</a></button>
        </div>
        <br />
      </div>
      <div className="main">
        <div
          className={activeTab === 'Routes' ? 'active' : ''}
          onClick={() => openTab("/Routes")}
        >
          <button><a href="/Routes1">Routes</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Tickets' ? 'active' : ''}
          onClick={() => openTab("/Tickets")}
        >
          <button><a href="/Purchase_ticket_and_seat">Tickets</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Airports' ? 'active' : ''}
          onClick={() => openTab("/Airports")}
        >
          <button><a href="/Add_Airport">Airports</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'ViewsandSimulationCycle' ? 'active' : ''}
          onClick={() => openTab("/ViewsandSimulationCycle")}
        >
          <button><a href="/ViewsandSimulationCycle1">Views and Simulation Cycle</a></button>
        </div>
        <br />
      </div>
    </div>
  );
}

//Q1
export default class AddAirplane1 extends Component {
  constructor(props) {
    super(props);

    this.state = {
      airlineID: "",
      tail_num: "",
      seat_capacity: "",
      speed: "",
      locationID: "",
      plane_type: "",
      skids: "",
      propellers: "",
      jet_engines: "",
    };

    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleInputChange(event) {
    const target = event.target;
    let value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;

    if (name === "skids" && !["0", "1"].includes(value)) {
      value = null;
    }
    if (name === "locationID" || name === "skids" || name === "propellers" || name === "jet_engines") {
      if (value === "") {
          value = null;
      }
    }

    this.setState({
      [name]: value,
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    const airplaneData = {
      airlineID: this.state.airlineID,
      tail_num: this.state.tail_num,
      seat_capacity: this.state.seat_capacity,
      speed: this.state.speed,
      locationID: this.state.locationID,
      plane_type: this.state.plane_type,
      skids: this.state.skids,
      propellers: this.state.propellers,
      jet_engines: this.state.jet_engines,
    };
    alert(JSON.stringify(airplaneData));

    addAirplane(airplaneData)
      .then(data => {
        console.log('Airplane added successfully:', data);
      })
      .catch(error => {
        console.error('Failed to add airplane:', error);
      });


  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div>
          <label>
            Airline ID:
            <input
              name="airlineID"
              type="text"
              value={this.state.airlineID}
              onChange={this.handleInputChange}
            />
          </label>
        </div>
        <div>
          <label>
            Tail Number:
            <input
              name="tail_num"
              type="text"
              value={this.state.tail_num}
              onChange={this.handleInputChange}
            />
          </label>
        </div>
        <div>
          <label>
            Seat Capacity:
            <input
              name="seat_capacity"
              type="number"
              value={this.state.seat_capacity}
              onChange={this.handleInputChange}
            />
          </label>
        </div>
        <div>
          <label>
            Speed:
            <input
              name="speed"
              type="number"
              value={this.state.speed}
              onChange={this.handleInputChange}
            />
          </label>
        </div>
        <div>
          <label>
            Location ID:
            <input
              name="locationID"
              type="text"
              value={this.state.locationID}
              onChange={this.handleInputChange}
            />
          </label>
        </div>
        <div>
          <span>Plane Type:</span>
          <div>
            <label>
              <input
                type="radio"
                name="plane_type"
                value="jet"
                checked={this.state.plane_type === "jet"}
                onChange={this.handleInputChange}
              />
              jet
            </label>
            <label>
              <input
                type="radio"
                name="plane_type"
                value="prop"
                checked={this.state.plane_type === "prop"}
                onChange={this.handleInputChange}
              />
              prop
            </label>
          </div>
        </div>
        <div>
          <span>Skids:</span>
          <div>
            <label>
              <input
                type="radio"
                name="skids"
                value="0"
                checked={this.state.skids === "0"}
                onChange={this.handleInputChange}
              />
              false
            </label>
            <label>
              <input
                type="radio"
                name="skids"
                value="1"
                checked={this.state.skids === "1"}
                onChange={this.handleInputChange}
              />
              true
            </label>
          </div>
        </div>

        <div>
          <label>
            Propellers:
            <input
              name="propellers"
              type="number"
              value={this.state.propellers}
              onChange={this.handleInputChange}
            />
          </label>
        </div>
        <div>
          <label>
            Jet Engines:
            <input
              name="jet_engines"
              type="number"
              value={this.state.jet_engines}
              onChange={this.handleInputChange}
              />
            </label>
        </div>
      <button type="submit">Add</button>
      <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
        );
      }
    }

//Q3
export class AddPerson extends Component {
  constructor(props) {
    super(props);
    this.state = {
      personID: '',
      locationID: '',
      first_name: '',
      last_name: '',
      taxID: '',
      experience: '',
      flying_airline: '',
      flying_tail: '',
      miles: ''
    };
  }

  handleInputChange = (event) => {
    const target = event.target;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    console.log('Form submitted:', this.state);
    const personData =
    {personID: '',
           locationID: this.state.locationID,
           first_name: this.state.first_name,
           last_name: this.state.last_name,
           taxID: this.state.taxID,
           experience: this.state.experience,
           flying_airline: this.state.flying_airline,
           flying_tail: this.state.flying_tail,
           miles: this.state.miles
    }
    alert(JSON.stringify(personData));
    AddPerson(personData)
          .then(data => {
            console.log('Person added successfully:', data);
          })
          .catch(error => {
            console.error('Failed to add person:', error);
          });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Person ID:
          <select name="personID" value={this.state.personID} onChange={this.handleInputChange}>
            <option value="">--Select a person ID--</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            {/* add more options as needed */}
          </select>
        </label>
        <br />
        <label>
          Location ID:
          <select name="locationID" value={this.state.locationID} onChange={this.handleInputChange}>
            <option value="">--Select a location ID--</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            {/* add more options as needed */}
          </select>
        </label>
        <br />
        <label>
          First Name:
          <input type="text" name="firstName" value={this.state.first_name} onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          Last Name:
          <input type="text" name="lastName" value={this.state.last_name} onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          Tax ID:
          <input type="text" name="taxID" value={this.state.taxID} onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          Experience:
          <input type="text" name="experience" value={this.state.experience} onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          Airline:
          <input type="text" name="airline" value={this.state.flying_airline} onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          Tail:
          <input type="text" name="tail" value={this.state.flying_tail} onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          Miles:
          <input type="text" name="miles" value={this.state.miles} onChange={this.handleInputChange} />
        </label>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
    );
  }
}


//Q4
export class GrantPilotLicense extends Component {
  constructor(props) {
    super(props);
    this.state = {
      personID: '',
      licenseType: ''
    };
  }

  handleInputChange = (event) => {
    const target = event.target;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    console.log('Form submitted:', this.state);
    const PilotLicenseData = {
    personID: this.state.personID,
    license: this.state.license
    };
    alert(JSON.stringify(PilotLicenseData));
    GrantPilotLicense(PilotLicenseData)
          .then(data => {
            console.log('Airplane added successfully:', data);
          })
          .catch(error => {
            console.error('Failed to add airplane:', error);
          });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          Person ID:
          <select name="personID" value={this.state.personID} onChange={this.handleInputChange}>
            <option value="">--Select a person ID--</option>
            <option value="p1">p1</option>
            <option value="p2">p2</option>
            <option value="p3">p3</option>
            <option value="p4">p4</option>
            <option value="p5">p5</option>
            <option value="p6">p6</option>
            <option value="p7">p7</option>
            <option value="p8">p8</option>
            {/* add more options as needed */}
          </select>
        </label>
        <br />
        <label>
          License Type:
          <select name="licenseType" value={this.state.licenseType} onChange={this.handleInputChange}>
            <option value="">--Select a license type--</option>
            <option value="Prop">Prop License</option>
            <option value="Commercial">Commercial Pilot License</option>
            <option value="Airline">Airline Transport Pilot License</option>
            {/* add more options as needed */}
          </select>
        </label>
        <br />
        <input type="submit" value="Grant" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
    );
  }
}
