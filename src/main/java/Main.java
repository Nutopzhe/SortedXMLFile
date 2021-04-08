import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        //путь файла transactions.xml
        String pathToXmlFile = new File("").getAbsolutePath() + "\\transactions.xml";
        //путь до sort.xsl
        String pathToXslFile = new File("").getAbsolutePath() + "\\src\\main\\resources\\sort.xsl";

        sortedTransactionsByAmount(pathToXmlFile, pathToXslFile);
    }

    public static void sortedTransactionsByAmount(String pathToXmlFile, String pathToXslFile) {
        Document dom;
        try {
            //получаем данные из transaction.xml
            dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(pathToXmlFile);

            //сортируем полученные данные согласно написанному стилу в документе sort.xsl
            Transformer transform = TransformerFactory.newInstance().newTransformer(new StreamSource(
                    new File(pathToXslFile)));
            //записываем отсортированные данные обратно в документ transactions.xml
            StreamResult result = new StreamResult(new File(pathToXmlFile));
            transform.transform(new DOMSource(dom), result);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
