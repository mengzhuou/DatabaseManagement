import React, { Component, useState } from 'react';
import {addAirplane, purchaseTicketAndSeat, addAirport} from './connector';
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

//Flights Sub Menu

export class Flights extends Component {
  constructor(props) {
    super(props);
    this.state = {
      activeTab: '',
    };
  }

  handleButtonClick = (tabName) => {
    this.setState({ activeTab: tabName });
  };

  render() {
    const { activeTab } = this.state;

    return (
      <div className="Flights">
        <div className="buttons-container">
          <button onClick={() => this.handleButtonClick('offer_flight')}>Offer Flight</button>
          <button onClick={() => this.handleButtonClick('assign_pilot')}>Assign Pilot</button>
          <button onClick={() => this.handleButtonClick('recycle_crew')}>Recycle Crew</button>
          <button onClick={() => this.handleButtonClick('retire_flight')}>Retire Flight</button>
          <button onClick={() => this.handleButtonClick('remove_pilot_role')}>Remove Pilot Role</button>
          <button onClick={() => this.handleButtonClick('remove_passenger_role')}>Remove Passenger Role</button>
        </div>
        <div className="tab-content">
        // Q5
          {activeTab === 'offer_flight' && (

            <div className="offer-flight">
              <label>Flight ID: <input type="text" name="flightID" /></label>
                            <label>Support Tail: <input type="text" name="support_tail" /></label>
                            <label>Route ID: <input type="text" name="routeID" /></label>
                            <label>Progress: <input type="text" name="progress" /></label>
                            <label>Next Time: <input type="text" name="next_time" /></label>
                            <label>
                              Support Airline:
                              <select name="support_airline">
                                {/* Add options here */}
                              </select>
                            </label>
                            <label>
                              Airplane Status:
                              <select name="airplane_status">
                                {/* Add options here */}
                              </select>
                            </label>
            </div>
          )}
            // Q14
          {activeTab === 'assign_pilot' && (
            <div className="assign-pilot">
              <label>
                              Person ID:
                              <select name="personID">
                                {/* Add options here */}
                              </select>
                            </label>
                            <label>
                              Flight:
                              <select name="flight">
                                {/* Add options here */}
                              </select>
                            </label>
            </div>
          )}
            // Q15
          {activeTab === 'recycle_crew' && (
            <div className="recycle-crew">
              <label>
                              Flight:
                              <select name="flight">
                                {/* Add options here */}
                              </select>
                            </label>
            </div>
          )}
            // Q16
          {activeTab === 'retire_flight' && (
            <div className="retire-flight">
              <label>Flight ID: <input type="text" name="flightID" /></label>
            </div>
          )}
            // Q18
          {activeTab === 'remove_pilot_role' && (
            <div className="remove-pilot-role">
              <label>
                              Person ID:
                              <select name="personID">
                                {/* Add options here */}
                              </select>
                            </label>
            </div>
          )}
            // Q17
          {activeTab === 'remove_passenger_role' && (
            <div className="remove-passenger-role">
              <label>
                              Person ID:
                              <select name="personID">
                                {/* Add options here */}
                              </select>
                            </label>
            </div>
          )}
        </div>
      </div>
    );
  }
}

// Routes Sub Menu
export class Routes_sub_menu extends Component {
  constructor(props) {
    super(props);
    this.state = {
      activeTab: '',
    };
  }

  handleButtonClick = (tabName) => {
    this.setState({ activeTab: tabName });
  };

