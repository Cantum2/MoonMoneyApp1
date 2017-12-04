package kyrxstudios.moonmoney;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        //This is connecting the button from content_main.xml to this java doc
        final Button AdButton = (Button) findViewById(R.id.AdButton);
        Log.d("AdButton ", "Clicked ");

    }

}
