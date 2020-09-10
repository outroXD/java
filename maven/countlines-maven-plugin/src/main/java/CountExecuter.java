import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

/**
 * <!--<plugin>
 * <!-- here artifact description -->
 * <executions>
 *     <execution>
 *         <phase>test</phase>
 *         <goals>
 *             <goal>countlines</goal>
 *         </goals>
 *         <configuration>
 *             <dir>dir</dir>
 *             <ext>jsp</ext>
 *         </configuration>
 *     </execution>
 * </executions>
 * </plugin>-->
 */
public class CountExecuter {
    private File directory;
    private String[] extensions;

    public CountExecuter(File directory, String[] extensions) {
        this.directory = directory;
        this.extensions = extensions;
    }

    public void count() throws IOException {
        Collection<File> files = FileUtils.listFiles(directory, extensions, true);
        int count = 0;
        if (!files.isEmpty()) {
            for (File file : files) {
                count += countLines(file);
            }
        }
    }

    private int countLines(File file) throws IOException {
        int linenum = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                linenum++;
            }
        } finally {
            IOUtils.closeQuietly(bufferedReader);
            IOUtils.closeQuietly(fileReader);
        }

        return linenum;
    }
}
