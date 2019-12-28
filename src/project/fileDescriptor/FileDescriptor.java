/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.fileDescriptor;

import java.io.File;
import javafx.scene.paint.Color;

/**
 *
 * @author danie
 */

public class FileDescriptor implements Descriptable {
    private final long size;
    private String fileName;
    private final Color color;

    public FileDescriptor(File toDescript) {
        this.fileName = toDescript.getName();
        if(toDescript.isDirectory()){
            this.size = getDirSize(toDescript);
            this.color = Color.DARKSALMON;
        }else{
            this.size = toDescript.length();
            this.color = Color.SKYBLUE;
        }
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public String getDescription() {
        return this.fileName;
    }

    private long getDirSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        for (File fl : files) {
            if (fl.isFile()) {
                length = length + fl.length();
            } else {
                length = length + getDirSize(fl);
            }
        }
        return length;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

}
