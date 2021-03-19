package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.currencyconverter.model.*;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private double dub=0;
    private double bud=0; //this variable use for convertation
    private static String BaseData;
    private final static String TAG="MainActivity";
    EditText usd;
    EditText TextInput;
    Button RenovationButton;
    Button ConvertButton;
    String Dop="{    \"Date\": \"2021-03-19T11:30:00+03:00\",    \"PreviousDate\": \"2021-03-18T11:30:00+03:00\",    \"PreviousURL\": \"\\/\\/www.cbr-xml-daily.ru\\/archive\\/2021\\/03\\/18\\/daily_json.js\",    \"Timestamp\": \"2021-03-18T23:00:00+03:00\",    \"Valute\": {        \"AUD\": {            \"ID\": \"R01010\",            \"NumCode\": \"036\",            \"CharCode\": \"AUD\",            \"Nominal\": 1,            \"Name\": \"Австралийский доллар\",            \"Value\": 57.6007,            \"Previous\": 56.5078        },        \"AZN\": {            \"ID\": \"R01020A\",            \"NumCode\": \"944\",            \"CharCode\": \"AZN\",            \"Nominal\": 1,            \"Name\": \"Азербайджанский манат\",            \"Value\": 43.3539,            \"Previous\": 43.0264        },        \"GBP\": {            \"ID\": \"R01035\",            \"NumCode\": \"826\",            \"CharCode\": \"GBP\",            \"Nominal\": 1,            \"Name\": \"Фунт стерлингов Соединенного королевства\",            \"Value\": 102.8858,            \"Previous\": 101.6994        },        \"AMD\": {            \"ID\": \"R01060\",            \"NumCode\": \"051\",            \"CharCode\": \"AMD\",            \"Nominal\": 100,            \"Name\": \"Армянских драмов\",            \"Value\": 13.957,            \"Previous\": 13.8516        },        \"BYN\": {            \"ID\": \"R01090B\",            \"NumCode\": \"933\",            \"CharCode\": \"BYN\",            \"Nominal\": 1,            \"Name\": \"Белорусский рубль\",            \"Value\": 28.3246,            \"Previous\": 28.1302        },        \"BGN\": {            \"ID\": \"R01100\",            \"NumCode\": \"975\",            \"CharCode\": \"BGN\",            \"Nominal\": 1,            \"Name\": \"Болгарский лев\",            \"Value\": 45.0123,            \"Previous\": 44.447        },        \"BRL\": {            \"ID\": \"R01115\",            \"NumCode\": \"986\",            \"CharCode\": \"BRL\",            \"Nominal\": 1,            \"Name\": \"Бразильский реал\",            \"Value\": 13.1893,            \"Previous\": 12.9964        },        \"HUF\": {            \"ID\": \"R01135\",            \"NumCode\": \"348\",            \"CharCode\": \"HUF\",            \"Nominal\": 100,            \"Name\": \"Венгерских форинтов\",            \"Value\": 23.9956,            \"Previous\": 23.6365        },        \"HKD\": {            \"ID\": \"R01200\",            \"NumCode\": \"344\",            \"CharCode\": \"HKD\",            \"Nominal\": 10,            \"Name\": \"Гонконгских долларов\",            \"Value\": 94.858,            \"Previous\": 94.1283        },        \"DKK\": {            \"ID\": \"R01215\",            \"NumCode\": \"208\",            \"CharCode\": \"DKK\",            \"Nominal\": 1,            \"Name\": \"Датская крона\",            \"Value\": 11.8403,            \"Previous\": 11.6903        },        \"USD\": {            \"ID\": \"R01235\",            \"NumCode\": \"840\",            \"CharCode\": \"USD\",            \"Nominal\": 1,            \"Name\": \"Доллар США\",            \"Value\": 73.6582,            \"Previous\": 73.1019        },        \"EUR\": {            \"ID\": \"R01239\",            \"NumCode\": \"978\",            \"CharCode\": \"EUR\",            \"Nominal\": 1,            \"Name\": \"Евро\",            \"Value\": 88.1173,            \"Previous\": 86.9693        },        \"INR\": {            \"ID\": \"R01270\",            \"NumCode\": \"356\",            \"CharCode\": \"INR\",            \"Nominal\": 10,            \"Name\": \"Индийских рупий\",            \"Value\": 10.1531,            \"Previous\": 10.0709        },        \"KZT\": {            \"ID\": \"R01335\",            \"NumCode\": \"398\",            \"CharCode\": \"KZT\",            \"Nominal\": 100,            \"Name\": \"Казахстанских тенге\",            \"Value\": 17.5753,            \"Previous\": 17.4543        },        \"CAD\": {            \"ID\": \"R01350\",            \"NumCode\": \"124\",            \"CharCode\": \"CAD\",            \"Nominal\": 1,            \"Name\": \"Канадский доллар\",            \"Value\": 59.4305,            \"Previous\": 58.6646        },        \"KGS\": {            \"ID\": \"R01370\",            \"NumCode\": \"417\",            \"CharCode\": \"KGS\",            \"Nominal\": 100,            \"Name\": \"Киргизских сомов\",            \"Value\": 86.8353,            \"Previous\": 86.1774        },        \"CNY\": {            \"ID\": \"R01375\",            \"NumCode\": \"156\",            \"CharCode\": \"CNY\",            \"Nominal\": 1,            \"Name\": \"Китайский юань\",            \"Value\": 11.3282,            \"Previous\": 11.2413        },        \"MDL\": {            \"ID\": \"R01500\",            \"NumCode\": \"498\",            \"CharCode\": \"MDL\",            \"Nominal\": 10,            \"Name\": \"Молдавских леев\",            \"Value\": 41.4276,            \"Previous\": 41.161        },        \"NOK\": {            \"ID\": \"R01535\",            \"NumCode\": \"578\",            \"CharCode\": \"NOK\",            \"Nominal\": 10,            \"Name\": \"Норвежских крон\",            \"Value\": 87.3359,            \"Previous\": 86.1157        },        \"PLN\": {            \"ID\": \"R01565\",            \"NumCode\": \"985\",            \"CharCode\": \"PLN\",            \"Nominal\": 1,            \"Name\": \"Польский злотый\",            \"Value\": 19.1112,            \"Previous\": 18.8996        },        \"RON\": {            \"ID\": \"R01585F\",            \"NumCode\": \"946\",            \"CharCode\": \"RON\",            \"Nominal\": 1,            \"Name\": \"Румынский лей\",            \"Value\": 18.0177,            \"Previous\": 17.7902        },        \"XDR\": {            \"ID\": \"R01589\",            \"NumCode\": \"960\",            \"CharCode\": \"XDR\",            \"Nominal\": 1,            \"Name\": \"СДР (специальные права заимствования)\",            \"Value\": 105.1228,            \"Previous\": 104.4926        },        \"SGD\": {            \"ID\": \"R01625\",            \"NumCode\": \"702\",            \"CharCode\": \"SGD\",            \"Nominal\": 1,            \"Name\": \"Сингапурский доллар\",            \"Value\": 54.8746,            \"Previous\": 54.2621        },        \"TJS\": {            \"ID\": \"R01670\",            \"NumCode\": \"972\",            \"CharCode\": \"TJS\",            \"Nominal\": 10,            \"Name\": \"Таджикских сомони\",            \"Value\": 64.6408,            \"Previous\": 64.1526        },        \"TRY\": {            \"ID\": \"R01700J\",            \"NumCode\": \"949\",            \"CharCode\": \"TRY\",            \"Nominal\": 10,            \"Name\": \"Турецких лир\",            \"Value\": 98.2463,            \"Previous\": 97.4069        },        \"TMT\": {            \"ID\": \"R01710A\",            \"NumCode\": \"934\",            \"CharCode\": \"TMT\",            \"Nominal\": 1,            \"Name\": \"Новый туркменский манат\",            \"Value\": 21.0753,            \"Previous\": 20.9161        },        \"UZS\": {            \"ID\": \"R01717\",            \"NumCode\": \"860\",            \"CharCode\": \"UZS\",            \"Nominal\": 10000,            \"Name\": \"Узбекских сумов\",            \"Value\": 69.9931,            \"Previous\": 69.383        },        \"UAH\": {            \"ID\": \"R01720\",            \"NumCode\": \"980\",            \"CharCode\": \"UAH\",            \"Nominal\": 10,            \"Name\": \"Украинских гривен\",            \"Value\": 26.6058,            \"Previous\": 26.4012        },        \"CZK\": {            \"ID\": \"R01760\",            \"NumCode\": \"203\",            \"CharCode\": \"CZK\",            \"Nominal\": 10,            \"Name\": \"Чешских крон\",            \"Value\": 33.6654,            \"Previous\": 33.2191        },        \"SEK\": {            \"ID\": \"R01770\",            \"NumCode\": \"752\",            \"CharCode\": \"SEK\",            \"Nominal\": 10,            \"Name\": \"Шведских крон\",            \"Value\": 86.8959,            \"Previous\": 85.8004        },        \"CHF\": {            \"ID\": \"R01775\",            \"NumCode\": \"756\",            \"CharCode\": \"CHF\",            \"Nominal\": 1,            \"Name\": \"Швейцарский франк\",            \"Value\": 79.6219,            \"Previous\": 78.7906        },        \"ZAR\": {            \"ID\": \"R01810\",            \"NumCode\": \"710\",            \"CharCode\": \"ZAR\",            \"Nominal\": 10,            \"Name\": \"Южноафриканских рэндов\",            \"Value\": 50.2039,            \"Previous\": 48.9513        },        \"KRW\": {            \"ID\": \"R01815\",            \"NumCode\": \"410\",            \"CharCode\": \"KRW\",            \"Nominal\": 1000,            \"Name\": \"Вон Республики Корея\",            \"Value\": 65.4987,            \"Previous\": 64.708        },        \"JPY\": {            \"ID\": \"R01820\",            \"NumCode\": \"392\",            \"CharCode\": \"JPY\",            \"Nominal\": 100,            \"Name\": \"Японских иен\",            \"Value\": 67.4835,            \"Previous\": 66.9738        }    }}";
    Spinner spinner;
    int delay=60000;

    Handler handler=new Handler();
    HttpURLConnection connection=null;
    private Thread SecondThread; // Thread for Web and pars
    Runnable r=new Runnable(){
        @Override
        public void run(){
            ScanWebAndParseJson();
        }
    };
    private StringBuilder sb=new StringBuilder();
    private Gson GS=new Gson();
    private static Model JM=new Model();
    SharedPreferences preferences;

    String[] ValuteArray=new String[]{"USD", "EUR", "GBP", "CHF", "JPY", "CNY", "AMD", "BYN", "BGN", "AZN", "BRL", "HUF", "HKD", "DKK", "INR", "KZT", "CAD", "KGS", "CNY", "MDL", "NOK", "PLN", "RON", "XDR", "SGD", "TJS", "TRY", "TMT", "UZS", "UAH",  "CZK", "SEK",  "ZAR",  "KRW"};

    private void ScanWebAndParseJson(){
        try {
            connection=(HttpURLConnection) new URL("https://www.cbr-xml-daily.ru/daily_json.js").openConnection();
            connection.connect();
            if (HttpURLConnection.HTTP_OK==connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line=in.readLine())!=null){
                    //System.out.println(line);
                    sb.append(line);
                    //sb.append("\n");
                }
                //System.out.print(sb.toString());
                //storeJSON(sb.toString());
                //BaseData=preferences.getString("BaseData", null);
                JM=GS.fromJson(sb.toString(), Model.class);
                usd.setText("Последнее обновление базы данных:\n"+JM.getPreviousDate()+"\n"+JM.getValute().toString());
            }
            else {
                JM=GS.fromJson(Dop, Model.class);
                usd.setText("К сожалению установить соединение не удалось, отображены курсы на: \n"+JM.getDate()+"\n"+JM.getValute().toString());
            }
        } catch (Exception e){
            //JM=GS.fromJson(Dop, Model.class);
            //usd.setText("К сожалению установить соединение не удалось, отображены курсы на: \n"+JM.getDate()+"\n"+JM.getValute().toString());
            e.printStackTrace();
        } finally{
            if (connection!=null) connection.disconnect();
        }
    }


    private void ThreadForWebScan(){
        SecondThread=new Thread(r);
        SecondThread.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd=(EditText)findViewById(R.id.usd);
        TextInput=(EditText)findViewById(R.id.TextInput);
        spinner = (Spinner) findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ValuteArray);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        ConvertButton=(Button)findViewById(R.id.ConvertButton);
        RenovationButton=(Button)findViewById(R.id.RenovationButton);
        ThreadForWebScan();
        ConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Converter();
            }
        });

        RenovationButton=(Button)findViewById(R.id.RenovationButton);

        RenovationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreadForWebScan();
            }
        });

        handler.postDelayed(r, delay); // реализация переодического обновления
        //if(BaseData==null){
            //SharedPreferences preferences=
                    //PreferenceManager.getDefaultSharedPreferences(this);
            //storeJSON(Dop);
            //BaseData=preferences.getString("BaseData", null);
        //}
        //JM=GS.fromJson(BaseData, Model.class);
        //usd.setText(JM.getValute().toString());
        //DataText.setText("Последнее обновление базы данных:\n"+JM.getPreviousDate());

    }

    private void Converter() {
        try {
            String text = spinner.getSelectedItem().toString();
            dub=Double.parseDouble(TextInput.getText().toString());
            if (text.equalsIgnoreCase("USD")){
                bud=JM.getValute().getUSD().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("EUR")){
                bud=JM.getValute().getEUR().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("GBP")){
                bud=JM.getValute().getGBP().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("CHF")){
                bud=JM.getValute().getCHF().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("JPY")){
                bud=JM.getValute().getJPY().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("CNY")){
                bud=JM.getValute().getCNY().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("AMD")){
                bud=JM.getValute().getAMD().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("BYN")){
                bud=JM.getValute().getBYN().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("BGN")){
                bud=JM.getValute().getBGN().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("AZN")){
                bud=JM.getValute().getAZN().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("BRL")){
                bud=JM.getValute().getBRL().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("HUF")){
                bud=JM.getValute().getHUF().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("HKD")){
                bud=JM.getValute().getHKD().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("DKK")){
                bud=JM.getValute().getDKK().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("INR")){
                bud=JM.getValute().getINR().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("KZT")){
                bud=JM.getValute().getKZT().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("CAD")){
                bud=JM.getValute().getCAD().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("KGS")){
                bud=JM.getValute().getKGS().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("CNY")){
                bud=JM.getValute().getCNY().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("MDL")){
                bud=JM.getValute().getMDL().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("NOK")){
                bud=JM.getValute().getNOK().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("PLN")){
                bud=JM.getValute().getPLN().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("RON")){
                bud=JM.getValute().getRON().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("XDR")){
                bud=JM.getValute().getXDR().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("SGD")){
                bud=JM.getValute().getSGD().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("TJS")){
                bud=JM.getValute().getTJS().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("TRY")){
                bud=JM.getValute().getTRY().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("TMT")){
                bud=JM.getValute().getTMT().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("UZS")){
                bud=JM.getValute().getUZS().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("UAH")){
                bud=JM.getValute().getUAH().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("CZK")){
                bud=JM.getValute().getCZK().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("SEK")){
                bud=JM.getValute().getSEK().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("ZAR")){
                bud=JM.getValute().getZAR().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
            if (text.equalsIgnoreCase("KRW")){
                bud=JM.getValute().getKRW().convert(dub);
                TextInput.setText(String.valueOf(bud));
            }
        } catch (Exception e){
            TextInput.setHint("пожалуйста введите число");
        }finally {
        }
    }
    //public void storeJSON(String NewBaseData){
     //   SharedPreferences.Editor editor=preferences.edit();
     //   editor.putString("BaseData", NewBaseData);
     //   editor.apply();
    //}





    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}