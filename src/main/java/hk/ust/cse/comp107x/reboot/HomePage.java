package hk.ust.cse.comp107x.reboot;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public class HomePage extends Activity {
    ImageButton b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        b1=(ImageButton) findViewById(R.id.imageButton8) ;
        b2=(ImageButton) findViewById(R.id.imageButton10) ;
        b3=(ImageButton) findViewById(R.id.imageButton11) ;
        b4=(ImageButton) findViewById(R.id.imageButton12) ;
        b1.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         final Dialog dialoginfo = new Dialog(HomePage.this);
                                         dialoginfo.setContentView(R.layout.homepage);
                                         dialoginfo.setTitle("News Room");
                                         dialoginfo.show();}
                                 }
        );
        b2.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         final Dialog dialoginfo = new Dialog(HomePage.this);
                                         dialoginfo.setContentView(R.layout.homepage1);
                                         dialoginfo.setTitle("Achievements");
                                         dialoginfo.show();}
                                 }
        );
        b3.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         final Dialog dialoginfo = new Dialog(HomePage.this);
                                         dialoginfo.setContentView(R.layout.homepage2);
                                         dialoginfo.setTitle("Events");
                                         dialoginfo.show();}
                                 }
        );
        b4.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         final Dialog dialoginfo = new Dialog(HomePage.this);
                                         dialoginfo.setContentView(R.layout.homepage3);
                                         dialoginfo.setTitle("Join the team");
                                         dialoginfo.show();}
                                 }
        );
    }
}
