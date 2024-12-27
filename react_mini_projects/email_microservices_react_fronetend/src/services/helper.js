import axios from "axios";

const baseURL = 'http://localhost:8088';

export const customAxios = axios.create({
baseURL:baseURL
});