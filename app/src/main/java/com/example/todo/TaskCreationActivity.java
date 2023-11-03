package com.example.todo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date; // Import Date class

public class TaskCreationActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private DatePicker datePicker;
    private Button buttonConfirm;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        // Initialize the UI elements
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        datePicker = findViewById(R.id.datePicker);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonCancel = findViewById(R.id.buttonCancel);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getText().toString();
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();

                // Create a new task
                Task newTask = new Task();
                newTask.setTitle(title);
                newTask.setDescription(description);
                newTask.setDeadline(new Date(year - 1900, month, day));
                newTask.setCompleted(false);

                // Save the new task to the database (you can customize this part as per your database implementation)
                // For example: TaskDatabase.addTask(newTask);

                // Finish the activity and return to the main screen
                finish();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Finish the activity and return to the main screen without saving the task
                finish();
            }
        });
    }
}
