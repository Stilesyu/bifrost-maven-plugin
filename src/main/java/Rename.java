import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.nio.file.Files;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project:               bifrost-maven-plugin
 * Author:                Stiles yu
 * Created Date:          2020/4/10
 * Description:  add suffix
 * Copyright @ 2020-2020 Stiles yu
 * <p>
 * History:
 * ------------------------------------------------------------------------------
 * Date            |time        |Author    |Change Description
 */

@Mojo(name = "suffix")
public class Rename extends AbstractMojo {

    @Parameter(property = "suffix.path", required = true)
    private String path;
    @Parameter(property = "suffix.isRetainExt", defaultValue = "true")
    private boolean isRetainExt;
    @Parameter(property = "suffix.suffix", required = true)
    private String suffix;
    @Parameter(property = "suffix.regex")
    private String regex;


    public void execute() throws MojoExecutionException {
        File file = new File(path);
        if (!file.exists()) {
            throw new MojoExecutionException("Can't find the file,please check the path");
        }
        File[] files = file.listFiles();
        for (File f : files) {
            String oldFileName = f.getName();
            String newFileName;
            if (null != regex) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(oldFileName);
                if (!matcher.matches()) {
                    continue;
                }
            }
            if (isRetainExt) {
                String[] var = oldFileName.split("\\.");
                if (var.length > 1) {
                    newFileName = var[0] + suffix + var[1];
                } else {
                    newFileName = var[0] + suffix;
                }
                boolean isRename = f.renameTo(new File(path + "/" + newFileName));
                if (!isRename) {
                    throw new MojoExecutionException("Files rename failed,Please send email to yuxiaochen886@gmail.com or committed exception information to Github issues");
                }
                getLog().info(oldFileName + " had been renamed to " + newFileName);
            }
        }

    }




}

