package p04_IO;

import java.io.FileReader;
import java.io.Reader;

public class ReaderEx {
	public static void main(String[] args) throws Exception{
		Reader reader   = new FileReader("c:/temp/fRtest1.txt");
	      int readCharNo;
	      char[] cbuf = new char[4];
	      readCharNo = reader.read(cbuf, 1, 2);
	      for(int i=0;i<cbuf.length;i++) {
	         System.out.println(cbuf[i]+"~~~");
	      }
	 
	      String data = "";
	      while(true) {
	          readCharNo=reader.read(cbuf);
	          if(readCharNo == -1) break;
	          data += new String(cbuf, 0, readCharNo);
	     }
	      System.out.println(data);
	      reader.close();
		}
	}

