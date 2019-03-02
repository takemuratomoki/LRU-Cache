package lruCache;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class LRUCacheTest {
	
	//テスト用宣言
	LRUCacheClass lru = new LRUCacheClass();
	
	@Test
	public void 文字列1を返すget関数テスト() {
		assertThat(lru.get("hoge1"),is("1"));
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
	public void 配列の要素を削除し先頭に詰める関数テスト() {
		String test[]= {"hoge","hogehoge","hogehogehoge"};
		test = lru.deleteAndSort(1, test);
		assertThat(test[1],is("hogehogehoge"));
	}
}
