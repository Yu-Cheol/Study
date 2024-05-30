package net.daum.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UploadController {

	@GetMapping("/uploadForm") //get 으로 접근하는 매핑주소를 처리
	public void uploadForm() {//동기식 방법으로 이동하는 파일첨부 뷰페이지를 실행하는 메서드
		//리턴타입이 없는 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		//뷰리졸브 경로는 /WEB-INF/views/uploadForm.jsp
	}//uploadForm()
	
	//동기식 방법의 첨부된 파일을 실제 서버 upload경로에 업로드
	@PostMapping("/uploadForm_OK") //post방식으로 접근하는 매핑주소를 처리
	public void uploadForm_OK(MultipartFile[] uploadFile,
			HttpServletRequest request) {
	/* 스프링 API인 MultipartFile 타입을 사용해서 업로드 되는 이진파일 데이터를 쉽게 처리한다.
	 * 	다중 업로드 파일은 배열로 받는다.그리고 MultipartFile[] uploadFile에서 사용한
	 * 매개변수인  uploadFile과 <input type="file" name="uploadFile" >의 네임
	 * 피라미터 이름인 uploadFile과는 반드시 이름이 같아야 한다.HttpServletRequest 서블릿
	 * 은 사용자 폼에서 입력한 정보를 서버로 가져오는 역할을 한다.그리고 톰켓 WAS 10버전이후부터는
	 * 패키지 경로가 jakarta.servlet.http.HttpServletRequest으로 변경되었다.
	 */
		
       String uploadFolder = 
 		   request.getSession().getServletContext().getRealPath("upload");
       //첨부파일 업로드 실제 서버경로를 구함
       System.out.println("첨부파일 실제 서버경로:"+uploadFolder);
       
       for(MultipartFile multipartFile:uploadFile) {
          System.out.println("=========================>");
          System.out.println("업로드 원본 파일명:"+
                              multipartFile.getOriginalFilename());
          System.out.println("업로드 파일크기:"+multipartFile.getSize());
          
          File saveFile = new File(uploadFolder,
        		                multipartFile.getOriginalFilename());
          
          try {
               multipartFile.transferTo(saveFile);//업로드 된 원본파일로 실제
               //upload폴더에 저장
          }catch(Exception e) {e.printStackTrace();}
       }//향상된 확장for
	}//uploadForm_OK()
	
	//비동기식 아작스를 이용한 파일 업로드 뷰페이지 파일
	@GetMapping("/uploadAjaxForm")
	public ModelAndView uploadAjaxForm() {
		return new ModelAndView("upload_ajax");//생성자 인자값으로 뷰페이지 파일명
		//전달함.=>/WEB-INF/views/upload_ajax.jsp
	}//uploadAjaxForm()
	
	@PostMapping(value="/uploadAjaxForm_OK")
	public void uploadAjaxForm_OK(MultipartFile[] uploadFile,
			HttpServletRequest request) {
		
		System.out.println("============================>");
		System.out.println("\n\n upload ajax post....\n");
		String uploadFolder=
		request.getSession().getServletContext().getRealPath("upload");
		
		for(MultipartFile multipartFile:uploadFile) {
			System.out.println("------------------->");
			System.out.println("비동기식 업로드 원본파일명:"+
			                   multipartFile.getOriginalFilename());
			System.out.println("비동기식 업로드 파일크기:"+
			                   multipartFile.getSize());
			String uploadFileName=multipartFile.getOriginalFilename();
			uploadFileName=uploadFileName.substring(
					uploadFileName.lastIndexOf("\\")+1);
			/* ie웹브라우저인 경우 파일 전체경로가 전송되기 때문에 마지막 경로구분 '\'를
			 * 맨 오른쪽부터  찾아서 가장먼저 나오는 해당\의 위치번호를 맨 왼쪽 0
			 * 부터 카운터해서 해당\의 위치번호를 구한다(lastIndexOf()). 해당\이후부터
			 *  마지막문자까지 substring()메서드에 의해서 구함=>원본파일명만 구함.
			 */
			System.out.println("onle file Name:"+uploadFileName);
			File saveFile = new File(uploadFolder,uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			}catch(Exception e) {e.printStackTrace();}
		}//for
	}//uploadAjaxForm_OK()
}












