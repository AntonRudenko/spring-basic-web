package ru.teamlabs.utils.file;

import org.apache.commons.io.FilenameUtils;

/**
 * Created by dark on 20.11.15.
 */
public class PathUtils {

    public static String addPostfix(String path, String postFix) {
        return FilenameUtils.removeExtension(path)
                + postFix
                + "."
                + FilenameUtils.getExtension(path);
    }

    public static String joinFileNames(String firstPath, String secondPath) {
        return FilenameUtils.removeExtension(firstPath)
                + "_"
                + FilenameUtils.getBaseName(secondPath)
                + "."
                + FilenameUtils.getExtension(firstPath);
    }

}
