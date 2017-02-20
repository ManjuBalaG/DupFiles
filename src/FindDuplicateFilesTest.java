import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by MAnju on 2/19/17.
 */
public class FindDuplicateFilesTest {
    File folders,f,f1,dupFile;

    @Before
    public void setUp() throws Exception {
          dupFile =new File("/Users/infosys/Documents/myfile.txt");
         folders=new File("/Users/infosys/Documents/test/test1");
        folders.mkdirs();
         f = new File("/Users/infosys/Documents/test/myfile.txt");
        f.createNewFile();
        List<String> lines = new ArrayList();
        lines.add("abc");
        Files.write(f.toPath(), lines);
         f1 = new File("/Users/infosys/Documents/test/test1/myfile.txt");
        f1.createNewFile();
        Files.write(f1.toPath(), lines);


    }


    @After
    public void tearDown() throws Exception {
        dupFile.getParentFile().deleteOnExit();
        dupFile.deleteOnExit();
        f1.delete();
        f.deleteOnExit();
        folders.deleteOnExit();


    }

    @Test
    public void testUsingimproperFile() throws Exception {
        Map<FileDes,List<String>> list = FindDuplicateFiles.findDup("test");
        assertTrue("EmptyMap",list.isEmpty());

    }

    @Test
    public void testUsingTempFolder() throws IOException {
        //FindDuplicateFiles
        Map<FileDes,List<String>> lists = FindDuplicateFiles.findDup("/Users/infosys/Documents/test/");
        FileDes fi1= new FileDes(f.getName(),f.length());
        ArrayList<String > a = new ArrayList<>();
        a.add("/Users/infosys/Documents/test/myfile.txt");
        a.add("/Users/infosys/Documents/test/test1/myfile.txt");
        assertTrue("Same",lists.get(fi1).contains(a.get(0).toString()));

}
}