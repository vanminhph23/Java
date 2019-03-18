package com.minhthuan;

import com.lynden.gmapsfx.*;
import com.lynden.gmapsfx.javascript.object.Animation;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.minhthuan.network.MyServer;
import com.minhthuan.sqlserver.DBMarker;
import com.minhthuan.ultil.Ultil;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Example Application for creating and loading a GoogleMap into a JavaFX
 * application
 *
 * @author Rob Terpilowski
 */
public class MainApp extends Application implements MapComponentInitializedListener {

    protected GoogleMapView mapComponent;
    protected GoogleMap map;

    private ImageView btnZoomIn;
    private ImageView btnZoomOut;
    private Label lblZoom;
    private Label lblCenter;

    private Font normalFont;
    private List<Marker> listOldMarker;

    @Override
    public void start(final Stage stage) throws Exception {
        normalFont = Font.font("SansSerif", FontWeight.BOLD, 24);
        mapComponent = new GoogleMapView();
        mapComponent.addMapInializedListener(this);

        BorderPane bp = new BorderPane();
        ToolBar tb = new ToolBar();
        btnZoomIn = new ImageView(Ultil.getImage(this, "ic_zoomin.png"));
        btnZoomIn.setOnMouseClicked((e) -> {
            map.zoomProperty().set(map.getZoom() + 1);
        });

        btnZoomIn.setDisable(true);

        btnZoomOut = new ImageView(Ultil.getImage(this, "ic_zoomout.png"));
        btnZoomOut.setOnMouseClicked(e -> {
            map.zoomProperty().set(map.getZoom() - 1);
        });
        btnZoomOut.setDisable(true);

        lblZoom = new Label("Zoom: 0");
        lblZoom.setFont(normalFont);
        lblCenter = new Label();

        tb.getItems().addAll(btnZoomIn, lblZoom, btnZoomOut,// mapTypeCombo,
                new Label("Center: "), lblCenter);

        bp.setBottom(tb);
        bp.setCenter(mapComponent);

        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();

        MyServer myServer = new MyServer();
        myServer.start();

    }

    @Override
    public void mapInitialized() {
        //Once the map has been loaded by the Webview, initialize the map details.
        LatLong center = new LatLong(21.007704, 105.843845);
//        mapComponent.addMapReadyListener(() -> {
//            // This call will fail unless the map is completely ready.
//            checkCenter(center);
//        });

        MapOptions options = new MapOptions();
        options.center(center)
                .mapMarker(true)
                .zoom(13)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);

        map = mapComponent.createMap(options);

        map.setHeading(123.2);

        lblCenter.setText(map.getCenter().toString());
        map.centerProperty().addListener((ObservableValue<? extends LatLong> obs, LatLong o, LatLong n) -> {
            lblCenter.setText(n.toString());
        });

        lblZoom.setText("Zoom: " + Integer.toString(map.getZoom()));
        map.zoomProperty().addListener((ObservableValue<? extends Number> obs, Number o, Number n) -> {
            lblZoom.setText("Zoom: " + n);
        });

//        map.addUIEventHandler(UIEventType.click, (JSObject obj) -> {
//            LatLong ll = new LatLong((JSObject) obj.getMember("latLng"));
//            System.out.println("LatLong: lat: " + ll.getLatitude() + " lng: " + ll.getLongitude());
//        });
        btnZoomIn.setDisable(false);
        btnZoomOut.setDisable(false);

        listOldMarker = new ArrayList<Marker>();

        updateMarkerThread.setDaemon(true);
        updateMarkerThread.start();

    }

//    private void checkCenter(LatLong center) {
//        Point2D p = map.fromLatLngToPoint(center);
//    }
    private void updateMarker() {
        //System.out.println("Update Marker");
        final DBMarker dBMarker = new DBMarker(Ultil.server);
        List<com.minhthuan.lib.maps.Marker> listNewMarker = dBMarker.getAll();
        if (listNewMarker == null) {
            return;
        }

        // remove all old marker
        listOldMarker.stream().forEach((marker) -> {
            map.removeMarker(marker);
        });
        listOldMarker.clear();

        // add new marker
        for (com.minhthuan.lib.maps.Marker marker : listNewMarker) {
            MarkerOptions markerOptions = new MarkerOptions();
            LatLong markerLatLong = null;
            Marker myMarker = null;
            switch (marker.getLevel()) {
                case Good:
                    markerLatLong = new LatLong(marker.getLatLong().getLatitude(), marker.getLatLong().getLongitude());
                    markerOptions.position(markerLatLong)
                            .title("My new Marker")
                            .animation(Animation.BOUNCE)
                            .visible(true)
                            .icon(this, com.minhthuan.lib.maps.Marker.Level.Good, map.getZoom());

                    myMarker = new Marker(markerOptions);

                    map.addMarker(myMarker);
                    listOldMarker.add(myMarker);

//                                        InfoWindowOptions infoOptions = new InfoWindowOptions();
//                                        infoOptions.content("<h2>Here's an info window</h2><h3>with some info</h3>")
//                                                .position(markerLatLong);
//
//                                        InfoWindow window = new InfoWindow(infoOptions);
//                                        window.open(map, myMarker);
                    break;
                case Light_Jam:
                    markerLatLong = new LatLong(marker.getLatLong().getLatitude(), marker.getLatLong().getLongitude());
                    markerOptions.position(markerLatLong)
                            .title("My new Marker")
                            .animation(Animation.BOUNCE)
                            .visible(true)
                            .icon(this, com.minhthuan.lib.maps.Marker.Level.Light_Jam, map.getZoom());

                    myMarker = new Marker(markerOptions);

                    map.addMarker(myMarker);
                    listOldMarker.add(myMarker);

                    break;
                case Jam:
                    markerLatLong = new LatLong(marker.getLatLong().getLatitude(), marker.getLatLong().getLongitude());
                    markerOptions.position(markerLatLong)
                            .title("My new Marker")
                            .animation(Animation.BOUNCE)
                            .visible(true)
                            .icon(this, com.minhthuan.lib.maps.Marker.Level.Jam, map.getZoom());

                    myMarker = new Marker(markerOptions);

                    map.addMarker(myMarker);
                    listOldMarker.add(myMarker);
                    break;
                case Heavy_Jam:
                    markerLatLong = new LatLong(marker.getLatLong().getLatitude(), marker.getLatLong().getLongitude());
                    markerOptions.position(markerLatLong)
                            .title("My new Marker")
                            .animation(Animation.BOUNCE)
                            .visible(true)
                            .icon(this, com.minhthuan.lib.maps.Marker.Level.Heavy_Jam, map.getZoom());

                    myMarker = new Marker(markerOptions);

                    map.addMarker(myMarker);
                    listOldMarker.add(myMarker);
                    break;
                default:
                    break;
            }
        }
    }

    //Thread update all marker
    Thread updateMarkerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        updateMarker();
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            }
        }
    });

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("java.net.useSystemProxies", "true");
        launch(args);
    }

}
