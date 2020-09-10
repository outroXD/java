import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;

@Mojo(name = "countlines")
public class CountlinesMojo extends AbstractMojo {

    @Parameter(required = true)
    private String dir;

    @Parameter(required = true)
    private String ext;

    public void execute() throws MojoExecutionException, MojoFailureException {
        File directory = new File(dir);
        String[] extensions = ext.split(",");

        if (!directory.isDirectory()) {
            throw new MojoFailureException("ディレクトリでないか、または存在しません。");
        }

        CountExecuter executer = new CountExecuter(directory, extensions);

        try {
            executer.count();
        } catch (IOException e) {
            throw new MojoExecutionException(e.getMessage());
        }
    }
}
