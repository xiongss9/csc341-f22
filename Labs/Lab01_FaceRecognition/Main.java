import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.*;

/** Primary driver for facial recognition using DB of faces loaded from a file.
 * Graphics window is created in which to display faces.
 */
public class Main {
    
    /** Graphics window inside JFrame on which to draw components */
    static DrawingWindow window;

    /** Default size for graphics window (within frame) */
    static final Integer WINDOW_WIDTH = 800;
    static final Integer WINDOW_HEIGHT = 480;

    public static void main(String[] args) {   
        
        // If you want to read in only a few faces for testing purposes ...
        // String[] featureData = readFile('facetest.csv',10);

        // Read in csv file of facial features. 
        // Each face will be 1 line from the file.
        String[] featureData = readFile("facetest.csv");
        // Convert the strings from the file into Face objects
        Face[] faces = buildDB(featureData);

        // Get the graphics going - a popup window for displaying faces
        createGraphicsWindow();
        
        // Compare a randomly generated face to all faces in the DB
        // Find closest and furthest match
        Face randomFace = new Face();
        Integer bestIndex = findBestMatch(randomFace,faces);
        Face bestMatchCopy = new Face(faces[bestIndex]);
        Integer worstIndex = findWorstMatch(randomFace,faces);
        Face worstMatchCopy = new Face(faces[worstIndex]);


        // Establishing placement of the 3 faces within the graphics window.

        /* The DrawingWindow draws every item in the array passed through objectsToDraw(). The graphics window uses DrawingObject.location to place the object within the graphics window. Three locations are being defined within the window: center, left of center and right of center.
        */
        Double left = (WINDOW_WIDTH)*.25 - 150;
        Double middle = (WINDOW_WIDTH)*.50 - 100;
        Double right = (WINDOW_WIDTH)*0.75 - 50;
        Double center = (WINDOW_HEIGHT-20)*.5 - 100;    // vertical center
        
        // index 0-1-2 is text. index 3 toMatch, 4 best, 5 worst
        DrawingObject[] objectsToDraw = new DrawingObject[6];
        
        // The random face to match displayed in center of graphics window
        objectsToDraw[1] = new Text("Face To Match",new Point(middle,400));
        randomFace.location(new Point(middle,center));
        objectsToDraw[3] = randomFace;

        // Best match is left of center        
        objectsToDraw[0] = new Text("Best Match",new Point(left+20,400));
        bestMatchCopy.location(new Point(left,center));
        objectsToDraw[4] = bestMatchCopy;

        // Worst match is right of center
        objectsToDraw[2] = new Text("Worst Match",new Point(right,400));
        worstMatchCopy.location(new Point(right,center));
        objectsToDraw[5] = worstMatchCopy;

        // send objects to Drawing Window and render
        window.updateObjects(objectsToDraw);
        window.redraw();
    }

    /** Display all faces in graphics window
     * 
     * @param faces Collection of cartoon faces
     */
    public static void displayAll(Face[] faces) {
        // Establishing placement of the face within the graphics window.
        Double middle = (WINDOW_WIDTH)*.50 - 100;
        Double center = (WINDOW_HEIGHT-20)*.5 - 100;
        
        // index 0 is text and index 1 is face
        DrawingObject objectsToDraw[] = new DrawingObject[2];

        for (Face f : faces) {
            // locate next face in center of window
            f.location(new Point(middle,center));
            objectsToDraw[1] = f;
            // label face with ID
            objectsToDraw[0] = new Text("Face ID#"+f.id(),new Point(middle,400));
            window.updateObjects(objectsToDraw);
            window.redraw(); 
            // pause between renderings. must be in a try to compile.
            try { Thread.sleep(400);
            } catch (Exception e) {}
        }
    }

    /** Finds best match for toMatch in faces using the Face.compare method.
     * The best match is the closest (or minimum) value returned from compare
     * 
     * @param toMatch Face object to which all are compared
     * @param faces Collection of faces
     * 
     * @return INDEX of the face that is closest to toMatch
     */
    public static Integer findBestMatch(Face toMatch, Face[] faces) {
        
        return 0;
    }

