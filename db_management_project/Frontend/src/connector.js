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
