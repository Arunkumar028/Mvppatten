package com.example.mvp.roomdatabse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.R;

public class AddTaskActivity extends AppCompatActivity {
    private EditText editTextTask, editTextDesc, editTextFinishBy,editTextPhone,editTextpincode,editTextAge,editFiledId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        editFiledId = findViewById(R.id.editFiledId);
        editTextTask = findViewById(R.id.editTextTask);
        editTextDesc = findViewById(R.id.editTextDesc);
        editTextFinishBy = findViewById(R.id.editTextFinishBy);
        editTextPhone = findViewById(R.id.editPhoneNumber);
        editTextpincode = findViewById(R.id.editPinCode);
        editTextAge = findViewById(R.id.editage);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTask();
            }
        });
    }

    private void saveTask() {
        final String sTask = editTextTask.getText().toString().trim();
        final String sDesc = editTextDesc.getText().toString().trim();
        final String sFinishBy = editTextFinishBy.getText().toString().trim();
        final String sphone = editTextPhone.getText().toString().trim();
        final String spincode = editTextpincode.getText().toString().trim();
        final String sage = editTextAge.getText().toString().trim();
        final String suserid = editFiledId.getText().toString().trim();

        if (sTask.isEmpty()) {
            editTextTask.setError("Task required");
            editTextTask.requestFocus();
            return;

        }

        if (sDesc.isEmpty()) {
            editTextDesc.setError("Desc required");
            editTextDesc.requestFocus();
            return;
        }

        if (sFinishBy.isEmpty()) {
            editTextFinishBy.setError("Finish by required");
            editTextFinishBy.requestFocus();
            return;
        }

        if (sphone.isEmpty()){
            editTextPhone.setError("Phone number empty");
            editTextPhone.requestFocus();
            return;
        }
        if (spincode.isEmpty()){
            editTextpincode.setError("pincode empty");
            editTextpincode.requestFocus();
            return;

        }
        if (sage.isEmpty()){
            editTextAge.setError("age empty");
            editTextAge.requestFocus();
        }
        if (suserid.isEmpty()){
            editFiledId.setError("Userid empty");
            editFiledId.requestFocus();
        }

        class SaveTask extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                //creating a task
                Task task = new Task();
                task.setTask(sTask);
                task.setDesc(sDesc);
                task.setFinishBy(sFinishBy);
                task.setFinished(false);
                task.setPhonenumber(sphone);
                task.setPincode(spincode);
                task.setAge(sage);
              //  task.setUserid(suserid);


                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .taskDao()
                        .insert(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), RoomDatabaseActivity.class));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }
        SaveTask st = new SaveTask();
        st.execute();
    }
}

