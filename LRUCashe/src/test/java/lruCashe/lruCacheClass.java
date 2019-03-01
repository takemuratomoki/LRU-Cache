//一定の数に達したら使われていない順に要素が削除されていくMapのような入れ物を作りたい
//このためLastRecentlyUsedCacheを作成する。
//キャッシュの最大サイズに達した時に、最も使われていないデータから順に消される仕組みが欲しい

/*TODO　クラスの持つべきこと
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

package lruCashe;

public class lruCacheClass {

}
