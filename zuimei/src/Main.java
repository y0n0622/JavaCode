import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

public class Main {

    public static void main(String[] args) {

        byte [] hexData = {
            0x48, 0x34, 0x73, 0x49, 0x41, 0x41, 0x41, 0x41, 0x41, 0x41, 0x41, 0x41, 0x41, 0x4F, 0x31, 0x59,
                    0x57, 0x32, 0x73, 0x63, 0x4E, 0x78, 0x54, 0x2B, 0x4C, 0x77, 0x76, 0x32, 0x6B, 0x37, 0x30, 0x72,
                    0x61, 0x65, 0x34, 0x4A, 0x4A, 0x72, 0x6A, 0x65, 0x6D, 0x4C, 0x69, 0x32, 0x45, 0x36, 0x64, 0x32,
                    0x30, 0x35, 0x42, 0x51, 0x42, 0x75, 0x32, 0x4D, 0x5A, 0x6C, 0x66, 0x32, 0x33, 0x44, 0x4B, 0x6A,
                    0x76, 0x54, 0x67, 0x68, 0x55, 0x43, 0x69, 0x42, 0x55, 0x6B, 0x70, 0x70, 0x6F, 0x4E, 0x43, 0x58,
                    0x76, 0x6A, 0x52, 0x39, 0x36, 0x55, 0x4D, 0x66, 0x6D, 0x6A, 0x36, 0x55, 0x4E, 0x4F, 0x54, 0x6E,
                    0x32, 0x47, 0x6E, 0x79, 0x4C, 0x33, 0x6F, 0x30, 0x6F, 0x78, 0x6D, 0x50, 0x33, 0x61, 0x57, 0x78,
                    0x47, 0x38, 0x66, 0x46, 0x78, 0x73, 0x76, 0x43, 0x36, 0x68, 0x78, 0x4A, 0x5A, 0x34, 0x35, 0x30,
                    0x4C, 0x74, 0x2B, 0x33, 0x38, 0x36, 0x69, 0x56, 0x73, 0x32, 0x7A, 0x45, 0x73, 0x69, 0x34, 0x56,
                    0x72, 0x48, 0x57, 0x6C, 0x68, 0x55, 0x32, 0x6B, 0x45, 0x30, 0x66, 0x54, 0x62, 0x52, 0x4F, 0x5A,
                    0x65, 0x6D, 0x75, 0x75, 0x46, 0x62, 0x4F, 0x4A, 0x32, 0x4B, 0x42, 0x39, 0x4F, 0x51, 0x56, 0x53,
                    0x79, 0x48, 0x4F, 0x78, 0x36, 0x4F, 0x65, 0x74, 0x4B, 0x2F, 0x63, 0x66, 0x74, 0x61, 0x69, 0x2F,
                    0x34, 0x73, 0x73, 0x4E, 0x43, 0x47, 0x6B, 0x47, 0x67, 0x54, 0x6E, 0x42, 0x52, 0x53, 0x69, 0x58,
                    0x37, 0x62, 0x31, 0x36, 0x2B, 0x76, 0x61, 0x48, 0x33, 0x2F, 0x64, 0x2F, 0x65, 0x62, 0x37, 0x33,
                    0x35, 0x33, 0x65, 0x56, 0x6D, 0x70, 0x54, 0x62, 0x66, 0x5A, 0x5A, 0x37, 0x4D, 0x43, 0x72, 0x6E,
                    0x2F, 0x6E, 0x72, 0x35, 0x62, 0x50, 0x2B, 0x62, 0x4A, 0x36, 0x43, 0x6C, 0x61, 0x62, 0x72, 0x4A,
                    0x48, 0x36, 0x6F, 0x6E, 0x65, 0x44, 0x54, 0x32, 0x51, 0x72, 0x62, 0x69, 0x4A, 0x58, 0x45, 0x70,
                    0x35, 0x30, 0x6B, 0x6D, 0x35, 0x46, 0x50, 0x6B, 0x56, 0x4D, 0x61, 0x6F, 0x34, 0x43, 0x4F, 0x32,
                    0x74, 0x5A, 0x73, 0x79, 0x70, 0x61, 0x4A, 0x2B, 0x6E, 0x6C, 0x4B, 0x50, 0x46, 0x59, 0x34, 0x59,
                    0x63, 0x6B, 0x6E, 0x49, 0x76, 0x5A, 0x31, 0x50, 0x73, 0x78, 0x44, 0x45, 0x67, 0x52, 0x42, 0x70,
                    0x66, 0x71, 0x58, 0x54, 0x59, 0x58, 0x47, 0x66, 0x78, 0x36, 0x77, 0x74, 0x68, 0x6A, 0x79, 0x6A,
                    0x76, 0x52, 0x34, 0x58, 0x62, 0x53, 0x2B, 0x4A, 0x4F, 0x6A, 0x7A, 0x32, 0x32, 0x61, 0x52, 0x44,
                    0x50, 0x54, 0x44, 0x48, 0x78, 0x65, 0x34, 0x31, 0x38, 0x47, 0x43, 0x56, 0x37, 0x53, 0x37, 0x6F,
                    0x5A, 0x72, 0x59, 0x59, 0x44, 0x53, 0x63, 0x62, 0x61, 0x33, 0x66, 0x70, 0x6C, 0x75, 0x33, 0x63,
                    0x76, 0x57, 0x48, 0x65, 0x57, 0x39, 0x33, 0x77, 0x72, 0x6F, 0x38, 0x47, 0x65, 0x50, 0x50, 0x75,
                    0x39, 0x69, 0x77, 0x38, 0x4B, 0x6B, 0x7A, 0x45, 0x69, 0x72, 0x2B, 0x67, 0x45, 0x63, 0x50, 0x41,
                    0x47, 0x6A, 0x79, 0x4D, 0x78, 0x34, 0x4A, 0x6C, 0x30, 0x6B, 0x59, 0x53, 0x4E, 0x31, 0x78, 0x69,
                    0x6B, 0x78, 0x53, 0x65, 0x56, 0x43, 0x68, 0x35, 0x70, 0x47, 0x34, 0x55, 0x37, 0x6C, 0x4E, 0x48,
                    0x78, 0x51, 0x63, 0x57, 0x52, 0x4A, 0x53, 0x48, 0x35, 0x64, 0x6E, 0x53, 0x51, 0x52, 0x4B, 0x72,
                    0x59, 0x30, 0x64, 0x35, 0x76, 0x78, 0x78, 0x77, 0x4F, 0x50, 0x6C, 0x6D, 0x35, 0x6A, 0x55, 0x4F,
                    0x4D, 0x42, 0x68, 0x54, 0x76, 0x2F, 0x31, 0x77, 0x43, 0x4D, 0x61, 0x34, 0x34, 0x44, 0x52, 0x2B,
                    0x77, 0x49, 0x73, 0x54, 0x45, 0x49, 0x52, 0x77, 0x5A, 0x38, 0x78, 0x6F, 0x77, 0x45, 0x50, 0x57,
                    0x36, 0x66, 0x63, 0x37, 0x4B, 0x66, 0x64, 0x41, 0x42, 0x31, 0x71, 0x62, 0x57, 0x42, 0x31, 0x73,
                    0x4F, 0x4C, 0x59, 0x68, 0x2F, 0x54, 0x53, 0x49, 0x36, 0x62, 0x54, 0x37, 0x50, 0x4A, 0x43, 0x47,
                    0x49, 0x34, 0x6A, 0x69, 0x42, 0x37, 0x57, 0x38, 0x37, 0x68, 0x74, 0x67, 0x6E, 0x50, 0x56, 0x59,
                    0x59, 0x42, 0x44, 0x62, 0x4E, 0x78, 0x6B, 0x69, 0x58, 0x75, 0x41, 0x51, 0x57, 0x79, 0x4E, 0x61,
                    0x34, 0x44, 0x76, 0x4D, 0x39, 0x45, 0x7A, 0x66, 0x74, 0x4F, 0x78, 0x65, 0x73, 0x61, 0x48, 0x2F,
                    0x47, 0x66, 0x66, 0x46, 0x41, 0x46, 0x59, 0x37, 0x5A, 0x69, 0x6E, 0x66, 0x59, 0x4C, 0x77, 0x2F,
                    0x6B, 0x49, 0x47, 0x32, 0x55, 0x5A, 0x6B, 0x52, 0x47, 0x39, 0x54, 0x62, 0x71, 0x64, 0x4D, 0x4F,
                    0x35, 0x44, 0x73, 0x73, 0x79, 0x33, 0x6D, 0x56, 0x46, 0x41, 0x66, 0x79, 0x55, 0x75, 0x4A, 0x58,
                    0x69, 0x52, 0x50, 0x53, 0x50, 0x4C, 0x39, 0x4A, 0x49, 0x79, 0x57, 0x4F, 0x65, 0x58, 0x77, 0x7A,
                    0x45, 0x64, 0x78, 0x6A, 0x5A, 0x54, 0x62, 0x49, 0x77, 0x49, 0x78, 0x59, 0x4C, 0x46, 0x53, 0x67,
                    0x6D, 0x67, 0x76, 0x57, 0x57, 0x65, 0x48, 0x4A, 0x6B, 0x54, 0x30, 0x62, 0x4E, 0x49, 0x75, 0x4F,
                    0x5A, 0x75, 0x52, 0x47, 0x58, 0x71, 0x64, 0x69, 0x72, 0x53, 0x73, 0x50, 0x50, 0x59, 0x38, 0x50,
                    0x51, 0x6E, 0x65, 0x43, 0x61, 0x34, 0x41, 0x44, 0x33, 0x68, 0x49, 0x44, 0x6C, 0x71, 0x6E, 0x51,
                    0x31, 0x33, 0x4A, 0x70, 0x51, 0x71, 0x59, 0x46, 0x48, 0x45, 0x2B, 0x36, 0x6A, 0x77, 0x37, 0x4D,
                    0x72, 0x33, 0x48, 0x70, 0x78, 0x66, 0x30, 0x69, 0x69, 0x42, 0x44, 0x44, 0x59, 0x65, 0x70, 0x44,
                    0x34, 0x52, 0x34, 0x33, 0x69, 0x74, 0x6A, 0x47, 0x42, 0x4E, 0x73, 0x51, 0x52, 0x64, 0x33, 0x41,
                    0x79, 0x45, 0x44, 0x45, 0x31, 0x47, 0x33, 0x53, 0x54, 0x75, 0x4D, 0x2B, 0x6D, 0x44, 0x38, 0x4E,
                    0x65, 0x34, 0x62, 0x6C, 0x59, 0x4C, 0x32, 0x77, 0x39, 0x7A, 0x6C, 0x55, 0x37, 0x71, 0x6A, 0x66,
                    0x63, 0x46, 0x64, 0x71, 0x5A, 0x50, 0x65, 0x34, 0x58, 0x6B, 0x51, 0x42, 0x79, 0x6D, 0x59, 0x48,
                    0x74, 0x48, 0x4B, 0x56, 0x4B, 0x45, 0x38, 0x36, 0x34, 0x6A, 0x35, 0x4C, 0x56, 0x4D, 0x6E, 0x76,
                    0x38, 0x46, 0x54, 0x64, 0x63, 0x38, 0x37, 0x67, 0x30, 0x4C, 0x4C, 0x66, 0x74, 0x47, 0x54, 0x42,
                    0x70, 0x53, 0x7A, 0x7A, 0x59, 0x48, 0x65, 0x35, 0x61, 0x72, 0x4A, 0x62, 0x74, 0x61, 0x53, 0x49,
                    0x4B, 0x31, 0x56, 0x5A, 0x69, 0x36, 0x71, 0x32, 0x61, 0x45, 0x61, 0x6A, 0x38, 0x68, 0x45, 0x38,
                    0x58, 0x2F, 0x53, 0x56, 0x76, 0x58, 0x47, 0x56, 0x5A, 0x6B, 0x58, 0x76, 0x75, 0x4A, 0x56, 0x78,
                    0x36, 0x41, 0x31, 0x71, 0x79, 0x6D, 0x63, 0x73, 0x58, 0x65, 0x50, 0x78, 0x54, 0x6A, 0x6C, 0x5A,
                    0x58, 0x73, 0x4E, 0x42, 0x42, 0x65, 0x73, 0x59, 0x45, 0x38, 0x31, 0x78, 0x48, 0x43, 0x51, 0x37,
                    0x48, 0x63, 0x38, 0x2F, 0x59, 0x57, 0x6E, 0x5A, 0x6C, 0x34, 0x72, 0x41, 0x35, 0x4D, 0x74, 0x38,
                    0x77, 0x76, 0x78, 0x61, 0x36, 0x72, 0x4B, 0x41, 0x44, 0x73, 0x4E, 0x71, 0x74, 0x6D, 0x68, 0x4A,
                    0x47, 0x37, 0x58, 0x6E, 0x71, 0x44, 0x37, 0x56, 0x59, 0x56, 0x32, 0x53, 0x73, 0x72, 0x67, 0x4C,
                    0x4C, 0x6F, 0x53, 0x6C, 0x43, 0x30, 0x55, 0x2B, 0x35, 0x52, 0x38, 0x56, 0x31, 0x36, 0x53, 0x45,
                    0x70, 0x54, 0x44, 0x4A, 0x57, 0x53, 0x31, 0x74, 0x71, 0x57, 0x35, 0x62, 0x53, 0x70, 0x73, 0x44,
                    0x6D, 0x6C, 0x56, 0x53, 0x4C, 0x73, 0x66, 0x56, 0x64, 0x43, 0x55, 0x33, 0x47, 0x71, 0x6F, 0x55,
                    0x75, 0x32, 0x55, 0x6A, 0x4C, 0x74, 0x6F, 0x56, 0x4E, 0x4C, 0x47, 0x59, 0x51, 0x70, 0x49, 0x39,
                    0x4B, 0x6D, 0x50, 0x67, 0x52, 0x6C, 0x58, 0x79, 0x70, 0x53, 0x48, 0x64, 0x64, 0x55, 0x74, 0x66,
                    0x6C, 0x53, 0x4A, 0x4A, 0x44, 0x38, 0x6C, 0x68, 0x41, 0x6F, 0x6F, 0x67, 0x70, 0x4B, 0x70, 0x31,
                    0x6A, 0x52, 0x49, 0x6F, 0x6E, 0x59, 0x5A, 0x4D, 0x66, 0x56, 0x66, 0x6D, 0x37, 0x49, 0x48, 0x42,
                    0x53, 0x6A, 0x46, 0x57, 0x78, 0x64, 0x39, 0x51, 0x44, 0x52, 0x71, 0x42, 0x67, 0x63, 0x52, 0x78,
                    0x51, 0x31, 0x34, 0x6C, 0x52, 0x70, 0x6F, 0x42, 0x4E, 0x72, 0x68, 0x5A, 0x69, 0x55, 0x37, 0x79,
                    0x50, 0x70, 0x4E, 0x68, 0x4C, 0x46, 0x77, 0x2F, 0x47, 0x61, 0x76, 0x7A, 0x54, 0x4B, 0x4A, 0x65,
                    0x4F, 0x52, 0x41, 0x30, 0x33, 0x33, 0x47, 0x35, 0x63, 0x6F, 0x33, 0x6E, 0x62, 0x6A, 0x35, 0x49,
                    0x78, 0x6B, 0x30, 0x54, 0x38, 0x56, 0x41, 0x56, 0x39, 0x4D, 0x53, 0x62, 0x75, 0x4D, 0x4E, 0x71,
                    0x6F, 0x52, 0x53, 0x67, 0x6E, 0x64, 0x52, 0x69, 0x31, 0x48, 0x4F, 0x6A, 0x75, 0x71, 0x63, 0x55,
                    0x45, 0x6F, 0x53, 0x53, 0x70, 0x36, 0x48, 0x4B, 0x4E, 0x70, 0x48, 0x52, 0x45, 0x51, 0x75, 0x58,
                    0x41, 0x44, 0x54, 0x57, 0x61, 0x67, 0x2F, 0x6C, 0x67, 0x31, 0x79, 0x46, 0x55, 0x77, 0x55, 0x73,
                    0x41, 0x4C, 0x59, 0x30, 0x44, 0x6C, 0x44, 0x65, 0x61, 0x73, 0x43, 0x7A, 0x58, 0x4C, 0x68, 0x51,
                    0x4E, 0x63, 0x66, 0x72, 0x76, 0x2F, 0x55, 0x2B, 0x36, 0x47, 0x6F, 0x6E, 0x32, 0x31, 0x62, 0x64,
                    0x36, 0x50, 0x41, 0x51, 0x43, 0x76, 0x37, 0x62, 0x6E, 0x73, 0x65, 0x50, 0x35, 0x35, 0x70, 0x6F,
                    0x62, 0x69, 0x4B, 0x6A, 0x69, 0x65, 0x59, 0x76, 0x66, 0x39, 0x31, 0x37, 0x38, 0x65, 0x4E, 0x30,
                    0x48, 0x4B, 0x2F, 0x6E, 0x54, 0x67, 0x6E, 0x42, 0x48, 0x57, 0x73, 0x36, 0x68, 0x48, 0x75, 0x65,
                    0x4E, 0x7A, 0x39, 0x70, 0x62, 0x2F, 0x75, 0x46, 0x7A, 0x37, 0x43, 0x2B, 0x34, 0x34, 0x58, 0x58,
                    0x30, 0x69, 0x54, 0x6E, 0x2F, 0x67, 0x4B, 0x47, 0x6B, 0x70, 0x77, 0x64, 0x4C, 0x56, 0x6A, 0x49,
                    0x6D, 0x68, 0x33, 0x47, 0x55, 0x50, 0x75, 0x75, 0x31, 0x45, 0x6D, 0x63, 0x4A, 0x5A, 0x70, 0x6D,
                    0x36, 0x37, 0x4D, 0x51, 0x31, 0x67, 0x58, 0x69, 0x49, 0x47, 0x64, 0x57, 0x30, 0x4C, 0x36, 0x63,
                    0x77, 0x59, 0x35, 0x70, 0x6D, 0x4C, 0x4D, 0x2B, 0x39, 0x79, 0x45, 0x6C, 0x46, 0x31, 0x78, 0x33,
                    0x5A, 0x66, 0x33, 0x36, 0x69, 0x75, 0x76, 0x4F, 0x63, 0x6A, 0x2B, 0x67, 0x53, 0x74, 0x46, 0x64,
                    0x58, 0x67, 0x51, 0x46, 0x4C, 0x46, 0x43, 0x7A, 0x6A, 0x52, 0x56, 0x71, 0x57, 0x69, 0x30, 0x52,
                    0x79, 0x55, 0x4C, 0x68, 0x33, 0x59, 0x79, 0x32, 0x4F, 0x45, 0x4F, 0x57, 0x34, 0x54, 0x73, 0x77,
                    0x32, 0x70, 0x46, 0x79, 0x45, 0x61, 0x51, 0x65, 0x37, 0x62, 0x47, 0x77, 0x79, 0x33, 0x64, 0x68,
                    0x65, 0x49, 0x38, 0x4E, 0x63, 0x2F, 0x69, 0x35, 0x45, 0x32, 0x51, 0x32, 0x74, 0x6C, 0x66, 0x74,
                    0x32, 0x36, 0x61, 0x7A, 0x4C, 0x63, 0x6A, 0x36, 0x41, 0x35, 0x62, 0x66, 0x35, 0x4B, 0x75, 0x33,
                    0x74, 0x7A, 0x34, 0x65, 0x47, 0x57, 0x73, 0x77, 0x57, 0x2B, 0x52, 0x4D, 0x65, 0x79, 0x43, 0x69,
                    0x63, 0x45, 0x5A, 0x62, 0x68, 0x67, 0x67, 0x6D, 0x2F, 0x6F, 0x7A, 0x57, 0x78, 0x54, 0x50, 0x45,
                    0x4C, 0x41, 0x77, 0x74, 0x44, 0x57, 0x67, 0x63, 0x4D, 0x35, 0x6A, 0x71, 0x43, 0x69, 0x45, 0x49,
                    0x61, 0x4C, 0x31, 0x61, 0x73, 0x65, 0x33, 0x50, 0x52, 0x7A, 0x6E, 0x47, 0x76, 0x6A, 0x65, 0x66,
                    0x50, 0x34, 0x79, 0x32, 0x35, 0x32, 0x6B, 0x59, 0x6E, 0x6F, 0x69, 0x59, 0x36, 0x4A, 0x70, 0x47,
                    0x37, 0x4C, 0x4D, 0x68, 0x4A, 0x68, 0x69, 0x44, 0x76, 0x6D, 0x43, 0x58, 0x6D, 0x71, 0x56, 0x62,
                    0x6A, 0x6D, 0x46, 0x57, 0x77, 0x50, 0x50, 0x65, 0x78, 0x4F, 0x53, 0x64, 0x6C, 0x68, 0x55, 0x69,
                    0x36, 0x79, 0x59, 0x44, 0x34, 0x44, 0x56, 0x4D, 0x6E, 0x79, 0x4C, 0x64, 0x30, 0x69, 0x7A, 0x41,
                    0x50, 0x6F, 0x61, 0x52, 0x31, 0x61, 0x4E, 0x55, 0x4A, 0x38, 0x7A, 0x71, 0x47, 0x59, 0x65, 0x4A,
                    0x43, 0x63, 0x48, 0x57, 0x45, 0x57, 0x5A, 0x43, 0x64, 0x50, 0x75, 0x43, 0x55, 0x4A, 0x50, 0x6A,
                    0x58, 0x4D, 0x54, 0x37, 0x55, 0x4A, 0x4F, 0x7A, 0x51, 0x76, 0x39, 0x35, 0x44, 0x61, 0x4F, 0x35,
                    0x65, 0x5A, 0x75, 0x67, 0x71, 0x2F, 0x58, 0x6F, 0x37, 0x41, 0x67, 0x42, 0x4A, 0x4A, 0x74, 0x46,
                    0x6B, 0x4F, 0x58, 0x6F, 0x6C, 0x34, 0x52, 0x67, 0x4B, 0x69, 0x46, 0x41, 0x52, 0x78, 0x6B, 0x42,
                    0x75, 0x71, 0x51, 0x45, 0x35, 0x35, 0x63, 0x53, 0x61, 0x41, 0x31, 0x4B, 0x67, 0x50, 0x65, 0x66,
                    0x66, 0x50, 0x6E, 0x36, 0x36, 0x32, 0x64, 0x76, 0x2F, 0x6E, 0x69, 0x79, 0x2F, 0x38, 0x57, 0x72,
                    0x2F, 0x61, 0x39, 0x65, 0x6C, 0x50, 0x2F, 0x69, 0x70, 0x2F, 0x43, 0x44, 0x36, 0x51, 0x76, 0x2F,
                    0x4B, 0x31, 0x6C, 0x41, 0x52, 0x39, 0x68, 0x43, 0x30, 0x59, 0x34, 0x76, 0x32, 0x63, 0x4C, 0x46,
                    0x5A, 0x77, 0x73, 0x47, 0x66, 0x4A, 0x48, 0x54, 0x33, 0x6B, 0x35, 0x50, 0x6E, 0x53, 0x31, 0x4D,
                    0x74, 0x56, 0x77, 0x69, 0x58, 0x49, 0x42, 0x31, 0x70, 0x47, 0x48, 0x57, 0x38, 0x2B, 0x79, 0x41,
                    0x65, 0x43, 0x78, 0x67, 0x7A, 0x41, 0x34, 0x38, 0x79, 0x42, 0x2F, 0x34, 0x4D, 0x75, 0x77, 0x46,
                    0x6C, 0x6E, 0x57, 0x59, 0x4C, 0x56, 0x67, 0x46, 0x38, 0x6A, 0x54, 0x5A, 0x41, 0x6A, 0x62, 0x4E,
                    0x43, 0x2F, 0x49, 0x6D, 0x34, 0x31, 0x67, 0x33, 0x63, 0x52, 0x37, 0x6F, 0x41, 0x6A, 0x48, 0x52,
                    0x6E, 0x49, 0x48, 0x73, 0x71, 0x2B, 0x72, 0x33, 0x62, 0x4B, 0x6D, 0x43, 0x34, 0x57, 0x67, 0x32,
                    0x76, 0x71, 0x51, 0x4B, 0x6C, 0x31, 0x54, 0x68, 0x67, 0x6C, 0x4D, 0x46, 0x59, 0x6C, 0x73, 0x4E,
                    0x71, 0x76, 0x44, 0x36, 0x74, 0x2B, 0x2F, 0x66, 0x50, 0x50, 0x2F, 0x70, 0x37, 0x63, 0x2F, 0x66,
                    0x37, 0x72, 0x31, 0x38, 0x4F, 0x70, 0x30, 0x6A, 0x48, 0x46, 0x6C, 0x78, 0x53, 0x6D, 0x38, 0x53,
                    0x63, 0x50, 0x47, 0x65, 0x62, 0x67, 0x6F, 0x35, 0x41, 0x49, 0x44, 0x36, 0x35, 0x30, 0x48, 0x47,
                    0x72, 0x4E, 0x66, 0x4A, 0x49, 0x55, 0x58, 0x43, 0x6B, 0x41, 0x76, 0x57, 0x4F, 0x55, 0x44, 0x58,
                    0x45, 0x34, 0x48, 0x6A, 0x57, 0x62, 0x37, 0x6A, 0x4E, 0x34, 0x6B, 0x6A, 0x33, 0x38, 0x52, 0x72,
                    0x4F, 0x72, 0x46, 0x31, 0x57, 0x7A, 0x65, 0x30, 0x55, 0x2F, 0x73, 0x72, 0x2F, 0x55, 0x37, 0x4C,
                    0x5A, 0x54, 0x38, 0x6E, 0x70, 0x67, 0x30, 0x6B, 0x49, 0x71, 0x43, 0x6D, 0x36, 0x58, 0x6D, 0x4F,
                    0x6F, 0x54, 0x75, 0x73, 0x5A, 0x33, 0x71, 0x45, 0x45, 0x6F, 0x6F, 0x41, 0x54, 0x34, 0x6D, 0x6C,
                    0x6F, 0x38, 0x50, 0x67, 0x69, 0x49, 0x74, 0x65, 0x65, 0x77, 0x67, 0x63, 0x30, 0x51, 0x58, 0x35,
                    0x4B, 0x33, 0x32, 0x73, 0x69, 0x7A, 0x67, 0x32, 0x4E, 0x6C, 0x72, 0x2F, 0x48, 0x7A, 0x61, 0x65,
                    0x47, 0x52, 0x67, 0x53, 0x68, 0x7A, 0x67, 0x36, 0x45, 0x45, 0x6E, 0x74, 0x45, 0x67, 0x7A, 0x50,
                    0x43, 0x52, 0x68, 0x2B, 0x59, 0x50, 0x77, 0x37, 0x68, 0x34, 0x41, 0x48, 0x70, 0x5A, 0x43, 0x4A,
                    0x65, 0x4C, 0x31, 0x71, 0x35, 0x7A, 0x42, 0x57, 0x44, 0x51, 0x71, 0x31, 0x48, 0x76, 0x38, 0x4E,
                    0x49, 0x35, 0x65, 0x63, 0x50, 0x6B, 0x38, 0x66, 0x41, 0x41, 0x41, 0x3D
        };




//        String str3 = strDecodeUnGzip(a("https://ad.zuimeitianqi.com/AdvertisServer/adserverfilter/", new String("H4sIAAAAAAAAAI1TTU/jMBD9K1ZPIIUSJ85Xe4IgLYiURpRlL7249hQs3Dhy0u7Cav/7jp0UWInDRpGSGc/Mm3nz/HtyD52ZzCZJlgY0jNgkmEg4KAE3Er0sCYcnKlgeh3goQOu95tYfn1H07DsYLPzvhAVorqDpVP+KLjqNhnyWpXmc0STHoA3ve7CvFRxAY4yr+rZTHm6bsiLPQpmKWKScRTHPt4XMkoiykEnXHG9bD+ayuOxaPnaaBFEYUJoHRRYUecByNw3GLFcPry1ggDPKZw/IQhp9pK/UGwzdG67GOY5TVlwcx5TDUFf1jZurcAWu4PCpOFp3fOcs07bmnrok3khrlPQdbugWRJoW2zxLU+6IKLWCpn8Ei6c7s1Ea0Gm7TjnMJEFD7UB9uYY76EdoB1MZwXtlmnJg3Sf6KizFpLiI4qhAZNflpcWe8GRZ10s0v6sv1nwW/vu4el2932glRkA3q/nPxNI0DYgeRmq1aZ5Uv5cj51zWXLzwJ6hU1w+u2hpRGh9AsXv0rMx2pCmdhskU5YS6QmUVfsXCGCtVw3sYKXEpO7+5MJ+F4SzKZpt8licz8IpowXq2jvx4lbyXn9JP+x8LerG143ad5Dl+F+ZNac3X59gQOalUs/81JxfDwokvNCdOCQSlQC73Ssv1+SOj2c39nPw8nJKLttXwAza3qscacTaNU3Jye/2wqAKi1QuQbyBezCnBzjrsdn3OEKd8tmYHGB8hQJSxeIoUkYUXD1nxLbfqWMxxjXN+UF1xN3J5/X5Pl9bp78iF12u7GHiLHG+fXsfJs64taMPl+x368xe/OuUePwQAAA==".getBytes()), 0));
//        byte [] test = {}
        String str3 = strDecodeUnGzip(hexData);

        System.out.println(str3);

    }
//    public static byte[] a(String arg5, String arg6, int arg7) {
//        byte[] v6_1;
//        HttpURLConnection v0;
////        ac.b("URLConnectionOpertion", "httpPostData url:" + arg5 + " content: " + arg6, new Object[0]);
////        if(ap.c(arg5)) {
////            ac.b("URLConnectionOpertion", "httpPostData param error", new Object[0]);
////            return null;
////        }
//
//        try {
//            v0 = (HttpURLConnection)new URL(arg5).openConnection();
//            if(arg7 <= 0) {
//                arg7 = 10000;
//            }
//
//            v0.addRequestProperty("Cache-Control", "no-cache");
//        }
//        catch(MalformedURLException v5) {
//            v5.printStackTrace();
//            return null;
//        }
//        catch(ProtocolException v5_1) {
//            v5_1.printStackTrace();
//            return null;
//        }
//        catch(Exception v5_2) {
//            v5_2.printStackTrace();
//            return null;
//        }
//
//        try {
//            v0.setRequestProperty("Content-Type", "application/x-protobuf;charset=utf-8");
//            String v3_1 = System.getProperty("http.agent");
//            if(!v3_1.isEmpty()) {
//                v0.setRequestProperty("User-Agent", v3_1);
//            }
//
////            goto label_44;
//            v0.setConnectTimeout(arg7);
//            v0.setReadTimeout(arg7);
//            v0.setRequestMethod("POST");
//            v0.setDoOutput(true);
//            v0.setDoInput(true);
//            PrintWriter v7 = new PrintWriter(v0.getOutputStream());
//            v7.write(arg6);
//            v7.flush();
//        }
//        catch(Exception v3) {
//            return null;
//        }
////        catch(MalformedURLException v5) {
////            v5.printStackTrace();
////            return null;
////        }
////        catch(ProtocolException v5_1) {
////            v5_1.printStackTrace();
////            return null;
////        }
//
////        try {
//////            v3.printStackTrace();
//////            label_44:
////
////        }
////        catch(MalformedURLException v5) {
////            v5.printStackTrace();
////            return null;
////        }
////        catch(ProtocolException v5_1) {
////            v5_1.printStackTrace();
////            return null;
////        }
////        catch(Exception v5_2) {
////            v5_2.printStackTrace();
////            return null;
////        }
//
////        try {
//////            ac.b("URLConnectionOpertion", "httpPostData statusCode: " + v0.getResponseCode() + " url:" + arg5, new Object[0]);
////        }
////        catch(Exception unused_ex) {
////        }
////        catch(MalformedURLException v5) {
////            v5.printStackTrace();
////            return null;
////        }
////        catch(ProtocolException v5_1) {
////            v5_1.printStackTrace();
////            return null;
////        }
//
//        try {
//            BufferedInputStream v6 = new BufferedInputStream(v0.getInputStream());
//            ByteArrayOutputStream v7_1 = new ByteArrayOutputStream();
//            byte[] v0_1 = new byte[0x400];
//            while(true) {
//                int v3_2 = v6.read(v0_1);
//                if(v3_2 == -1) {
//                    break;
//                }
//
//                v7_1.write(v0_1, 0, v3_2);
//                v7_1.flush();
//            }
//
//            v7_1.close();
//            v6_1 = v7_1.toByteArray();
//        }
//        catch(MalformedURLException v5) {
//            v5.printStackTrace();
//            return null;
//        }
//        catch(ProtocolException v5_1) {
//            v5_1.printStackTrace();
//            return null;
//        }
//        catch(Exception v5_2) {
//            v5_2.printStackTrace();
//            return null;
//        }
//
////        try {
////            ac.b("URLConnectionOpertion", "httpPostData resp: " + new String(v6_1) + " url:" + arg5, new Object[0]);
////            return v6_1;
////        }
////        catch(Exception v5_3) {
////            try {
////                v5_3.printStackTrace();
////                return v6_1;
////            }
////            catch(MalformedURLException v5) {
////                v5.printStackTrace();
////                return null;
////            }
////            catch(ProtocolException v5_1) {
////                v5_1.printStackTrace();
////                return null;
////            }
////            catch(Exception v5_2) {
////            }
////
////            v5_2.printStackTrace();
////            return null;
////        }
////        catch(MalformedURLException v5) {
////            v5.printStackTrace();
////            return null;
////        }
////        catch(ProtocolException v5_1) {
////            v5_1.printStackTrace();
////            return null;
////        }
//        return null;
//    }
    public static String strDecodeUnGzip(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(b(e(bArr)), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public static byte[] b(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        t_b(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }
    public static byte[] e(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        d dVar = new d();
        byte[] bArr2 = new byte[((int) ((long) ((bArr.length * 3) / 4)))];
        dVar.b(bArr2, 0, bArr2.length);
        dVar.d(bArr, 0, bArr.length);
        dVar.d(bArr, 0, -1);
        byte[] bArr3 = new byte[dVar.j];
        dVar.a(bArr3, 0, bArr3.length);
        return bArr3;
    }



    public static void t_b(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                gZIPInputStream.close();
                return;
            }
        }
    }



}



