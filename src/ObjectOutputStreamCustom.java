import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamCustom extends ObjectOutputStream {
    public ObjectOutputStreamCustom(OutputStream out) throws IOException {
        super(out);
    }

    public ObjectOutputStreamCustom() throws IOException, SecurityException {
    }

    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
