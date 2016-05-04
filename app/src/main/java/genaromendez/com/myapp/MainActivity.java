package genaromendez.com.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.*;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btnInvocar);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
           switch(v.getId()){
               case R.id.btnInvocar:

                   EditText edtURL = (EditText) findViewById(R.id.edtURL);

                   if (edtURL!=null) {

                       String strUrl = edtURL.getText().toString();

                       AsyncHttpClient client = new AsyncHttpClient();
                       client.get(strUrl, new AsyncHttpResponseHandler() {

                           @Override
                           public void onStart() {
                               // called before request is started
                           }

                           @Override
                           public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                               // called when response HTTP status is "200 OK"

                               String resp = new String(response);

                               EditText edtRespuesta = (EditText) findViewById(R.id.edtRespuesta);

                               edtRespuesta.setText(resp);

                           }

                           @Override
                           public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                               // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                           }

                           @Override
                           public void onRetry(int retryNo) {
                               // called when request is retried
                           }
                       });
                   }

                   break;
           }
    }
}
