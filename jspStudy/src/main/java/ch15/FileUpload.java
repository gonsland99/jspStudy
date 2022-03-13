package ch15;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			String encoding = "utf-8";
			File currentDirPath = new File("C:\\upload");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath);	//file path
			factory.setSizeThreshold(1024 * 1024);	//upload file size

			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					FileItem fileItem = (FileItem) items.get(i);
	
					if (fileItem.isFormField()) {
						System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					} else {
						System.out.println("varname:" + fileItem.getFieldName());	//file1
						System.out.println("filename:" + fileItem.getName());		//xxx.png
						System.out.println("filesize:" + fileItem.getSize() + "bytes");
						//upload filename
						if (fileItem.getSize() > 0) {
							int idx = fileItem.getName().lastIndexOf("\\");
							if (idx == -1) {
								idx = fileItem.getName().lastIndexOf("/");
							}
							System.out.println(idx);	//-1
							String fileName = fileItem.getName().substring(idx + 1);
							System.out.println(fileName);	//xxx.png
							//file items upload
							File uploadFile = new File(currentDirPath + "\\" + fileName);
							fileItem.write(uploadFile);
							System.out.println(uploadFile);	//c:\\upload\xxx.png
						} // end if
					} // end if
				} // end for
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}