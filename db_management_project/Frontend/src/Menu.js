import React, { Component } from 'react';
import { getAirlineAll } from './connector';

class Menu extends Component {
  constructor(props) {
    super(props);
    this.state = {
      airlines: [],
    };
  }

  async componentDidMount() {
    try {
      const airlineId = 'American';
      const airlines = await getAirlineAll(airlineId);
      this.setState({ airlines });
    } catch (error) {
      console.error("error using getAirlineAll method");
    }
  }

  render() {
    const { airlines } = this.state;
    return (
      <div>
        <h1>Airlines:</h1>
        <ul>
          {airlines.map((airline) => (
            <li key={airline.airlineID}>
              {airline.airlineID} - {airline.revenue}
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default Menu;
