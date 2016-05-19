package ru.tonyware.utils.process;

/**
 * Created by dark on 23.11.15.
 */
public class ProcessResult {

    private String output;
    private String errorOutput;

    public ProcessResult(String output, String errorOutput) {
        this.output = output;
        this.errorOutput = errorOutput;
    }

    public String getOutput() {
        return output;
    }

    public String getErrorOutput() {
        return errorOutput;
    }

    @Override
    public String toString() {
        return "ProcessResult{" +
                "output='" + output + '\'' +
                ", errorOutput='" + errorOutput + '\'' +
                '}';
    }
}
