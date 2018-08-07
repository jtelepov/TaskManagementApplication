package com.jantelepovsky.taskmanagement;

import com.jantelepovsky.taskmanagement.data.TodoData;
import com.jantelepovsky.taskmanagement.data.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField itemField;
    @FXML
    private TextArea descArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults(){
        String item = itemField.getText().trim();
        String description = descArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(item,description,deadline);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
