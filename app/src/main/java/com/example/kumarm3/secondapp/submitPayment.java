package com.example.kumarm3.secondapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by karnamp on 11/23/2017.
 */

public class submitPayment extends AppCompatActivity  {

    private Button btnSendRequest;
    private RequestQueue mRequestQueue;
    public com.android.volley.toolbox.StringRequest StringRequest;
    String url = "http://nrc3lq2v4api01vm.am.tsacorp.com:8080/connect/xml/createCreditCardPayment1.do";
    public final String TAG = submitPayment.class.getName();
    Context context;  //Public

    public submitPayment(Context context) throws Exception {
        this.context=context;
        context.getFilesDir();}

    public submitPayment() {}

    public void onStartCommand(Intent intent, int flags, int startId) throws Exception {
        super.onCreate(null);
        submitPayment submitPayment = new submitPayment(this);


        String res = sendRequestAndprintResponse1();
    }

    public  String sendRequestAndprintResponse1() throws Exception {

        String line = "";
        String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><credit-card-payment-request xmlns=\"http://www.princetonecom.com/connect/creditcardpaymentrequest1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">  <identity>    <business-id>566420</business-id>    <login>FSSIConnectUser</login>    <password>p9KH4DlO6b</password>  </identity>  <credit-card-account>    <credit-card-number>5154223595085235</credit-card-number>    <credit-card-type>MC</credit-card-type>    <expiration-month>1</expiration-month>    <expiration-year>2018</expiration-year>    <security-code>123</security-code>    <account-holder-name>Justin Case</account-holder-name>    <account-address-1>456 Some St.</account-address-1>    <account-city>Princeton</account-city>    <account-state>NJ</account-state>    <account-postal-code>08450</account-postal-code>    <account-country-code>US</account-country-code>  </credit-card-account>  <ecommerce-indicator>ECOMMERCE</ecommerce-indicator>  <credit-debit-indicator>DEBIT</credit-debit-indicator>  <requested-payment-date>2017-11-26</requested-payment-date>  <remittance>    <billing-account>      <billing-account-number>123456792</billing-account-number>    </billing-account>    <remit-amount>100</remit-amount>    <remit-fee>0</remit-fee>            <!--<fee-waiver-reason>Courtesy</fee-waiver-reason>!-->    <payment-remit-field>      <value>00001</value>    </payment-remit-field>    <payment-remit-field>      <value>00002</value>    </payment-remit-field>  </remittance>  <email-address>pradeep.karnam@aciworldwide.com</email-address></credit-card-payment-request>";
        String url = "http://nrc3lq2v4api01vm.am.tsacorp.com:8080/connect/xml/createCreditCardPayment1.do";

        doInBackground(url, a);
        return a;
    }




    protected void doInBackground(String url, String params) throws IOException {
        // do above Server call here

        new processpayment().execute();

        //postxml(url, params);

    }

