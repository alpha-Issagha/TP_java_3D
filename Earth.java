import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class Earth extends Group {
    private Rotate ry;
    private Sphere sph;
    private ArrayList<Sphere> yellowSphere;
    PhongMaterial texture = new PhongMaterial();
    public Earth() {
        super();
        this.sph=new Sphere(300);
        texture.setDiffuseMap(new Image("file:data/earth_lights_4800.png"));
        sph.setMaterial(texture);

        this.getChildren().add(sph);

        ry = new Rotate();
        ry.setAxis(Rotate.Y_AXIS);
        sph.getTransforms().add(ry);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                ry.setAngle(ry.getAngle() + 0.25);
            }
        };
        animationTimer.start();
    }

}
