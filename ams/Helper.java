package ams;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.StringReader;
import org.w3c.dom.Document;
/**
 * This class contains helper methods
 */
public class Helper {
    // Validate parameters if any is null or an empty string
    public static void validateParameters(String ...parameters) {
        for (String parameter : parameters) {
            if (parameter == null || parameter.length() == 0) {
                throw new IllegalArgumentException("Parameters cannot be null or empty.");
            }
        }
    }

    public static String getValueFromTag(String tag, Document doc) {
        return doc.getElementsByTagName(tag).item(0).getTextContent();
    }

    public static String beautifyXml(String input, int indent) {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
            Transformer transformer = transformerFactory.newTransformer(); 
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // New line for tags
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            // Remove header
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFile(String filePath) {
        File dir = new File(filePath);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file: files) {
                deleteFile(file.toString());
            }
        }
        dir.delete();
    }
}
