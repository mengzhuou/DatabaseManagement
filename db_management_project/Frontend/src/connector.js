import tough from 'tough-cookie';
import axios from 'axios';
import { wrapper } from 'axios-cookiejar-support';

const jar = new tough.CookieJar();
const client = wrapper(axios.create({ jar }));

const host = 'http://localhost:8080';
const apiPath = '/api/v1';

//Q1
export async function addAirplane(airplane) {
  try {
    const response = await client.post(`${host}${apiPath}/addAirplane`, airplane, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add airplane');
  }
}

//Q2
export async function addAirport(airport) {
  try {
    const response = await client.post(`${host}${apiPath}/addAirport`, airport, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add airport');
  }
}

//Q3
export async function addPerson(person) {
  try {
    const response = await client.post(`${host}${apiPath}/addPerson`, person, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add person');
  }
}

//Q4
export async function grantPilotLicense(license) {
  try {
    const response = await client.post(`${host}${apiPath}/grantPilotLicense`, license, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add flight');
  }
}

//Q5
export async function offerFlight(flight) {
  try {
    const response = await client.post(`${host}${apiPath}/offerFlight`, flight, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add flight');
  }
}

//Q6
export async function purchaseTicketAndSeat(ticket) {
  try {
    const response = await client.post(`${host}${apiPath}/purchaseTicketAndSeat`, ticket, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add ticket');
  }
}

//Q7
export async function addUpdateLeg(leg) {
  try {
    const response = await client.post(`${host}${apiPath}/addUpdateLeg`, leg, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add leg');
  }
}

//Q8
export async function startRoute(route) {
  try {
    const response = await client.post(`${host}${apiPath}/startRoute`, route, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to start route');
  }
}

//Q9
export async function extendRoute(route) {
  try {
    const response = await client.post(`${host}${apiPath}/extendRoute`, route, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to extend route');
  }
}

//Q10
export async function flightLanding(flight) {
  try {
    const response = await client.post(`${host}${apiPath}/flightLanding`, flight, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to execute flight landing');
  }
}

//Q11
export async function flightTakeoff(flight) {
  try {
    const response = await client.post(`${host}${apiPath}/flightTakeoff`, flight, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to execute flight taking off');
  }
}

//Q12
export async function passengersBoard(flight) {
  try {
    const response = await client.post(`${host}${apiPath}/passengersBoard`, flight, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to execute passenger board');
  }
}

//Q13
export async function passengersDisembark(flight) {
  try {
    const response = await client.post(`${host}${apiPath}/passengersDisembark`, flight, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to disembark passengers');
  }
}

//Q14
export async function assignPilot(flight) {
  try {
    const response = await client.post(`${host}${apiPath}/assignPilot`, flight, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to assign pilot');
  }
}

//Q15
export async function recycleCrew(flight) {
  try {
    const response = await client.post(`${host}${apiPath}/recycleCrew`, flight, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to recycle crew');
  }
}

//Q16
export async function retireFlight(flight) {
  try {
    const response = await client.post(`${host}${apiPath}/retireFlight`, flight, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to retire flight');
  }
}

//Q17
export async function removePassengerRole(person) {
  try {
    const response = await client.post(`${host}${apiPath}/removePassengerRole`, person, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to remove passenger');
  }
}

//Q18
export async function removePilotRole(person) {
  try {
    const response = await client.post(`${host}${apiPath}/removePilotRole`, person, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to remove pilot');
  }
}
//Q19
export async function getFlightInTheAir() {
  try {
    const response = await client.get(`${host}${apiPath}/getFlightInTheAir`, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to get flight in the air');
  }
}
//Q20
//Q21
//Q22
//Q23
export async function getRouteSummary() {
  try {
    const response = await client.get(`${host}${apiPath}/getRouteSummary`, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to get route summary');
  }
}
//Q24
export async function getAlternativeAirports() {
  try {
    const response = await client.get(`${host}${apiPath}/getAlternativeAirports`, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to get alternative airports');
  }
}
//Q25



