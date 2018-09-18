package c.msiazn.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    EditText editText;
    Button button;
    ListView listView;

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editText = findViewById(R.id.homeET);
        button = findViewById(R.id.homeBTN);
        listView = findViewById(R.id.homeLV);

        arrayList = FileHelper.readData(this);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);



        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.homeBTN:

                String data = editText.getText().toString();
                adapter.add(data);
                editText.setText("");
                FileHelper.writeData(arrayList,this);
                Toast.makeText(this,"Added data to list",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        arrayList.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this,"Delete Success !",Toast.LENGTH_LONG).show();
    }
}
