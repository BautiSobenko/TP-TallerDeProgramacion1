package main;

import controladores.ControladorLogin;
import modelo.Empresa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Prueba {
    public static void main(String[] args) {

        //DateFormat dateFormat = new SimpleDateFormat("EEEEE, MMM d, yyyy '@' HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("EEEEE");


        String date = dateFormat.format(Calendar.getInstance().getTime());
        System.out.println(date);
    }
}
