import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project:               bifrost-maven-plugin
 * Author:                Stiles yu
 * Created Date:          2020/4/10
 * Description:
 * Copyright @ 2020-2020 Stiles yu
 * <p>
 * History:
 * ------------------------------------------------------------------------------
 * Date            |time        |Author    |Change Description
 */

@Mojo(name = "readOnly")
public class ReadOnly extends AbstractMojo {
    @Parameter(property = "readOnly.isReadOnly", required = true)
    private boolean isReadOnly;
    @Parameter(property = "suffix.path", required = true)
    private String path;
    @Parameter(property = "suffix.regex")
    private String regex;

    @Override
    public void execute() throws MojoExecutionException {
        if (isReadOnly) {
            File file = new File(path);
            if (!file.exists()) {
                throw new MojoExecutionException("Can't find any files,please check your path");
            }
            File[] files = file.listFiles();
            assert files != null;
            for (File f : files) {
                if (!(null == regex || "".equals(regex.trim()))) {
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(f.getName());
                    if (!matcher.matches()) {
                        continue;
                    }
                    boolean readOnlySetSuccess = f.setReadOnly();
                    if (readOnlySetSuccess) {
                        getLog().info(f.getName() + " set " + (readOnlySetSuccess ? "success" : "failure"));
                    }
                }
            }
        }
    }
}
