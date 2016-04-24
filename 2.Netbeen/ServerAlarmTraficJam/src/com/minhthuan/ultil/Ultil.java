/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhthuan.ultil;

import com.minhthuan.lib.maps.Marker;
import com.minhthuan.sqlserver.SQLServer;
import java.net.URISyntaxException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author vanmi
 */
public class Ultil {

    private final static String TAG = "Ultil";
    private final static String HOST = "127.0.0.1\\SQLEXPRESS";
    private final static String DATABASE = "AlarmTrafficjam";
    private final static String USERNAME = "sa";
    private final static String PASS = "1234";
    public final static SQLServer server = new SQLServer(HOST, DATABASE, USERNAME, PASS);

    public static Image getImage(Object o, String image) {
        try {
            return new Image(o.getClass().getResource("/images/" + image).toString());
        } catch (Exception e) {
            System.out.println(TAG + ": No found image");
        }
        return null;
    }

    public static ImageView getImageView(Object o, String image) {
        return new ImageView(getImage(o, image));
    }

    public static String getImagePath(Object o, String image) {
        return o.getClass().getResource("/images/" + image).toString();
    }

    public static String getImageLevelJam(Object o, Marker.Level level, int zoom) {
        switch (level) {
            case Good:
                if (zoom >= 17) {
                    return Ultil.getImagePath(o, "ic_good.png");
                } else {
                    return Ultil.getImagePath(o, "ic_good16.png");
                }
            case Light_Jam:
                if (zoom >= 17) {
                    return Ultil.getImagePath(o, "ic_lightjam.png");
                } else {
                    return Ultil.getImagePath(o, "ic_lightjam16.png");
                }
            case Jam:
                if (zoom >= 17) {
                    return Ultil.getImagePath(o, "ic_jam.png");
                } else {
                    return Ultil.getImagePath(o, "ic_jam16.png");
                }
            case Heavy_Jam:
                if (zoom >= 17) {
                    return Ultil.getImagePath(o, "ic_heavyjam.png");
                } else {
                    return Ultil.getImagePath(o, "ic_heavyjam16.png");
                }
            default:
                return null;

        }
    }

}
