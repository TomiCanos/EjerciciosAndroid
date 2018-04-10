package com.example.dh.claserepasoejercicio1login;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity implements FragmentLoginOCrear.NotificarAActivities, FragmentCrear.NotificarAActivities2{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        FragmentLoginOCrear fragmentLoginOCrear = new FragmentLoginOCrear();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity1_container, fragmentLoginOCrear);
        transaction.commit();

    }

    @Override
    public void recibirMensaje(String mensaje) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (mensaje.equals("clickeastelogin")){
            FragmentLogin fragmentLogin = new FragmentLogin();
            transaction.replace(R.id.activity1_container, fragmentLogin);
            transaction.commit();
        }else if (mensaje.equals("clickeastecrear")){
            FragmentCrear fragmentCrear = new FragmentCrear();
            transaction.replace(R.id.activity1_container, fragmentCrear);
            transaction.commit();
        }
    }

    @Override
    public void recibirMensaje2(String correoElectronico, String password, String repassword) {

        if (!correoElectronico.contains("@") || !correoElectronico.contains(".com")) {
            Toast.makeText(this, "CorreoElectronico must contain (@) and (.com)", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (password.length() < 6){
            Toast.makeText(this, "Password is too short (Min 6)", Toast.LENGTH_SHORT).show();
            return;
        }

        else if (!password.equals(repassword)){
            Toast.makeText(this, "Password and Repetir Password must be the same", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            Intent intent = new Intent(this, Activity2.class);
            Bundle bundle = new Bundle();
            bundle.putString("CLAVE_CORREO_ELECTRONICO_CREAR", correoElectronico);
            bundle.putString("CLAVE_PASSWORD_CREAR", password);
            bundle.putString("CLAVE_REPASSWORD_CREAR", repassword);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    }
}
