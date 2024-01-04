import axios from "axios";
const API_URL = "https://dummyjson.com/products";
class ProductService {
  getProducts() {
    return axios.get(API_URL);
  }
  getProductById(id) {
    return axios.get(API_URL + "/" + id);
  }
}

export default new ProductService();
