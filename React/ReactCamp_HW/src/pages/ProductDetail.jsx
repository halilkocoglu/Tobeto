import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import {
  Button,
  Card,
  CardContent,
  CardDescription,
  CardGroup,
  CardHeader,
  CardMeta,
  Image,
} from "semantic-ui-react";
import productService from "../services/productService";

function ProductDetail() {
  const { id } = useParams();
  const [product, setProduct] = useState();
  const fetchProductById = async (id) => {
    try {
      let response = await productService.getProductById(id);
      setProduct(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {
    fetchProductById(id);
  }, [id]);
  return (
    <>
      {product && (
        <div>
          <CardGroup>
            <Card fluid>
              <CardContent
                style={{
                  textAlign: "center",
                }}
              >
                <Image
                  rounded
                  style={{
                    marginBottom: "1em",
                  }}
                  size="large"
                  src={product.thumbnail}
                />
                <CardHeader>{product.title}</CardHeader>
                <CardMeta>{product.brand}</CardMeta>
                <CardDescription>{product.description}</CardDescription>
              </CardContent>
              <CardContent extra>
                <div className="ui two buttons">
                  <Button basic color="green">
                    Approve
                  </Button>
                  <Button basic color="red">
                    Decline
                  </Button>
                </div>
              </CardContent>
            </Card>
          </CardGroup>
        </div>
      )}
    </>
  );
}

export default ProductDetail;
