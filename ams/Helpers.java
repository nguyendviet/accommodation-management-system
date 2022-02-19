package ams;
import org.w3c.dom.Document;
/**
 * This class contains helper methods
 */
public class Helpers {
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
}
