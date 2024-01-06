import { useField } from "formik";
import { FormField, Label } from "semantic-ui-react";

function TobetoTextInput({ ...props }) {
  const [field, meta] = useField(props);
  return (
    <div style={{ marginBottom: "10px" }}>
      <FormField error={meta.touched && !!meta.error}>
        <input {...field} {...props} />
        {meta.touched && !!meta.error && (
          <Label pointing basic color="red" content={meta.error}></Label>
        )}
      </FormField>
      {/* <FormField>
        <div>{props.title}</div>
        <Field name={props.name} placeholder={props.placeholder}></Field>
        <ErrorMessage
          name={props.name}
          render={(error) => (
            <Label pointing basic color="red" content={error}></Label>
          )}
        ></ErrorMessage>
      </FormField> */}
    </div>
  );
}

export default TobetoTextInput;
