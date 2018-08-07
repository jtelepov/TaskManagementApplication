package com.jantelepovsky.taskmanagement.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TaskManagement.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance() {
        return instance;
    }

    private TodoData() {
        formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem todoItem) {
        todoItems.add(todoItem);
    }



    public void loadTodoItems() throws IOException {

        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);

        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {

                String[] itemPieces = input.split("\t");

                String item = itemPieces[0];
                String description = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, formatter);

                TodoItem todoItem = new TodoItem(item, description, date);
                todoItems.add(todoItem);


            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<TodoItem> iter = todoItems.iterator();
            while (iter.hasNext()) {
                TodoItem item = iter.next();
                bw.write(String.format(("%s\t%s\t%s"),
                        item.getItem(),
                        item.getDescription(),
                        item.getDeadLine().format(formatter)));
                bw.newLine();

            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }


    public void deleteTodoItem(TodoItem item) {
        todoItems.remove(item);
    }
}