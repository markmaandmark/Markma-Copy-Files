package copyfiles;
import java.io.*;
import java.nio.file.Files;
//import org.slf4j.Logger;  
//import org.slf4j.LoggerFactory;     
public class MyCp
{
	//private static final Logger logger = LoggerFactory.getLogger(MyCp.class);
	public static void main(String[] args) throws IOException
	{
		/*
        // 获取classpath路径
        String s = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("classpath : " + s );
 
        System.out.println("----> logback start");
        logger.trace("--> Hello trace.");
        logger.debug("--> Hello debug.");
        logger.info("--> Hello info.");
        logger.warn("--> Goodbye warn.");
        logger.error("--> Goodbye error.");
        System.out.println("----> logback end");
 
		DirCopy(args[0],args[1]);
		System.out.println("复制成功");
		*/
		//这里maven依赖问题还没有解决。*-*
	}
	public static void DirCopy(String src,String dest) throws IOException
	{
		File fileSrc = new File(src);
		File fileDest = new File(dest);
		if(!fileDest.exists())
		{
			fileDest.mkdirs();//创立目标文件夹和父文件夹
		}
		if(fileSrc.isFile())
		{
			FileCopy(src,dest);//文件拷贝
		}
		else	//子文件拷贝
		{
			for(File subFile:fileSrc.listFiles())
			{
				String subFileSrc = subFile.getPath(),
					   subFileDest = dest + File.separator + subFile.getName();
				DirCopy(subFileSrc,subFileDest);
			}
		}
	}
	public static void FileCopy(String src,String dest) throws IOException
	{
		File fileSrc = new File(src);
		File fileDest = new File(dest);
		if(fileDest.exists())//若子文件存在就直接删除
		{
			fileDest.delete();
		}
		Files.copy(fileSrc.toPath(), fileDest.toPath());
		
	}

}
