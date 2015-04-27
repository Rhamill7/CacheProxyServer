


import java.net.*;
import java.util.StringTokenizer;
import java.io.*;


public final class SpoofServer {

	public SpoofServer() {
	}

	public void extract(String fileName) throws IOException {

		{
			try {
				System.out.println(fileName);
				String fileName2 = fileName.substring(1);
				fileName2 = fileName2.substring(1);
				String saveName = fileName2.substring(11);
				System.out.println(saveName);
				URL website = new URL(fileName2);
				InputStream input = website.openConnection().getInputStream();
				BufferedInputStream br = new BufferedInputStream(input);
				FileOutputStream fileOut = new FileOutputStream(saveName+".html");
				int c;
				while ((c = br.read()) != -1) {
					fileOut.write(c);
				}
				fileOut.close();
				br.close();
				input.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
