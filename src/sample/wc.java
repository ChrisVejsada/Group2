//Francisco Prado
package sample;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;



public class wc {
	public long ccount;
	public long wcount;
	public long lcount;
	public int cccount;
	public int slcount;
	static public long total_ccount = 0;
	static public long total_wcount = 0;
	static public long total_lcount = 0;

	public int getCccount() {
		return cccount;
	}

	public int getSlcount() {
		return slcount;
	}

	public String filename;
	public boolean skipped = false;

	public long getCcount() {
		return ccount;
	}

	public void setCcount(long ccount) {
		this.ccount = ccount;
	}

	public long getWcount() {
		return wcount;
	}

	public void setWcount(long wcount) {
		this.wcount = wcount;
	}

	public long getLcount() {
		return lcount;
	}

	public void setLcount(long lcount) {
		this.lcount = lcount;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void counter(String string, File file) throws IOException {
		filename = string;

		String extension = "";
		String fileName = file.getName();
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		System.out.println(extension);

		if(extension.equals("java")){
			try {
			FileReader fr = new FileReader(file);

			while (getword(fr))
				;
			if (lcount == 0 && ccount != 0)
				lcount++;

			countSourceLines s = new countSourceLines();
			cccount = s.getCommentLines(file);
			slcount = s.getSourceLines(file);

			fr.close();
			System.out.println(slcount);
			System.out.println(cccount);
			System.out.println("comment" + ccount);

			} catch (Exception e) {
			System.out.println("Skipping " + string);
			skipped = true;
			}
		}
		else
			skipped = true;
	}
	//checks if current item is a valid character. If it is it increas wcount and goes on to count ccount
	private boolean getword(FileReader fr) throws IOException {
		// TODO Auto-generated method stub
		int c;

		while ((c = fr.read()) != -1) {
			if (isword (c)) {
				wcount ++;
				break;
			}
			COUNT (c);
			}

		for (; c != -1; c = fr.read()) {
			COUNT (c);
			if (!isword (c))
				break;
		}
		return c != -1;
	}

	private void COUNT(int c) {
		// TODO Auto-generated method stub
			ccount ++;

		if ((c) == 10)
			lcount++;

	}
	//checks if current item is a balnk space
	@SuppressWarnings("deprecation")
	private static boolean isword(int c) {
		// TODO Auto-generated method stub
		return !Character.isSpace((char) c);
	}

	//add it under here





}
