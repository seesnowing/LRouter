package app.com.lrouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import lrouter.app.com.processor.annotation.LParamInjector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @LParamInjector("dd")
    public void getUserInfo(){

    }

}
