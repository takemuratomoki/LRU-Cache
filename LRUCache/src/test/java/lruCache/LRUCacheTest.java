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
		
		@Test
		public void get関数で正しい値が返ってくるかのテスト() {
			lru.testGetMethod();
			assertThat(lru.get("k1"), is("d1"));
		}
		
		@Test
		public void 保存されていないkey値が引数に入れられた時nullが返ってくるかのテスト() {
			lru.testGetMethod();
			assertThat(lru.get("testes"),nullValue());
		}
		
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
