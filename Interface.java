import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.File;
public class Interface extends Application {
    double mousePosX;
    double mousePosY;
    Scene theScene;
    World world;
    Earth earth;
    Pane pane;
    PerspectiveCamera camera;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello world");
        //Group root = new Group();
        earth = new Earth();
        pane = new Pane(earth);
        theScene = new Scene(pane, 600, 400,true);
        primaryStage.setScene(theScene);
        primaryStage.show();

        //ajout d'une camera a notre scene
        camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);
        theScene.setCamera(camera);
        zoom();

    }

    public void zoom()
    {
        theScene.addEventHandler(MouseEvent.ANY, event -> {
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                System.out.println("Clicked on : (" + event.getSceneX() + ", "+ event.getSceneY() + ")");
                mousePosY=event.getSceneY();
            }
            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                if(event.getSceneY() > mousePosY)
                {

                    mousePosX=event.getSceneX();
                    mousePosY=event.getSceneY();
                    camera.getTransforms().add(new Translate(0,0,2));
                }
                else
                {
                    mousePosX=event.getSceneX();
                    mousePosY=event.getSceneY();
                    camera.getTransforms().add(new Translate(0,0,-2));
                }
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
