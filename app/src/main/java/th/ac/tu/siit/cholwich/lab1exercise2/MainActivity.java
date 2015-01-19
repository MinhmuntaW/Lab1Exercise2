package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertClicked(View v){
        EditText etInput =(EditText)findViewById(R.id.etInput);
        String s = etInput.getText().toString();
        double cal = Double.parseDouble(s);
        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        int selFrom = rgFrom.getCheckedRadioButtonId();
        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);
        int selTo = rgTo.getCheckedRadioButtonId();
        double temp=0;
        if(selFrom == R.id.rbFrmC) {
            if (selTo == R.id.rbToC) {
                temp=cal;
            } else if (selTo == R.id.rbToF) {
               temp = cal * (9.0 / 5) + 32;

            } else if (selTo == R.id.rbToK) {
                temp = cal + 273.15;

            }
        }
        else if(selFrom == R.id.rbFrmF){
                if(selTo == R.id.rbToF){
                    temp=cal;
                }
                else if(selTo == R.id.rbToC) {
                    temp= (cal-32)*(5.0/9);

                }
                else if(selTo == R.id.rbToK) {
                    temp = (cal + 459.67)*(5.0/9);

                }

        }
        else if(selFrom == R.id.rbFrmK){
            if(selTo == R.id.rbToK){
                temp=cal;
            }
            else if(selTo == R.id.rbToC) {
                temp= cal-273.15;

            }
            else if(selTo == R.id.rbToF) {
                temp = (cal *(9/5))-459.67;

            }

        }
        TextView t =(TextView)findViewById(R.id.tvOutput);
        t.setText(Double.toString(temp));
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
}
