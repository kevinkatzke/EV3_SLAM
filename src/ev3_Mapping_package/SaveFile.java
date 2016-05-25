package ev3_Mapping_package;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFile {

	public void saveToFile(String filename, ArrayList<Float> arrData) throws IOException {
		FileWriter writer = new FileWriter(filename + ".txt"); 
		for(Float num: arrData) {
		  writer.write(String.valueOf(num) + ", \n");
		}
		writer.close();
	}
}
