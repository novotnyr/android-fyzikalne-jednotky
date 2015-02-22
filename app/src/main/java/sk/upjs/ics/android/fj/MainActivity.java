package sk.upjs.ics.android.fj;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {
    private TextView lblFahrenheit;

    private EditText txtCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblFahrenheit = (TextView) findViewById(R.id.lblFahrenheit);

        txtCelsius = (EditText) findViewById(R.id.txtCelsius);
        txtCelsius.addTextChangedListener(new CelsiusTextWatcher());
    }

    private class CelsiusTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            updateFahrenheit();
        }
    }

    private void updateFahrenheit() {
        try {
            double celsius = Double.parseDouble(txtCelsius.getText().toString());
            double fahrenheit = ((9 / 5) * celsius) + 32;
            lblFahrenheit.setText(new DecimalFormat("#.##").format(fahrenheit));
        } catch (NumberFormatException e) {
            Toast
                    .makeText(this, "Please enter a number", Toast.LENGTH_LONG)
                    .show();
        }
    }

}
