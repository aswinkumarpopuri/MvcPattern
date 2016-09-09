package co.brighterbrain.mvcpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity  implements Observer,View.OnClickListener{
    private Model mModel;

    private Button mbutton1;
    private Button mbutton2;
    private Button mbutton3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mModel= new Model();
        mModel.addObserver(this);
        mbutton1 = (Button)findViewById(R.id.button1);
        mbutton2 = (Button)findViewById(R.id.button2);
        mbutton3 = (Button)findViewById(R.id.button3);
        mbutton1.setOnClickListener(this);
        mbutton2.setOnClickListener(this);
        mbutton3.setOnClickListener(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        mbutton1.setText("count:" +mModel.getValueAtIndex(0));
        mbutton2.setText("count:" +mModel.getValueAtIndex(1));
        mbutton3.setText("count:" +mModel.getValueAtIndex(2));

    }

    @Override
    public void onClick(View view) {
           switch (view.getId())
           {
               case R.id.button1:
                   mModel.setValueAtIndex(0);
                   break;
               case R.id.button2:
                   mModel.setValueAtIndex(1);
                   break;
               case R.id.button3:
                   mModel.setValueAtIndex(2);
                   break;
           }
    }
}
