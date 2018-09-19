package com.bl;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DexProcessor {
	public static boolean decodeDex(File dexFile) throws IOException {
		byte[] datas = FileUtils.readFileToByteArray(dexFile);
		byte[] dexData = Base64.decode(datas, Base64.DEFAULT);
		File readedDex = new File(dexFile.getAbsolutePath().replace(".dex", ".read.dex"));
		readedDex.delete();
		FileUtils.writeByteArrayToFile(readedDex, dexData);

		return true;
	}

}
