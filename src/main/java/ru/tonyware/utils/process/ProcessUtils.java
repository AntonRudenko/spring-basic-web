package ru.tonyware.utils.process;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.tonyware.ProcessResult;
import ru.tonyware.utils.file.PathUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by dark on 20.11.15.
 */
public class ProcessUtils {

    private static final Logger logger = LoggerFactory.getLogger(PathUtils.class);

    public static String singleValueProcess(String... args) {
        try {
            Process process = executeProcess(args);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ProcessResult processWithFullInfo(String... args) {
        Process process = executeProcess(args);

        try {
            ProcessResult result = new ProcessResult(
                    IOUtils.toString(process.getInputStream()),
                    IOUtils.toString(process.getErrorStream())
            );
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void noResultProcess(String... args) {
        executeProcess(args);
    }

    private static Process executeProcess(String[] args){
        try {
            String command = Arrays.stream(args).collect(Collectors.joining(" "));
            logger.warn("Command executed: {}", command);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            if (process.exitValue() != 0) throw new RuntimeException("Wrong exit value. Exit value: " + process.exitValue()
                    + ". Output: " + IOUtils.toString(process.getInputStream())
                    + ". Error output: " + IOUtils.toString(process.getErrorStream()));
            return process;
        }catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
