
/**
 *
 * @author larson amy c
 */
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Face implements DrawingObject {

    private static final Point DEFAULT_LOCATION = new Point(320, 100);

    /** Count instantiations to generate unique id **/
    private static Integer faceCount = 0;

    /** Unique ID per face. Set by instantiation **/
    private Integer id;

    /** x,y-coordinate of upper left corner of bounding box **/
    private Point location = DEFAULT_LOCATION;

    /** Midpoint of the face. Calculated using location. **/
    private Point midpoint;

    /*** Face height in pixels **/
    private int height;
    /*** Face width in pixels **/
    private int width;

    /** length of the ellipse that forms the eye **/
    private int eyeLength;
    /** distance from midline to edge of eye **/
    private int eyeDelta;

    /** length of nose along vertical center of face **/
    private int noseLength;
    /** width of nose (offset from midline) **/
    private int noseWidth;

    /** distance from end of nose to top of mouth **/
    private int mouthDelta;

    private Random rand = new Random();

    /**
     * Provide id based on instantiations.
     *
     * @return current faceCount (then increment count)
     */
    public static Integer getID() {
        return faceCount++;
    }

    /**
     * 
     */
    public Face() {
        id = getID();

        // head dimensions
        width = rand.nextInt(100) + 100;
        height = rand.nextInt(100) + 110;

        eyeDelta = rand.nextInt(25 - 7) + 7;
        eyeLength = rand.nextInt(30 - 15) + 15;

        noseLength = rand.nextInt(45 - 20) + 20;
        noseWidth = rand.nextInt(20 - 5) + 5;
        mouthDelta = rand.nextInt(13 - 3) + 3;
    }

    /**
     * 
     */
    public Face(int h, int w) {
        id = getID();
        height = h;
        width = w;
    }

    /**
     * 
     */
    public Face(String dims) {
        id = getID();
        String[] values = dims.split(",");
        width = Integer.valueOf(values[0]);
        height = Integer.valueOf(values[1]);
        eyeDelta = Integer.valueOf(values[2]);
        eyeLength = Integer.valueOf(values[3]);
        noseLength = Integer.valueOf(values[4]);
        noseWidth = Integer.valueOf(values[5]);
        mouthDelta = Integer.valueOf(values[6]);
    }

    /** Copy constructor - creates new based on another
     * @param toCopy is face to copy (creating a new object)
     */
    public Face(Face toCopy) {
        id = toCopy.id;
        width = toCopy.width;
        height = toCopy.height;
        eyeDelta = toCopy.eyeDelta;
        eyeLength = toCopy.eyeLength;
        noseLength = toCopy.noseLength;
        noseWidth = toCopy.noseWidth;
        mouthDelta = toCopy.mouthDelta;
    }

    /**
     *
     */
    public double compare(Face other) {
        /*
        RATIOS to calculate:
        a. face width / face height
        b. Distance between two eyes (eye_delta*2) / face width
        c. nose length / face height
        d. Nose width / face width
        e. Distance between nose and mouth (mouth_delta) / face height. 
         */

        return 0;
    }

    @Override
    public String toString() {
        String toPrint = id+" [";
        toPrint += width+", "+height+", "+eyeDelta+", "+eyeLength+", "+noseLength+", "+noseWidth+", "+mouthDelta;
        toPrint += "]";
        return toPrint;
    }

    /**
     * Draw eyes at midline of face using facial feature information.
     *
     * @param g2d graphics window on which to draw
     */
    public void draw_eyes(Graphics2D g2d) {
        // eyes
        // When drawing left eye, shift x position to the left-most edge of the eye

        // Randomly choose how open the eyes are
        int openness = rand.nextInt(5) + 4;

        // Left and right eye sockets, drawn in the middle of the face
        // Left edge of left eye socket is delta+length away from midline.
        // Left edge of right eye socket is delta away from midline.
        Ellipse2D.Double left
                = new Ellipse2D.Double(midpoint.x - eyeDelta - eyeLength, midpoint.y, eyeLength, openness);
        Ellipse2D.Double right
                = new Ellipse2D.Double(midpoint.x + eyeDelta, midpoint.y, eyeLength, openness);
        g2d.setColor(new Color(255, 255, 255));
        g2d.fill(left);
        g2d.fill(right);

        // left and right eyeballs. Order matters so must do eyeball after socket.
        Ellipse2D.Double left_eyeball = new Ellipse2D.Double(midpoint.x - eyeDelta - (3 * eyeLength / 4), midpoint.y, eyeLength / 2, openness);
        Ellipse2D.Double right_eyeball = new Ellipse2D.Double(midpoint.x + eyeDelta + (eyeLength / 4), midpoint.y, eyeLength / 2, openness);
        g2d.setColor(new Color(88, 33, 24));
        g2d.fill(left_eyeball);
        g2d.fill(right_eyeball);

    }

    /**
     * 
     */
    public void draw_nose(Graphics2D g2d) {
        // Create a half triangle for the nose
        Path2D.Double nose = new Path2D.Double();
        nose.moveTo(midpoint.x, midpoint.y - 2);
        nose.lineTo(midpoint.x - noseWidth, midpoint.y + noseLength);
        nose.lineTo(midpoint.x, midpoint.y + noseLength);
        // Draw on the face
        g2d.setColor(new Color(0, 89, 179));
        g2d.draw(nose);
    }

    /**
     * 
     */
    public void draw_mouth(Graphics2D g2d) {
        // Create a slight curve for the mouth
        Path2D.Double curve = new Path2D.Double();
        // Determine vertical position on the face (i.e. y-value)
        double ypos = midpoint.y + noseLength + mouthDelta;
        // Start at the left corner of the mouth
        curve.moveTo(midpoint.x - 20, ypos);
        // 2 bezier points then end point - determines curvature
        curve.curveTo(midpoint.x - 18, ypos + 2, midpoint.x + 18,
                ypos + 2, midpoint.x + 20, ypos);
        // Draw on the face
        g2d.setColor(new Color(179, 0, 0));
        g2d.draw(curve);
    }

    @Override
    /**
     * 
     */
    public void draw(Graphics2D g2d) {

        // draw the head. 
        // order matters - must draw head first, then features on top of face.
        // The x-y location of an ellipse is the upper left corner of the bounding box
        Ellipse2D.Double f = new Ellipse2D.Double(location.x, location.y, width, height);
        g2d.setColor(new Color(153, 204, 255));
        g2d.fill(f);

        // exact center of face with respect to drawing window
        // used to determine placement of eyes, nose and mouth within face
        midpoint = new Point(location.x() + width / 2, location.y() + height / 2);

        // draw components of face
        draw_eyes(g2d);
        draw_nose(g2d);
        draw_mouth(g2d);
    }

    // all setters and getters from here ------------------------------------
    // It is NOT necessary to document setters and getters.
    
    public Point location() {
        return location;
    }

    public void location(Point p) {
        location = p;
    }

    public Point midpoint() {
        return midpoint;
    }

    public void midpoint(Point p) {
        midpoint = p;
    }

    public int height() {
        return height;
    }

    public void height(int height) {
        this.height = height;
    }

    public int width() {
        return width;
    }

    public void width(int width) {
        this.width = width;
    }

    public int eyeLength() {
        return eyeLength;
    }

    public void eyeLength(int eye_length) {
        this.eyeLength = eye_length;
    }

    public int eyeDelta() {
        return eyeDelta;
    }

    public void eyeDelta(int eye_delta) {
        this.eyeDelta = eye_delta;
    }

    public int noseLength() {
        return noseLength;
    }

    public void noseLength(int nose_length) {
        this.noseLength = nose_length;
    }

    public int noseWidth() {
        return noseWidth;
    }

    public void noseWidth(int nose_width) {
        this.noseWidth = nose_width;
    }

    public void mouthDelta(int value) {
        mouthDelta = value;
    }

    public int mouthDelta() {
        return mouthDelta;
    }

    public Integer id() {
        return id;
    }
}
