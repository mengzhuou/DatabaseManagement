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

export async function addAirplane(airlineID, tail_num, seat_capacity, speed, locationID, plane_type, skids, propellers, jet_engines) {
  try {
    const response = await client.post(`${host}${apiPath}/addAirplane`, {
      airlineID,
      tail_num,
      seat_capacity,
      speed,
      locationID,
      plane_type,
      skids,
      propellers,
      jet_engines,
    }, {
      withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.error(error);
    throw new Error('Failed to add airplane');
  }
}

