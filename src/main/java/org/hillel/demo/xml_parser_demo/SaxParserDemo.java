package org.hillel.demo.xml_parser_demo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

class DefaultHandlerExt extends DefaultHandler {

    boolean isNameStarted = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document parsing");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document parsing");
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element " + qName + " "+ localName);
        if (qName.equals("name")) {
            this.isNameStarted = true;
        } else {
            this.isNameStarted = false;
        }
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element " + qName + " "+ localName);
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        char [] charsContent = new char[length];
        System.arraycopy(ch, start, charsContent, 0, length);
        if (isNameStarted) {
            System.out.println("User name is " + new String(charsContent));
        }
        super.characters(ch, start, length);
    }
}

public class SaxParserDemo {
    public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        InputStream xmlInputStream = SaxParserDemo.class.getResourceAsStream("test.xml");
        DefaultHandlerExt handler= new DefaultHandlerExt();
        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlInputStream, handler);
    }
}
