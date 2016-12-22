package models.utils

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;

/**
  * Created by king on 2016/12/7.
  */
object XmlFormatter {

  def format(unformattedXml: String):String= {
    val document = parseXmlFile(unformattedXml);
    val format = new OutputFormat(document);
    format.setLineWidth(65);
    format.setIndenting(true);
    format.setIndent(2);
    val out = new StringWriter();
    val serializer = new XMLSerializer(out, format);
    serializer.serialize(document);
     out.toString();
  }

  private def parseXmlFile(in: String): Document = {
    val dbf = DocumentBuilderFactory.newInstance();
    val db = dbf.newDocumentBuilder();
    val is = new InputSource(new StringReader(in));
    db.parse(is);
  }
}
