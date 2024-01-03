import axios from "axios";
const API_URL = "https://dummyjson.com/products";
class ProductService {
  getProducts() {
    return axios.get(API_URL);
  }
}

export default new ProductService();
