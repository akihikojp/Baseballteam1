package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriUtils;

import com.example.demo.repository.BaseballRepository;

@Controller
@RequestMapping("")
public class BaseballController {

	@ModelAttribute
	public FileForm setUpForm() {
		return new FileForm();
	}

	@Autowired
	BaseballRepository baseballRepository;

	@RequestMapping("/top")
	public String topPage() {
		return "detail";
	}

	@PostMapping("/upload")
	public String upload(FileForm form) throws IOException {
		File file = new File();// Fileオブジェクト生成
		
		System.out.println("サイズの数は----------" + form.getFile().size());
		
		////////////////////////////////////////////////////////////
		/////ファイルのアップロード
		////////////////////////////////////////////////////////////
//		// このパスの中では、exceptionhandlerを作っておく.
//		// MultiPartで取得したデータを。byteデータに変換
//		file.setBlobFile(form.getFile().getBytes());
//		// file.setFileName(form.getFile().getName()); //名前はfileが入る
//		file.setFileName(form.getFile().getOriginalFilename()); // これが、拡張子付きの名前が入る
//		baseballRepository.save(file);

		////////////////////////////////////////////////////////////
		/////アップロードしたファイルの取得
		////////////////////////////////////////////////////////////
		File file2 = baseballRepository.findById(1);
		file2.getFileName();
		file2.getBlobFile();
		System.out.println(file2);

		// https://qiita.com/tera78/items/432d365c527342dcf9f4
		// https://www.agilegroup.co.jp/technote/springboot-fileupload-error-handling.html
		
		return topPage();
	}

	
	////////////////////////////////////////////////////////////
	/////ファイルのDL
	////////////////////////////////////////////////////////////
	@Autowired
	DownloadSupport downloadSupport;

	@RequestMapping(path = "/download", method = RequestMethod.GET)
	public ResponseEntity<Resource> download() throws IOException{
		
		File form = baseballRepository.findById(2);
		
		//InputStream teStream = new ByteArrayInputStream(form.getBlobFile());
		
		// ファイル名とダウンロードデータ(BLOBデータ)はDBから取得
		HttpHeaders headers = new HttpHeaders();
		downloadSupport.addContentDisposition(headers, form.getFileName()); // 2-2 サポートクラス参照！
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_OCTET_STREAM) /** ここでファイル形式指定 */
				.headers(headers).body(new InputStreamResource(new ByteArrayInputStream(form.getBlobFile())));
	}
	
	
	
	@Component
	public class DownloadSupport {
		private static final String CONTENT_DISPOSITION_FORMAT = "attachment; filename=\"%s\"; filename*=UTF-8''%s";
		public void addContentDisposition(HttpHeaders headers, String fileName) throws UnsupportedEncodingException {
			String headerValue = String.format(CONTENT_DISPOSITION_FORMAT, fileName,
					UriUtils.encode(fileName, StandardCharsets.UTF_8.name()));
			headers.add(HttpHeaders.CONTENT_DISPOSITION, headerValue);
		}
	}
}
