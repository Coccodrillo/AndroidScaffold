package uk.co.span9.krneki;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

import uk.co.span9.krneki.adapters.DogodkiAdapter;
import uk.co.span9.krneki.models.Dogodek;
import uk.co.span9.krneki.util.Global;
import uk.co.span9.krneki.util.KrnekiRestClient;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public ListView list;
    public DogodkiAdapter adapter;
    public Button addMore;
    public ArrayList<Dogodek> dogodki;
    private Global global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        global = (Global) getApplicationContext();

        dogodki = new ArrayList<>();
        dogodki.add(new Dogodek("prvi", "krneki", 0));
        dogodki.add(new Dogodek("drugi", "šeneki", 0));

        adapter = new DogodkiAdapter(this, dogodki);
        list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);
        addMore = (Button) findViewById(R.id.add_more);
        addMore.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        KrnekiRestClient.get("categories", null, null, MainActivity.this, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson = new GsonBuilder().create();
                Type listType = new TypeToken<ArrayList<Dogodek>>() {
                }.getType();
                ArrayList<Dogodek> receivedItems = gson.fromJson(response.toString(), listType);
                if (receivedItems != null && receivedItems.size() > 0) {
                    dogodki = receivedItems;
                    if(adapter!=null) adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.d("fail", "100%");
            }
        });
        }
    }