  render() {
    const { activeTab } = this.state;

    return (
      <div className="Routes_sub_menu">
        <div className="buttons-container">
          <button onClick={() => this.handleButtonClick('add_update_leg')}>Add Update Leg</button>
          <button onClick={() => this.handleButtonClick('start_route')}>Start Route</button>
          <button onClick={() => this.handleButtonClick('extend_route')}>Extend Route</button>
        </div>
        <div className="tab-content">
        // Q7
          {activeTab === 'add_update_leg' && (
            <div className="add-update-leg">
              <label>Leg ID: <input type="text" name="legID" /></label>
              <label>Distance: <input type="text" name="distance" /></label>
              <label>
                Departure:
                <select name="departure">
                  {/* Add options here */}
                </select>
              </label>
              <label>
                Arrival:
                <select name="arrival">
                  {/* Add options here */}
                </select>
              </label>
            </div>
          )}
          // Q8
          {activeTab === 'start_route' && (
            <div className="start-route">
              <label>
                Leg ID:
                <select name="legID">
                  {/* Add options here */}
                </select>
              </label>
              <label>Route ID: <input type="text" name="routeID" /></label>
            </div>
          )}
          // Q9
          {activeTab === 'extend_route' && (
            <div className="extend-route">
              <label>
                Leg ID:
                <select name="legID">
                  {/* Add options here */}
                </select>
              </label>
              <label>Route ID: <input type="text" name="routeID" /></label>
            </div>
          )}
        </div>
      </div>
    );
  }
}
//Airports Sub Menu
export class Airports extends Component {
  constructor(props) {
    super(props);
    this.state = {
      activeTab: '',
    };
  }

  handleButtonClick = (tabName) => {
    this.setState({ activeTab: tabName });
  };

  render() {
    const { activeTab } = this.state;

    return (
      <div className="Airports">
        <div className="buttons-container">
          <button onClick={() => this.handleButtonClick('add_airport')}>Add Airport</button>
          <button onClick={() => this.handleButtonClick('flight_landing')}>Flight Landing</button>
          <button onClick={() => this.handleButtonClick('flight_takeoff')}>Flight Takeoff</button>
          <button onClick={() => this.handleButtonClick('passengers_board')}>Passengers Board</button>
          <button onClick={() => this.handleButtonClick('passengers_disembark')}>Passengers Disembark</button>
        </div>
        <div className="tab-content">
        // Q2
          {activeTab === 'add_airport' && (
            <div className="add-airport">
              <label>Airport ID: <input type="text" name="airportID" /></label>
              <label>Airport Name: <input type="text" name="airport_name" /></label>
              <label>City: <input type="text" name="city" /></label>
              <label>State: <input type="text" name="state" /></label>
              <label>
                Location ID:
                <select name="location_id">
                  {/* Add options here */}
                </select>
              </label>
            </div>
          )}
          // Q10
          {activeTab === 'flight_landing' && (
            <div className="flight-landing">
              <label>Flight ID: <input type="text" name="flightID" /></label>
            </div>
          )}
          // Q11
          {activeTab === 'flight_takeoff' && (
            <div className="flight-takeoff">
              <label>Flight ID: <input type="text" name="flightID" /></label>
            </div>
          )}
          // Q12
          {activeTab === 'passengers_board' && (
            <div className="passengers-board">
              <label>
                Flight ID:
                <select name="flightID">
                  {/* Add options here */}
                </select>
              </label>
            </div>
          )}
          // Q13
          {activeTab === 'passengers_disembark' && (
            <div className="passengers-disembark">
              <label>
                Flight ID:
                <select name="flightID">
                  {/* Add options here */}
                </select>
              </label>
            </div>
          )}
        </div>
      </div>
    );
  }
}

//View sub menu
export class ViewsandSimulationCycle extends Component {
  constructor(props) {
    super(props);
    this.state = {
      activeTab: '',
    };
  }

  handleButtonClick = (tabName) => {
    this.setState({ activeTab: tabName });
  };

  render() {
    const { activeTab } = this.state;

    return (
      <div className="ViewsandSimulationCycle">
        <div className="buttons-container">
          <button onClick={() => this.handleButtonClick('FlightsInTheAir')}>Flights In The Air</button>
          <button onClick={() => this.handleButtonClick('flights_on_the_ground')}>Flights On The Ground</button>
          <button onClick={() => this.handleButtonClick('people_in_the_air')}>People in the air</button>
          <button onClick={() => this.handleButtonClick('people_in_the_ground')}>People in the ground</button>
          <button onClick={() => this.handleButtonClick('route_summary')}>Route Summary</button>
          <button onClick={() => this.handleButtonClick('alternative_airports')}>Alternative Airports</button>
          <button onClick={() => this.handleButtonClick('simulation_cycle')}>Simulation Cycle</button>
        </div>
        <div className="tab-content">
          {/* Add components for each tab */}
        </div>
      </div>
    );
  }
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