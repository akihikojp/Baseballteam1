
ファイルのダウンロードとアップロード


・DBはBLOB型で保存されていると仮定。
・FileDomainトはbyte[]型でもおｋ
・Formの型はMultiPartFileにする。
・formタグにはenctypeが必要
・form.getFile().getOriginalFilename()で、ファイル名が取得できる。

InputStreamは、byteを扱いやすくしたやつっていう認識


・データが大きすぎる場合
        ymlにファイルの最大MBを設定する。
		// https://qiita.com/tera78/items/432d365c527342dcf9f4
		// https://www.agilegroup.co.jp/technote/springboot-fileupload-error-handling.html
	
	
・100MBくらいの設定ならできるが、それされもオーバーした場合は例外処理を書く。
・@ControllerAdvise全部の処理共通・・例えば、ダウンロードで共通の例外を出したい時とか。
・@ExceptionHandler:例外ハンドリングについては、徹底入門のp284,326を見る。		
.例外処理、引数をStringにしてreturnにそれを入れたら、それが呼ばれるんじゃね？


・Dropzone.js : 
http://ace.jeka.by/dropzone.html
https://cdnjs.com/libraries/dropzone
・CDNでcssを読み込む必要がある。ソースをダウンロード。

・詳しい説明:https://terasolunaorg.github.io/guideline/public_review/ArchitectureInDetail/FileUpload.html


・ACEはあるが、使いにくい ： http://jsfiddle.net/Ittavi/Ajz6s/

・ファイルをプレビューで閲覧する方法 ： http://okakacacao.wpblog.jp/technology/preview-upload-file
・画像をプレビューで閲覧する方法　: https://qiita.com/kon_yu/items/f98df7ac826e7c36cc6c
・最高最速のアップロードに近づく為の方法: https://qiita.com/zaru/items/8c0ab5c70775644d4d41
