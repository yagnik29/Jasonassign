package demo.example.com.jasonassign;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static final String URL = "http://androidhitesh.890m.com/hitesh/jsonphp.php";

    public String id = "id";

    ListView listView;
    ProgressDialog progressDialog;

    ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        new Getdata().execute();
    }

    public class Getdata extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("wait");
        }



        @Override
        protected Void doInBackground(Void... voids) {
            HttpServiceHandler handler = new HttpServiceHandler();
            String result =  handler.getHttpdata(URL);

            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for(int i =0 ; i < jsonArray.length(); i++){
                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String file = jsonObject.getString("file");
                    list.add(file);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            Log.e("Resutl",result);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            ListAdapter listAdapter = new ListAdapter(MainActivity.this,list);
            listView.setAdapter(listAdapter);

        }
    }
}
