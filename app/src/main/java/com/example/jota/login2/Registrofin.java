package com.example.jota.login2;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;

import android.os.AsyncTask;

import android.os.Bundle;
import android.util.Log;
import org.apache.http.NameValuePair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;




public class Registrofin extends Activity implements OnClickListener {

    //cambie estas clases de private a public...
    public EditText user, pass, correo, nickname;
    public Button mRegister;
    public Spinner diversion,comida, pasatiempo, vestuario, temaint, lugarint, bebida;



    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();

    private static final String REGISTER_URL = "http://dominiojona.esy.es/Proyecto/register.php";

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrofin);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        correo = (EditText) findViewById(R.id.idcorreo);
        nickname = (EditText) findViewById(R.id.idnickname);
        diversion = (Spinner) findViewById(R.id.lista2);
        comida = (Spinner) findViewById(R.id.lista1);
        pasatiempo = (Spinner) findViewById(R.id.lista3);
        vestuario = (Spinner) findViewById(R.id.lista4);
        temaint = (Spinner) findViewById(R.id.lista1a);
        lugarint = (Spinner) findViewById(R.id.lista1b);
        bebida = (Spinner) findViewById(R.id.lista1c);



        mRegister = (Button) findViewById(R.id.register);
        mRegister.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        new CreateUser().execute();

    }
    class CreateUser extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Registrofin.this);
            pDialog.setMessage("Creating User...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // Check for success tag
            int success;
            String username = user.getText().toString();
            String password = pass.getText().toString();
            String elcorreo = correo.getText().toString();
            String elnickname = nickname.getText().toString();
            String ladiversion = diversion.getSelectedItem().toString();
            String lacomida = comida.getSelectedItem().toString();
            String elpasatiempo = pasatiempo.getSelectedItem().toString();
            String elvestuario = vestuario.getSelectedItem().toString();
            String eltemaint = temaint.getSelectedItem().toString();
            String ellugarint = lugarint.getSelectedItem().toString();
            String labebida = bebida.getSelectedItem().toString();

            try {
                // Building Parameters
                List params = new ArrayList();
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));
                params.add(new BasicNameValuePair("correo", elcorreo));
                params.add(new BasicNameValuePair("nickname", elnickname));
                params.add(new BasicNameValuePair("diversion", ladiversion));
                params.add(new BasicNameValuePair("comida", lacomida));
                params.add(new BasicNameValuePair("pasatiempo", elpasatiempo));
                params.add(new BasicNameValuePair("vestuario", elvestuario));
                params.add(new BasicNameValuePair("temainteres", eltemaint));
                params.add(new BasicNameValuePair("lugarinteres", ellugarint));
                params.add(new BasicNameValuePair("bebida", labebida));



                Log.d("request!", "starting");

                //Posting user data to script
                JSONObject json = jsonParser.makeHttpRequest(
                        REGISTER_URL, "POST", params);

                // full json response
                Log.d("Registering attempt", json.toString());

                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("User Created!", json.toString());
                    finish();
                    return json.getString(TAG_MESSAGE);
                }else{
                    Log.d("Registering Failure!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(Registrofin.this, file_url, Toast.LENGTH_LONG).show();
            }

        }

    }
}
