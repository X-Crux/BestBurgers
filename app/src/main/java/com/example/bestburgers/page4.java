package com.example.bestburgers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;

import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;


public class page4 extends AppCompatActivity {

    private final String MAPKIT_API_KEY = "e4c7e963-4400-425b-ace5-b7c2be20da49";
    private final Point TARGET_LOCATION = new Point(56.014458, 92.895358);

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        mapView = (MapView)findViewById(R.id.mapview);

        mapView.getMap().getMapObjects().addPlacemark(
                new Point(56.014458, 92.895358),
                ImageProvider.fromBitmap(drawSimpleBitmap("с 9 до 22"))
        );

        // Перемещение камеры на координаты.
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);
    }

    public Bitmap drawSimpleBitmap(String number) {
        int picSize = 200;
        Bitmap bitmap = Bitmap.createBitmap(picSize * 2, picSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        // отрисовка плейсмарка
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(picSize / 2, picSize / 2, picSize / 30, paint);
        // отрисовка текста
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Ежедневно", picSize / 2, picSize / 2 - 70, paint);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(number, picSize / 2, picSize / 2 - 30, paint);
        return bitmap;
    }

    @Override
    protected void onStop() {
        // Вызов onStop нужно передавать инстансам MapView и MapKit.
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Вызов onStart нужно передавать инстансам MapView и MapKit.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }

    public void pageBurgerStart(View v) {
        Intent intent = new Intent(this, page1.class);
        startActivity(intent);
    }

    public void pageColaStart(View v) {
        Intent intent = new Intent(this, page2.class);
        startActivity(intent);
    }

    public void pageBoxStart(View v) {
        Intent intent = new Intent(this, page3.class);
        startActivity(intent);
    }

    public void pageNavStart(View v) {
        Intent intent = new Intent(this, page4.class);
        startActivity(intent);
    }
}