package hk.ust.cse.comp107x.reboot;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button btnSignIn, btnSignUp;
    ImageButton mybut;
    Adapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter = new Adapter(this);
        Adapter = Adapter.open();
        mybut=(ImageButton) findViewById(R.id.imageButton) ;

        btnSignIn = (Button) findViewById(R.id.buttonSignIN);
        btnSignUp = (Button) findViewById(R.id.buttonSignUP);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intentSignUP = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentSignUP);
            }
        });
        mybut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            final Dialog dialoginfo = new Dialog(MainActivity.this);
            dialoginfo.setContentView(R.layout.activity_informactivity);
            dialoginfo.setTitle("Reboot");
            dialoginfo.show();}
        }
    );
    }

    public void signIn(View V) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_login);
        dialog.setTitle("Login");
        final EditText editTextUserName = (EditText) dialog
                .findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = (EditText) dialog
                .findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String storedPassword = Adapter
                        .getSinlgeEntry(userName);
                if (password.equals(storedPassword)) {
                    Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    Intent intentSignUP = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intentSignUP);

                } else {
                    Toast.makeText(MainActivity.this,
                            "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Adapter.close();
    }
}





