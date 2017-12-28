
ファイルのダウンロードとアップロード


・DBはBLOB型で保存されていると仮定しても、Fileオブジェクトはbyte[]型でもおｋ
・Formの型はMultiPartFile
・templateにはenctypeが必要
・fileNameでファイル名が取れる

InputStreamは、byteを扱いやすくしたやつっていう認識


・データが大きすぎる場合
        ymlにファイルの最大MBを設定する。
		// https://qiita.com/tera78/items/432d365c527342dcf9f4
		// https://www.agilegroup.co.jp/technote/springboot-fileupload-error-handling.html
	
	
・100MBくらいの設定ならできるが、それされもオーバーした場合は例外処理を書く。