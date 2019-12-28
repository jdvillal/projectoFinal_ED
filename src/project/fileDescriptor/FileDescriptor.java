/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.fileDescriptor;

import java.io.File;

/**
 *
 * @author danie
 */
public class FileDescriptor implements Descriptable {
    private long size;
    private String fileName;

    public FileDescriptor(File toDescript) {
        if(toDescript.isDirectory()){
            this.size = getDirSize(toDescript);
        }else{
            this.size = toDescript.length();
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

}
