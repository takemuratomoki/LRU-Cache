//一定の数に達したら使われていない順に要素が削除されていくMapのような入れ物を作りたい
//このためLastRecentlyUsedCacheを作成する。
//キャッシュの最大サイズに達した時に、最も使われていないデータから順に消される仕組みが欲しい

/*クラスの持つべきこと
 * 2つの配列を持つ　要素数はキャッシュサイズ
 * 1つはキー値、一つはデータ
 * 
 * put関数でデータとキー値の追加
 * -既に入っているキー値と同一のキー値が指定されたらデータは上書きされる（Mapの仕様から）
 * get関数で引数に入れたキー値と一致するデータをコンソールに書き出す
 * 
 * 書き出しをされたとき、それを格納する配列とキー値を格納する配列の要素（内容）を最も最後の要素に持ってくる
 * データの追加するとき、最も最後の要素に追加する。
 * データの追加して要素がいっぱいになった時（キャッシュ最大サイズに達した時）最も最初の要素を削除し、順序を繰り上げる
 * -このクラスに格納されるデータの最大数は、常にキャッシュサイズ-1に保たれる
 */

/*=====================================
 * 消されるのは最も過去に参照したデータ。頻度ではない
 * ====================================
 */

/*TODO
 * [x] 要素数が5の配列2つを持つクラスの実装　型はstring
 * 
 * [x] put関数でキー値とデータを要素の入っていない配列の要素に格納
 * - [x] 0番目の要素に引数を格納する
 * [x] get関数で指定されたキー値と共に格納されたデータをコンソール上に表示
 *  - [x] 文字列1を返すget関数
 *
 * [x] データが入っていない要素の検出関数を実装
 * - [x] 整数1を返す
 * - [x] nullの一致をしたn番目の要素を検出し、整数nを返す
 * 
 * [get関数完成後にテスト] put→格納したキー値とデータが配列の最後の要素だった時一番初めの要素(hoge[0]の要素)を消し、すべての要素に入っているデータを[n-1]番目に移す
 * - [x] 引数として渡されたkey値が、既存のものと一致する要素がある場合、その番号を返す
 * - [x] 指定された番の要素をnullにして、以降の要素を[n-1]に移す関数

 * [x] get→呼び出された要素のデータは先頭のnullが格納された要素に移し、元あった要素よりも後の要素を[n-1]に移す
 * - [x] get関数で正しい値が返ってくる
 * - [x] 保存されていないkey値が引数に入れられた時nullが返ってくる
 * - [x] get関数で一度呼び出した値が最後尾に移動する
 * 
 * [ ] 配列の要素数をnに変更
 */

package lruCashe;

public class LRUCacheClass {
	

	public String key[];
	public String data[];
	
	public LRUCacheClass(int ca) {
		key = new String[ca];
		data = new String[ca];
	}


	//キー値とデータを格納する関数
	public void put(String keyString,String dataString) {
		/*1、キー値が一致する要素がある時それを消してそれ以外をソートする
		 * 2、最も先頭のnullの場所にキー値とデータを格納
		 * 3、要素が最大数保存されている時、先頭を消して詰め、最後をnullにする
		 */
		
		//1の処理 keyの一致をみるのでkeyを変更するのが最後
		if(checkSameNum(key,keyString)!=-1) {//キー値に一致する要素がある
			data = deleteAndSort(checkSameNum(key,keyString),data);
			key = deleteAndSort(checkSameNum(key,keyString),key);
		}
		
		//保存実行（2の処理）
		key[checkNullNum(key)]=keyString;
		data[checkNullNum(data)]=dataString;
		
		//3の処理
		if(key[key.length - 1]!=null) {
			key=deleteAndSort(0,key);
			data=deleteAndSort(0,data);
		}
	}
	
	//　指定されたキー値に対応したデータを返す関数
	public String get(String keyString) {
		if(checkSameNum(key,keyString)==-1) {//一致するkey値がない
			return null;
		}else {
			//dataの保存
			String r =  data[checkSameNum(key,keyString)];
			
			//並べ替えの実行　keyの一致をみるのでkeyを変更するのが最後
			data = deleteAndSort(checkSameNum(key,keyString),data);
			key = deleteAndSort(checkSameNum(key,keyString),key);
			
			//nullの先頭に保存し直す
			key[checkNullNum(key)]=keyString;
			data[checkNullNum(data)]=r;
			
			return r;
		}
	}
	
	//任意の配列にたいして、先頭から数えて初めにnullが格納されている番号を返す関数
	private int checkNullNum(String array[]) {
		int nullNum=0;
		
		//配列の全要素に対して繰り返し
		for(String s:array) {
			if(s==null) {
				break;
			}else {
				nullNum++;
			}
		}
		
		return nullNum;
	}
	
	//引数として指定されたStringに、配列の中で一致する要素がある時、その要素の番号を整数で返す。一致しない時、整数-1を返す。
	private int checkSameNum(String array[],String s) {
		int sameNum=-1;
		for (int i = 0; i < array.length;i++) {
			if(array[i]!=null) {//null回避
				if(array[i].equals(s)) {
					sameNum=i;
				}
			}
		}
		return sameNum;
	}
	
	//指定された番の要素をnullにして、以降の要素を[n-1]に移す関数
	public String[] deleteAndSort(int delNum,String array[]) {
		for(int i = delNum ; i < array.length -1  ; i++) {//仕様上配列の最後の要素は必ずnullなので要素の最大数-1だけ繰り返す
			array[i]=array[i+1];
		}
		
		//最後に配列の最後は必ずnullになる処理
		array[array.length - 1] = null;
		
		return array;
	}
	
	//checkNullNum関数を外部クラスからテストするための関数1
	public int testCNNForKey() {
		return 	checkNullNum(key);
	}
	
	//checkNullNum関数を外部クラスからテストするための関数2
	public int testCNNForData() {
		return checkNullNum(data);
	}
	
	//put関数を用いずにget関数をテストするための関数
	public void testGetMethod() {
		//key配列の初期化
		for(int i = 0 ; i<key.length-1;i++) {
			key[i]="k"+(i+1);
		}
		key[key.length-1]=null;
		
		//data配列の初期化
		for(int j = 0 ; j<data.length-1;j++) {
			data[j]="d"+(j+1);
		}
		data[data.length-1]=null;
	}
}
