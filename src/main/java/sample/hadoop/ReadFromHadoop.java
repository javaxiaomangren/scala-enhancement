/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.hadoop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 *
 * @author yanghua
 */
public class ReadFromHadoop {
    public static void main(String[] args) throws IOException {
        String dest =  "hdfs://192.168.1.40:9000/home/hadoop/zhe800_for_service.sql" ;
        String myDir = "/home/hadooptest" ;
        Configuration cfg = new Configuration() ;
        FileSystem fs = FileSystem.get(URI.create(dest), cfg) ;
        FSDataInputStream hdfsInStream = fs.open(new Path(dest)) ;
        OutputStream out = new FileOutputStream(myDir) ;
        IOUtils.copyBytes(hdfsInStream, out, 4096, true);
    }
    
}
