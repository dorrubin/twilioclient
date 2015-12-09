package twilio.com.twilioclient;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import java.lang.Object;
import android.content.pm.PackageManager;




public class HelloMonkeyActivity extends Activity implements View.OnClickListener
{
    private MonkeyPhone phone;
    private EditText numberField;

    @Override
    public void onCreate(Bundle bundle)
    {
//        PackageManager.setComponentEnabledSetting(android.content.com.twilio.client.TwilioClientService, PackageManager.COMPONENT_ENABLED_STATE_ENABLED);
        super.onCreate(bundle);
        setContentView(R.layout.activity_hello_monkey);

        phone = new MonkeyPhone(getApplicationContext());

        ImageButton dialButton = (ImageButton)findViewById(R.id.dialButton);
        dialButton.setOnClickListener(this);

        ImageButton hangupButton = (ImageButton)findViewById(R.id.hangupButton);
        hangupButton.setOnClickListener(this);

        numberField = (EditText)findViewById(R.id.numberField);

    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.dialButton)
            phone.connect(numberField.getText().toString());
        else if (view.getId() == R.id.hangupButton)
            phone.disconnect();

    }
}
