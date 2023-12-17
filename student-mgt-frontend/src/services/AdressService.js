import axios from "axios";

const REST_API_URL = "http://localhost:8080/api/adresses";

export const listAdresses = () => {
  return axios.get(REST_API_URL);
};

export const createAdress = (department) => {
  return axios.post(REST_API_URL, department);
};

export const getAdressById = (id) => {
  return axios.get(REST_API_URL + "/" + id);
};

export const updateAdress = (id, department) => {
  return axios.put(REST_API_URL + "/" + id, department);
};

export const deleteAdress = (id) => {
  return axios.delete(REST_API_URL + "/" + id);
};