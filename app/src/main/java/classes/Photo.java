package classes;

import java.io.File;

public class Photo {
    private int height;
    private int width;
    private int resolution;
    private int size = 65536;
    private File photoGraph;

    public File getPhotoGraph() {
        return photoGraph;
    }
    public void setPhotoGraph(File photoGraph) { this.photoGraph = photoGraph; }


}
