import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlConverter.convertToPdf(new File("/home/vanminh/Downloads/HDDT_20181113151726456.html"),new File("/home/vanminh/Downloads/test.pdf"));
    }
}
