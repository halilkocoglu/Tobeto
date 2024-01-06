import { useEffect, useState } from "react";
import {
  Button,
  Icon,
  Menu,
  MenuItem,
  Table,
  TableBody,
  TableCell,
  TableFooter,
  TableHeader,
  TableHeaderCell,
  TableRow,
} from "semantic-ui-react";
import productService from "../services/productService";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { addToCart } from "../store/actions/cartActions";
import { toast } from "react-toastify";

function ProductList() {
  const [productList, setProductList] = useState([]);
  const dispatch = useDispatch();
  useEffect(() => {
    fetchProducts();
  }, []);
  const fetchProducts = async () => {
    try {
      let response = await productService.getProducts();
      setProductList(response.data.products);
    } catch (error) {
      console.log(error);
    }
  };
  const handleAddToCart = (product) => {
    dispatch(addToCart(product));
    toast.success(`${product.title} added to cart`, {
      position: "top-right",
      autoClose: 5000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
      theme: "light",
    });
  };
  return (
    <div>
      <Table celled>
        <TableHeader>
          <TableRow>
            <TableHeaderCell>Brand</TableHeaderCell>
            <TableHeaderCell>Title</TableHeaderCell>
            <TableHeaderCell>Price</TableHeaderCell>
            <TableHeaderCell>Discount Percentage</TableHeaderCell>
            <TableHeaderCell>Category</TableHeaderCell>
            <TableHeaderCell>Stock</TableHeaderCell>
            <TableHeaderCell></TableHeaderCell>
          </TableRow>
        </TableHeader>

        <TableBody>
          {productList.map((product) => {
            return (
              <TableRow key={product.id}>
                <TableCell>{product.brand}</TableCell>
                <TableCell>
                  <Link to={`/products/${product.id}`}>{product.title} </Link>
                </TableCell>
                <TableCell>{product.price}</TableCell>
                <TableCell>{product.discountPercentage + " %"}</TableCell>
                <TableCell>{product.category}</TableCell>
                <TableCell>{product.stock}</TableCell>
                <TableCell>
                  <Button onClick={() => handleAddToCart(product)}>
                    Sepete Ekle
                  </Button>
                </TableCell>
              </TableRow>
            );
          })}
        </TableBody>

        <TableFooter>
          <TableRow>
            <TableHeaderCell colSpan="12">
              <Menu floated="right" pagination>
                <MenuItem as="a" icon>
                  <Icon name="chevron left" />
                </MenuItem>
                <MenuItem as="a">1</MenuItem>
                <MenuItem as="a">2</MenuItem>
                <MenuItem as="a">3</MenuItem>
                <MenuItem as="a">4</MenuItem>
                <MenuItem as="a" icon>
                  <Icon name="chevron right" />
                </MenuItem>
              </Menu>
            </TableHeaderCell>
          </TableRow>
        </TableFooter>
      </Table>
    </div>
  );
}

export default ProductList;
