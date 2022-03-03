package structs;

import enums.ProcessType;

public class Processor implements Runnable{
    String          fileNameOriginal, fileNameNew;
    Image           original;
    Image           edited;
    ProcessType type;

    public Processor(String _fileNameOriginal, String _fileNameNew, ProcessType _type) {
        fileNameOriginal = _fileNameOriginal;
        fileNameNew = _fileNameNew;
        type = _type;
    }
    @Override
    public void run() {
        original        = new Image(fileNameOriginal);
        edited          = new Image(fileNameNew, original.getColorStorage(), type);
    }
}
