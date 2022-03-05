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
        validateParameters(tag);
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
        validateParameters(filePath);
        File dir = new File(filePath);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file: files) {
                deleteFile(file.toString());
            }
        }
        dir.delete();
    }

    public static File getFolderPath(String fileName) {
        validateParameters(fileName);
        File folderPath = new File("./accounts/" + fileName);
        return folderPath;
    }

    public static File getFilePath(String accountNumber, String fileName, String fileType) {
        validateParameters(fileName, fileType);
        if (fileType != "acc" && fileType != "res") {
            throw new IllegalArgumentException("File fileType must be 'acc' or 'res'.");
        }
        File filePath = new File("./accounts/" + accountNumber + "/" + fileType + fileName + ".xml");
            return filePath;
    }

    public static void checkPassingTest(String desire, String result) {
        System.out.println("Expect: " + desire);
        System.out.println("Actual: " + result);
        System.out.println("✅ Test pass: " + result.equals(desire));
    }

    public static String getReservationType(String reservationNumber) {
        if (reservationNumber.contains("CABIN")) {
            return "CABIN";
        } else if (reservationNumber.contains("HOTEL")) {
            return "HOTEL";
        } else {
            return "HOUSE";
        }
    }
}
