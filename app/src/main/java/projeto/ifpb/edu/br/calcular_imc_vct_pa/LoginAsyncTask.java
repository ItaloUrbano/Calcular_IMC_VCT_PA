package projeto.ifpb.edu.br.calcular_imc_vct_pa;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;


public class LoginAsyncTask extends AsyncTask<String, Void, Response> {

    Context context;

    public LoginAsyncTask(Context activity) {

        this.context = activity;
    }

     @Override
     protected Response doInBackground(String... strings) {
         Log.i("Calcular_IMC_VCT_PA", "doInBackground: " + valores  [0]);

         Response response = null;
         HttpURLConnection connection = null;

         try {

             connection = HttpService.sendGetRequest("servicoservlet");

             int statusCodeHttp = connection.getResponseCode();
             String contentValue = HttpService.getHttpContent(connection);

             response = new Response(statusCodeHttp, contentValue);

         } catch (MalformedURLException ex) {

             Log.e("Calcular_IMC_VCT_PA","MalformedURLException");

         } catch (IOException ex) {

             Log.e("Calcular_IMC_VCT_PA","MalformedURLException");

         } finally {

             connection.disconnect();
         }

         return response;
     }
    @Override
    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();

            if (status == HttpURLConnection.HTTP_OK) {

                JSONObject json = new JSONObject(response.getContentValue());

                String nome = json.getString("nome");
                Log.i("Calcular_IMC_VCT_PA", "Nome: " + nome);
                Toast.makeText(context, nome, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("Calcular_IMC_VCT_PA", "JSONException: " + e);
        }
    }


     @Override
    public void onPreExecute() {

        Log.i("Calcular_IMC_VCT_PA", "OnPreExecute");
    }
}
