package lruCache;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import lruCache.LRUCacheClass;

@RunWith(Enclosed.class)
public class LRUCacheTest {
	

	public static class get関数関係{
		
		//テスト用宣言
		private LRUCacheClass lru;
		
		@Before
		public void 前準備() {
			
			lru = new LRUCacheClass();	
		}
		
		//要素数が5の時のみ
		@Test
		public void get関数で正しい値が返ってくるかのテスト() {
			lru.testGetMethod();
			assertThat(lru.get("k1"), is("d1"));
		}
		
		//要素数が5の時のみ
		@Test
		public void 保存されていないkey値が引数に入れられた時nullが返ってくるかのテスト() {
			lru.testGetMethod();
			assertThat(lru.get("testes"),nullValue());
		}
		
		//要素数が5の時のみ
		@Test
		public void get関数で一度呼び出した値が最後尾に移動しているかテスト() {
			lru.testGetMethod();
			lru.get("k1");
			assertThat(lru.data[3],is("d1"));
		}
	}
	
	public static class put関数関係{
		//テスト用宣言
		private LRUCacheClass lru;
		
		@Before
		public void 前準備() {
			
			lru = new LRUCacheClass();	
		}
		
		@Test
		public void _2つ要素を追加した時のkey配列のnullチェック() {
			lru.put("hoge1", "hogehoge1");
			lru.put("hoge2", "hogehoge2");
			assertThat(lru.testCNNForKey(),is(2));
		}
		
		@Test
		public void _2つ要素を追加した時のdata配列のnullチェック() {
			lru.put("hoge1", "hogehoge1");
			lru.put("hoge2", "hogehoge2");
			assertThat(lru.testCNNForData(),is(2));
		}

		@Test
		public void put関数で配列の先頭に要素が保存されるテスト() {
			lru.put("k1", "d1");
			assertThat(lru.data[0],is("d1"));
		}
		
		@Test
		public void _2度目のput関数呼び出しで二番目に要素が保存されるかのテスト(){
			lru.put("k1", "d1");
			lru.put("k2", "d2");
			assertThat(lru.data[1],is("d2"));
		}
		
		@Test
		public void _2度目のput関数呼び出しで既存のkey値が指定されたとき上書きされる() {
			lru.put("k1", "d1");
			lru.put("k1", "d2");
			assertThat(lru.get("k1"),is("d2"));
		}
		
		//要素数が5の時のみ
		@Test
		public void put関数の実行で要素が最大となる時先頭データが削除されるかのテスト(){
			lru.testGetMethod();
			lru.put("hoge", "hogehoge");
			assertThat(lru.get("k1"),nullValue());
			assertThat(lru.data[0],is("d2"));
		}
		
		//要素数が5の時のみ
		@Test
		public void put関数の実行で要素が最大となる時最後の要素がnullになっているかのテスト() {
			lru.testGetMethod();
			lru.put("hoge", "hogehoge");
			assertThat(lru.data[4],nullValue());
		}
		
	}
	
	public static class 配列要素チェック関係{
		
		//テスト用宣言
		private LRUCacheClass lru;
		
		@Before
		public void 前準備() {
			
			lru = new LRUCacheClass();	
		}
		
		@Test
		public void 何も格納していない時のkey配列のnullチェック() {
			assertThat(lru.testCNNForKey(),is(0));
		}
		
		@Test
		public void 何も格納していない時のdata配列のnullチェック() {
			assertThat(lru.testCNNForData(),is(0));
		}
				
		@Test
		public void 配列の要素を削除し先頭に詰める関数テスト() {
			String test[]= {"hoge","hogehoge","hogehogehoge"};
			test = lru.deleteAndSort(1, test);
			assertThat(test[1],is("hogehogehoge"));
		}
	}

	

}
