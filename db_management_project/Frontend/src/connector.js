import tough from 'tough-cookie';
import axios from 'axios';
import { wrapper } from 'axios-cookiejar-support';

const jar = new tough.CookieJar();
const client = wrapper(axios.create({ jar }));

const host = 'http://localhost:8080';
const apiPath = '/api/v1';

// Define functions for making API requests

export async function getAirlineAll() {
  const response = await client.get(`${host}${apiPath}/getAirlineAll`, {
    withCredentials: true,
  });
  return response.data;
}

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

export async function getPilotLicensesAll(pilotLicense) {
  try {
    const response = await client.post(`${host}${apiPath}/getPilotLicensesAll`, pilotLicense, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add pilot license');
  }
}

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