    public class processpayment extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String xmlResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><credit-card-payment-request xmlns=\"http://www.princetonecom.com/connect/creditcardpaymentrequest1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">  <identity>    <business-id>566420</business-id>    <login>FSSIConnectUser</login>    <password>p9KH4DlO6b</password>  </identity>  <credit-card-account>    <credit-card-number>5154223595085235</credit-card-number>    <credit-card-type>MC</credit-card-type>    <expiration-month>1</expiration-month>    <expiration-year>2018</expiration-year>    <security-code>123</security-code>    <account-holder-name>Justin Case</account-holder-name>    <account-address-1>456 Some St.</account-address-1>    <account-city>Princeton</account-city>    <account-state>NJ</account-state>    <account-postal-code>08450</account-postal-code>    <account-country-code>US</account-country-code>  </credit-card-account>  <ecommerce-indicator>ECOMMERCE</ecommerce-indicator>  <credit-debit-indicator>DEBIT</credit-debit-indicator>  <requested-payment-date>2017-11-27    </requested-payment-date>  <remittance>    <billing-account>      <billing-account-number>123456792</billing-account-number>    </billing-account>    <remit-amount>100</remit-amount>    <remit-fee>0</remit-fee>            <!--<fee-waiver-reason>Courtesy</fee-waiver-reason>!-->    <payment-remit-field>      <value>00001</value>    </payment-remit-field>    <payment-remit-field>      <value>00002</value>    </payment-remit-field>  </remittance>  <email-address>pradeep.karnam@aciworldwide.com</email-address></credit-card-payment-request>";
            String Response = null;
            DefaultHttpClient httpClient = new DefaultHttpClient();
            final HttpPost httppost = new HttpPost(url);
            final List<NameValuePair> params = new ArrayList<NameValuePair>(1);
            params.add(new BasicNameValuePair("xml", xmlResponse));
            params.add(new BasicNameValuePair("xmlData", xmlResponse));
            try {
                httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                String request1 = params.toString();
                URLEncoder.encode(request1, "UTF-8");
                final HttpResponse response = httpClient.execute(httppost);
                System.out.println("response .."+ response);
                final HttpEntity entity = response.getEntity();
                if (entity != null) {
                    Response = EntityUtils.toString(entity);
                }
                System.out.println("response .."+ Response);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }



    public static String postxml(final String url, final String xmlRequest)   {
        String Response = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        final HttpPost httppost = new HttpPost(url);
        final List<NameValuePair> params = new ArrayList<NameValuePair>(1);
        params.add(new BasicNameValuePair("xml", xmlRequest));
        params.add(new BasicNameValuePair("xmlData", xmlRequest));
        try {

            final HttpResponse response = httpClient.execute(httppost);
            final HttpEntity entity = response.getEntity();

            if (entity != null) {
                Response = EntityUtils.toString(entity);
            }
            return Response;
        } catch (final UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (final ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (final IOException ioe) {
            ioe.printStackTrace();
        }

        return Response;
    }

    public void sendRequestAndprintResponse(){
        mRequestQueue = Volley.newRequestQueue(this);

        StringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "Response.." + response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Error.. " + error.toString());
            }


        });
        mRequestQueue.add(StringRequest);
    }

    public static boolean findParameter(String xmlLine) {
        boolean found = false;
        String paramPrefix = "${";
        if (xmlLine.contains(paramPrefix)) {
            found = true;
            System.out.println("Found a variable in the string");
        } else {
            System.out.println("Did not find any variable in the string");
        }
        return found;
    }

    //carey admin123

    public  String getParameterName(String xmlLine) {
        if (isValid(xmlLine)) {
            int startIndex = xmlLine.indexOf("{") + 1;
            int endIndex = xmlLine.indexOf("}");
            String paramName = xmlLine.substring(startIndex, endIndex);
            System.out.println("Parsed the parameter name : " + paramName);
            return paramName;
        } else {
            return "";
        }
    }
    /**
     * Method parse the xml and returns the URL/Confirmation number
     *
     * @param testdata
     * @return
     */
    public  String parse_xml(final Map<String, String> testdata) {
        String extractvalue = null;
        try {
            final String xmlresponse = sendRequestAndprintResponse1();
            System.out.println("the response is ==" + xmlresponse);

            if (xmlresponse != null) {
                final String http_response = postxml(testdata.get("url"), xmlresponse);
                System.out.println("the response is ==" + http_response);
                if(extractvalue==null)
                {
                    extractvalue = http_response;
                }
            }
        } catch (final Exception e) {
            System.out.println("The data is not parsed correctly in  xml");
        }
        return extractvalue;}

    public  boolean isValid(String value) {
        if (value != null && !value.equals("")) {
            return true;
        }
        return false;
    }

    public  String replaceParameterWithValue(String xmlLine,
                                             String param, String value) {
        if (param != null && value != null) {
            String parameter = "${" + param + "}";
            xmlLine = xmlLine.replace(parameter, value);
            System.out.println("xmlLine " + parameter + "= " + value + "\n"
                    + xmlLine);
        }
        return xmlLine;
    }




}