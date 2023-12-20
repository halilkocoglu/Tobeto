import React, { useEffect, useState } from "react";
import "./todo.css";

function Todo() {
  const [input, setInput] = useState("");
  const [todoList, setTodoList] = useState([]);

  const handleSubmit = () => {
    if (input.trim() !== "") {
      setTodoList([...todoList, input]);
      setInput(""); // Input'u temizle
    }
  };
  const handleDelete = (index) => {
    setTodoList(todoList.filter((item, i) => i !== index));
  };
  useEffect(() => {
    console.log(todoList);
  }, [todoList]);

  return (
    <div className="container">
      <div className="center">
        <input
          onChange={(e) => setInput(e.target.value)}
          value={input}
          type="text"
        />
        <button className="btn" onClick={handleSubmit} type="button">
          Add
        </button>
        <ul className="list">
          {todoList.map((todo, index) => {
            return (
              <div className="list-item" key={index}>
                <li className="todo-item">{todo}</li>
                <button
                  onClick={() => handleDelete(index)}
                  className="delete-btn"
                  type="button"
                >
                  X
                </button>
              </div>
            );
          })}
        </ul>
      </div>
    </div>
  );
}

export default Todo;
