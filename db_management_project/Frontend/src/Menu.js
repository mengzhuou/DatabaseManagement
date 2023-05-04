import React, { Component, useState } from 'react';
import {addAirplane, purchaseTicketAndSeat, addAirport, addUpdateLeg, startRoute, extendRoute, flightLanding, flightTakeoff, passengersBoard, passengersDisembark, assignPilot, retireFlight, recycleCrew, removePassengerRole, removePilotRole, offerFlight } from './connector';
import './App.css';

export function Menu() {
  const [activeTab, setActiveTab] = useState('AddAirplane1','AddPerson', 'GrantPilotLicense', 'Flights', 'Routes_sub_menu', 'Tickets', 'Airports', 'ViewsandSimulationCycle');
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
          <button><a href="/Flights">Flights</a></button>
        </div>
        <br />
      </div>
      <div className="main">
        <div
          className={activeTab === 'Routes_sub_menu' ? 'active' : ''}
          onClick={() => openTab("/Routes_sub_menu")}
        >
          <button><a href="/Routes_sub_menu">Routes</a></button>
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
        <div
                  className={activeTab === 'FlightsInTheAir' ? 'active' : ''}
                    onClick={() => openTab("/FlightsInTheAir")}
                >

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
    {personID: this.state.personID,
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


export function Flights() {
  const [activeTab, setActiveTab] = useState('Offer_flight','Assign_pilot', 'Recycle_crew', 'Retire_flight', 'Remove_pilot_role', 'Remove_passenger_role');
  const openTab = (url) => {
      window.open(url, "_blank");
    };
  const handleTabClick = (tabName) => {
    setActiveTab(tabName);
  };
  return (
    <div className="Flights">
    <br />
    Flights
      <div className="sidebar">
        <div
          className={activeTab === 'Offer_flight' ? 'active' : ''}
          onClick={() => openTab("/Offer_flight")}
        >
        <br />
         <button><a href="/Offer_flight">Offer_flight</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Assign_pilot' ? 'active' : ''}
          onClick={() => openTab("/Assign_pilot")}
        >
          <button><a href="/Assign_pilot">assign_pilot</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Recycle_crew' ? 'active' : ''}
          onClick={() => openTab("/Recycle_crew")}
        >
          <button><a href="/Recycle_crew">Recycle_crew</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Retire_flight' ? 'active' : ''}
          onClick={() => openTab("/Retire_flight")}
        >
          <button><a href="/Retire_flight">Retire_flight"</a></button>
        </div>
        <br />
      </div>
      <div className="main">
        <div
          className={activeTab === 'Remove_pilot_role' ? 'active' : ''}
          onClick={() => openTab("/Remove_pilot_role")}
        >
          <button><a href="/Remove_pilot_role">Remove_pilot_role</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Remove_passenger_role' ? 'active' : ''}
          onClick={() => openTab("/Remove_passenger_role")}
        >
          <button><a href="/Remove_passenger_role">Remove_passenger_role</a></button>
        </div>
      </div>
    </div>
  );
}




// Q5
export class Offer_flight extends Component {
    constructor(props) {
      super(props);
      this.state = {
        flightID: '',
        routeID: '',
        support_tail: '',
        progress: '',
        airplane_status: '',
        support_airline: '',
        next_time: '',
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
      const flight =
      {
        flightID: this.state.flightID,
             routeID: this.state.routeID,
             support_tail: this.state.support_tail,
             progress: this.state.progress,
             airplane_status: this.state.airplane_status,
             support_airline: this.state.support_airline,
             next_time: this.state.next_time
      }
      alert(JSON.stringify(flight));
      offerFlight(flight)
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
          <div>
          <label>
            support_airline:
            <select name="support_airline" value={this.state.support_airline} onChange={this.handleInputChange}>
              <option value="">--Select a support_airline--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              {/* add more options as needed */}
            </select>
          </label>
          <br />
          <label>
            airplane_status:
            <select name="airplane_status" value={this.state.airplane_status} onChange={this.handleInputChange}>
              <option value="">--Select a airplane_status--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              {/* add more options as needed */}
            </select>
          </label>
          <br />
          <label>
            flightID:
            <input type="text" name="flightID" value={this.state.flightID} onChange={this.handleInputChange} />
          </label>
          <br />
          <label>
            routeID:
            <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
          </label>
          <br />
          <label>
            support_tail:
            <input type="text" name="support_tail" value={this.state.support_tail} onChange={this.handleInputChange} />
          </label>
          <br />
          <label>
            progress:
            <input type="text" name="progress" value={this.state.progress} onChange={this.handleInputChange} />
          </label>
          <br />
          <label>
            next_time:
            <input type="text" name="next_time" value={this.state.next_time} onChange={this.handleInputChange} />
          </label>
          </div>
          <br />
          <input type="submit" value="Add" />
          <button type="button" onClick={this.handleCancel}>Cancel</button>
        </form>
    )}
  }
//Q14 Assign Pilot 2 drop downs

export class AssignPilot extends Component {
  constructor(props) {
    super(props);
    this.state = {
      personID: '',
      flight: ''
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
    const pilotData =
    {
      routeID: this.state.routeID,
      legID: this.state.legID
    }
    alert(JSON.stringify(pilotData));
    assignPilot(pilotData)
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
        <div>
          <label>
            Person ID:
            <select name="personID" value={this.state.personID} onChange={this.handleInputChange}>
              <option value="">--Select a person ID--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </label>
        </div>
        <div>
          <label>
            Flight:
            <select name="personID" value={this.state.flight} onChange={this.handleInputChange}>
              <option value="">--Select a flight--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </label>
        </div>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}

//Q15 Assign Pilot 2 drop downs
export class Recycle_crew extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flightID: ''
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
    const flightData =
    {
      routeID: this.state.routeID,
      legID: this.state.legID
    }
    alert(JSON.stringify(flightData));
    recycleCrew(flightData)
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
        <div>
          <label>
            Flight ID:
            <select name="personID" value={this.state.personID} onChange={this.handleInputChange}>
              <option value="">--Select a person ID--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </label>
        </div>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}

// Q16

export class Retire_flight extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flightID: ''
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
    const flightData =
    {
      routeID: this.state.routeID,
      legID: this.state.legID
    }
    alert(JSON.stringify(flightData));
    retireFlight(flightData)
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
        <div>
          <label>
            Flight ID:
            <select name="personID" value={this.state.personID} onChange={this.handleInputChange}>
              <option value="">--Select a person ID--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </label>
        </div>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}


//Q17
export class Remove_passenger_role extends Component {
  constructor(props) {
    super(props);
    this.state = {
      personID: ''
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
    const person =
    {
      personID: this.state.personID,
    }
    alert(JSON.stringify(person));
    removePassengerRole(person)
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
        <div>
          <label>
            Person ID:
            <select name="personID" value={this.state.personID} onChange={this.handleInputChange}>
              <option value="">--Select a person ID--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </label>
        </div>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}

// Q18
export class Remove_pilot_role extends Component {
  constructor(props) {
    super(props);
    this.state = {
      personID: ''
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
    const person =
    {
      personID: this.state.personID,
    }
    alert(JSON.stringify(person));
    removePilotRole(person)
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
        <div>
          <label>
            Person ID:
            <select name="personID" value={this.state.personID} onChange={this.handleInputChange}>
              <option value="">--Select a person ID--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </label>
        </div>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}



export function Routes_sub_menu() {
  const [activeTab, setActiveTab] = useState('Add_Update_Leg','Start_Route', 'Extend_Route');
  const openTab = (url) => {
      window.open(url, "_blank");
    };
  const handleTabClick = (tabName) => {
    setActiveTab(tabName);
  };
  return (
    <div className="Routes_sub_menu">
    <br />
    Routes_sub_menu
      <div className="sidebar">
        <div
          className={activeTab === 'Add_Update_Leg' ? 'active' : ''}
          onClick={() => openTab("/Add_Update_Leg")}
        >
        <br />
         <button><a href="/Add_Update_Leg">Add_Update_Leg</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Start_Route' ? 'active' : ''}
          onClick={() => openTab("/Start_Route")}
        >
          <button><a href="/Start_Route">Start_Route</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Extend_Route' ? 'active' : ''}
          onClick={() => openTab("/Extend_Route")}
        >
          <button><a href="/Extend_Route">Extend_Route</a></button>
        </div>
      </div>
    </div>
  );
}


// Q7
export class Add_Update_Leg extends Component {
  constructor(props) {
    super(props);
    this.state = {
      legID: '',
      distance: '',
      departure: '',
      arrival: ''
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
    {legID: this.state.legID,
           distance: this.state.distance,
           departure: this.state.departure,
           arrival: this.state.arrival
    }
    alert(JSON.stringify(personData));
    AddPerson(personData)
          .then(data => {
            console.log('Add_Update_Leg added successfully:', data);
          })
          .catch(error => {
            console.error('Failed to Add_Update_Leg:', error);
          });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          departure:
          <select name="departure" value={this.state.departure} onChange={this.handleInputChange}>
            <option value="">--Select a departure--</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            {/* add more options as needed */}
          </select>
        </label>
        <br />
        <label>
          arrival:
          <select name="arrival" value={this.state.arrival} onChange={this.handleInputChange}>
            <option value="">--Select a arrival--</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            {/* add more options as needed */}
          </select>
        </label>
        <br />
        <label>
          legID:
          <input type="text" name="legID" value={this.state.legID} onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          distance:
          <input type="text" name="distance" value={this.state.distance} onChange={this.handleInputChange} />
        </label>
      </form>
    );
  }
}

// Q8
export class Start_Route extends Component {
  constructor(props) {
    super(props);
    this.state = {
      legID: '',
      routeID: ''
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
    {legID: this.state.legID,
           routeID: this.state.distance
    }
    alert(JSON.stringify(personData));
    AddPerson(personData)
          .then(data => {
            console.log('Start_Route added successfully:', data);
          })
          .catch(error => {
            console.error('Failed to Start_Route:', error);
          });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          legID:
          <select name="legID" value={this.state.legID} onChange={this.handleInputChange}>
            <option value="">--Select a legID--</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            {/* add more options as needed */}
          </select>
        </label>
        <br />
        <label>
          routeID:
          <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
        </label>
      </form>
    );
  }
}

// Q9
export class Extend_Route extends Component {
  constructor(props) {
    super(props);
    this.state = {
      legID: '',
      routeID: '',
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
    {legID: this.state.legID,
           routeID: this.state.distance,
    }
    alert(JSON.stringify(personData));
    AddPerson(personData)
          .then(data => {
            console.log('Extend_Route added successfully:', data);
          })
          .catch(error => {
            console.error('Failed to Extend_Route:', error);
          });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <label>
          legID:
          <select name="legID" value={this.state.legID} onChange={this.handleInputChange}>
            <option value="">--Select a legID--</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            {/* add more options as needed */}
          </select>
        </label>
        <br />
        <label>
          routeID:
          <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
        </label>
      </form>
    );
  }
}


export function Airports() {
  const [activeTab, setActiveTab] = useState('Add_Airport','Flight_landing', 'Flight_takeoff', 'Passengers_board', 'Passengers_disembark');
  const openTab = (url) => {
      window.open(url, "_blank");
    };
  const handleTabClick = (tabName) => {
    setActiveTab(tabName);
  };
  return (
    <div className="Airports">
    <br />
    Routes_sub_menu
      <div className="sidebar">
        <div
          className={activeTab === 'Add_Airport' ? 'active' : ''}
          onClick={() => openTab("/Add_Airport")}
        >
        <br />
         <button><a href="/Add_Airport">Add_Airport</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Flight_landing' ? 'active' : ''}
          onClick={() => openTab("/Flight_landing")}
        >
          <button><a href="/Flight_landing">Flight_landing</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Flight_takeoff' ? 'active' : ''}
          onClick={() => openTab("/Flight_takeoff")}
        >
          <button><a href="/Flight_takeoff">Flight_takeoff</a></button>
        </div>
        <br />
        <div
                  className={activeTab === 'Passengers_board' ? 'active' : ''}
                  onClick={() => openTab("/Passengers_board")}
                >
                  <button><a href="/Passengers_board">Passengers_board</a></button>
        </div>
        <br />
        <div
                  className={activeTab === 'Passengers_disembark' ? 'active' : ''}
                  onClick={() => openTab("/Passengers_disembark")}
                >
                  <button><a href="/Passengers_disembark">Passengers_disembark</a></button>
        </div>
      </div>
    </div>
  );
}

// Q2
export class AddAirport extends Component {
  constructor(props) {
    super(props);
    this.state = {
      airportID: '',
      airport_name: '',
      city: '',
      state: '',
      location_id: ''
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
    const airportData =
    {airportID: '',
           airportID: this.airportID,
           airport_name: this.airport_name,
           city: this.city,
           state: this.state,
           location_id: this.location_id,
          
    }
    alert(JSON.stringify(airportData));
    addAirport(airportData)
          .then(data => {
            console.log('Person added successfully:', data);
          })
          .catch(error => {
            console.error('Failed to add person:', error);
          });
  }

  render() {
    return (
      //locationid use drop down, other txtbox
      <form onSubmit={this.handleSubmit}>
<div>
  <label>
        Airport ID:
        <input type="text" name="Airport ID:" value={this.state.airportID} onChange={this.handleInputChange} />
      </label>
      </div>
        
      <div>
      <label>
  Airport Name:
  <input type="text" name="airport_name" value={this.state.airport_name} onChange={this.handleInputChange} />
</label>
</div>
<div><label>
  City:
  <input type="text" name="city" value={this.state.city} onChange={this.handleInputChange} />
</label></div>

<div><label>
  State:
  <input type="text" name="state" value={this.state.state} onChange={this.handleInputChange} />
</label></div>


<label>
        
          location_id:
          <select name="location_id" value={this.state.location_id} onChange={this.handleInputChange}>
            <option value="">--Select a location ID--</option>
            //update options later
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            {/* add more options as needed */}
          </select>
        </label>


        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
    );
  }
}

  

//Q10 flight landing
export class FlightLanding extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flightID: '',
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
    const flight =
    {
      flightID: this.state.routeID,
    }
    alert(JSON.stringify(flight));
    flightLanding(flight)
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
        <div>
          <label>
            flight ID:
            <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
          </label>
        </div>
        
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}
            

//Q11 flight takeoff
export class FlightTakeoff extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flightID: '',
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
    const flight =
    {
      flightID: this.state.routeID,
    }
    alert(JSON.stringify(flight));
    flightTakeoff(flight)
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
        <div>
          <label>
            flight ID:
            <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
          </label>
        </div>
        
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}



//Q12 - flight dropdown!
export class PassengersBoard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flightID: '',
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
    const flight =
    {
      flightID: this.state.routeID,
    }
    alert(JSON.stringify(flight));
    passengersBoard(flight)
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
        <div>
          <label>
            flight ID:
            <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
          </label>
        </div>
        
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}
 


//Q13 flight dropdown!
export class PassengersDisembark extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flightID: '',
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
    const flight =
    {
      flightID: this.state.routeID,
    }
    alert(JSON.stringify(flight));
    passengersDisembark(flight)
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
        <div>
          <label>
            flight ID:
            <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
          </label>
        </div>
        
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}

 


export function ViewsandSimulationCycle() {
  const [activeTab, setActiveTab] = useState('FlightsInTheAir','FlightsOnTheGround', 'PeopleInTheAir', 'PeopleInTheGround', 'RouteSummary', 'AlternativeAirports', 'SimulationCycle');
  const openTab = (url) => {
      window.open(url, "_blank");
    };
  const handleTabClick = (tabName) => {
    setActiveTab(tabName);
  };
  return (
    <div className="ViewsandSimulationCycle">
    <br />
    ViewsandSimulationCycle
      <div className="sidebar">
        <div
          className={activeTab === 'FlightsInTheAir' ? 'active' : ''}
          onClick={() => openTab("/FlightsInTheAir")}
        >
        <br />
         <button><a href="/FlightsInTheAir">FlightsInTheAir</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'FlightsOnTheGround' ? 'active' : ''}
          onClick={() => openTab("/FlightsOnTheGround")}
        >
          <button><a href="/FlightsOnTheGround">FlightsOnTheGround</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'PeopleInTheAir' ? 'active' : ''}
          onClick={() => openTab("/PeopleInTheAir")}
        >
          <button><a href="/PeopleInTheAir">PeopleInTheAir</a></button>
        </div>
        <br />
        <div
                  className={activeTab === 'PeopleInTheGround' ? 'active' : ''}
                  onClick={() => openTab("/PeopleInTheGround")}
                >
                  <button><a href="/PeopleInTheGround">PeopleInTheGround</a></button>
        </div>
        <br />
        <div
                  className={activeTab === 'RouteSummary' ? 'active' : ''}
                  onClick={() => openTab("/RouteSummary")}
                >
                  <button><a href="/RouteSummary">RouteSummary</a></button>
        </div>
                <br />
                <div
                          className={activeTab === 'AlternativeAirports' ? 'active' : ''}
                          onClick={() => openTab("/AlternativeAirports")}
                        >
                          <button><a href="/AlternativeAirports">AlternativeAirports</a></button>
        </div>
                <br />
                <div
                          className={activeTab === 'SimulationCycle' ? 'active' : ''}
                          onClick={() => openTab("/SimulationCycle")}
                        >
                          <button><a href="/SimulationCycle">SimulationCycle</a></button>
        </div>
      </div>
    </div>
  );
}


//Q19 View
export class FlightsInTheAir extends Component {
  // Fetch the data and manage the state here

  render() {
    return (
      <table>
        <thead>
          <tr>
            <th>Departure Airport</th>
            <th>Arrival Airport</th>
            <th>Number Flights</th>
            <th>Flight List</th>
            <th>Earliest Arrival</th>
            <th>Latest Arrival</th>
            <th>Airplane List</th>
          </tr>
        </thead>
        <tbody>
          {/* Render the data rows here */}
        </tbody>
      </table>
    );
  }
}
/*Q2
export class AddAirport extends Component {
  constructor(props) {
    super(props);
    this.state = {
      airportID: '',
      airport_name: '',
      city: '',
      state: '',
      location_id: ''
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
    const airportData =
    {airportID: '',
           airportID: this.airportID,
           airport_name: this.airport_name,
           city: this.city,
           state: this.state,
           location_id: this.location_id,
          
    }
    alert(JSON.stringify(airportData));
    AddAirport(airportData)
          .then(data => {
            console.log('Person added successfully:', data);
          })
          .catch(error => {
            console.error('Failed to add person:', error);
          });
  }

  render() {
    return (
      //locationid use drop down, other txtbox
      <form onSubmit={this.handleSubmit}>
<div>
  <label>
        Airport ID:
        <input type="text" name="Airport ID:" value={this.state.airportID} onChange={this.handleInputChange} />
      </label>
      </div>
        
      <div>
      <label>
  Airport Name:
  <input type="text" name="airport_name" value={this.state.airport_name} onChange={this.handleInputChange} />
</label>
</div>
<div><label>
  City:
  <input type="text" name="city" value={this.state.city} onChange={this.handleInputChange} />
</label></div>

<div><label>
  State:
  <input type="text" name="state" value={this.state.state} onChange={this.handleInputChange} />
</label></div>


<label>
        
          location_id:
          <select name="location_id" value={this.state.location_id} onChange={this.handleInputChange}>
            <option value="">--Select a location ID--</option>
            //update options later
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            {/* add more options as needed /}
          </select>
        </label>


        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
    );
  }
}
*/

//Q6 purchase_ticket_and_seat() 
//see class name change

export class AddTicket extends Component {
  constructor(props) {
    super(props);
    this.state = {
      ticketID: '',
      cost: '',
      carrier: '',
      customer: '',
      deplane: '',
      seat_num: '',
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
    const ticketData =
    { ticketID: this.state.ticketID,
      cost: this.state.cost,
      carrier: this.state.carrier,
      customer: this.state.customer,
      deplane: this.state.deplane,
      seat_num: this.state.seat_num,
    }
    alert(JSON.stringify(ticketData));
    // Call the function to add the data to the database
    purchaseTicketAndSeat(ticketData);
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div>
          <label>
            Ticket ID:
            <select name="ticketID" value={this.state.ticketID} onChange={this.handleInputChange}>
              <option value="">--Select a ticket ID--</option>
              {/* Add options for ticket ID here */}
            </select>
          </label>
        </div>

        <div>
          <label>
            Cost:
            <select name="cost" value={this.state.cost} onChange={this.handleInputChange}>
              <option value="">--Select a cost--</option>
              {/* Add options for cost here */}
            </select>
          </label>
        </div>

        <div>
          <label>
            Carrier:
            <input type="text" name="carrier" value={this.state.carrier} onChange={this.handleInputChange} />
          </label>
        </div>

        <div>
          <label>
            Customer:
            <input type="text" name="customer" value={this.state.customer} onChange={this.handleInputChange} />
          </label>
        </div>

        <div>
          <label>
            Deplane:
            <select name="deplane" value={this.state.deplane} onChange={this.handleInputChange}>
              <option value="">--Select a deplane--</option>
              {/* Add options for deplane here */}
            </select>
          </label>
        </div>

        <div>
          <label>
            Seat Number:
            <input type="text" name="seat_num" value={this.state.seat_num} onChange={this.handleInputChange} />
          </label>
        </div>

        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
    );
  }
}
//Q7 Add_Update_Leg()

export class AddUpdateLeg extends Component {
  constructor(props) {
    super(props);
    this.state = {
      legID: '',
      distance: '',
      departure: '',
      arrival: ''
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
    const legData =
    {
      legID: this.state.legID,
      distance: this.state.distance,
      departure: this.state.departure,
      arrival: this.state.arrival
    }
    alert(JSON.stringify(legData));
    // Add your code to push the data to the server here
    addUpdateLeg(legData);
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div>
          <label>
            Leg ID:
            <input type="text" name="legID" value={this.state.legID} onChange={this.handleInputChange} />
          </label>
        </div>
        <div>
          <label>
            Distance:
            <input type="text" name="distance" value={this.state.distance} onChange={this.handleInputChange} />
          </label>
        </div>
        <div>
          <label>
            Departure:
            <select name="departure" value={this.state.departure} onChange={this.handleInputChange}>
              <option value="">--Select a departure location--</option>
              <option value="New York">New York</option>
              <option value="Los Angeles">Los Angeles</option>
              <option value="Chicago">Chicago</option>
              {/* add more options as needed */}
            </select>
          </label>
        </div>
        <div>
          <label>
            Arrival:
            <select name="arrival" value={this.state.arrival} onChange={this.handleInputChange}>
              <option value="">--Select an arrival location--</option>
              <option value="London">London</option>
              <option value="Paris">Paris</option>
              <option value="Dubai">Dubai</option>
              {/* add more options as needed */}
            </select>
          </label>
        </div>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
    );
  }
}

//Q8 Start_Route()


export class StartRoute extends Component {
  constructor(props) {
    super(props);
    this.state = {
    
      routeID: '',
      legID: ''
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
    const routeData =
    {
      routeID: this.state.routeID,
      legID: this.state.legID
    }
    alert(JSON.stringify(routeData));
    startRoute(routeData)
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
        <div>
          <label>
            Route ID:
            <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
          </label>
        </div>
        <div>
          <label>
            Leg ID:
            <select name="legID" value={this.state.legID} onChange={this.handleInputChange}>
              <option value="">--Select a leg ID--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </label>
        </div>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}

//Q9 Extend Route

export class ExtendRoute extends Component {
  constructor(props) {
    super(props);
    this.state = {
      routeID: '',
      legID: ''
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
    const routeData =
    {
      routeID: this.state.routeID,
      legID: this.state.legID
    }
    alert(JSON.stringify(routeData));
    extendRoute(routeData)
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
        <div>
          <label>
            Route ID:
            <input type="text" name="routeID" value={this.state.routeID} onChange={this.handleInputChange} />
          </label>
        </div>
        <div>
          <label>
            Leg ID:
            <select name="legID" value={this.state.legID} onChange={this.handleInputChange}>
              <option value="">--Select a leg ID--</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
            </select>
          </label>
        </div>
        <br />
        <input type="submit" value="Add" />
        <button type="button" onClick={this.handleCancel}>Cancel</button>
      </form>
  )}
}