    /** Finds worst match for toMatch in faces using the Face.compare method.
     * The worst match is the furthest (or maximum) value returned from compare
     * 
     * @param toMatch Face object to which all are compared
     * @param faces Collection of faces
     * 
     * @return INDEX of the face that is furthest from toMatch
     */
    public static Integer findWorstMatch(Face toMatch, Face[] faces) {

        return 0;
    }
    
    /** Create pop-up graphics window in which all things are drawn.
     * 
     */
    public static void createGraphicsWindow() {
        
        JFrame f = new JFrame();
        window = new DrawingWindow(WINDOW_WIDTH, WINDOW_HEIGHT);
        f.setSize(WINDOW_WIDTH+20, WINDOW_HEIGHT+20);
        f.setTitle("Face Recognition");
        f.add(window);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    /** Convert data read from file into a database of faces.
     * The "DB" in this case is simply an array of faces
     * 
     * @param features[] Each element is comma-separated values representing a face
     * @return "DB" array of constructed faces
     */
    public static Face[] buildDB(String[] features) {
        // Initialize empty array of faces
        Face[] faces = new Face[features.length];
        // Convert each string of features into a Face object
        for (int i = 0; i < features.length; i++) {
            faces[i] = new Face(features[i]);
        }
        System.out.println("Built DB of "+faces.length+" faces.");
        return faces;
    }
    
    /** Read all the faces in the file
     * 
     * @param filename comma-separated values representing a face
     * @return String array - each element is facial features of one face
     */
    public static String[] readFile(String filename) {
        // passing null for size to indicate read all in the file
        return readFile(filename, null);
    }

    /** Read as many faces in the file as indicated by size.
     * 
     * @param filename comma-separated values representing a face
     * @param size The number of lines to read from the file
     * 
     * @return String array - each element is facial features of one face
     */    
    public static String[] readFile(String filename, Integer size) {
        
        String[] lines;
        
        // a null size means to read all faces in the file
        if (size == null) {
            // assumuing there are not more than 10000 faces in file
            size = 10000;
        }
        
        // create array to hold each line from file (as String)
        lines = new String[size];
        
        // track where to insert into lines
        int index = 0;

        // Read file using "try with resources"
        // When try-ing with resources, the system will manage the
        // closing of the file if anything goes wrong.
        try ( Scanner scanner = new Scanner(new File(filename))) {
            // Read first line of column headings
            scanner.nextLine();
            while (scanner.hasNextLine() && index < size) {
                // add line to array (used to instantiate a face later)
                lines[index] = scanner.nextLine();
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
        // We want the array to be full - no empty spaces
        if (index < size) {
            // resize the array so it is exactly the right size
            lines = resizeArray(lines,index);
        }
        System.out.println("Successfully read "+lines.length+ " lines from "+filename);
        return lines;
    }

    /** Create a file of random faces. It will have "size" lines, each representing a face.
     * 
     * @param filename File to write to -- this OVERWRITES the file!
     * @param size Number of random faces to store.
    */
    public static void makeFile(String filename, Integer size) {
        
        // Write file using "try with resources"
        // When try-ing with resources, the system will manage the
        // closing of the file if anything goes wrong.
        try ( FileWriter writer = new FileWriter(new File(filename))) {
            Face f;
            String toWrite;
            writer.write("width,height,eye_delta,eye_length,nose_length,nose_width,mouth_delta,mouth_length\n");

            for (int i=0; i<size; i++) {
                // add line to array (used to instantiate a face later)
                f = new Face();
                toWrite = f.width()+","+f.height()+","+f.eyeDelta()+","+f.eyeLength()+",";
                toWrite += +f.noseLength()+","+f.noseWidth()+","+f.mouthDelta()+"\n";
                writer.write(toWrite);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
    
    /** Resize the array so that every array element has a face in it.
     * 
     * @param array Each element is a face or null
     * @param size Copy over only "size" faces into the new array
     * @return New array that is full (no null elements)
     */
    public static String[] resizeArray(String[] array, int size) {
        String[] newArray = new String[size];
        for (int i=0; i<size; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
