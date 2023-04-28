import React, { Component, useState } from 'react';
import {addAirplane} from './connector';
import './App.css';

export function Menu() {
  const [activeTab, setActiveTab] = useState('AddAirplane1');
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
          //onClick={() => handleTabClick('Airplanes')}
          onClick={() => openTab("/AddAirplane1")}
        >
        <br />
         <button><a href="/addAirplane">Airplanes</a></button>
        </div>
        <br />
        <div
          className={activeTab === 'Pilots' ? 'active' : ''}
          onClick={() => handleTabClick('Pilots')}
        >
          <button>Pilots</button>
        </div>
        <br />
        <div
          className={activeTab === 'People' ? 'active' : ''}
          onClick={() => handleTabClick('People')}
        >
          <button>People</button>
        </div>
        <br />
        <div
          className={activeTab === 'Flights' ? 'active' : ''}
          onClick={() => handleTabClick('Flights')}
        >
          <button>Flights</button>
        </div>
        <br />
      </div>
      <div className="main">
        <div
          className={activeTab === 'Routes' ? 'active' : ''}
          onClick={() => handleTabClick('Routes')}
        >
          <button>Routes</button>
        </div>
        <br />
        <div
          className={activeTab === 'Tickets' ? 'active' : ''}
          onClick={() => handleTabClick('Tickets')}
        >
          <button>Tickets</button>
        </div>
        <br />
        <div
          className={activeTab === 'Airports' ? 'active' : ''}
          onClick={() => handleTabClick('Airports')}
        >
          <button>Airports</button>
        </div>
        <br />
        <div
          className={activeTab === 'ViewsandSimulationCycle' ? 'active' : ''}
          onClick={() => handleTabClick('ViewsandSimulationCycle')}
        >
          <button>Views and Simulation Cycle</button>
        </div>
        <br />
      </div>
    </div>
  );
}

export class MyRand extends Component {
    render() {
        return (
            <h1>Myrand</h1>
        );
    }
}

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
      <button type="submit">Submit</button>
      </form>
        );
      }
    }






