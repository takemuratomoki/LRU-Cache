package lruCache;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class LRUCacheTest {
	
	//テスト用宣言
	LRUCacheClass lru = new LRUCacheClass();
	
	@Test
	public void _0番目の要素に格納するput関数テスト(){
		try {
			lru.put("hoge1", "hogehoge1");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

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
	public void _1つだけ要素を格納した時のkey配列のnullチェック() {
		lru.put("hoge1", "hogehoge1");
		assertThat(lru.testCNNForKey(),is(1));
	}
	
	@Test
	public void _1つだけ要素を格納した時のdata配列のnullチェック() {
		lru.put("hoge1", "hogehoge1");
		assertThat(lru.testCNNForData(),is(1));
	}
}
