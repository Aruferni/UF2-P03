package com.example.albertfernie.uf2_p03;

/**
 * Created by albertfernie on 24/01/2017.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;


public class Gview extends View{

    //Declaraciones globales
    Bitmap bmp1;
    Paint paint = new Paint();
    float newX, newY, oldX, oldY;
    private MediaPlayer mediaPlayer;

    //constructor:
    public Gview(Context context) {
        super(context);
        //Inicializamos tanto la imagen como el sonido
        bmp1 =  BitmapFactory.decodeResource(getResources(), R.drawable.pelota);
        mediaPlayer = MediaPlayer.create(super.getContext(), R.raw.bici);
    } //fin del constructor

    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.CYAN);//Esteblece el fondo de pantalla
        canvas.drawBitmap(bmp1, newX - 100, newY - 100, null);//Dibuja el bitmap
        paint.setColor(Color.MAGENTA);//Establece el color de la línea
        canvas.drawLine(oldX, oldY, newX + 45, newY + 45, paint);//Dibuja una línea del color de la línea anterior
        super.onDraw(canvas);
    }//fin de onDraw

    public boolean onTouchEvent(MotionEvent event) {
        mediaPlayer.start();//Inicia el sonido cada vez que toca la pantalla
        oldX = newX;//Damos a estas variables las coordenadas de X e Y anteriores
        oldY = newY;
        newX = event.getX();//Cogemos las coordenadas X e Y de la pantalla
        newY = event.getY();
        this.invalidate(); //refrescar la pantalla
        return super.onTouchEvent(event);
    }
} //fin de class Gview
