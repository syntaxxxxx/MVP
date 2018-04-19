package fiqri.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity
        implements MainView, View.OnClickListener {

    private EditText edtAlas, edtTinggi;
    private TextView tvResult;
    private Button btnHitung;
    public static String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAlas = findViewById(R.id.edt_alas);
        edtTinggi = findViewById(R.id.edt_tinggi);
        tvResult = findViewById(R.id.tv_result);
        btnHitung = findViewById(R.id.btn_hitung);
        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(result);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle b) {
        b.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(b);
    }

    // instance class
    MainPresenter presenter = new MainPresenter(this);

    @Override
    public void onClick(View v) {
        String alas = edtAlas.getText().toString().trim();
        String tinggi = edtTinggi.getText().toString().trim();

        boolean isEmptyFiled = false;
        boolean isNumberValid = false;
        String msg = "Tidak Boleh Kosong";
        String validNumber = "Harus Berupa Nomor Valid";

        if (TextUtils.isEmpty(alas)) {
            isEmptyFiled = true;
            edtAlas.setError(msg);

        } else if (!isDouble(alas)) {
            isNumberValid = true;
            edtAlas.setError(validNumber);
        }

        if (TextUtils.isEmpty(tinggi)) {
            isEmptyFiled = true;
            edtTinggi.setError(msg);

        } else if (!isDouble(tinggi)) {
            isNumberValid = true;
            edtTinggi.setError(validNumber);
        }

        if (!isEmptyFiled && !isNumberValid) {
            double als = Double.parseDouble(alas);
            double tgi = Double.parseDouble(tinggi);

            presenter.hitungLuas(als, tgi);

        }
    }


    @Override
    public void nampilinLuas(MainModel model) {
        tvResult.setText(String.valueOf(model.getLuas()));
    }

    boolean isDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
