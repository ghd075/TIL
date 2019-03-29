<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.*"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<html>  
<head><title>업로드 정보</title></head>
<body>
<%
	String up_dir = request.getParameter("up_dir")!=null?request.getParameter("up_dir") :"/upload";    // 기본 업로드 폴더
	String temp_dir = request.getParameter("temp_dir")!=null?request.getParameter("temp_dir") :"c:/Temp";  // 임시 업로드 폴더
	String save_dir = "";
	String fileName = "";

	// 1. multipart/form-data 여부 확인
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (isMultipart) {
		// 2. 메모리나 파일로 업로드 데이터를 보관하는 FileItem의 Factory 설정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024*10);
		factory.setRepository(new File(temp_dir));

		// 3. 업로드 요청을 처리하는 ServletFileUpload 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 4. 업로드 요청 파싱해서 FileItem 목록 구함
		List<FileItem> items = upload.parseRequest(request);
		
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = iter.next();
			// 5. FileItem이 폼 입력 항목인지 여부에 따라 알맞은 처리
			if (!item.isFormField()) {
				//String name = item.getFieldName();
				fileName = item.getName();
				long sizeInBytes = item.getSize();
				int pos = fileName.lastIndexOf("\\");
				if ( pos >=0 )
					fileName = fileName.substring(pos+1);
				//6. 파일 저장 : 파일명 중복여부 체크해야함.
				//save_dir = application.getRealPath(up_dir) + "/" + fileName ; 				
				save_dir =  "d:/upload/" + fileName ; //업로드 파일 저장경로 지정
				item.write(new File(save_dir));		
			}
		}
	} 

	out.print("<script>alert('업로드완료'); opener.document.forms[0].attachFile.value = '"+fileName+"'; window.close();</script>");		
%>
</body>
</html>