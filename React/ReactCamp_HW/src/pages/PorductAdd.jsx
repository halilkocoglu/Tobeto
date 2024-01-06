import { Form, Formik } from "formik";
import { Button } from "semantic-ui-react";
import * as Yup from "yup";
import TobetoTextInput from "../utilities/customFormControls/TobetoTextInput";
import productService from "../services/productService";
function PorductAdd() {
  const initialValues = {
    brand: "",
    title: "",
    price: "",
  };
  const schema = Yup.object({
    brand: Yup.string().required("Ürün markası zorunludur"),
    title: Yup.string().required("Ürün adı zorunludur"),
    price: Yup.number().required("Ürün fiyatı zorunludur"),
  });
  const fetchAddProduct = async (product) => {
    try {
      let response = await productService.addProduct(product);
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div>
      <Formik
        initialValues={initialValues}
        validationSchema={schema}
        onSubmit={(values) => {
          fetchAddProduct(values);
          //   console.log(values);
        }}
      >
        <Form className="ui form">
          <TobetoTextInput
            title={"Brand"}
            name={"brand"}
            placeholder={"Brand Name"}
          />
          <TobetoTextInput
            title={"Product name"}
            name={"title"}
            placeholder={"Product Name"}
          />
          <TobetoTextInput
            title={"Product price"}
            name={"price"}
            placeholder={"Product price"}
          />

          <Button style={{ marginTop: "10px" }} color="green" type="submit">
            Submit
          </Button>
        </Form>
      </Formik>
    </div>
  );
}

export default PorductAdd;
