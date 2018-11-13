package app.com.lrouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import lrouter.app.com.processor.annotation.LClass;
import lrouter.app.com.processor.annotation.LMethod;
import lrouter.app.com.processor.annotation.LParam;

@LClass(classname = "HelloTest")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAnnotationMessage();
    }

    public void getUserInfo(){

    }

    private void showAnnotationMessage() {

    }

}
